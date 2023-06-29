package com.test.saucedemo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

import java.util.List;

public class SauceDemoMainPage {
    public SauceDemoMainPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(css = ".inventory_item_name")
    List<WebElement> allItemsName;
    @FindBy(xpath = "//button[.='Add to cart']")
    List<WebElement> addToCartButtons;
    @FindBy(css = ".shopping_cart_link")
    WebElement cartSign;

    public void itemChoosePage(String itemName) throws InterruptedException {
        Thread.sleep(2000);

        for (int i = 0; i < allItemsName.size(); i++) {
                if (BrowserUtils.getText(allItemsName.get(i)).equals(itemName)) {
                    addToCartButtons.get(i).click();
                    break;
                }
        }
    }

    public void ClickCartSign(){
        cartSign.click();
    }
}
