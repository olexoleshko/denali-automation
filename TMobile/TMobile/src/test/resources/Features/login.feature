@smoke
Feature: feature to test login functionality

  Scenario Outline: Check login is unsuccessful with invalid email

    Given user is on the login page
    When user enters invalid email: <email>
    And clicks on the Next button on Login Page
    Then validation message displayed
    And user stays on the same page

    Examples:
      | email         |
      | invalid@email |

  Scenario Outline: Check login is unsuccessful with non-existing email

    Given user is on the login page
    When user enters non-existing email: <email>
    And clicks on the Next button on Login Page
    Then error message displayed
    And user stays on the same page

    Examples:
      | email                 |
      | nonexisting@email.com |