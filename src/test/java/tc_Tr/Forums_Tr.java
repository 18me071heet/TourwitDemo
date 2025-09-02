package tc_Tr;

import static org.testng.Assert.fail;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import baseClassTr.BaseClassTr;
import pageObjectTr.Forums_TR;
import pageObjectTr.Login_TR;

public class Forums_Tr extends BaseClassTr {

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
		   		
	   		}  catch(Exception e) {
	   			
	   			logger.error("Failed:"+e);
	   			Assert.fail("Failed due to:"+e.getMessage());
	   		}
	   		
	   		
	   	}
	    
          @Test(priority=2,dependsOnMethods= {"logInDetails"})
	        void createForum() throws InterruptedException {
	    	
	    	Forums_TR createForums = new Forums_TR(driver);
	    	
	    	try {
	    		
	    		logger.info("TC-01 --> Verify User is navigate to the forum page by clicking on Forum ");
		    	createForums.forumNavigation();
		    	
		    	logger.info("TC-02 --> Verify Create Forum screen is displaying or not by clicking Create Forum");
		    	createForums.createForumClick();
		    	
		    	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		    	
		    	logger.info("TC-03 --> Verify User is able to select forum category and Selected category is displaying or not");
		    	
		    
		    	WebElement forumCategory = wait.until(ExpectedConditions.elementToBeClickable(By.id("react-select-lazy-category-input")));
		    	forumCategory.click();
		    	forumCategory.sendKeys("My Food");

		    	WebElement option = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@id,'react-select-lazy-category-option') and text()='My Food']")));
		    	option.click();
		    	  	
		    	logger.info("TC-04 --> Verify User is able to add forum title");
		    	createForums.createTitle("New Automation Testing Forum");
		    	
		    	logger.info("TC-05 --> Verify User is able to add forum description");
		    	createForums.forumDescriptionAdd("Welcome to the new automation testing forum");
		    	
		    	logger.info("TC-06 --> Verify Forum is getting created or not by clicking Publish");
		    	createForums.forumPublishBtn();
		    	
		    	WebElement toastMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Forum verification sent to the admin.')]")));
		    	
		    	String toastTxt = toastMsg.getText();
		  
		    	Assert.assertTrue(toastTxt.contains("Forum verification sent to the admin."), "No similiar toast message is found");
		    	
	    	}
	    	
	    	catch(Exception e) {
	    		
	    		logger.error("Test failed due to exception: ", e);
	   		   Assert.fail("Failed due to:"+e.getMessage());
	   		   
	    	}
	    		    	
	    }
	    
	       //@Test(priority=2,dependsOnMethods= {"logInDetails"})
	        void searchForum() throws InterruptedException {
	    	
	    	Forums_TR createForums = new Forums_TR(driver);
	    	
		    	try {
	    		
	    		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    		
	    		logger.info("TC-01 --> Verify User is navigate to the forum page by clicking on Forum ");
		    	Thread.sleep(5000);
		    	createForums.forumNavigation();
		    	
		    	logger.info("TC-02 --> Verify User is navigate to my forum page");
		    	threadTime();
		    	createForums.myForumNavigation();
		    	
		    	logger.info("TC-03 --> Verify User is able to search forum name");
		    	threadTime();
		    	createForums.searchForum("Automation Forum");
		    	
		            WebElement forumLink = wait.until(ExpectedConditions
		   	        .elementToBeClickable(By.xpath("//a[contains(text(),'Automation Forum')]")));
		            forumLink.click();
		    	
	    	}
	    	
	    	catch(Exception e) {
	    		
	    		logger.error("Failed:"+e);
	    		Assert.fail("Failed due to:"+e.getMessage());
	    	}
	    	
	    	
	    }
	    
	  //  @Test(priority=2,dependsOnMethods= {"logInDetails"})
	    void editForum() throws InterruptedException {
	    	
           Forums_TR createForums = new Forums_TR(driver);
	       	
           try {
        	   
        	   logger.info("TC-01 --> Verify User is navigate to the forum page by clicking on Forum ");
   	    	Thread.sleep(5000);
   	    	createForums.forumNavigation();
   	    	
   	    	logger.info("TC-02 --> Verify User is navigate to my forum page");
   	    	threadTime();
   	    	createForums.myForumNavigation();
   	    	
   	    	logger.info("TC-03 --> Verify User is able to search forum name");
   	    	threadTime();
   	    	createForums.searchForum("Automation Forum");
   	    	
   	    	logger.info("TC-04 --> Verify Edit Forum screen is displaying by clicking edit icon");
   	    	Thread.sleep(6000);
   	    //	createForums.editForum();
   	    	
   	    	/*WebElement editIcon = driver.findElement(By.xpath("//button[contains(@class,'min-w-5')]/svg[@width='20']"));
   	    	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", editIcon);

   	    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
   	    	wait.until(ExpectedConditions.elementToBeClickable(editIcon)).click(); */

   	    	logger.info("TC-05 --> Verify User is able to Edit forum Title");
   	    	createForums.updateForumName();
   	    	threadTime();
   	    	
   	    	createForums.createTitle("Update Automation Forum");
   	    
   	    	
   	    	logger.info("TC-06 --> Verify User is able to Edit forum description");
   	    	createForums.updateForumDescription();
   	    	createForums.forumDescriptionAdd("This is Update Automation Forum");
   	    	
   	    	logger.info("TC-07 --> Verify Forum details are getting updated by clicking publish button");
   	    	createForums.forumPublishBtn();
   	    	
           }catch(Exception e) {
        	   
        	   logger.error("Failed:"+e);
        	   Assert.fail("It is failed due to:"+e.getMessage());
           }
	    	
	    }
}
