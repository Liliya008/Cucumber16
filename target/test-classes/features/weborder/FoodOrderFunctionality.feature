@regression
Feature: Testing Food Order functionality of WebOrder

  Background: Food Order same steps
    Given User provides username and password
    When User clicks Group Order Box and Next Button
    And User provides note 'I LOVE SELENIUM' to invitees box
    And User provides gmail "email@gmail.com","email2@gmail.com" to InviteList

  Scenario:Testing Happy Path(positive) for MyHouse Food Order
    And User chooses the location 'My House' and validates the address '3137 Laguna'
    And User clicks Create Group OrderButton
    Then User validates the 'View Group Order' and 'Your group order is now pending' from description


  Scenario: Testing Happy Path(positive) for Office Food Order
    And User chooses the location 'Office' and validates the address '2012 EMPIRE'
    And User clicks Create Group OrderButton
    Then User validates the 'View Group Order' and 'Your group order is now pending' from description



