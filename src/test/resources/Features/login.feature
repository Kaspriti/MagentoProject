#Author : Priti Kasar
@Test
Feature: Login Functionality Test
@smoke
  Scenario: Valid login with correct credentials
    Given I am on the login page
    When I enter valid username and password
    And I click the login button
    Then I should be logged in successfully
@regression
  Scenario: Invalid login with incorrect credentials
    Given I am on the login page
    When I enter invalid username and invalid password
    And I click the login button
    Then I should see an error message indicating invalid credentials