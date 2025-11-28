package pageObjectTr;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Login_TR {

	public WebDriver driver;
	WebDriverWait wait;
	
	public Login_TR(WebDriver driver){
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
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
		
		   WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		    WebElement icon = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//img[@alt='Profile']")));
		    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", icon);
	}
	
	public void avtarClick() {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

		WebElement menuButton = wait.until(
		    ExpectedConditions.presenceOfElementLocated(
		        By.xpath("//button[@id='dropdownAvatarNameButton']")
		    )
		);

		menuButton.click();

		
	}
	
	public void logOut() {
		
		WebElement logOut = wait.until(ExpectedConditions.elementToBeClickable(btnLogOut));
		logOut.click();
	}
	
	public void logOutConfirm() {
	
		WebElement logOutConfirm = wait.until(ExpectedConditions.elementToBeClickable(logOutConfirmation));
		logOutConfirm.click();
	}
	
	public boolean isLoginSuccessful() {
		
		  try {
		      
		        WebElement profileIcon = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@alt='Profile']")));
		        return profileIcon.isDisplayed();
		    } catch (Exception e) {
		        return false; // profile icon not found → login failed
		    }
	}
	
	public void clickSignUpLink() {
		
		signUpLink.click();
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
