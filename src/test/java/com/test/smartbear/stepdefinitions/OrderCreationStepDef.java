package com.test.smartbear.stepdefinitions;

import com.test.smartbear.pages.SmartBearLoginPage;
import com.test.smartbear.pages.SmartBearMainPage;
import com.test.smartbear.pages.SmartBearOrderPage;
import com.test.smartbear.pages.SmartBearViewOrderPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import utils.BrowserUtils;
import utils.DriverHelper;

import java.util.List;
import java.util.Map;

import static org.apache.commons.compress.harmony.unpack200.bytecode.forms.ByteCodeForm.get;

public class OrderCreationStepDef {
    WebDriver driver= DriverHelper.getDriver();
    SmartBearLoginPage smartBearLoginPage=new SmartBearLoginPage(driver);
    SmartBearMainPage smartBearMainPage=new SmartBearMainPage(driver);
    SmartBearOrderPage smartBearOrderPage=new SmartBearOrderPage(driver);
    SmartBearViewOrderPage smartBearViewOrderPage=new SmartBearViewOrderPage(driver);
    @Given("User provides username and password for SmartBear Login")
    public void user_provides_username_and_password_for_smart_bear_login() {
       smartBearLoginPage.successfulLogin();
    }
    @When("User clicks Order Button and provides the {string} and {string} for product information")
    public void user_clicks_order_button_and_provides_the_and_for_product_information(String product, String quantity) throws InterruptedException {
        smartBearMainPage.chooseCategory(driver);
        smartBearOrderPage.productInformation(product,quantity);

    }
    @When("User provides {string},{string},{string},{string},{string} for address information")
    public void user_provides_for_address_information(String customerName, String street, String city, String state, String zipCode) {
      smartBearOrderPage.addressInformation(customerName,street,city,state,zipCode);
    }
    @When("User choose {string} and provides {string},{string} for payment information")
    public void user_choose_and_provides_for_payment_information(String cardType,String cardNumber, String carExpireDate) throws InterruptedException {
        smartBearOrderPage.paymentInformation(cardType,cardNumber,carExpireDate);
    }


    @Then("User clicks process button and validate {string} and click view order button")
    public void user_clicks_process_button_and_validate_and_click_view_order_button(String expectedMessage) throws InterruptedException {
        smartBearOrderPage.proceedOrder();
        Assert.assertEquals(expectedMessage,smartBearOrderPage.getMessage());

    }
    @Then("User validates all information {string},{string},{string},{string},{string},{string},{string},{string},{string},{string} from table")
    public void user_validates_all_information_from_table(String customerName,String product,String quantity,String street,String city,String state,String zipCode,String cardType,String cardNumber,String carExpireDate) {
        smartBearViewOrderPage.validateOrderInformation(customerName,product,quantity,street,city,state,zipCode,cardType,cardNumber,carExpireDate);
    }

    @When("User clicks Order Button and provides the product and quantity for product information")
    public void user_clicks_order_button_and_provides_the_product_and_quantity_for_product_information(DataTable dataTable) throws InterruptedException {
     Map<String,String> productInformation =dataTable.asMap();
        System.out.println(productInformation);
        smartBearMainPage.chooseCategory(driver);
        smartBearOrderPage.productInformation(productInformation.get("product"),
                productInformation.get("quantity"));
    }
    @When("User provides customerName,street,city,state,zipCode for address information")
    public void user_provides_customer_name_street_city_state_zip_code_for_address_information(DataTable dataTable) {
        Map<String,String> productInformation =dataTable.asMap();
        smartBearOrderPage.addressInformation(productInformation.get("customerName"),
                productInformation.get("street"),
                productInformation.get("city"),
                productInformation.get("state"),
                productInformation.get("zipCode"));
    }
    @When("User choose cardType and provides cardNumber,carExpireDate for payment information")
    public void user_choose_card_type_and_provides_card_number_car_expire_date_for_payment_information(DataTable dataTable) throws InterruptedException {
        Map<String,String> productInformation =dataTable.asMap();
        smartBearOrderPage.paymentInformation(productInformation.get("cardType"),
                productInformation.get("cardNumber"),
                productInformation.get("carExpireDate"));
    }
    @Then("User clicks process button and validates message")
    public void user_clicks_process_button_and_validates_message(DataTable dataTable) throws InterruptedException {
        smartBearOrderPage.proceedOrder();
      List<String> message=dataTable.asList();
      Assert.assertEquals(message.get(0),smartBearOrderPage.getMessage());
    }

}
