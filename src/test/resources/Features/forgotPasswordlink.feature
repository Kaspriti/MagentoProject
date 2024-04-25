
Feature: Verify forgot password link navigates to forgot password page

Background:
    Given I am on the Magento website login page

  Scenario: Resetting password with valid email
    When I click on the Forgot Your Password? link
    And I enter my email address into the email field
    And I click on the Reset My Password button
    Then I should see a success message indicating that the password reset email has been sent

  Scenario: Resetting password with invalid email
    When I click on the Forgot Your Password? link
    And I enter an invalid email address into the email field
    And I click on the Reset My Password button
    Then I should see an error message indicating that the email address is invalid
