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
	
	@FindBy(xpath="//span[contains(text(),'Saved Addresses')]")
	WebElement savedAddress;
	
	/*@FindBy(xpath="//input[@id='firstName']")
	WebElement txtFname;
	
	@FindBy(xpath="//input[@id='lastName']")
	WebElement txtLname;
	
	@FindBy(xpath="//input[@id='email']")
	WebElement txtEmail;
	
	@FindBy(xpath="//input[@id='mobile']")
	WebElement txtPhone;
	
	@FindBy(xpath="//input[@id='addressLine']")
	WebElement txtAddress;
	
	@FindBy(xpath="//input[@id='zipCode']")
	WebElement txtCode;
	
	*/
	
	@FindBy(xpath = "//div[contains(@class,'app_ModalpopoutBottom')]//input[@id='firstName']")
	WebElement txtFname;

	@FindBy(xpath = "//div[contains(@class,'app_ModalpopoutBottom')]//input[@id='lastName']")
	WebElement txtLname;

	@FindBy(xpath = "//div[contains(@class,'app_ModalpopoutBottom')]//input[@id='email']")
	WebElement txtEmail;

	@FindBy(xpath = "//div[contains(@class,'app_ModalpopoutBottom')]//input[@id='mobile']")
	WebElement txtPhone;

	@FindBy(xpath = "//div[contains(@class,'app_ModalpopoutBottom')]//input[@id='addressLine']")
	WebElement txtAddress;

	@FindBy(xpath = "//div[contains(@class,'app_ModalpopoutBottom')]//input[@id='zipCode']")
	WebElement txtCode;

	
	@FindBy(xpath="//button[normalize-space()='Save address']")
	WebElement btnSave;
	
   	public void clickAddress() {
   		
   		btnAddress.click();
   	}
   	
   	public void clickSavedAddress() {
   		
   		savedAddress.click();
   	}
   
   /*	public void addFname(String fname) {
   		
   	    wait.until(ExpectedConditions.visibilityOf(txtFname));
   	    wait.until(ExpectedConditions.elementToBeClickable(txtFname));
   	    
   	    
   	    txtFname.click();
   	    txtFname.clear();
   	    txtFname.sendKeys(fname);
   	}

   	public void addLname(String lname) {
   		
   	 wait.until(ExpectedConditions.visibilityOf(txtLname));
	 wait.until(ExpectedConditions.elementToBeClickable(txtLname));
	    
   	    txtLname.click();
   	    txtLname.clear();
   	    txtLname.sendKeys(lname);
   	}

   	public void addPhone(String phone) {
   		
   	 wait.until(ExpectedConditions.visibilityOf(txtPhone));
   	 wait.until(ExpectedConditions.elementToBeClickable(txtPhone));
   		
   	    txtPhone.click();
   	    txtPhone.clear();
   	    txtPhone.sendKeys(phone);
   	}

   	public void addEmail(String email) {
   		
   	 wait.until(ExpectedConditions.visibilityOf(txtEmail));
   	 wait.until(ExpectedConditions.elementToBeClickable(txtEmail));
   	 
   	    txtEmail.click();
   	    txtEmail.clear();
   	    txtEmail.sendKeys(email);
   	}

   	public void addAddress(String address1) {
   		
   	 wait.until(ExpectedConditions.visibilityOf(txtAddress));
   	 wait.until(ExpectedConditions.elementToBeClickable(txtAddress));
   	 
   		
   	    txtAddress.click();
   	    txtAddress.clear();
   	    txtAddress.sendKeys(address1);
   	}

   	public void addCode(String zip) {
   		
   		wait.until(ExpectedConditions.visibilityOf(txtCode));
      	 wait.until(ExpectedConditions.elementToBeClickable(txtCode));
      	 
   	    txtCode.click();
   	    txtCode.clear();
   	    txtCode.sendKeys(zip);
   	}
*/
   	
   	
   	public void addFname(String fname) {
   	    WebElement element = wait.until(ExpectedConditions.visibilityOf(txtFname));
   	    element.clear();
   	    element.sendKeys(fname);
   	}

   	public void addLname(String lname) {
   	    WebElement element = wait.until(ExpectedConditions.visibilityOf(txtLname));
   	    element.clear();
   	    element.sendKeys(lname);
   	}

   	public void addPhone(String phone) {
   	    WebElement element = wait.until(ExpectedConditions.visibilityOf(txtPhone));
   	    element.clear();
   	    element.sendKeys(phone);
   	}

   	public void addEmail(String email) {
   	    WebElement element = wait.until(ExpectedConditions.visibilityOf(txtEmail));
   	    element.clear();
   	    element.sendKeys(email);
   	}

   	public void addAddress(String address1) {
   	    WebElement element = wait.until(ExpectedConditions.visibilityOf(txtAddress));
   	    element.clear();
   	    element.sendKeys(address1);
   	}

   	public void addCode(String zip) {
   	    WebElement element = wait.until(ExpectedConditions.visibilityOf(txtCode));
   	    element.clear();
   	    element.sendKeys(zip);
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
   
  
			   