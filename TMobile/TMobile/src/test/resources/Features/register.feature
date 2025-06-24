@smoke
Feature: feature to test register functionality

  Scenario Outline: Check register is successful with valid credentials

    Given user is on the registration page
    When user enters phone number: <phoneNumber>
    And clicks on the Next button on Register page
    Then user redirected to the Contact page

    When user enters contact information: <firstName>, <lastName>, <phoneNumber>, <email> and <password>
    And clicks on the Create T-Mobile ID
    Then user redirected to the Homepage

    Examples:
      | phoneNumber | firstName | lastName | email          | password      |
      | 4225012012  | testName  | testName | test@email.com | testPassword1 |