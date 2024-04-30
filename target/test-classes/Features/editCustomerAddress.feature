@Test
Feature: Edit customer address

  Scenario: Edit customer address
    Given I am logged in as a customer
    And I navigate to the customer address edit page
    When I update the address details
    Then the address should be successfully updated
