@Test

Feature: Search for Pants on Magento Website

  Background:
    Given I am on the Magento website
@smoke
  Scenario: Searching for pants
    When I enter "pant" into the search bar
    And I click the search button
    Then I should see a list of search results
    And all search results should contain the word "pant"