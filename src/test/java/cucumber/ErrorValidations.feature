
@tag
Feature: Error validation
 
	
  @ErrorValidation
  Scenario Outline:  Positive test of purchasing the order
   
    Given I landed on Ecommerce webpage
    When logged in with <username> and  <password>
    Then "Epic sadface: Sorry, this user has been locked out." message is displayed

    Examples: 
      | username          | password        | 
      | locked_out_user     | secret_sauce    | 
    
