package pageObjectTr;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Signup_TR {

	public WebDriver driver;
	WebDriverWait wait;
	
	public Signup_TR(WebDriver driver){
		
		 if (driver == null) {
		        throw new IllegalArgumentException("WebDriver is null! Did BaseClass initialize it?");
		    }
		 
		this.driver=driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	@FindBy(xpath="//button[@aria-label='Close']")
	WebElement closeBtn;
	
	@FindBy(xpath="//button[@type='button' and normalize-space(text())='Sign up']")
	WebElement SignUpClick;
	
	@FindBy(xpath="//input[@id='firstName']")
	WebElement txtFname;
	
	@FindBy(xpath="//input[@id='lastName']")
	WebElement txtLname;
	
	@FindBy(xpath="//input[@id='password']")
	WebElement txtPassword;
	
	@FindBy(xpath="//input[@id='confirmPassword']")
	WebElement txtCpass;
	
	@FindBy(xpath="//input[@id='email']")
	WebElement txtEmail;
	
	@FindBy(xpath="//input[@id='instagramId']")
	WebElement txtInstaId;
	
	@FindBy(xpath="//input[@id='ToCAgreed']")
	WebElement checkTerms;
	
	@FindBy(xpath="//button[normalize-space()='Create account']")
	WebElement btnCreateAccount;
	
	public void crossClick() {
		
		closeBtn.click();
	}
	public void SignUpScreen() {
		
		SignUpClick.click();
	}
	public void addFname(String fname) {
		
		txtFname.sendKeys(fname);
	}
	
	public void addLname(String lname) {
		
		txtLname.sendKeys(lname);
	}
	
	public void addPassword(String password) {
		
		txtPassword.sendKeys(password);
	}
	
	public void addConfirmPassword(String cpass) {
		
		txtCpass.sendKeys(cpass);
	}
	
	public void addEmail(String email) {
		
		txtEmail.sendKeys(email);
	}
	
	public void addInstaId(String id) {
		
		txtInstaId.sendKeys(id);
	}
	
	public void checkTermsClick() {
		
		checkTerms.click();
	}
	
	public void btnSignUp() {
		
		btnCreateAccount.click();
	}
	
	public void clearPassword() {
		
		txtCpass.clear();
	}
	
}
