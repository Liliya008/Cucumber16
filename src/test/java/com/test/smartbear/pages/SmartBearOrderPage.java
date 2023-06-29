package com.test.smartbear.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

import java.util.List;

public class SmartBearOrderPage {

    public SmartBearOrderPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(css = "#ctl00_MainContent_fmwOrder_ddlProduct")
    WebElement product;
    @FindBy(css = "#ctl00_MainContent_fmwOrder_txtQuantity")
    WebElement quantity;
    @FindBy(css = "#ctl00_MainContent_fmwOrder_txtName")
    WebElement customerName;
    @FindBy(css = "#ctl00_MainContent_fmwOrder_TextBox2")
    WebElement street;
    @FindBy(css = "#ctl00_MainContent_fmwOrder_TextBox3")
    WebElement city;
    @FindBy(css = "#ctl00_MainContent_fmwOrder_TextBox4")
    WebElement state;
    @FindBy(css = "#ctl00_MainContent_fmwOrder_TextBox5")
    WebElement zipCode;
    @FindBy(xpath = "//input[@type='radio']//..//label")
    List<WebElement> cardTypes;
    @FindBy(xpath = "//label[contains(text(),'Card Nr')]//..//input")
    WebElement cardNumber;
    @FindBy(css = "#ctl00_MainContent_fmwOrder_TextBox1")
    WebElement carExpireDate;
    @FindBy(css = ".btn_light")
    WebElement processButton;
    @FindBy(xpath = "//strong")
    WebElement message;
    @FindBy(xpath = "//a[.='View all orders']")
    WebElement viewAllOrderButton;

    public void productInformation(String product,String quantity){
        this.product.sendKeys(product);
        //this.quantity.clear();
        this.quantity.sendKeys(quantity);
    }
    public void addressInformation(String customerName,String street,String city,String state,String zipCode){
        this.customerName.sendKeys(customerName);
        this.street.sendKeys(street);
        this.city.sendKeys(city);
        this.state.sendKeys(state);
        this.zipCode.sendKeys(zipCode);
    }
    public void paymentInformation(String cardType,String cardNumber,String carExpireDate) throws InterruptedException {
        Thread.sleep(2000);
        for (int i = 0; i < cardTypes.size(); i++) {
            if(BrowserUtils.getText(cardTypes.get(i)).equals(cardType)) {
                cardTypes.get(i).click();
                break;
            }
        }

        Thread.sleep(2000);
        this.cardNumber.sendKeys(cardNumber);
        this.carExpireDate.sendKeys(carExpireDate);

    }

    public String getMessage(){

        return BrowserUtils.getText(message);
    }
    public void proceedOrder() throws InterruptedException {
        Thread.sleep(2000);
        processButton.click();
        Thread.sleep(2000);


    }
}
