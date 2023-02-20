package Home.PracticeProject.pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Home.PracticeProject.abstractComponents.parentObjectClass;

public class OrderConfirmationPage extends parentObjectClass {
	WebDriver driver;
	public OrderConfirmationPage(WebDriver driver)

	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(css="h2[class='complete-header']")
	WebElement TextEle;
	
	
	
	public String getTextInOrderPage()
	{
		
		return TextEle.getText();
		
		//return new
	}
}
