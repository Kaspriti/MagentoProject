@Test
Feature: Registration Functionality Test

  Scenario: Create New Customer Account
    Given I am on the Registration page
    When I enter FirstName and LastName
    And I enter Email
    And I enter Password and ConfirmPassword
    And I click on CreateanAccount button
    Then I should be registered successfully
