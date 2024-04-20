Feature: API Test Automation

  Scenario: Perform GET request
    Given I send a GET request to "https://jsonplaceholder.typicode.com/posts/1"
    Then the response status code should be 200

  Scenario: Perform POST request
    Given I send a POST request to "https://jsonplaceholder.typicode.com/posts" with body:
      """
      {
        "title": "anything",
        "body": "anything",
        "userId": 1
      }
      """
    Then the response status code should be 201

  Scenario: Perform PUT request
    Given I send a PUT request to "https://jsonplaceholder.typicode.com/posts/1" with body:
      """
      {
        "id": 1,
        "title": "update",
        "body": "update",
        "userId": 1
      }
      """
    Then the response status code should be 200

  Scenario: Perform DELETE request
    Given I send a DELETE request to "https://jsonplaceholder.typicode.com/posts/1"
    Then the response status code should be 200
