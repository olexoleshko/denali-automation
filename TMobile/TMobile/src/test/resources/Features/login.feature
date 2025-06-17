Feature: feature to test login functionality

  Scenario: Check login is unsuccessful with invalid credentials

    Given browser is open
    And user is on the login page
    When user enters invalid username
    Then error message displayed
    And user stays on the same page