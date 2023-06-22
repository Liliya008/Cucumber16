Feature: Testing the Google Search Functionality Parameters
#general description
  Scenario: Happy Path(positive) testing for Search Parameters
 #test case
    Given User navigates to the 'https://www.google.com/'
    When User searches for 'CodeFish'
    Then User validates first page returns more than 10 links

  Scenario: Happy Path(positive) Testing Result for Search Parameters
    Given User navigates to the 'https://www.google.com/'
    When User searches for 'Kyrgyz Food in USA'
    Then User validates the result is 300000000

  Scenario: Happy Path(positive) Testing Search Timing for an item Parameters
    Given User navigates to the 'https://www.google.com/'
    When User searches for 'Turkish baklava'
    Then User validates the loaded result is less than 1.0 sec