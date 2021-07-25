package com.blueapron.base;

import com.blueapron.pages.PricingPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BaseWorkspacePage extends BrowseBase {

    @FindBy(xpath = "//nav[@id='main-nav']//a[@class='nav_pricing']")
    private WebElement pricingLabel;

    private final WebDriver driver;

    public BaseWorkspacePage(WebDriver driver) {
        PageFactory.initElements(driver(), this);
        this.driver = driver;
    }

    public PricingPage clickPricingLabel() {
        waitForVisibility(pricingLabel);
        pricingLabel.click();
        return new PricingPage();
    }
}