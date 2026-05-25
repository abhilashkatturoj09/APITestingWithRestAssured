Feature: User API Testing

  @GetObjectsList
  Scenario: Get Object list

    Given Object endpoint is available
    When User sends GET request
    Then User should get status code 200

  @CreateObject
  Scenario: Create new object

    Given Object endpoint is available
    Given Create object payload
    When User sends POST request
    Then User should get status code 200