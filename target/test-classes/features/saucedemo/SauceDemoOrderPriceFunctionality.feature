@regression
Feature: Testing order functionality of SauceDemo Website

  Scenario: Testing order functionality and item price from SauceDemo Website
    Given User provides username and password for SauceDemo Login
    When User chooses 'Sauce Labs Backpack' and click Add to Cart button
    And Click Cart sign on the top right
    And Click checkout button
    And fill in all the box('Ava','Kim','60078') and click continue button
    When User validates the name of the 'Sauce Labs Backpack', the 29.99$, and the 2.40$ amount should be 8% of the total
    And The total amount should match the sum of the item total and tax,clicks the Finish button
    Then User validate the message 'Thank you for your order!'

  Scenario Outline: Testing order functionality and item price from SauceDemo Website with Scenario Outline
    Given User provides username and password for SauceDemo Login
    When User chooses '<itemName>' and click Add to Cart button
    And Click Cart sign on the top right
    And Click checkout button
    And fill in all the box('<firstName>','<lastName>','<zipCode>') and click continue button
    When User validates the name of the '<itemName>', the <itemTotal>$, and the <taxAmount>$ amount should be 8% of the total
    And The total amount should match the sum of the item total and tax,clicks the Finish button
    Then User validate the message 'Thank you for your order!'
    Examples:
      | itemName                          | firstName | lastName | zipCode | itemTotal | taxAmount |
      | Sauce Labs Backpack               | Mia       | Hill     | 60070   | 29.99     | 2.40      |
      | Sauce Labs Bike Light             | Ava       | Kim      | 60071   | 9.99      | 0.80      |
      | Sauce Labs Bolt T-Shirt           | Eli       | Ten      | 60072   | 15.99     | 1.28      |
      | Sauce Labs Fleece Jacket          | Max       | Lee      | 60073   | 49.99     | 4.00      |
      | Sauce Labs Onesie                 | Alisa     | King     | 60074   | 7.99      | 0.64      |
      | Test.allTheThings() T-Shirt (Red) | Amara     | Diaz     | 60075   | 15.99     | 1.28      |

  Scenario: Testing order functionality and item price from SauceDemo Website with DataTable
    Given User provides username and password for SauceDemo Login
    When User chooses item and click Add to Cart button
      | itemName | Sauce Labs Backpack |
    And Click Cart sign on the top right
    And Click checkout button
    And fill in all the box(firstName,lastName,zipCode) and click continue button
      | firstName | Ava   |
      | lastName  | Kim   |
      | zipCode   | 60098 |
    When User validates the name of the product, the item total, and the tax amount should be eight percentage of the total
      | productName | Sauce Labs Backpack |
      | itemTotal | 29.99 |
      | taxAmount | 2.40  |
      | taxPercentage | 8 |
    And The total amount should match the sum of the item total and tax,clicks the Finish button
    Then User validate the message
      | Thank you for your order! |