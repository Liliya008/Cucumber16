package com.test.saucedemo.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

public class SauceDemoCheckoutStep2Page {
    public SauceDemoCheckoutStep2Page(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".inventory_item_name")
    WebElement productName;
    @FindBy(css = ".summary_subtotal_label")
    WebElement itemTotalPrice;
    @FindBy(css = ".summary_tax_label")
    WebElement taxAmount;
    @FindBy(css = ".summary_total_label")
    WebElement totalPrice;
    @FindBy(css = "#finish")
    WebElement finishButton;

    public void validateProductName(String expectedProductName){
        Assert.assertEquals(expectedProductName, BrowserUtils.getText(productName));


    }
    public void taxAmountPercentage(double expectedItemPrice,double expectedTax,int taxPercentage){
       String[] itemPrice = BrowserUtils.getText(this.itemTotalPrice).split(" ");
       double itemTotalPrice=Double.parseDouble(itemPrice[2].replace("$",""));
        double delta = 0.0001;
        Assert.assertEquals(expectedItemPrice,itemTotalPrice,delta);
       String[] tax =BrowserUtils.getText(this.taxAmount).split(" ");
       double taxAmount=Double.parseDouble(tax[1].replace("$",""));
       Assert.assertEquals(expectedTax,taxAmount,delta);
       int taxAmountPercentage= (int) ((taxAmount*100)/itemTotalPrice);
      Assert.assertEquals(taxAmountPercentage,taxPercentage);
    }
    public void validateTotalAmount(){
        String[] itemPrice = BrowserUtils.getText(this.itemTotalPrice).split(" ");
        double itemTotalPrice=Double.parseDouble(itemPrice[2].replace("$",""));
        String[] tax =BrowserUtils.getText(this.taxAmount).split(" ");
        double taxAmount=Double.parseDouble(tax[1].replace("$",""));
        String[] TotalPrice=BrowserUtils.getText(this.totalPrice).split(" ");
        double totalPrice = Double.parseDouble(TotalPrice[1].replace("$",""));
        double expectedTotalPrice=itemTotalPrice + taxAmount;
        double delta = 0.0001;
//        DecimalFormat df = new DecimalFormat("#.##");
//        String expectedPrice = df.format(expectedTotalPrice);
        System.out.println(expectedTotalPrice);
        System.out.println(totalPrice);
       Assert.assertEquals(expectedTotalPrice,totalPrice,delta);
       finishButton.click();
    }



}
