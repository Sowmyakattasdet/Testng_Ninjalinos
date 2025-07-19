@Launch
Feature: Opening DsAlgo Home page

Background: opening the Dsalgoportal
Given the user is on the Dsalgo portal after entering Url
##When the user enters the valid DsAlgo portal Url

  @URL
  Scenario: verify that user is able to see "You are at the right place"
    Then The user should be able to land on DsAlgo portal with the message "You are at the right place"

  @Getstarted
  Scenario: click on get started button to land on Home page
     When the user clicks Get started button
    Then the user lands on Home page
