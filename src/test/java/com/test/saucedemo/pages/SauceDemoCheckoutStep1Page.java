package com.test.saucedemo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SauceDemoCheckoutStep1Page {
    public SauceDemoCheckoutStep1Page(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(css = "#first-name")
    WebElement firstName;
    @FindBy(css = "#last-name")
    WebElement lastName;
    @FindBy(css = "#postal-code")
    WebElement zipCode;
    @FindBy(css = "#continue")
    WebElement continueButton;

    public void fillInCheckoutInfo(String firstName,String lastName,String zipCode){
        this.firstName.sendKeys(firstName);
        this.lastName.sendKeys(lastName);
        this.zipCode.sendKeys(zipCode);
        continueButton.click();
    }

}
