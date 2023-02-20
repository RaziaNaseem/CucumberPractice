package Home.PracticeProject.pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Home.PracticeProject.abstractComponents.parentObjectClass;

public class CheckoutPage1 extends parentObjectClass {
	WebDriver driver;
	public CheckoutPage1(WebDriver driver)

	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(id="first-name")
	WebElement fname;
	
	@FindBy(id="last-name")
	WebElement lname;
	
	@FindBy(id="postal-code")
	WebElement pincode;
	
	@FindBy(id="continue")
	WebElement continu;
	
	public void enterShippingDetails(String firstname,String lastname,String pcode)
	{
		fname.sendKeys(firstname);
		lname.sendKeys(lastname);
		pincode.sendKeys(pcode);
	}
	
	
	public CheckoutPage2 continuetocheckout()
	{
		continu.click();
	    return new CheckoutPage2(driver);
	}
}
