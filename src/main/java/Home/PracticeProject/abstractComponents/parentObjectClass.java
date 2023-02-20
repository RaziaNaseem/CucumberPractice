package Home.PracticeProject.abstractComponents;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Home.PracticeProject.pageObjects.CartPage;

public class parentObjectClass {

	WebDriver driver;
	public parentObjectClass(WebDriver driver)

	{
		this.driver =driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(css="a[class='shopping_cart_link']")
	WebElement cartlink ;
	
	public CartPage goToCartPage()
	{
		cartlink.click();
		return new CartPage(driver);
		
	}
	
	
}
