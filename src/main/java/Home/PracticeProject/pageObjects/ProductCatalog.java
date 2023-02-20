package Home.PracticeProject.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Home.PracticeProject.abstractComponents.parentObjectClass;

public class ProductCatalog extends parentObjectClass{
	WebDriver driver;
	
	public ProductCatalog(WebDriver driver)

	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css=".inventory_item")
	List<WebElement> listOfItems;

	By addToCart = By.cssSelector(".btn");
	By productToAdd = By.cssSelector(".inventory_item_name");
	
	WebElement item;
	
	public List<WebElement> getProductList()
	{
		
		return listOfItems;
		
	}
	public WebElement getProductByName(String productName)
	{
		
		WebElement item = getProductList().stream().filter(
				products -> products.findElement(productToAdd).getText().equals(productName))
				.findFirst().orElse(null);
     return item;
		
		
	}
	
	public void addProductToCart(String productName)
	{
		getProductByName(productName).findElement(addToCart).click();
		
	}
	
	
}
