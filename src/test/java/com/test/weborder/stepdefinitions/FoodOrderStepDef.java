package com.test.weborder.stepdefinitions;

import com.test.weborder.pages.FoodOrderPage;
import com.test.weborder.pages.WebOrderLoginPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import utils.ConfigReader;
import utils.DriverHelper;

public class FoodOrderStepDef {
    WebDriver driver= DriverHelper.getDriver();
    WebOrderLoginPage webOrderLoginPage=new WebOrderLoginPage(driver);
    FoodOrderPage foodOrderPage=new FoodOrderPage(driver);
    @When("User logged in,click the order box,next button,provide inviteNote {string},inviteList {string}")
    public void user_logged_in_click_the_order_box_next_button_provide_invite_note_invite_list(String inviteNote,String inviteList) throws InterruptedException {
       webOrderLoginPage.login(ConfigReader.readProperty("QA_weborder_username"),ConfigReader.readProperty("QA_weborder_password"));
       foodOrderPage.orderDetails(inviteNote,inviteList);
    }
    @Then("User choose the delivery option \\(My House) and validate the address {string}")
    public void user_choose_the_delivery_option_my_house_and_validate_the_address(String expectedAddress) {
       foodOrderPage.validateOrderAddress(expectedAddress);
    }
    @Then("User click order button,validate the header {string},description {string}")
    public void user_click_order_button_validate_the_header_description(String expectedHeader, String expectedDescription) throws InterruptedException {
       foodOrderPage.validateHeaderAndDescription(expectedHeader,expectedDescription);
    }



}
