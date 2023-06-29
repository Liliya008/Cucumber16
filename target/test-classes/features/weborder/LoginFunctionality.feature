@regression
Feature: Testing login functionality for WebOrder
  @smoke
  Scenario: Happy Path(Correct username-Correct Password)
    When User provides 'guest1@microworks.com','Guest1!' and click Login button
    Then User validates the 'ORDER DETAILS - Weborder'
  @smoke
  Scenario: Negative Login(Correct username-Wrong Password)
    When User provides 'guest1@microworks.com','wrong' and click Login button
    Then User validates the message 'Sign in Failed'

  Scenario: Negative Login(Wrong username-Correct Password)
    When User provides 'wrong@gmail.com','Guest1!' and click Login button
    Then User validates the message 'Sign in Failed'

  Scenario: Negative Login(Empty username-Empty Password)
    When User provides ' ',' ' and click Login button
    Then User validates the message 'Sign in Failed'

