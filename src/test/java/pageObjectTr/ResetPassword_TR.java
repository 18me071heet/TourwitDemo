package pageObjectTr;

import java.time.Duration;

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
	
	public void addNewPassword(String newPassword ) {
		
		txtNewPassword.sendKeys(newPassword);
		
	}
	
	public void addConfirmPassword(String cpass) {
		
		txtConfirmPassword.sendKeys(cpass);
	}
	
	public void clearCpass() {
		
		txtConfirmPassword.clear();
	}
	
	public void resetPass() {
		
		savePassword.click();
	}
	
}
