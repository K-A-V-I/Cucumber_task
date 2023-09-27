Feature: Gmail Account Login
  Scenario: Login with valid credentials
    Given I open the Gmail login page
    When I enter valid username and password from Excel
    Then I should be logged in successfully
