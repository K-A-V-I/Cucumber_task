Feature: Gmail Login

  Scenario Outline: Login to Gmail with username <username> and password <password>
    Given I navigate to the Gmail login page
    When I enter Gmail username "<username>" and password "<password>"
    And I click the Gmail login button
    Then I should be logged into Gmail

  Examples:
    | username               | password |
    | kaviayirpsm@gmail.com  | K@v!1810 |

