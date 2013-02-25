package geb.pages
import geb.Page

class JQHomePage extends Page {
    static url = "http://m.jetstar.com/"
    static at = { title == "Cheap Flights Australia | Cheap International and Domestic Airfares | Jetstar Mobile" }

    static content = {

        menuButtons {
            $("a.menu-button")
        }

        cultureButton {
            $("a[data-modal='#culture-screen']")
        }

        cultureScreen {
          $("div #culture-screen")
        }

        bookingButton {
            $("#menu-opt-booking")
        }

    }
}
