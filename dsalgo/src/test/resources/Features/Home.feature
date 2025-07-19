@Home
Feature: Opening DsAlgo Home page

  Background: user is on DsAlgo page
    Given the user is on DsAlgo portal
    When the user clicks on Get started button

  @Datastructure_button
  Scenario: Verify that user able to see warning message on clicking Get Started button of Data Structures-Introduction on the home page without Sign in
    Given the user is on Home page
    When the user clicks on Get started button  in Data strucures-Introduction without signin
    Then The user should able to see an warning message You are not logged in

  @Array_button
  Scenario: Verify that user able to see warning message on clicking Get Started button of  Array on the home page without Sign in
    Given the user is on Home page
    When the user clicks on Get started button in Array without signin
    Then The user should able to see an warning message You are not logged in

  @Linked_button
  Scenario: Verify that user able to see warning message on clicking Get Started button of Linked List on the home page without Sign in
    Given the user is on Home page
    When the user clicks on Get started button in Linked List without signin
    Then The user should able to see an warning message You are not logged in

  @Stack_button
  Scenario: Verify that user able to see warning message on clicking Get Started button of Stack on the home page without Sign in
    Given the user is on Home page
    When the user clicks on Get started button in Stack without signin
    Then The user should able to see an warning message You are not logged in

  @Queue_button
  Scenario: Verify that user able to see warning message on clicking Get Started button of Queue on the home page without Sign in
    Given the user is on Home page
    When the user clicks on Get started button in Queue without signin
    Then The user should able to see an warning message You are not logged in

  @Tree_button
  Scenario: Verify that user able to see warning message on clicking Get Started button of Tree on the home page without Sign in
    Given the user is on Home page
    When the user clicks on Get started button Tree without signin
    Then The user should able to see an warning message You are not logged in

  @Graph_button
  Scenario: Verify that user able to see warning message on clicking Get Started button of  Graph on the home page without Sign in
    Given the user is on Home page
    When the user clicks on Get started button in Graph without signin
    Then The user should able to see an warning message You are not logged in

  @Datastructure_dropdown
  Scenario: Verify that user able to see warning message while selecting Data Structures from the drop down without Sign in
    Given the user is on Home page
    When the user clicks dropdown and select datastructures
    Then The user should able to see an warning message You are not logged in

  @Array_dropdown
  Scenario: Verify that user able to see warning message while selecting Array from the drop down without Sign in
    Given the user is on Home page
    When the user clicks dropdown and select Array
    Then The user should able to see an warning message You are not logged in

  @Linked_dropdown
  Scenario: Verify that user able to see warning message while selecting Linked List from the drop down without Sign in
    Given the user is on Home page
    When the user clicks dropdown and select Linkedlist
    Then The user should able to see an warning message You are not logged in

  @stack_dropdown
  Scenario: Verify that user able to see warning message while selecting Stack from the drop down without Sign in
    Given the user is on Home page
    When the user clicks dropdown and select Stack
    Then The user should able to see an warning message You are not logged in

  @Queue_dropdown
  Scenario: Verify that user able to see warning message while selecting Queue from the drop down without Sign in
    Given the user is on Home page
    When the user clicks dropdown and select Queue
    Then The user should able to see an warning message You are not logged in

  @Tree_dropdown
  Scenario: Verify that user able to see warning message while selecting Tree from the drop down without Sign in
    Given the user is on Home page
    When the user clicks dropdown and select Tree
    Then The user should able to see an warning message You are not logged in

  @Graph_dropdown
  Scenario: Verify that user able to see warning message while selecting Graph from the drop down without Sign in
    Given the user is on Home page
    When the user clicks dropdown and select Graph
    Then The user should able to see an warning message You are not logged in

  @register_button
  Scenario: verify user is able to view "register" option and click on Register.
    Given the user is on Home page
    When the user clicks on Register
    Then The user should land on registration page
