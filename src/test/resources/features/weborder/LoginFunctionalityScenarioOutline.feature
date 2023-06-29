@regression
Feature: Testing login functionality for WebOrder

  @smoke
  Scenario: Happy Path(Correct username-Correct Password)
    When User provides 'guest1@microworks.com','Guest1!' and click Login button
    Then User validates the 'ORDER DETAILS - Weborder'

  @smoke
  Scenario Outline: Negative Login
    When User provides '<username>','<password>' and click Login button
    Then User validates the message '<message>'
    Examples:
      | username         | password | message        |
      | guest1@gmail.com | wrong    | Sign in Failed |
      | wrong@gmail.com  | Guest1!  | Sign in Failed |
      |                  |          | Sign in Failed |

