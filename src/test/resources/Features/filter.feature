@Test
Feature: Verify the filter functionality

  Scenario: Filter products by price range
    Given I am on the Listing page
    When I filter products by price range
    Then I should see only products within the specified price range
