Feature: Homepage
  To use the website
  the homescreen should have options
  to allow the user to use the application

  Scenario: Land on home page
    Given I am on the Jetstar home page
    Then There should be 9 menu items

  Scenario: Enter booking page
    Given I am on the Jetstar home page
    When I click the book flights button
    Then I am on the search details page

  Scenario: Change culuture
    Given I am on the Jetstar home page
    When I click the change culture button
    Then I get a list of cultures


