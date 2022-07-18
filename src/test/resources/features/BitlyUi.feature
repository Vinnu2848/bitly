Feature: Login Action

  Scenario: Successful Login with Valid Credentials
    Given User is on Home Page
    When User Navigate to LogIn Page
    And User enters UserName and Password
    And User should be add the items "You Don't Know JS"
    And User should be add the items "Understanding ECMAScript 6"
    And User should be add the items "Learning JavaScript Design Patterns"
    And User should be add the item with search part of item "Git"
    Then Verify all books is added Login Successfully

  Scenario: Successful LogOut
    When User LogOut from the Application
    Then Message displayed LogOut Successfully
