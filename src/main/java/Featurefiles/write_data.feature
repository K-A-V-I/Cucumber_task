Feature: Gmail Login

  Scenario: User Login with valid username and password from Excel
    Given I navigate to the Gmail login page
    When I enter Gmail username and password from Excel
    And I click the Gmail login button
    Then I should be logged into Gmail
