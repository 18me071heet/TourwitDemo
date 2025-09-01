package pageObjectTr;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DataProviderLogIn {

	public WebDriver driver;
	
	WebDriverWait wait;
	
	public DataProviderLogIn(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	@FindBy(xpath="//input[@id='email']")
	WebElement txtEmail;
	
	@FindBy(xpath="//input[@id='password']")
	WebElement txtPass;
	
	@FindBy(xpath="//button[normalize-space()='Login to your account']")
	WebElement btnLogin;
	
	public void setEmail(String email) {
		
	  
	    wait.until(ExpectedConditions.visibilityOf(txtEmail));
	    txtEmail.clear();
	    txtEmail.sendKeys(email);
	}
	
	public void setPass(String password) {
		
	
		 wait.until(ExpectedConditions.visibilityOf(txtPass));
		 txtPass.clear();
		 txtPass.sendKeys(password);
	}
	
	public void logIn() {
		
		btnLogin.click();
		
	}
	
	
}
