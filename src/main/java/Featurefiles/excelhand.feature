Feature: Gmail Login

  Scenario Outline: User Login with valid username and password from Excel
    Given User is on SignIn page
    When User enters sheet number <SheetNumber> and row number <RowNumber> from Excel
    And User clicks on login button
    Then I should be logged into Gmail

    Examples:
    | SheetNumber| RowNumber |
    | 1          | 1         |
