package com.test.saucedemo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.ConfigReader;

public class SauceDemoLoginPage {

   public SauceDemoLoginPage(WebDriver driver){
       PageFactory.initElements(driver,this);
   }
    @FindBy(css = "#user-name")
    WebElement userName;
    @FindBy(css = "#password")
    WebElement password;
    @FindBy(css = "#login-button")
    WebElement loginButton;


    public void login(){
        userName.sendKeys(ConfigReader.readProperty("QA_saucedemo_login"));
        password.sendKeys(ConfigReader.readProperty("QA_saucedemo_password"));
        loginButton.click();

    }

}
