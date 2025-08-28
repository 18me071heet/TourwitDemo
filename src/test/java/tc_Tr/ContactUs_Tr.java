package tc_Tr;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import baseClassTr.BaseClassTr;
import pageObjectTr.ContactUs_TR;
import pageObjectTr.Login_TR;

public class ContactUs_Tr extends BaseClassTr {

	  void threadTime() throws InterruptedException {
   	   
   	   Thread.sleep(3000);
       }
   
   @Test(priority=1)
  	void logInDetails() throws InterruptedException {
  		
  		Login_TR login = new Login_TR(driver);
  		
  		try {
  			logger.info("TC-01 --> Verify User is able to add email");
  	  		threadTime();
  	  		login.addEmail(p.getProperty("email_tr"));
  	  		
  	  		logger.info("TC-02 --> Verify User is able to add password");
  	  		threadTime();
  	  		login.addPass(p.getProperty("password_tr"));
  	  		
  	  		logger.info("TC-03 --> Verify User is able to login by clicking on Login Button");
  	  		threadTime();
  	  		login.loginBtn();
  	  		
  		}catch(Exception e) {
  			
  			logger.error("Failed:"+ e);
  			Assert.fail("Failed due to:"+e.getMessage());
  		}
  		
  		
  	}
   
   @Test(priority=2,dependsOnMethods= {"logInDetails"})
   void contactUs() throws InterruptedException {
	   
	   Thread.sleep(5000);
	    ContactUs_TR contact = new ContactUs_TR(driver);
	    
	    try {
	    	
	    	  logger.info("TC-01 --> Verify Contact us page is displaying or not by clicking contact us link");
	   	   ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
	   	    contact.contactUsClick();
	   	
	   	    logger.info("TC-02 --> Verify User is able to fill description in contact us form");
	   	    
	   	    WebElement descriptionBox = driver.findElement(By.id("note"));
	          ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", descriptionBox);
	          descriptionBox.sendKeys("This is Automation Testing description.");
	          
	          logger.info("TC-03 --> Verify Query is getting saved or not");
	      
	          threadTime();
	          contact.saveContactUs();
	          
	    }catch(Exception e) {
	    	
	    	logger.error("Failed:"+e);
	    	Assert.fail("It is failed:"+e.getMessage());
	    }
	  
	   
   }
  	
}
