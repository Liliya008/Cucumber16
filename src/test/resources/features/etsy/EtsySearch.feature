@regression
Feature: Testing the Search Functionality of the Etsy Website
  Scenario: Search Functionality Happy Path for Etsy Hat
    When User searches for 'Hat' for Etsy
    Then User validate the title 'Hat - Etsy' from Etsy

  Scenario: Search Functionality Happy Path for Etsy Key
    When User searches for 'Key' for Etsy
    Then User validate the title 'Key - Etsy' from Etsy

  Scenario: Search Functionality Happy Path for Etsy Pin
    When User searches for 'Pin' for Etsy
    Then User validate the title 'Pin - Etsy' from Etsy

