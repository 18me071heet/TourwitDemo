package pageObjectTr;

import java.time.Duration;
import org.openqa.selenium.TimeoutException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyBookings_TR {

	public WebDriver driver;
	WebDriverWait wait;
	
	public MyBookings_TR(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver,Duration.ofSeconds(20));
	}
	
	@FindBy(xpath="//input[@id='search']")
	WebElement search;
    
	@FindBy(xpath="//img[@alt='Logo']")
	WebElement homeLogo;

	public void myBookings() {
		
		WebElement btnBookings= wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='My Bookings']")));
		btnBookings.click();
		
	}
	
	public void serachId(String id) {
		
		search.sendKeys(id);
	}
	
	public void viewDetails() {
		
		
		WebElement viewDetailsLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//a[contains(text(),'View Details')]")));
		viewDetailsLink.click();
		
	}
	
	public void clickBack() {
		
		WebElement clickBackArrow = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[local-name()='svg' and @class='h-6 w-6']")));
		clickBackArrow.click();
	}
	
	public void homeLogoClick() {
		
		homeLogo.click();
	}
	
	public void clickNotificationIcon() {

		WebElement notiIcon = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='/notification']")));
		notiIcon.click();
			
	}
	
	public void clearAllNoti() {
		
		WebElement notiClear = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(" //button[normalize-space()='Clear All']")));
		notiClear.click();
	}
	
	public void moreNotification() throws InterruptedException {
		
		
		try {
			
			WebElement showMore = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(" //button[normalize-space()='Load More']")));
			
			 JavascriptExecutor js = (JavascriptExecutor) driver;
			 js.executeScript("arguments[0].scrollIntoView({behavior:'smooth', block:'center'});", showMore);
			
			
		  	if(showMore.isDisplayed()) {
				showMore.click();	
			} else {
				
				System.out.println("Show more button is not found");
			}
			
			
		}catch(TimeoutException e) {
			
			System.out.println("Show more button is not displaying");
		}
		
	}
	
	
	
}
