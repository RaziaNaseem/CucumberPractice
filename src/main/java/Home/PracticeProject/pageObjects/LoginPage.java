package Home.PracticeProject.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Home.PracticeProject.abstractComponents.parentObjectClass;

public class LoginPage extends parentObjectClass {
	WebDriver driver;
	public LoginPage(WebDriver driver)

	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="user-name")
	WebElement usernameEle;
	
	@FindBy(id="password")
	WebElement passwordEle;
	
	@FindBy(id="login-button")
	WebElement login;
	
	@FindBy(css="h3[data-test='error']")
	WebElement errorMsg;
	// Boolean loginCheck;
	
	public ProductCatalog logIntoApplication(String username, String password)
	
	{
		usernameEle.sendKeys(username);
		passwordEle.sendKeys(password);
		login.click();
		return new ProductCatalog(driver);
		
	}
	
	public String checkLogin()
	{
		return errorMsg.getText();
		
	}
	
	public void goTo()
	{
		driver.get("https://www.saucedemo.com/");
	}
}
