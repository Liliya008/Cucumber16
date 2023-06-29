package com.test.smartbear.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.ConfigReader;

public class SmartBearLoginPage {

    public SmartBearLoginPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//input[@type='text']")
    WebElement userName;
    @FindBy(xpath = "//input[@type='password']")
    WebElement password;
    @FindBy(xpath = "//input[@value='Login']")
    WebElement loginButton;

    public void successfulLogin(){
        userName.sendKeys(ConfigReader.readProperty("QA_smartbear_username"));
        password.sendKeys(ConfigReader.readProperty("QA_smartbear_password"));
        loginButton.click();
    }
}
