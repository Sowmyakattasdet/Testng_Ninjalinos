@Login
Feature: Login page

  Background: Recurring steps for Login
    Given the user is on the Home page
    When user clicks on signin

  @login_valid
  Scenario: login validation with valid data
    When the user enters valid username  password and clicks on Login
    Then the user lands on Home page with message "you are logged in"

  @login_invalid
  Scenario Outline: Login validations with Invalid data
    When the user enters   "<Username>" and "<Password>" and clicks on Login
    Then the user will able to see "<error_message>" in login page

    Examples: 
      | Username           | Password   | error_message                 |
      |                    |            | Please fill out this field    |
      | ninjalinos         |            | Please fill out this field    |
      |                    |    3905978 | Please fill out this field    |
      | ninjalinos@wrk.com | sdet21920@ | Invalid Username and Password |
