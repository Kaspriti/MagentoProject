@Test

Feature: Navigation of Privacy Policy
@regression
  Scenario: Verify Privacy Policy navigate to correct page
    Given I am the homepage
    When I click on Privacy page link
    Then I should be redirected to Privacy page
 
