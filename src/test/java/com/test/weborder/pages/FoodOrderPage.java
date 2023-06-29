package com.test.weborder.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import utils.BrowserUtils;

public class FoodOrderPage {
    public FoodOrderPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(css = "#ConfirmAddressID")
    WebElement chooseOrderLocation;
    @FindBy(xpath = "//label[@class='custom-control-label']")
    WebElement groupOrderButton;
    @FindBy(css = "#getAddressNextButton")
    WebElement nextButton;
    @FindBy(css = "#InviteNote")
    WebElement inviteNote;
    @FindBy(css = "#InviteList")
    WebElement inviteList;
    @FindBy(css = "#ConfirmAddressID")
    WebElement location;
    @FindBy(css = "#addressPreview")
    WebElement address;
    @FindBy(css = "#createGroupOrder")
    WebElement createOrderButton;
    @FindBy(css = ".topBannerHeader")
    WebElement foodOrderHeader;
    @FindBy(xpath = "//p[contains(text(),'now pending')]")
    WebElement description;



    public void clickGroupOrderBox(){
        if (groupOrderButton.isDisplayed())
        groupOrderButton.click();
    }
    public void clickNextButton(){
        nextButton.click();
    }


    public void sendInviteesMessage(String note) throws InterruptedException {
        Thread.sleep(2000);
        this.inviteNote.sendKeys(note);

    }

    public void sendInviteList(String email1, String email2) throws InterruptedException {
        Thread.sleep(2000);
        this.inviteList.sendKeys(email1+","+email2);
    }

    public void validateOrderAddress(String location,String expectedAddress) {
        BrowserUtils.selectBy(this.location,location,"text");
        Assert.assertTrue(BrowserUtils.getText(address).contains(expectedAddress));
    }

    public void clickCreateGroupOrderButton() throws InterruptedException {
        createOrderButton.click();

    }
        public void validateHeaderAndDescription(String expectedHeader,String expectedDescription) throws InterruptedException {
            Assert.assertEquals(expectedHeader, BrowserUtils.getText(foodOrderHeader));
            Assert.assertTrue(BrowserUtils.getText(description).contains(expectedDescription));
        }
}
