package geb.pages

import geb.*
import geb.modules.GoogleSearchModule

class GoogleHomePage extends Page {
    static url = "http://google.com/ncr"
    static at = { title == "Google" }

    static content = {
        search { module GoogleSearchModule }
    }
}