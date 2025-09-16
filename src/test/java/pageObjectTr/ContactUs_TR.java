package pageObjectTr;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactUs_TR {
	
	public WebDriver driver;
	
	public ContactUs_TR(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[normalize-space()='Contact Us']")
	WebElement btnContactUs;

	@FindBy(xpath="//input[@id='userName']")
	WebElement txtName;
	
	@FindBy(xpath="//input[@id='userEmail']")
	WebElement txtEmail;
	
	@FindBy(xpath="//button[@type='submit' and text()='Send Message']")
	WebElement btnSave;
	
	public void contactUsClick() {
		
		btnContactUs.click();
		
	}
	
	public void addFname(String fname) {
		
		txtName.sendKeys(fname);
	}
	
	public void addEmail(String email) {
		
		txtEmail.sendKeys(email);
	}
		
	public void saveContactUs() {
		
		btnSave.click();
	}

}
