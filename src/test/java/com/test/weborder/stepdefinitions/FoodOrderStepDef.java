package com.test.weborder.stepdefinitions;

import com.test.weborder.pages.FoodOrderPage;
import com.test.weborder.pages.WebOrderLoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import utils.ConfigReader;
import utils.DriverHelper;

public class FoodOrderStepDef {
    WebDriver driver= DriverHelper.getDriver();
    WebOrderLoginPage webOrderLoginPage=new WebOrderLoginPage(driver);
    FoodOrderPage foodOrderPage=new FoodOrderPage(driver);

    @Given("User provides username and password")
    public void user_provides_username_and_password() {
        webOrderLoginPage.login(ConfigReader.readProperty("QA_weborder_username"),ConfigReader.readProperty("QA_weborder_password"));
    }

    @When("User clicks Group Order Box and Next Button")
    public void user_clicks_group_order_box_and_next_button() {
       foodOrderPage.clickGroupOrderBox();
       foodOrderPage.clickNextButton();
    }

    @When("User provides note {string} to invitees box")
    public void user_provides_note_to_invitees_box(String message) throws InterruptedException {
        foodOrderPage.sendInviteesMessage(message);
    }

    @When("User provides gmail {string},{string} to InviteList")
    public void user_provides_gmail_to_invite_list(String email1, String email2) throws InterruptedException {
        foodOrderPage.sendInviteList(email1, email2);
    }

    @When("User chooses the location {string} and validates the address {string}")
    public void user_chooses_the_location_and_validates_the_address(String expectedLocation, String expectedAddress) {
        foodOrderPage.validateOrderAddress(expectedLocation, expectedAddress);
    }
    @When("User clicks Create Group OrderButton")
    public void user_clicks_create_group_order_button() throws InterruptedException {
        foodOrderPage.clickCreateGroupOrderButton();

    }
    @Then("User validates the {string} and {string} from description")
    public void user_validates_the_and_from_description(String string, String string2) {

    }

}
