package PracticeProject.stepDefinition;

import java.io.IOException;

import org.testng.Assert;

import Home.PracticeProject.abstracttest.parentTestClass;
import Home.PracticeProject.pageObjects.CartPage;
import Home.PracticeProject.pageObjects.CheckoutPage1;
import Home.PracticeProject.pageObjects.CheckoutPage2;
import Home.PracticeProject.pageObjects.LoginPage;
import Home.PracticeProject.pageObjects.OrderConfirmationPage;
import Home.PracticeProject.pageObjects.ProductCatalog;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class stepDefinitionImplementation extends parentTestClass {
	
	public LoginPage login;
	public ProductCatalog productCatalog;
	public CheckoutPage1 checkoutpage1;
	public CheckoutPage2 checkoutpage2;
	public OrderConfirmationPage ocp ;
	String firstname = "john";
	String lastname = "peter";
	String pcode = "560022";
	
	@Given("I landed on Ecommerce webpage")
	public void I_landed_on_Ecommerce_webpage() throws IOException
	{
		login=launchApplication();
	}
	
	@Given("^logged in with (.+) and  (.+)$")
	public void logged_in_username_and_password(String username, String password)
	{
		productCatalog =login.logIntoApplication(username,password);
	}

	 @When("^I add (.+) from cart$")
	public void i_add_product_to_cart(String productName)
	{
		productCatalog.addProductToCart(productName);
		
	}
	
	@When("^checkout (.+) and submit the order$")
	public void checkout_submit_order(String productName)
	{
		CartPage cartpage = productCatalog.goToCartPage();
		Assert.assertTrue(cartpage.verifyProductDisplay(productName));
		checkoutpage1 = cartpage.checkoutCart();
		checkoutpage1.enterShippingDetails(firstname, lastname, pcode);
	
		checkoutpage2 = checkoutpage1.continuetocheckout();
		ocp = checkoutpage2.finishcheckout();
	}
	
	@Then("{string} is displayed on the confirmation page")
	public void message_displayed_confirmationPage(String string)
	{
		Assert.assertEquals(ocp.getTextInOrderPage(),string);
		driver.close();
	}
	
	@Then("{string} message is displayed")
	public void message_displayed(String string)
	{
		Assert.assertEquals(string, login.checkLogin());
		driver.close();
		
	}
}


