@Test
Feature: Add product to cart

  Scenario: Add a product to the cart
Given I on the Product detail page
When I click on the add to cart button
Then the product should get a sucess message that the product is added in the cart
And in the cart the product should be visible