Feature: Bitly Data
  Scenario: Verify the get details of bitly
    Given I send a request to endpoint of Get Bitly
    When the API should return status 200
    Then Verify the get bitly Response data

  Scenario: Verify the get details of bitly with invalid guid
    Given I send a request to endpoint of Get Bitly invalid Guid
    When the API should return status 403
    Then Verify the get bitly error Response

  Scenario: Verify the get bitlinks data
    Given I send a request to endpoint of Get Bitlinks
    When the API should return status 200
    Then Verify the get bitlinks with group Response

  Scenario: Verify the create bitlinks
    Given Verify the create bitlinks
    When the API should return status 201
    Then Validate the response data
