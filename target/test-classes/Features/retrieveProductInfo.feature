@Test

Feature: Get Product Information from Magento Product Page
@regression
  Scenario: Retrieve Product Information
    When I am on the product page of on the Magento website
    Then I should display the product information