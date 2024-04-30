@Test
Feature: Edit quantity of random product in the cart

  Scenario: Edit quantity of random product in the cart
    Given I am logged in customer
    And I am on the cart page
    When I edit the quantity of a random product
    Then the updated quantity should be reflected in the cart