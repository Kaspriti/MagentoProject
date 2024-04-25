Feature: Order Placing Functionality on Magento Website

  Scenario: Place an Order for a Product
    Given I am on the product page of on the Magento website
    When I click on the Add to Cart button
    And I proceed to checkout
    And I fill in shipping information
    And I select a shipping method
    And I fill in billing information
    And I select a payment method
    And I place the order
    Then I should receive a confirmation of the order