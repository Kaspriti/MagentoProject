Feature: Navigation of Logo Verification

  Scenario: Verify logo navigation to home page
    Given I am on Product listing page
    When I click on the logo
    Then I should be on the Magento website homepage
