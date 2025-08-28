package pageObjectTr;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login_TR {

	public WebDriver driver;
	
	public Login_TR(WebDriver driver){
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@id='email']")
	WebElement txtEmail;
	
	@FindBy(xpath="//input[@id='password']")
	WebElement txtPassword;
	
	@FindBy(xpath=" //button[normalize-space()='Login to your account']")
	WebElement btnLogin;
	
	@FindBy(xpath="//img[@alt='Profile']")
	WebElement profileIcon;
	
	@FindBy(xpath="//button[normalize-space()='Log out']")
	WebElement btnLogOut;
	
	@FindBy(xpath="//button[contains(text(),'Logout')]")
	WebElement logOutConfirmation;
	
	@FindBy(xpath="//a[normalize-space()='Sign up']")
	WebElement signUpLink ;
	
	public void addEmail(String email) {
		
		txtEmail.sendKeys(email);
	}
	
	public void addPass(String password) {
		
		txtPassword.sendKeys(password);
	}
	
	public void loginBtn() {
		
		btnLogin.click();
	}
	
	public void profileIconClick() {
		
		profileIcon.click();
	}
	public void logOut() {
		
		btnLogOut.click();
	}
	
	public void logOutConfirm() {
		
		logOutConfirmation.click();
	}
	
	public void clickSignUpLink() {
		
		signUpLink.click();
	}
	
}
