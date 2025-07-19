@register

Feature: registration  page

  Background: Home page
    Given the user is on Home page
    When  the user clicks on Register

@register_valid
  Scenario: register with valid inputs
    When the user enters valid inputs and clicks on register button
    Then User able to see succesfully registered  message

@register_invalid
  Scenario Outline: register with invalid inputs
    When the user enters "<username>" "<password>" and "<confirm password>" and clicks register button
    Then the user be able to see error message
 Examples:
    
      | username   | password   | confirm password |
      |            |            |                  |        
      | ninjalinos |            |                  |             
      |            | djifejf    |                  |            
      | dfjeifj    | jfijgisjgi |                  |    
      | dfjeifj     | jfijgisjgi | giowehfidsjfoijd |        
