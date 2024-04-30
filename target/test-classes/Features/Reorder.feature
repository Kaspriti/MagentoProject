@Test

Feature: Reorder functionality
@sanity
  Scenario: Reorder a previous order
    Given I am logged in user
    And I navigate to the My Orders page
    When I proceed to reorder the selected order
    And I should be redirected to the cart page to complete the order
