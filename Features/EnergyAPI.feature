Feature: EnergyAPI


  Scenario: Invalid APIKEY is passed
    Given I invoke an invalid APIKEY "KAJ"
    When started
    Then Verify
    And Close

  Scenario: Requesting metering points
    Given I invoke a valid token "HOLBERGSVEJ"
    When I request meter data from "2022-11-20" to "2022-11-21" from location "HOLBERGSVEJ"
    Then Verify that the response contains 24 days of data
   # And Close

