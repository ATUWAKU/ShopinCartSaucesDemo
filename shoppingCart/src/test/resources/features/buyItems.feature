Feature: As an applicant for the vacancy of automator
         I want to automate the purchase of products
         To demonstrate my knowledge


  Scenario: Successful. Verify that the purchase order is correctly generated
    Given I authenticate with User And Password
      |User         |Password    |
      |standard_user|secret_sauce|
    When I make the order of "backpack" and "bolt-t-shirt"
    Then The purchase order must list the products "Sauce Labs Backpack" and "Sauce Labs Bolt T-Shirt"

  Scenario: Successful. Make the purchase of products
    Given I authenticate with User And Password
      |User         |Password    |
      |standard_user|secret_sauce|
    When I make the purchase of ProductOne and ProductTwo for FirstName LastName to Zip
      |ProductOne|ProductTwo  |FirstName|LastName|Zip   |
      |backpack  |bolt-t-shirt|Yisus    |Munera  |050001|
    Then The purchase must be completed by displaying the message "THANK YOU FOR YOUR ORDER"

