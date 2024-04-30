@Test
Feature: Logout

  Scenario: Verify the logout funcionality
    Given I have logged in
    When I click on Sign out
    Then I should be logged out
