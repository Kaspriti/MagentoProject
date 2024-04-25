Feature: Add a Simple Product to the Cart

  Scenario: Add a Simple Product to the Cart
    Given I am on the product page of Overnight Duffle on the Magento website
    When I click on the Add to Cart button
    Then I should see a confirmation message indicating the product has been added to the cart
