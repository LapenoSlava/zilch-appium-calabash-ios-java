Feature: Habits

  Scenario Outline: Habits zero case disappears when adding 1st habit

    Given I grant permission to notifications
    When  I tap Skip button on Onboarding Page
    And   I tap Login button on Landing Page
    And   I login with the new user
    Then  I verify list of habits is empty
    When  I create a new Habit with "<title>"
    Then  I verify list of habits is not empty
    And   I reset my account
    And   I open Settings Page
    And   I tap Log Out button
Examples:
  | title         |
  | Stay hydrate  |