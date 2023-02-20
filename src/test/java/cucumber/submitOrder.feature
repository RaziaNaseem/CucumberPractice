
@tag
Feature: Submit an order in Ecommerce website

 
 Background:
  Given I landed on Ecommerce webpage
  @Regression
  Scenario Outline:  Positive test of purchasing the order
	   
	  Given logged in with <username> and  <password>
    When I add <productName> from cart 
    And checkout <productName> and submit the order
    Then "THANK YOU FOR YOUR ORDER" is displayed on the confirmation page

    Examples: 
      | username          | password        | productName       |
      | standard_user     | secret_sauce    | Sauce Labs Onesie |
    
