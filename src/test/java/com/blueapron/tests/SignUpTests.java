package com.blueapron.tests;

import com.blueapron.base.BrowseBase;
import com.blueapron.pages.MainPage;
import com.blueapron.pages.PricingPage;
import com.blueapron.pages.SignUpPage;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SignUpTests extends BrowseBase {

    private String expectedTwoSignatureForThreeRecipesPlanPrice;
    private String expectedTwoSignatureForThreeRecipesPlanShipping;
    private String expectedFourSignatureForTwoRecipesPlanPrice;
    private String expectedFourSignatureForTwoRecipesPlanShipping;
    private String expectedTwoSignatureForTwoRecipesPlanPrice;
    private String expectedTwoSignatureForTwoRecipesPlanShipping;
    private String expectedFourSignatureForThreeRecipesPlanPrice;
    private String expectedEmailValidationError;

    @BeforeMethod
    protected void specificSetup() {
        expectedTwoSignatureForThreeRecipesPlanPrice = "$9.99";
        expectedTwoSignatureForThreeRecipesPlanShipping = "FREE";
        expectedTwoSignatureForTwoRecipesPlanPrice = "$9.99";
        expectedTwoSignatureForTwoRecipesPlanShipping = "$7.99";
        expectedFourSignatureForTwoRecipesPlanPrice = "$8.99";
        expectedFourSignatureForTwoRecipesPlanShipping = "FREE";
        expectedFourSignatureForThreeRecipesPlanPrice = "$7.99";
        expectedEmailValidationError = "Invalid email address";
    }

    @Description("Check validation message on sign up page without entering email address")
    @Test
    public void checkValidationMessageOnSignUpPageWithoutEnteringEmailAddress() {
        MainPage mainPage = new MainPage();
        PricingPage pricingPage = new PricingPage();
        SignUpPage signUpPage = new SignUpPage();

        mainPage
                .openMainPage(baseUrl)
                .clickPricingLabel();
        Assert.assertTrue(pricingPage.isPageDisplayed(),
                "Current URL is: " + pricingPage.getCurrentUrl() + ". Should be ends with /pricing");

        Assert.assertEquals(pricingPage.getTwoServingSignaturePlanPrice(), expectedTwoSignatureForThreeRecipesPlanPrice,
                "Current two serving signature plan price is: " + pricingPage.getTwoServingSignaturePlanPrice() +
                        ", but expected: " + expectedTwoSignatureForThreeRecipesPlanPrice);
        Assert.assertEquals(pricingPage.getTwoServingSignaturePlanShipping(), expectedTwoSignatureForThreeRecipesPlanShipping,
                "Current two serving signature plan shipping is: " + pricingPage.getTwoServingSignaturePlanShipping() +
                        ", but expected: " + expectedTwoSignatureForThreeRecipesPlanShipping);
        Assert.assertEquals(pricingPage.getFourServingSignaturePlanPrice(), expectedFourSignatureForTwoRecipesPlanPrice,
                "Current four serving signature plan price is: " + pricingPage.getTwoServingSignaturePlanPrice() +
                        ", but expected: " + expectedFourSignatureForTwoRecipesPlanPrice);
        Assert.assertEquals(pricingPage.getFourServingSignaturePlanShipping(), expectedFourSignatureForTwoRecipesPlanShipping,
                "Current four serving signature plan shipping is: " + pricingPage.getTwoServingSignaturePlanShipping() +
                        ", but expected: " + expectedFourSignatureForTwoRecipesPlanShipping);

        pricingPage
                .selectSignatureRecipesPerWeek("2")
                .selectSignatureForFourRecipesPerWeek("3");

        Assert.assertEquals(pricingPage.getTwoServingSignaturePlanPrice(), expectedTwoSignatureForTwoRecipesPlanPrice,
                "Current two serving signature plan price is: " + pricingPage.getTwoServingSignaturePlanPrice() +
                        ", but expected: " + expectedTwoSignatureForTwoRecipesPlanPrice);
        Assert.assertEquals(pricingPage.getTwoServingSignaturePlanShipping(), expectedTwoSignatureForTwoRecipesPlanShipping,
                "Current two serving signature plan shipping is: " + pricingPage.getTwoServingSignaturePlanShipping() +
                        ", but expected: " + expectedTwoSignatureForTwoRecipesPlanShipping);
        Assert.assertEquals(pricingPage.getFourServingSignaturePlanPrice(), expectedFourSignatureForThreeRecipesPlanPrice,
                "Current four serving signature plan price is: " + pricingPage.getTwoServingSignaturePlanPrice() +
                        ", but expected: " + expectedFourSignatureForThreeRecipesPlanPrice);

        pricingPage
                .clickSelectButton();
        Assert.assertTrue(signUpPage.isPageDisplayed(),
                "Current URL is: " + signUpPage.getCurrentUrl() + ". Should be ends with /users/sign_up");

        signUpPage.clickContinueButton();
        Assert.assertEquals(signUpPage.getEmailValidationMessageText(), expectedEmailValidationError,
                "Current email validation error is: " + signUpPage.getEmailValidationMessageText() +
                        ", but expected: " + expectedEmailValidationError);
    }
}