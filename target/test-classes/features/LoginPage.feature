Feature: Login Page Feature

  Scenario: Login page title
    Given user is on login page
    When user gets the title of the page
    Then page title should be "Login - My Store"

  Scenario: Forgot Password link
    Given user is on login page
    Then forgot password link should be displayed

  Scenario: Login with credentials
    Given user is on login page
    When user enters username "ansonwalder@yahoo.com"
    And user enters password "agwalder"
    And user clicks on Login button
    And user gets the title of the page
    Then page title should be "My account - My Store"
