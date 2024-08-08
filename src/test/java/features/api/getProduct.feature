Feature: Get All Product From API

  @apitesting
  Scenario: Verify all the product from API
    Given I hit the url of get the products
    When I pass the products of products in the request
    Then I receive the response code 200