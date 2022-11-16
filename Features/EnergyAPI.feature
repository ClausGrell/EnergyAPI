Feature: EnergyAPI


  Scenario: Invalid APIKEY is passed
    Given I invoke an invalid APIKEY "KAJ"
    When started
    Then Verify
    And Close

  Scenario: Requesting metering points
    Given I invoke a valid token "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ0b2tlblR5cGUiOiJDdXN0b21lckFQSV9SZWZyZXNoIiwidG9rZW5pZCI6IjRiYWNjYWFlLWUxYTAtNDM1My1iM2Y2LTJmZTM0NzhiYzY4MSIsIndlYkFwcCI6WyJDdXN0b21lckFwaSIsIkN1c3RvbWVyQXBwQXBpIl0sImp0aSI6IjRiYWNjYWFlLWUxYTAtNDM1My1iM2Y2LTJmZTM0NzhiYzY4MSIsImh0dHA6Ly9zY2hlbWFzLnhtbHNvYXAub3JnL3dzLzIwMDUvMDUvaWRlbnRpdHkvY2xhaW1zL25hbWVpZGVudGlmaWVyIjoiUElEOjkyMDgtMjAwMi0yLTg3MzMyNDk0MzMzMyIsImh0dHA6Ly9zY2hlbWFzLnhtbHNvYXAub3JnL3dzLzIwMDUvMDUvaWRlbnRpdHkvY2xhaW1zL2dpdmVubmFtZSI6IkNsYXVzIEdyZWxsIiwibG9naW5UeXBlIjoiS2V5Q2FyZCIsInBpZCI6IjkyMDgtMjAwMi0yLTg3MzMyNDk0MzMzMyIsInR5cCI6IlBPQ0VTIiwidXNlcklkIjoiNTc0MTY0IiwiZXhwIjoxNjk3ODgxNDUxLCJpc3MiOiJFbmVyZ2luZXQiLCJ0b2tlbk5hbWUiOiJHcmVsbCIsImF1ZCI6IkVuZXJnaW5ldCJ9.ywXoNQFrE2yy7wxOy5UwUclzkoJgyk9VjKOeOEYmZhQ"
    When I request meter data from "2022-10-10" to "2022-10-25"
    Then Verify that the response contains 15 days of data
    And Close

