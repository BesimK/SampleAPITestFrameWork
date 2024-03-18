Feature: I do something to do some other thing

  @sample
  Scenario: I send a request to sample api to get sample response
    Given the database is accessible
    When I request all sample records
    Then I should receive a list of all actors

  @sample
  Scenario Outline: Retrieve actor record by ID
    Given the database is accessible
    When I request the actor record with ID <actor_id>
    Then I should receive the actor record with first name "<first_name>" and last name "<last_name>"

    Examples:
      | actor_id | first_name | last_name |
      | 1        | Penelope   | Guiness   |
      | 2        | Nick       | Wahlberg  |
      | 3        | Ed         | Chase     |

  @sample
  Feature: This feature is considering auth

  Scenario: I try to delete an issue without a valid token
    Given The authentication is made with invalid token to connect with api endpoints
    Then I try to delete an issue with "This"
    And Response status code should be 401

  Scenario: I try to delete an issue without a valid token
    Given The authentication is made with invalid username to connect with api endpoints
    Then I try to delete an issue with "That"
    And Response status code should be 401