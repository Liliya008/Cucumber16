package com.test.saucedemo.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

public class SauceDemoCheckoutCompletePage {
    public SauceDemoCheckoutCompletePage (WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(css = ".complete-header")
    WebElement completeHeader;

    public String completeHeaderValidation(){

        return BrowserUtils.getText(completeHeader);
    }
}
