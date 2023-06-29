package com.test.smartbear.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class SmartBearViewOrderPage {
    public SmartBearViewOrderPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//tr[2]//td")
    List<WebElement> listOfOrder;

    @FindBy(xpath = "//a[.='View all orders']")
    WebElement viewAllOrderButton;

    public void validateOrderInformation(String customerName,String product,String quantity,String street,String city,String state,String zipCode,String cardType,String cardNumber,String carExpireDate){

        DateTimeFormatter dtf=DateTimeFormatter.ofPattern("MM/dd/yyyy");
        LocalDateTime now=LocalDateTime.now().plusDays(1);
        String currentDate=dtf.format(now);

        List<String> expectedList = Arrays.asList("",customerName,product,quantity,currentDate,street,city,state,zipCode,cardType,cardNumber,carExpireDate,"");
        for (int i = 1; i < listOfOrder.size()-1; i++) {
            Assert.assertEquals(expectedList.get(i).trim(), BrowserUtils.getText(listOfOrder.get(i)));

        }
    }
    public void viewAllOrders(){
        viewAllOrderButton.click();
    }

}
