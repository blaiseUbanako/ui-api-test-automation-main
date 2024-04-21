# ui-api-test-automation

## Description

This project demonstrates UI automation and API testing for Amazon using Selenium WebDriver and RestAssured.

## UI Automation

### Prerequisites

- Java Development Kit (JDK)
- Maven
- WebDriverManager

### Running UI Tests Without Cucumber

1. Clone this repository to your local machine.

2. Navigate to the project directory.

3. Open the `AmazonSearchAutomationWithoutCucumber.java` file located in the `src/main/java/com.ui.api.automation` directory.

4. Update the `config.properties` file located in the `src/main/resources` directory with the necessary configurations (e.g., browser type, Amazon URL, etc.).

5. Run the tests.

### Example UI Test Without Cucumber

The `AmazonSearchAutomationWithoutCucumber.java` file contains a test method (`testAmazonProductSearch`) that demonstrates searching for a product on Amazon and verifying the search results.

## API Testing

### Prerequisites

- Java Development Kit (JDK)
- Maven
- RestAssured

### Running API Tests Without Cucumber

1. Clone this repository to your local machine.

2. Navigate to the project directory.

3. Open the `ApiTestAutomationWithoutCucumber.java` file located in the `src/main/java/com.ui.api.automation` directory.

4. Update the `config.properties` file located in the `src/main/resources` directory with the necessary configurations (e.g., API base URL, endpoints, etc.).

5. Run the tests.

### Example API Tests

The `ApiTestAutomation.java` file contains test methods (`testGETRequest`, `testPOSTRequest`, `testPUTRequest`, `testDELETERequest`) that demonstrate making GET, POST, PUT, and DELETE requests to the Amazon API and verifying the responses.



### Running UI And API Tests With Cucumber

1. Clone this repository to your local machine.

2. Navigate to the project directory.

3. Open the `TestRunnerWithCucumber.java` file located in the `src/test/java/com.ui.api.automation/tests` directory.

4. Update the `config.properties` file located in the `src/main/resources` directory with the necessary configurations (e.g., browser type, Amazon URL, etc.).

5. Run the tests.

6. Cucumber document report is made on this directory "ui-api-test-automation/target".

### Running UI And API Tests With Cucumber
1. Navigate to the repository.
2. Make any changes to the repository and commit and push
3. Navigate to Actions.
4. You should see a new job created following any push to the repository
5. Click on build and you should see the logs
6. Following build of the project, test cases will be executed. 
   

   



