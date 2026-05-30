@Object
Feature: Object API Testing

  @GetObjectsList
  Scenario: Get Object list

    Given Object endpoint is available
    When User sends GET request
    Then User should get status code 200

  @GetObjectsListById
  Scenario: Get Object list By Id

    Given Object endpoint is available
    When User sends GET request By Id 7
    Then User should get status code 200

  @CreateObject
  Scenario: Create new object

    Given Object endpoint is available
    Given Create object payload
    When User sends POST request
    Then User should get status code 200


#  @UpdateObject
#  Scenario: Update object
#
#    Given Object endpoint is available
#    Given Create object payload
#    When User sends PUT request by id 7
#    Then User should get status code 200