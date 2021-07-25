package com.blueapron.pages;

import com.blueapron.base.BaseWorkspacePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends BaseWorkspacePage {

    public MainPage() {
        super(driver());
    }

    public MainPage openMainPage(String url) {
        driver().navigate().to(url);
        return this;
    }
}