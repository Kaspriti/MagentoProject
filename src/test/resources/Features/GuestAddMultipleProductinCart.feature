@Test
Feature: Add multiple random products to the cart

  Scenario: Add multiple random products to the cart
    Given I am on the product listing page
    When I add multiple random products to the cart
    Then the cart should contain the added products