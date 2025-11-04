package pageObjectTr;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ResetPassword_TR {

	public WebDriver driver;
	WebDriverWait wait;
	
	public ResetPassword_TR(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	@FindBy(xpath="//a[normalize-space()='My Profile']")
	WebElement btnProfile;
	
	@FindBy(xpath="//span[normalize-space()='Reset Password']/parent::*")
	WebElement btnResetPassword;

	@FindBy(xpath="//input[@id='oldPassword']")
	WebElement txtOldPassword;
	
	@FindBy(xpath="//input[@id='newPassword']")
	WebElement txtNewPassword;
	
	@FindBy(xpath="//input[@id='confirmPassword']")
	WebElement txtConfirmPassword;
	
	@FindBy(xpath="//button[normalize-space()='Reset Password']")
	WebElement savePassword;
	
	@FindBy(id = "dropdownAvatarNameButton")
	WebElement avtarClick;
	
	public void profileClicks(WebDriver driver) {
		
       WebElement profileBtn = wait.until(ExpectedConditions.elementToBeClickable(btnProfile));
		profileBtn.click();
	}
	
	public void resetPassword(WebDriver driver) {
		
		WebElement resetBtn = wait.until(ExpectedConditions.elementToBeClickable(btnResetPassword));
		resetBtn.click();
	}
	
	public void addOldPassword(String oldPassword) {
			
		txtOldPassword.sendKeys(oldPassword);
	}
	
	public void clearOldPassword() {
		
		txtOldPassword.clear();
		txtOldPassword.sendKeys(Keys.CONTROL + "a");
	    txtOldPassword.sendKeys(Keys.DELETE);
	    
	}
	
	public void addNewPassword(String newPassword ) {
		
		txtNewPassword.sendKeys(newPassword);
		
	}
	
	public void addConfirmPassword(String cpass) {
		
		txtConfirmPassword.sendKeys(cpass);
	}
	
	public void clearCpass() {
		
		txtConfirmPassword.clear();
	}
	
	public void avtarClick() {
		
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		    wait.until(ExpectedConditions.elementToBeClickable(avtarClick));
		    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", avtarClick);
	}
	
	public void resetPasswordClick() {
		
		savePassword.click();
	}
	
	public void logOut() {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

	    // Step 1: Click "Log out" from dropdown menu
	    WebElement logOutBtn = wait.until(ExpectedConditions.elementToBeClickable(
	        By.xpath("//button[normalize-space(text())='Log out']")
	    ));
	    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", logOutBtn);

	    // Step 2: Wait for confirmation popup and click "Logout"
	    WebElement confirmLogout = wait.until(ExpectedConditions.elementToBeClickable(
	        By.xpath("//div[contains(@class,'flex justify-center')]/button[normalize-space(text())='Logout']")
	    ));
	    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", confirmLogout);
	}

	 public void subscribeNewsLater(String fname, String email) {
		  
		  //input[@placeholder='Enter your name']
		  
		  WebElement frstName = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(" //input[@placeholder='Enter your name']")));
		  frstName.sendKeys(fname);
		  
		  WebElement emailAddress = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(" //input[@placeholder='Enter your Email']")));
		  emailAddress.sendKeys(email);
		  
		  WebElement termsClick = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(" //input[@type='checkbox']")));
		  termsClick.click();
		  
		//  WebElement termsandConditionLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(" //a[normalize-space()='terms and conditions']")));
		  //termsandConditionLink.click();
		  
	      WebElement subScribeButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(" //button[normalize-space()='Subscribe']")));
		  subScribeButton.click();
		 
	  }
	
}
