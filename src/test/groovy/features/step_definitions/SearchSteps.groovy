package features.step_definitions

import geb.pages.*

this.metaClass.mixin (cucumber.runtime.groovy.EN)

Given(~'^I am on the Google search page$') { ->
    to GoogleHomePage
    waitFor { at(GoogleHomePage) }
}

When(~'^I search for "([^"]*)"$') { String query ->
    page.search.field.value(query)
    page.search.button.click()
}

Then(~'^I am at the results page$') { ->
    assert at(GoogleResultsPage)
}

Then(~'^The first link should be "([^"]*)"$') { String text ->
    waitFor { page.results }
    assert page.resultLink(0).text(), text
}