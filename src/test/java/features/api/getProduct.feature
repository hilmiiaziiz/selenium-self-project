Feature: Verify The API Proses

  @apitesting
  Scenario: Verify all the product from API
    Given Hit the api url to get the value
    When Go to endpoint products when request the API
    Then Verify the response code is 200


  Scenario Outline: Verify all the response data is correct
    Given Hit the api url to get the value
    When Go to endpoint <endpoint> when request the API
    Then verify value of the [0].category is equals with<cat>
    Examples:
      | endpoint | cat|
      | products | men's clothing|