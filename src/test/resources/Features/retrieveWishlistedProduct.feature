@Test

Feature: Retrieve products from wishlist page
@sanity
  Scenario: View products in the wishlist
    Given I am log in as a customer
    When I navigate to the wishlist page
    Then I should see the list of products in my wishlist