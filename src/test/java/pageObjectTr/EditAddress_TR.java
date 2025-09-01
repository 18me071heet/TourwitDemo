package pageObjectTr;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EditAddress_TR {

	public WebDriver driver;
	
	public EditAddress_TR(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[normalize-space()='My Profile']")
	WebElement btnProfile;
	
	@FindBy(xpath="//span[normalize-space()='Saved Addresses']/parent::*")
	WebElement btnAddress;
	
	@FindBy(xpath="//input[@id='firstName']")
	WebElement txtFname;
	
	@FindBy(xpath="//input[@id='lastName']")
	WebElement txtLname;
	
	@FindBy(xpath="//input[@id='email']")
	WebElement txtEmail;
	
	@FindBy(xpath="//input[@id='mobile']")
	WebElement txtPhone;
	
	@FindBy(xpath="//input[@id='addressLine']")
	WebElement txtAddress;
	
	@FindBy(xpath=" //input[@id='zipCode']")
	WebElement txtCode;
   
	@FindBy(xpath="//button[normalize-space()='Save address']")
	WebElement btnSave;
	
	@FindBy(xpath="")
	WebElement btnDefault;
	
   	public void clickAddress() {
   		
   		btnAddress.click();
   	}
   
   	public void changeFname(String fname) {
   		
   		txtFname.sendKeys(Keys.CONTROL + "a");
   		txtFname.sendKeys(Keys.DELETE);
   		txtFname.sendKeys(fname);
   	}
   
    public void changeLname(String lname) {
    	
    	txtLname.sendKeys(Keys.CONTROL + "a");
    	txtLname.sendKeys(Keys.DELETE);
     	txtLname.sendKeys(lname);
   
   	}
    
    public void changePhone(String phone) {
   
    	txtPhone.sendKeys(Keys.CONTROL + "a");
    	txtPhone.sendKeys(Keys.DELETE);
    	txtPhone.sendKeys(phone);
    }
   
   public void changeEmail(String email) {
	   
	   txtEmail.sendKeys(Keys.CONTROL + "a");
	   txtEmail.sendKeys(Keys.DELETE);
	   txtEmail.sendKeys(email);
   }
   
    public void changeAddress(String address) {
   
    	   
    	txtAddress.sendKeys(Keys.CONTROL + "a");
 	   txtAddress.sendKeys(Keys.DELETE);
    	txtAddress.sendKeys(address);
    }
   
   
   public void changeCode(String code) {
   
	   txtCode.sendKeys(Keys.CONTROL + "a");
	   txtCode.sendKeys(Keys.DELETE);
        txtCode.sendKeys(code);
    
   }
   
   public void myProfile() {
	 	   
	   btnProfile.click();
   }
   

   public void saveAddress() {
	  
	   btnSave.click();
   }
   
   public String getUserFname() {
	   return txtFname.getText().trim();
   }
   
   public void clickDefault() {
	   
	   String name=getUserFname();
	   
	   if(name.equalsIgnoreCase("Smith")) {
		   
		   ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", btnDefault);
		   
		   WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		   
		   wait.until(ExpectedConditions.elementToBeClickable(btnDefault)).click();
	       
	      
	    } 
	   
	   else
	   {
	        System.out.println("User is not smith, skipping default selection. Found: " + name);
	    }
	   
	   }
   }
   
  
			   