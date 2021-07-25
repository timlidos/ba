package com.blueapron.pages;

import com.blueapron.base.BaseWorkspacePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PricingPage extends BaseWorkspacePage {

    @FindBy(xpath = "//h1[@class='pom-PlanCard__name' and text()='Signature']/..//span[@uit='serving-price-value-with-discount']")
    private WebElement twoServingSignaturePlanPriceBlock;

    @FindBy(xpath = "//h1[@class='pom-PlanCard__name' and text()='Signature']/..//span[@uit='shipping-price-value']")
    private WebElement twoServingSignaturePlanShippingBlock;

    @FindBy(xpath = "//h1[@class='pom-PlanCard__name' and text()='Signature for 4']/..//span[@uit='serving-price-value-with-discount']")
    private WebElement fourServingSignaturePlanPriceBlock;

    @FindBy(xpath = "//h1[@class='pom-PlanCard__name' and text()='Signature for 4']/..//span[@uit='shipping-price-value']")
    private WebElement fourServingSignaturePlanShippingBlock;

    public PricingPage() {
        super(driver());
    }

    public Boolean isPageDisplayed() {
        return driver().getCurrentUrl().endsWith("/pricing");
    }

    public String getCurrentUrl() {
        return driver().getCurrentUrl();
    }

    public String getTwoServingSignaturePlanPrice() {
        return twoServingSignaturePlanPriceBlock.getText();
    }

    public String getTwoServingSignaturePlanShipping() {
        return twoServingSignaturePlanShippingBlock.getText();
    }

    public String getFourServingSignaturePlanPrice() {
        return fourServingSignaturePlanPriceBlock.getText();
    }

    public String getFourServingSignaturePlanShipping() {
        return fourServingSignaturePlanShippingBlock.getText();
    }

    public PricingPage selectSignatureRecipesPerWeek(String value) {
        String xPath = "//h1[@class='pom-PlanCard__name' and text()='Signature']/..//ul//button[contains(., '" + value + "')]";
        WebElement button = driver().findElement(By.xpath(xPath));
        waitForVisibility(button);
        button.click();
        return this;
    }

    public PricingPage selectSignatureForFourRecipesPerWeek(String value) {
        String xPath = "//h1[@class='pom-PlanCard__name' and text()='Signature for 4']/..//ul//button[contains(., '" + value + "')]";
        WebElement button = driver().findElement(By.xpath(xPath));
        waitForVisibility(button);
        button.click();
        return this;
    }

    public SignUpPage clickSelectButton() {
        Random random = new Random();
        List<WebElement> selectButtons = driver().findElements(By.xpath("//button[@uit='plan-card-select-btn']"));
        WebElement button = selectButtons.get(random.nextInt(selectButtons.size()));
        waitForVisibility(button);
        button.click();
        return new SignUpPage();
    }
}