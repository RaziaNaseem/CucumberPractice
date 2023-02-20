package Home.PracticeProject.pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Home.PracticeProject.abstractComponents.parentObjectClass;

public class CartPage extends parentObjectClass {
	WebDriver driver;
	public CartPage(WebDriver driver)

	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(css=".inventory_item_name")
	List<WebElement> listOfItems;
	
	@FindBy(id="checkout")
	WebElement checkoutEle;
	
	public boolean verifyProductDisplay(String productname)
	{
		
		boolean match = listOfItems.stream().anyMatch(cartproduct->cartproduct.getText().equalsIgnoreCase(productname));
		return match;
	}
	
	public CheckoutPage1 checkoutCart()
	{
		checkoutEle.click();
		return new CheckoutPage1(driver);
	}
	
}
