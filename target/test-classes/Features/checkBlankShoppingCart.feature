@Test
Feature: Blank Shopping Cart Check
@sanity
  Scenario: Verify if the shopping cart is empty
    Given I am on the Home page
    When I click on the shopping cart icon
    Then I should see the cart is empty
