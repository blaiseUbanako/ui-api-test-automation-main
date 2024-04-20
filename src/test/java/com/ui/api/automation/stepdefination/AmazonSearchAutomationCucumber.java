package com.ui.api.automation.stepdefination;

import com.ui.api.automation.browserUtilities.BrowserManager;
import com.ui.api.automation.pages.AmazonHomePage;
import com.ui.api.automation.utilities.EnvConfigReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

import org.testng.Assert;

public class AmazonSearchAutomationCucumber {
    private final BrowserManager browserManager = new BrowserManager();
    private WebDriver driver;
    private AmazonHomePage amazonHomePage;

    @Given("I am on the Amazon homepage")
    public void iAmOnTheAmazonHomepage() throws InterruptedException {
        driver = browserManager.launchApp();
        amazonHomePage = new AmazonHomePage(driver);
        driver.get(EnvConfigReader.getProperty("amazon.url"));
        Thread.sleep(1000);
        amazonHomePage.clickedOnPrivacy();

    }

    @When("I search for {string}")
    public void iSearchFor(String product) {
        amazonHomePage.searchForProduct(product);
    }

    @Then("I should see search results for {string}")
    public void iShouldSeeSearchResultsFor(String product) {
        String searchResultText = amazonHomePage.getSearchResultText();
        Assert.assertTrue(searchResultText.contains(product));
        driver.quit();
    }
}
