Feature: Accounts page feature

  Background: 
    Given User is already loggedin to application
      | username              | password |
      | ansonwalder@yahoo.com | agwalder |

  Scenario: Accounts page title
    Given user is on Accounts page
    When user gets the title of the page
    Then page title should be "My account - My Store"

  Scenario: Accounts section count
    Given user is on Accounts page
    Then user gets accounts section
      | MY CREDIT SLIPS           |
      | ORDER HISTORY AND DETAILS |
      | MY ADDRESSES              |
      | MY PERSONAL INFORMATION   |
      | MY WISHLISTS              |
      | Home                      |
    And accounts section count should be 6
