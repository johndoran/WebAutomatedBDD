package features.step_definitions

import geb.pages.*

this.metaClass.mixin (cucumber.runtime.groovy.EN)

Given(~'^I am on the Jetstar home page$') { ->
    to JQHomePage
    waitFor { at(JQHomePage) }
}

When(~'^I click the book flights button$') { ->
    page.bookingButton.click()
}

Then(~'^I am on the search details page$') { ->
    assert $(".nav-bar .title").text() == "Search"
}

Then(~'^There should be (\\d+) menu items$') { int noOfItems ->
    assert page.menuButtons.size() == noOfItems
}

When(~'^I click the change culture button$') { ->
    page.cultureButton.click()
}

Then(~'^I get a list of cultures$') {->
    assert !page.cultureScreen.getAttribute("style").contains("display: none")
    assert page.cultureScreen.find("#cultures a").size() == 12
}
