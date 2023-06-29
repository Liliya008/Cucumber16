@regression
Feature: Order creation functionality of SmartBear Website

  Scenario Outline: Creating the WebOrder from SmartBear with Scenario Outline
    Given User provides username and password for SmartBear Login
    When User clicks Order Button and provides the '<product>' and '<quantity>' for product information
    And User provides '<customerName>','<street>','<city>','<state>','<zipCode>' for address information
    And User choose '<cardType>' and provides '<cardNumber>','<carExpireDate>' for payment information
    Then User clicks process button and validate 'New order has been successfully added.' and click view order button
    And User validates all information '<customerName>','<product>','<quantity>','<street>','<city>','<state>','<zipCode>','<cardType>','<cardNumber>','<carExpireDate>' from table

    Examples:
      | product     | quantity | customerName | street         | city    | state      | zipCode | cardType         | cardNumber  | carExpireDate |
      | MyMoney     | 4        | Alex         | 1423 Rand Road | Chicago | IL         | 60075   | Visa             | 45678909876 | 06/25         |
      | FamilyAlbum | 3        | Ava          | 1987 Avenue    | LA      | California | 60077   | MasterCard       | 456123456   | 07/27         |
      | ScreenSaver | 2        | Sofa         | 6547 Devon     | Miami   | Florida    | 60475   | American Express | 978764434   | 09/24         |


Scenario: Creating the WebOrder from SmartBear with DataTable
  Given User provides username and password for SmartBear Login
  When User clicks Order Button and provides the product and quantity for product information
  |product|MyMoney|
  |quantity|4|
  And User provides customerName,street,city,state,zipCode for address information
  |customerName|Alex|
  |street      | 1423 Rand Road|
  |city        |Chicago        |
  |state       |IL             |
  |zipCode     |60075          |
  And User choose cardType and provides cardNumber,carExpireDate for payment information
  |cardType|Visa|
  |cardNumber|45678909876|
  |carExpireDate| 06/25  |
  Then User clicks process button and validates message
  |New order has been successfully added.|