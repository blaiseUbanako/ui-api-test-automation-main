package com.ui.api.automation.browserUtilities;

import com.ui.api.automation.utilities.EnvConfigReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BrowserManager {
    public static ChromeOptions chromeOptions;

    public WebDriver launchApp() throws InterruptedException {

        chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--disable-popup-blocking", "--disable-infobars", "--fast-start", "--no-sandbox", "--ignore-certificate-errors", "--start-maximized");
        WebDriver driver = WebDriverManager.chromedriver().capabilities(chromeOptions).create();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        return driver;
    }

}
