@Test
Feature: Add to Wishlist as a Guest User
 Scenario: Adding an item to the wishlist as a guest user
    Given I am on the product page
    And I am not logged in to the website
    When I click on the Add to Wishlist button
    Then I should be prompted to sign up or log in
    And I should be redirected to the sign-in page