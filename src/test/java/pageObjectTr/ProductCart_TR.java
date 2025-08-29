package pageObjectTr;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductCart_TR {
	
	public WebDriver driver;
	
	public ProductCart_TR(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//a[@href='/crafts/my-cart']")
	WebElement cartIcon;
	
	@FindBy(xpath=" //button[normalize-space()='Proceed to checkout']")
	WebElement checkOut;
	
	public void cartPage(WebDriver driver) {
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(15));
		WebElement cartPage = wait.until(ExpectedConditions.elementToBeClickable(cartIcon));
		cartPage.click();
	}
	
	public void checkOut(WebDriver driver) {
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(15));
		WebElement checkOutBtn = wait.until(ExpectedConditions.elementToBeClickable(checkOut));
		checkOutBtn.click();
	}
	
	
}
