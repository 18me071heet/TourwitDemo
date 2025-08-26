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
	
	public void addEmail(String email) {
		
		txtEmail.sendKeys(email);
	}
	
	public void addPass(String password) {
		
		txtPassword.sendKeys(password);
	}
	
	public void loginBtn() {
		
		btnLogin.click();
	}
	
}
