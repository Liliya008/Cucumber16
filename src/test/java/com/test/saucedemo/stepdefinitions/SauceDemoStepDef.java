package com.test.saucedemo.stepdefinitions;

import com.test.saucedemo.pages.*;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.eo.Do;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import utils.DriverHelper;

import java.util.List;
import java.util.Map;

public class SauceDemoStepDef {
    WebDriver driver= DriverHelper.getDriver();
    SauceDemoLoginPage sauceDemoLoginPage=new SauceDemoLoginPage(driver);
    SauceDemoMainPage sauceDemoMainPage=new SauceDemoMainPage(driver);
    SauceDemoCartPage sauceDemoCartPage=new SauceDemoCartPage(driver);
    SauceDemoCheckoutStep1Page sauceDemoCheckoutStep1Page=new SauceDemoCheckoutStep1Page(driver);
    SauceDemoCheckoutStep2Page sauceDemoCheckoutStep2Page=new SauceDemoCheckoutStep2Page(driver);
    SauceDemoCheckoutCompletePage sauceDemoCheckoutCompletePage=new SauceDemoCheckoutCompletePage(driver);

    @Given("User provides username and password for SauceDemo Login")
    public void user_provides_username_and_password_for_sauce_demo_login() {
      sauceDemoLoginPage.login();
    }
    @When("User chooses {string} and click Add to Cart button")
    public void user_chooses_and_click_add_to_cart_button(String itemName) throws InterruptedException {
     sauceDemoMainPage.itemChoosePage(itemName);
    }
    @When("Click Cart sign on the top right")
    public void click_cart_sign_on_the_top_right() {
      sauceDemoMainPage.ClickCartSign();
    }
    @When("Click checkout button")
    public void click_checkout_button() {
      sauceDemoCartPage.clickCheckOutButton();
    }
    @When("fill in all the box\\({string},{string},{string}) and click continue button")
    public void fill_in_all_the_box_and_click_continue_button(String firstName, String lastName, String zipCode) {
     sauceDemoCheckoutStep1Page.fillInCheckoutInfo(firstName,lastName,zipCode);
    }
    @When("User validates the name of the {string}, the {double}$, and the {double}$ amount should be {int}% of the total")
    public void user_validates_the_name_of_the_the_$_and_the_$_amount_should_be_of_the_$(String expectedProductName, Double expectedItemPrice, Double expectedTax, Integer taxPercentage) {
        sauceDemoCheckoutStep2Page.validateProductName(expectedProductName);
        sauceDemoCheckoutStep2Page.taxAmountPercentage(expectedItemPrice,expectedTax,taxPercentage);
    }

    @When("The total amount should match the sum of the item total and tax,clicks the Finish button")
    public void the_total_amount_should_match_the_sum_of_the_item_total_and_tax_clicks_the_finish_button() {
       sauceDemoCheckoutStep2Page.validateTotalAmount();
    }
    @Then("User validate the message {string}")
    public void user_validate_the_message(String expectedHeader) {
        Assert.assertEquals(expectedHeader,sauceDemoCheckoutCompletePage.completeHeaderValidation());
    }


    @When("User chooses item and click Add to Cart button")
    public void user_chooses_item_and_click_add_to_cart_button(DataTable dataTable) throws InterruptedException {
        Map<String,String> itemsName=dataTable.asMap();
        sauceDemoMainPage.itemChoosePage(itemsName.get("itemName"));
        sauceDemoMainPage.ClickCartSign();

    }
    @When("fill in all the box\\(firstName,lastName,zipCode) and click continue button")
    public void fill_in_all_the_box_first_name_last_name_zip_code_and_click_continue_button(DataTable dataTable) {
        Map<String,String> checkoutInfo=dataTable.asMap();
        sauceDemoCheckoutStep1Page.fillInCheckoutInfo(checkoutInfo.get("firstName"),
                checkoutInfo.get("lastName"),
                checkoutInfo.get("zipCode"));
    }
    @When("User validates the name of the product")
    public void user_validates_the_name_of_the_product(DataTable dataTable) {
        Map<String,String> productName=dataTable.asMap();
      sauceDemoCheckoutStep2Page.validateProductName(productName.get("productName"));
    }
    @When("User validates the name of the product, the item total, and the tax amount should be eight percentage of the total")
    public void user_validates_the_name_of_the_product_the_item_total_and_the_tax_amount_should_be_eight_percentage_of_the_total(DataTable dataTable) {

        Map<String, String> data = dataTable.asMap(String.class, String.class);
        String productName = data.get("productName");
        Double itemTotal = Double.parseDouble(data.get("itemTotal"));
        Double taxAmount = Double.parseDouble(data.get("taxAmount"));
        Integer taxPercentage = Integer.parseInt(data.get("taxPercentage"));
    }
    @Then("User validate the message")
    public void user_validate_the_message(io.cucumber.datatable.DataTable dataTable) {
        List<String> message=dataTable.asList();
        Assert.assertEquals(message.get(0),sauceDemoCheckoutCompletePage.completeHeaderValidation());

}
}