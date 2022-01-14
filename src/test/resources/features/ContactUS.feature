Feature: Contact Us Feature

  Scenario Outline: Contact us with different set of data
    Given User navigates to Contact us page
    When User fills the form from given sheetname "<SheetName>" and rownumber <RowNumber>
    And User clicks on send button
    Then System shows successful message as "Your message has been successfully sent to our team."

    Examples: 
      | SheetName | RowNumber |
      | contactus |         0 |
      | contactus |         1 |
