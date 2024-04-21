Feature: Amazon Search
  As a user
  I want to search for a product on Amazon
  So that I can view search results

  Scenario: Search for iPhone
    Given I am on the Amazon homepage
    When I search for "iPhone"
    Then I should see search results for "Apple iPhone"
