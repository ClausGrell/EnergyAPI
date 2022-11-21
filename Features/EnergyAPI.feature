Feature: EnergyAPI


  Scenario: Invalid APIKEY is passed
    Given I invoke an invalid APIKEY "KAJ"
    When started
    Then Verify
    And Close

  Scenario: Requesting metering points
    Given I invoke a valid token "MAAGEVAENGET"
   # When I request meter data from "2022-11-01" to "2022-11-21"
   # Then Verify that the response contains 15 days of data
   # And Close

