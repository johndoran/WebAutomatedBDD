
Feature: Search Flight Page
  To book a flight
  the site should be accept
  my booking flight criteria

Scenario: Enter to search flight
  Given I am on the Jetstar home page
  When I enter the search flight page
  Then I see the search flight page


Scenario: Pick departure date
  Given I am on the Jetstar home page
  When I enter the search flight page
  Then I touch the return date button
  And the date picker is displayed
  And I enter dates for the following month
  Then my chosen dates are displayed on the search page

Scenario: Pick airports
  Given I am on the Jetstar home page
  When I enter the search flight page
  Then I touch the route picker
  And the route selection page is displayed
  And I choose departing "Adelaide"
  And I choose returning "Brisbane"
  Then my selection is displayed on the search page

