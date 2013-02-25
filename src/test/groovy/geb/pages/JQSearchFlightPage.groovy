package geb.pages

import geb.Page

/**
 * Created with IntelliJ IDEA.
 * User: johndoran
 * Date: 24/02/2013
 * Time: 17:05
 */

class JQSearchFlightPage extends Page {
    static url = "http://m.jetstar.com/s/booking"


    static at = { title == "Jetstar Airways Cheap Flights, Low Fares all day everyday from the world's best Cheap Fare airline | Jetstar Mobile" }

    static content = {
        departureAirportPicker{ $('.clickable', 0) }

        returnAirportPicker { ($('.clickable', 1)) }

        departureDatePicker { $('#departureDate') }

        depDayLabel { $('#departureDate .title')}
        depYearLabel { $('#departureDate .subtitle')}

        returnDatePicker { $('#returnDate') }
    }

}
