@Test
Feature: Guest user- Delete product from the minicart

  Scenario: Delete Product from the minicart
    Given Add the Product into the cart
    When I click on the delete icon
    And I click Ok from the pop up box
    Then the product should get deleted from the cart

  
