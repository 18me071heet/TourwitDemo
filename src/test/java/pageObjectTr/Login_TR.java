package pageObjectTr;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
	
	@FindBy(xpath="(//button[normalize-space()='Logout'])[last()]")
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
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		WebElement logOut = wait.until(ExpectedConditions.elementToBeClickable(btnLogOut));
		
		logOut.click();
	}
	
	public void logOutConfirm() {
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		WebElement logOutConfirm = wait.until(ExpectedConditions.elementToBeClickable(logOutConfirmation));
		
		logOutConfirm.click();
	}
	
	public boolean isLoginSuccessful() {
		
		  try {
		        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		        WebElement profileIcon = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@alt='Profile']")));
		        return profileIcon.isDisplayed();
		    } catch (Exception e) {
		        return false; // profile icon not found → login failed
		    }
	}
	
	public void clickSignUpLink() {
		
		signUpLink.click();
	}
	
}
