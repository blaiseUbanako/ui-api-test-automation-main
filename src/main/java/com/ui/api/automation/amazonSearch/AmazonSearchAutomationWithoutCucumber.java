package com.ui.api.automation.amazonSearch;

import com.ui.api.automation.browserUtilities.BrowserManager;
import com.ui.api.automation.utilities.EnvConfigReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * UI Test case first result contains Apple iPhone or not
 */
public class AmazonSearchAutomationWithoutCucumber {

    private final BrowserManager browserManager = new BrowserManager();
    private WebDriver driver;

    @BeforeClass
    public void setUp() throws InterruptedException {
        driver = browserManager.launchApp();
    }

    @Test
    public void testAmazonProductSearch() throws InterruptedException {
        driver.get(EnvConfigReader.getProperty("amazon.url"));
        Thread.sleep(5000);
        driver.findElement(By.xpath("/html/body/div/div[3]/a[2]")).click();
        WebElement searchBox = driver.findElement(By.id(EnvConfigReader.getProperty("amazon.searchbox.id")));
        searchBox.sendKeys(EnvConfigReader.getProperty("amazon.search.keyword"));
        driver.findElement(By.id(EnvConfigReader.getProperty("amazon.searchbutton.id"))).click();
        WebElement firstResult = driver.findElement(By.xpath(EnvConfigReader.getProperty("amazon.search.result.xpath")));
        Thread.sleep(1000);
        Assert.assertTrue(firstResult.getText().contains(EnvConfigReader.getProperty("amazon.matching.keyword")));
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
