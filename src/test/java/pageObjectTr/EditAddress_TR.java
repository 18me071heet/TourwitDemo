package pageObjectTr;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EditAddress_TR {

	public WebDriver driver;
	
	WebDriverWait wait;
	JavascriptExecutor js;
	
	public EditAddress_TR(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		js = (JavascriptExecutor) driver;
		
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
	
   	public void clickAddress() {
   		
   		btnAddress.click();
   	}
   
 	public void addFname(String fname) {
  
   		txtFname.sendKeys(fname);
   	}
   	
 	 public void addLname(String lname) {
 		 
      	txtLname.sendKeys(lname);
    
    	}
 	 
 	public void addPhone(String phone) {
 	   
    	txtPhone.sendKeys(phone);
    }
 	
 	 public void addEmail(String email) {
 		   
 		   txtEmail.sendKeys(email);
 	   }
 	 
 	 public void addAddress(String address) {
 		 
 	       txtAddress.sendKeys(address);
 	       
 	    }
 	 
 	 public void addCode(String code) {
 		
 	        txtCode.sendKeys(code);
 	    
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
   
   @FindBy(xpath = "//button[.//span[normalize-space()='Add new address']]")
   WebElement btnAddNewAddress;
   
   public void myProfile() {
	 	   
	   btnProfile.click();
   }
  
   public void saveAddress() {
	  
	   btnSave.click();
   }
   
   public String getUserFname() {
	   return txtFname.getText().trim();
   }
   

    public void setDefaultForUser(String userName) {

	    List<WebElement> addressCards = driver.findElements(
	            By.xpath("//div[@class='rounded-lg border border-gray-200 p-4']"));

	    for (WebElement card : addressCards) {

	        String nameText = card.findElement(By.xpath(".//p[1]")).getText().trim();

	        if (nameText.equalsIgnoreCase(userName)) {

	            WebElement setDefaultButton = card.findElement(
	                    By.xpath(".//button[contains(text(),'Set as default')]"));

	           js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", card);

	            wait.until(ExpectedConditions.elementToBeClickable(setDefaultButton));

	            js.executeScript("arguments[0].click();", setDefaultButton);
	            break;
	        }
	    }
	}
    
    public void clickAddNewAddress() {
    	
        try {
           
            js.executeScript("arguments[0].scrollIntoView({block:'center'});", btnAddNewAddress);
         wait.until(ExpectedConditions.elementToBeClickable(btnAddNewAddress));
           js.executeScript("arguments[0].click();", btnAddNewAddress);
   
        } catch (Exception e) {
           
       new Actions(driver).moveToElement(btnAddNewAddress).click().perform();
       
        }
    }    
   }
   
  
			   