@Test
Feature: Add to Wishlist as a logged In User
@sanity
  Scenario: Adding an item to the wishlist
    Given I am logged in to the website
    And Navigate to the product page
    When I click on the Add to Wishlist icon
    Then I should see a confirmation message
