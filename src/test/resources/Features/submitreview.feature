@Test

Feature: Submit Review for Product
@regression
  Scenario: Submit a review for "Olivia 1/4 Zip Light Jacket"
    Given I am on the product page"
    When I click on the Reviews button
    And I fill in the review form with my details
    And I submit the review
    Then I should see a success message confirming the review submission
