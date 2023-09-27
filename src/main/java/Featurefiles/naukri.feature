Feature: Naukri Job Search
  As a user, I want to search for jobs on Naukri website

  Scenario: Perform a job search
    Given I am on the Naukri homepage
    When I search for "Software Engineer" jobs
    Then I should see job search results
