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
	WebDriverWait wait;

	
	public UserProfile_TR(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver,Duration.ofSeconds(20));
	
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
	
	@FindBy(xpath="//label[contains(@class,'cursor-pointer')]//div[contains(@class,'absolute') and .//svg]")
	WebElement editIconProfileLogo;
	
	public void myProfileClick() {
		
		WebElement profileBtn = wait.until(ExpectedConditions.elementToBeClickable(btnProfile));
		profileBtn.click();
	}
	
	
	public void editFirstName() {
		
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
		
	    WebElement editBtn = wait.until(ExpectedConditions.presenceOfElementLocated(
		        By.xpath("//h3[normalize-space()='Last Name']/following::button[normalize-space()='Edit'][1]")
		    ));

		    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", editBtn);
		    
		        wait.until(ExpectedConditions.elementToBeClickable(editBtn)).click();
		  
	}

	public void editInsta() {
		
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
		    
		  wait.until(ExpectedConditions.visibilityOfElementLocated(
		        By.xpath("//*[contains(text(),'Profile updated successfully')]")
		    ));
	}
	
	
	public void clickFollowersView() {
		
   	WebElement editBtn = wait.until(ExpectedConditions.presenceOfElementLocated(
				By.xpath("//h3[normalize-space()='Followers']/following::span[normalize-space()='View'][1]")));
		
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView({block:'center'});", editBtn);
		
		wait.until(ExpectedConditions.elementToBeClickable(editBtn)).click();
		
	}
	
	public void clickFollowingView() {
				
			WebElement editBtn = wait.until(ExpectedConditions.presenceOfElementLocated(
					By.xpath("//h3[normalize-space()='Following']/following::span[normalize-space()='View'][1]")));
			
			((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView({block:'center'});", editBtn);
			
			wait.until(ExpectedConditions.elementToBeClickable(editBtn)).click();
			
		}
	
	public void search(String name) {
		
		txtSearch.sendKeys(name);
		
	}
	
	public void unfollowUser() {
			
		WebElement unFollowUser = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Unfollow']")));
		unFollowUser.click();
	}
	
	public void profileImage() {
		
		WebElement profileIcon = wait.until(ExpectedConditions.elementToBeClickable(
			    By.xpath("//div[contains(@class,'rounded-full') and contains(@class,'h-7') and contains(@class,'w-7')]")
			));
		
		profileIcon.click();
	}
	
	public void deleteAccount() throws InterruptedException {
		
		WebElement deleteAccountLink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[normalize-space()='Delete my account']")));
		
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", deleteAccountLink);
		Thread.sleep(2000);
		deleteAccountLink.click();
		
		WebElement confirmBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(@class,'bg-primary') and normalize-space()='Delete Account']")));
		
		confirmBtn.click();
		
	}
	
	public void logOut() {
		
		WebElement logOutBtn =  wait.until(ExpectedConditions.elementToBeClickable(By.xpath(" //button[normalize-space()='Log out']")));
		logOutBtn.click();
		
		WebElement confirmLogout = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space(text())='Logout']")));
		confirmLogout.click();
		
	}
	
	public void changeProfileImage() {

	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	    // 1. Click edit icon
	    WebElement editIcon = wait.until(
	        ExpectedConditions.elementToBeClickable(
	            By.xpath("//div[normalize-space()='TQ']/following-sibling::div[contains(@class,'p-2')]")
	        )
	    );
	    editIcon.click();

	    // 2. Upload image
	    WebElement fileInput = wait.until(
	        ExpectedConditions.presenceOfElementLocated(
	            By.xpath("//input[@type='file']")
	        )
	    );

	    fileInput.sendKeys("C:\\Users\\INX\\OneDrive\\Documents\\Saved Pictures\\test.jpg");
	}



	
}
