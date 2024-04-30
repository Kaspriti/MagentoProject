@Test
Feature: Advanced Search
@sanity
  Scenario: Perform an advanced search with specific criteria
    Given I am on homepage
    When I click on Advanced Search
    And I enter Product name and click on search button
    Then I should see list of search results 
    And all search results should contain the Product name
