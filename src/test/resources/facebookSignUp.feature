Feature: As a social media person, I want to sign up with facebook to create an account.

  Scenario: I sign up multiple users on facebook.
    Given I navigate to facebook
    When I sign up 10 users with random details on facebook successfully
    Then I close the browser