package pageObjectTr;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class HomePage_TR {

	public WebDriver driver;
	WebDriverWait wait;
	
	public HomePage_TR(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver,Duration.ofSeconds(20));		
	}
		
	@FindBy(xpath=" //a[normalize-space()='World of Travel']")
	WebElement btnTravelHeader;
	
	public void travelNavigation() {
		
		WebElement btnTravel = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(" //a[normalize-space()='World of Travel']")));
		btnTravel.click();		
	}
	
	public void countrySelection() {
		
		WebElement countryAsia = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(" //a[normalize-space()='Asia']")));
		countryAsia.click();
	}
	
	public void countryClick() {
		
		WebElement countryClicks = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(" //span[normalize-space()='Japan']")));
		countryClicks.click();		
	}
	
	public void txtComment(WebDriver driver,String comment) {
		
		WebElement txtCommentField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//textarea[@placeholder='What are your thoughts?']")));
			
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", txtCommentField);
		txtCommentField.sendKeys(comment);
				
		}
		
	
	public void suggestBlogCick(WebDriver driver) {
		
		List<WebElement>blogs = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//h2[contains(.,'Related')]/following::div[@class='flex flex-auto flex-col p-4 lg:p-5']//a")));
		
		if(blogs.size()>0) {
			
			WebElement blogClick = blogs.get(2);
			
			 ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",blogClick);
			 
			 blogClick.click();
		}
		
		else {
			
			Assert.fail();
		}
		
	}
	
    public void emojiSelect(WebDriver driver) throws InterruptedException {
   	 
    	 
  	  WebElement smileIcon = wait.until(ExpectedConditions.elementToBeClickable(
  		        By.xpath("//*[name()='svg' and contains(@class,'lucide-smile')]")));
  	  
  	  ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", smileIcon);
  	  smileIcon.click();
  	  
  	  WebElement blush = driver.findElement(By.xpath(" //input[@placeholder='Search']"));
  	  blush.sendKeys("slightly smiling ");
  	  
  	  WebElement smileEmoji = wait.until(ExpectedConditions.elementToBeClickable(
  		        By.xpath("//img[@alt='slightly smiling face']")));
  	  
		  ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", smileEmoji);
  	  smileEmoji.click();
	 
  	  WebElement sendButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@role='button']/*[name()='svg']")));
   	 ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", sendButton);
  	   sendButton.click();
     	 
     	 Thread.sleep(3000);    	 
   }
   
   public void sendComment() {
  	   
 	  WebElement sendButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@role='button']/*[name()='svg']")));
	 ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", sendButton);
	   sendButton.click();
  	 
   }

   public void userProfile() {
		
		WebElement editIcon = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class,'cursor-pointer')]//svg")));
		
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", editIcon);
		
		editIcon.click();
		
		WebElement profile = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(" //li[normalize-space()='User profile']")));
		
		profile.click();
		
		WebElement followUser = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(" //button[normalize-space()='Follow']")));
		
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", followUser);
		
		if(followUser.isDisplayed()) {
			
			followUser.click();		
		}
		
	}
}
