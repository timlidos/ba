package com.blueapron.pages;

import com.blueapron.base.BaseWorkspacePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignUpPage extends BaseWorkspacePage {

    @FindBy(id = "sign-up-button")
    private WebElement continueButton;

    @FindBy(xpath = "//div[@class='pom-InputError']")
    private WebElement emailValidationMessageBlock;

    public SignUpPage() {
        super(driver());
    }

    public Boolean isPageDisplayed() {
        return driver().getCurrentUrl().endsWith("/users/sign_up");
    }

    public String getCurrentUrl() {
        return driver().getCurrentUrl();
    }

    public void clickContinueButton() {
        waitForVisibility(continueButton);
        continueButton.click();
    }

    public String getEmailValidationMessageText() {
        waitForVisibility(emailValidationMessageBlock);
        return emailValidationMessageBlock.getText();
    }
}