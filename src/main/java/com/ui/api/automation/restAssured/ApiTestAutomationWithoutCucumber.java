package com.ui.api.automation.restAssured;

import com.ui.api.automation.utilities.EnvConfigReader;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

/**
 * API Test cases GET,POST,PUT and DELETE
 */
public class ApiTestAutomationWithoutCucumber {


    @Test
    public void testGETRequest() {
        Response response = given().when().get(EnvConfigReader.getProperty("api.get.url"));
        assertEquals(response.getStatusCode(), Integer.parseInt(EnvConfigReader.getProperty("api.get.expected.status")));
    }

    @Test
    public void testPOSTRequest() {
        Response response = given().contentType("application/json").body(EnvConfigReader.getProperty("api.post.body")).when().post(EnvConfigReader.getProperty("api.post.url"));
        assertEquals(response.getStatusCode(), Integer.parseInt(EnvConfigReader.getProperty("api.post.expected.status")));
    }

    @Test
    public void testPUTRequest() {
        Response response = given().contentType("application/json").body(EnvConfigReader.getProperty("api.put.body")).when().put(EnvConfigReader.getProperty("api.put.url"));
        assertEquals(response.getStatusCode(), Integer.parseInt(EnvConfigReader.getProperty("api.put.expected.status")));
    }

    @Test
    public void testDELETERequest() {
        Response response = given().when().delete(EnvConfigReader.getProperty("api.delete.url"));
        assertEquals(response.getStatusCode(), Integer.parseInt(EnvConfigReader.getProperty("api.delete.expected.status")));
    }
}
