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
    WebElement header;
    @FindBy(xpath = "//p[contains(text(),'Your group order is now pending')]")
    WebElement description;

    public void orderDetails(String inviteNote,String inviteList) throws InterruptedException {
        groupOrderButton.click();
        nextButton.click();
        this.inviteNote.sendKeys(inviteNote);
        this.inviteList.sendKeys(inviteList);
    }

public void validateOrderAddress(String expectedAddress){
        Select select=new Select(location);
        select.getFirstSelectedOption();
        Assert.assertTrue(BrowserUtils.getText(address).contains(expectedAddress));

}
        public void validateHeaderAndDescription(String expectedHeader,String expectedDescription) throws InterruptedException {
            createOrderButton.click();
            Thread.sleep(2000);
            Assert.assertEquals(expectedHeader, BrowserUtils.getText(header));
            Assert.assertTrue(BrowserUtils.getText(description).contains(expectedDescription));
        }
}
