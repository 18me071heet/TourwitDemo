package pageObjectTr;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UserProfile_TR {

	public WebDriver driver;

	
	public UserProfile_TR(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[normalize-space()='My Profile']")
	WebElement btnProfile;
	
	@FindBy(xpath=" //input[@id='firstName']")
	WebElement editFname;
	
	@FindBy(xpath="//input[@id='lastName']")
	WebElement editLname;
	
	@FindBy(xpath=" //input[@id='instagramId']")
	WebElement txtInstaId;
	
	@FindBy(xpath=" //button[normalize-space()='Save']")
	WebElement btnSave;
	
	@FindBy(xpath=" //input[@placeholder='Search...']")
	WebElement txtSearch;
	
	@FindBy(xpath="//button[normalize-space()='Unfollow']")
	WebElement unFollowUser;
	
	public void myProfileClick() {
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
		WebElement profileBtn = wait.until(ExpectedConditions.elementToBeClickable(btnProfile));
		profileBtn.click();
	}
	
	public void editFirstName() {
		
		
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

	    WebElement editBtn = wait.until(ExpectedConditions.presenceOfElementLocated(
	        By.xpath("//h3[normalize-space()='First Name']/following::button[normalize-space()='Edit'][1]")
	    ));

	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", editBtn);

	    try {
	        wait.until(ExpectedConditions.elementToBeClickable(editBtn)).click();
	    } catch (ElementClickInterceptedException e) {
	        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", editBtn);
	    }
	}

	
	public void editLastName() {
		
		  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		    WebElement editBtn = wait.until(ExpectedConditions.presenceOfElementLocated(
		        By.xpath("//h3[normalize-space()='Last Name']/following::button[normalize-space()='Edit'][1]")
		    ));

		    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", editBtn);
		    
		        wait.until(ExpectedConditions.elementToBeClickable(editBtn)).click();
		  
	}

	public void editInsta() {
		
		  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		    WebElement editBtn = wait.until(ExpectedConditions.presenceOfElementLocated(
		        By.xpath("//h3[normalize-space()='Instagram ID']/following::button[normalize-space()='Edit'][1]")
		    ));

		    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", editBtn);

		    try {
		        wait.until(ExpectedConditions.elementToBeClickable(editBtn)).click();
		    } catch (ElementClickInterceptedException e) {
		        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", editBtn);
		    }
	}
	
	public void editCountry() {
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
		
		WebElement editBtn = wait.until(ExpectedConditions.presenceOfElementLocated(
				By.xpath("//h3[normalize-space()='Country']/following::button[normalize-space()='Edit'][1]")));
		
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView({block:'center'});", editBtn);
		
		wait.until(ExpectedConditions.elementToBeClickable(editBtn)).click();
	}
	
	public void editFnames(String Fname) {
		
		editFname.sendKeys(Keys.CONTROL + "a");
		editFname.sendKeys(Keys.DELETE);
		editFname.sendKeys(Fname);
		
	}
	
	public void editLnames(String Lname) {
		
		editLname.sendKeys(Keys.CONTROL + "a");
		editLname.sendKeys(Keys.DELETE);
		editLname.sendKeys(Lname);
		
	}
	
	public void editInstaId(String id) {
		
		txtInstaId.sendKeys(Keys.CONTROL + "a");
		txtInstaId.sendKeys(Keys.DELETE);
		txtInstaId.sendKeys(id);
		
	}
	
	public void btnSaveClick() {
		
		 btnSave.click();
		 
           WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		    wait.until(ExpectedConditions.visibilityOfElementLocated(
		        By.xpath("//*[contains(text(),'Profile updated successfully')]")
		    ));
	}
	
	
	public void clickFollowersView() {
		
     WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
		
		WebElement editBtn = wait.until(ExpectedConditions.presenceOfElementLocated(
				By.xpath("//h3[normalize-space()='Followers']/following::span[normalize-space()='View'][1]")));
		
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView({block:'center'});", editBtn);
		
		wait.until(ExpectedConditions.elementToBeClickable(editBtn)).click();
		
	}
	
	public void clickFollowingView() {
		
	     WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
			
			WebElement editBtn = wait.until(ExpectedConditions.presenceOfElementLocated(
					By.xpath("//h3[normalize-space()='Following']/following::span[normalize-space()='View'][1]")));
			
			((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView({block:'center'});", editBtn);
			
			wait.until(ExpectedConditions.elementToBeClickable(editBtn)).click();
			
		}
	
	public void search(String name) {
		
		txtSearch.sendKeys(name);
		
	}
	
	public void unfollowUser() {
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
		
		WebElement unFollowUser = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Unfollow']")));
		unFollowUser.click();
	}
	
}
