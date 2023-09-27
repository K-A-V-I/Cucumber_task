Feature: E-commerce website functionality

  @search
  Scenario: Searching for a product
    Given I am on the e-commerce website
    When I log in with "8489221073" and "Kavi1234"
    When I add a laptop to the cart
  @cart
  Scenario: Adding products to the cart
   Given I am on the e-commerce website
    When I search for a "laptop"
    Then I should see search results for laptops



