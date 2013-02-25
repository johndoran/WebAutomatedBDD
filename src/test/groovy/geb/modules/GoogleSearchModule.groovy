package geb.modules

import geb.*
import geb.pages.GoogleResultsPage

class GoogleSearchModule extends Module {
    static content = {
        field { $("input", name: "q") }
        button(to: GoogleResultsPage) { btnG() }
    }
    void forTerm(term) {
        field.value term
        waitFor { button.displayed }
        button.click()
    }
}