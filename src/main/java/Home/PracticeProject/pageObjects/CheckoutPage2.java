package Home.PracticeProject.pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Home.PracticeProject.abstractComponents.parentObjectClass;

public class CheckoutPage2 extends parentObjectClass {
	WebDriver driver;
	public CheckoutPage2(WebDriver driver)

	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(id="finish")
	WebElement finishEle;
	
	
	
	public OrderConfirmationPage finishcheckout()
	{
		finishEle.click();
		return new OrderConfirmationPage(driver);
	}
}
