package com.ui.api.automation.amazonSearch;

import com.ui.api.automation.browserUtilities.BrowserManager;
import com.ui.api.automation.pages.AmazonHomePage;
import com.ui.api.automation.utilities.EnvConfigReader;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AmazonSearchAutomationWithPageObjectModel {
    private final BrowserManager browserManager = new BrowserManager();
    private WebDriver driver;
    private AmazonHomePage amazonHomePage;

    @BeforeClass
    public void setUp() throws InterruptedException {
        driver = browserManager.launchApp();
        amazonHomePage = new AmazonHomePage(driver);
    }

    @Test
    public void testAmazonProductSearch() throws InterruptedException {
        driver.get(EnvConfigReader.getProperty("amazon.url"));
        Thread.sleep(1000);
        amazonHomePage.clickedOnPrivacy();
        amazonHomePage.searchForProduct(EnvConfigReader.getProperty("amazon.search.keyword"));
        String searchResultText = amazonHomePage.getSearchResultText();
        Assert.assertTrue(searchResultText.contains(EnvConfigReader.getProperty("amazon.matching.keyword")));
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
