package com.ui.api.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmazonHomePage {
    private WebDriver driver;

    @FindBy(id = "twotabsearchtextbox")
    private WebElement searchBox;

    @FindBy(id = "nav-search-submit-button")
    private WebElement searchButton;

    @FindBy(xpath = "//*[@id=\"search\"]/div[1]/div[1]/div/span[1]/div[1]/div[2]")
    private WebElement searchResult;

    @FindBy(xpath = "/html/body/div/div[3]/a[2]")
    private WebElement privacyLink;

    public AmazonHomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void searchForProduct(String keyword) {
        searchBox.sendKeys(keyword);
        searchButton.click();
    }
    public String getSearchResultText() {
        return searchResult.getText();
    }
    public void clickedOnPrivacy()
    {
        privacyLink.click();
    }
}
