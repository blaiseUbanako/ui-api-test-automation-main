package com.ui.api.automation.stepdefination;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class ApiTestAutomationWithCucumber {
    private Response response;

    @Given("^I send a GET request to \"([^\"]*)\"$")
    public void i_send_a_get_request_to(String url) {
        response = given().when().get(url);
    }

    @Given("^I send a POST request to \"([^\"]*)\" with body:$")
    public void i_send_a_post_request_to_with_body(String url, String body) {
        response = given().contentType("application/json").body(body).when().post(url);
    }

    @Given("^I send a PUT request to \"([^\"]*)\" with body:$")
    public void i_send_a_put_request_to_with_body(String url, String body) {
        response = given().contentType("application/json").body(body).when().put(url);
    }

    @Given("^I send a DELETE request to \"([^\"]*)\"$")
    public void i_send_a_delete_request_to(String url) {
        response = given().when().delete(url);
    }

    @Then("^the response status code should be (\\d+)$")
    public void the_response_status_code_should_be(int statusCode) {
        assertEquals(response.getStatusCode(), statusCode);
    }
}
