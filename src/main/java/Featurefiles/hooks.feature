
Feature: Login

  Scenario: Login to orangehrmlive
    Given User is on Home page
    When User enters username as "Admin"
    And User enters password as "admin123"
    Then User should be able to login sucessfully
   

