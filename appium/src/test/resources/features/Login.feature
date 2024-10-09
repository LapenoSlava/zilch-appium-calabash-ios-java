Feature: Login

  Scenario: User Logs In with valid credentials and Logs Out

    Given I grant permission to notifications
    When  I tap Skip button on Onboarding Page
    And   I tap Login button on Landing Page
    And   I login with the new user
    Then  I am on Habits Page
    When  I open Settings Page
    And   I tap Log Out button
    Then  I am on Login Page