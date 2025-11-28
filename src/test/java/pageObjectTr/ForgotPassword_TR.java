package pageObjectTr;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ForgotPassword_TR {

	public WebDriver driver;
	
	public ForgotPassword_TR(WebDriver driver){
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[normalize-space()='Forgot your password?']")
	WebElement forgotPasswordLink;
	
	@FindBy(xpath="//input[@id='reset-email']")
	WebElement txtEmail;
	
	@FindBy(xpath="//button[normalize-space()='Reset Password']")
	WebElement btnReset;
	
	@FindBy(xpath="//button[normalize-space(text())='Back to login']")
	WebElement btnBacktoLogin;
	
	public void clickLink() {
		
		forgotPasswordLink.click();
	}
	
	public void addEmail(String email) {
		
		txtEmail.sendKeys(email);
	}
	
	public void btnResetClick() {
		
		btnReset.click();
	}
	
	public void btnBacktoLoginClick() {
		
		btnBacktoLogin.click();
	}

	
}
