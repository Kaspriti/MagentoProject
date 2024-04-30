@Test
Feature: Place an order as a logged-in user
@smoke
  Scenario: Place an order with existing user
    Given I am logged in as an existing user
    When I add items to the cart
    And I proceed to checkout
    And I enter shipping and payment information
    And I place the order
    Then I should see a Order Success Page