Feature: Testing order functionality for WebOrder
  Scenario:Happy Path(positive) testing group order functionality
    When User logged in,click the order box,next button,provide inviteNote 'I LOVE SELENIUM',inviteList 'email@gmail.com,email2@gmail.com'
    Then User choose the delivery option (My House) and validate the address '3137 Laguna'
    Then User click order button,validate the header 'View Group Order',description 'Your group order is now pending'






