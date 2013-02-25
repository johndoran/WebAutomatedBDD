package features.step_definitions

import geb.pages.JQSearchFlightPage

import java.text.DateFormat
import java.text.SimpleDateFormat

this.metaClass.mixin(cucumber.runtime.groovy.EN)

def departureDate
def returnDate

def depAirport
def arrAirport


When(~'^I enter the search flight page$') {->
    to JQSearchFlightPage
    waitFor { at(JQSearchFlightPage) }
    assert $(".nav-bar .title").text() == "Search"
}

Then(~'^I see the search flight page$') {->
    assert page != null && page.verifyAt()
    assert page.departureAirportPicker != null
}

Then(~'^I touch the return date button$') {->
    waitFor {
        page.departureDatePicker.click()
    }
}

Then(~'^the date picker is displayed$') {->
    assert !$('#calendar-screen').getAttribute("style").contains("display: none")
}

Then(~'^I enter dates for the following month$') {->

    $('.ical-nav-bar .ical-nav-next').click()

    waitFor {
        $('.ical-cell:not(.ical-cell-othermonth)').displayed == true
    }

    //dep date
    def depDateCell = $('.ical-cell:not(.ical-cell-othermonth)').first()
    departureDate = depDateCell.getAttribute("data-date")
    depDateCell.click()
    departureDate = new Date().parse("yyyy-MM-dd", departureDate)

    //return date
    $('.ical-tabs a', 1).click()

    waitFor {
        $('.ical-cell:not(.ical-cell-othermonth)', 1).displayed == true
    }

    def arrDateCell = $('.ical-cell:not(.ical-cell-othermonth)', 1)
    returnDate = arrDateCell.getAttribute("data-date")
    arrDateCell.click()
    returnDate = new Date().parse("yyyy-MM-dd", returnDate)

    $('.cal-buttons .apply-btn').click()
}

Then(~'my chosen dates are displayed on the search page$') {->
    DateFormat dayFormat = new SimpleDateFormat("EEEE dd");
    String depDay = dayFormat.format(departureDate);

    DateFormat monthFormat = new SimpleDateFormat("MMMMM yyyy");
    String depMonth = monthFormat.format(departureDate);

    assert page.depDayLabel.text() == depDay
    assert page.depYearLabel.text() == depMonth

    //todo return date assert
}

Then(~'I touch the route picker$') {->
    page.departureAirportPicker.click();
}

Then(~'the route selection page is displayed') { ->
    assert $(".nav-bar .title").text() == "Choose origin"
}

Then(~'^I choose departing "([^"]*)"$') { String departing ->

   $('.isearch input').value(departing)
    depAirport = departing

    //todo wtf wont it take departing?
    $(".iitems a .ilabel", text: departing).click()

}

Then(~'^I choose returning "([^"]*)"$') { String arriving ->
    $('.isearch input').value(arriving)

    arrAirport = arriving
    //todo wtf wont it take arriving?
    $(".iitems a .ilabel", text: arriving).click()

}

Then(~'my selection is displayed on the search page') { ->
    assert page != null && page.verifyAt()
    assert $(".nav-bar .title").text() == "Search"

    page.departureAirportPicker.find(".title").text() == depAirport
    page.returnAirportPicker.find(".title").text() == arrAirport
}


