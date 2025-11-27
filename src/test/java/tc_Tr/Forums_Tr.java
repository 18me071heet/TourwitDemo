package tc_Tr;

import java.time.Duration;
import org.openqa.selenium.By;
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
	 
	 @Test
		void logInDetails() throws InterruptedException {
			
			Login_TR login = new Login_TR(driver);
			
			try {
				
				WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
				logger.info("Verify User is able to add email");
				threadTime();
				login.addEmail(p.getProperty("email_tr"));
				
				logger.info("Verify User is able to add password");
				threadTime();
				login.addPass(p.getProperty("password_tr"));
				
				logger.info("Verify User is able to login by clicking on Login Button");
				threadTime();
				login.loginBtn();
				
			/*	WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(
					    By.xpath("//div[contains(text(),'Invalid email or password')]")));
				
				Assert.assertTrue(errorMessage.isDisplayed(),"Invalid email or password");
				
				*/
				
			} catch(Exception e) {
				
				logger.error("Failed :"+e);
				Assert.fail("Failed due to:"+e.getMessage());
			}
			
		}
	    
           // @Test(priority=2,dependsOnMethods= {"logInDetails"})
	        void createForum() throws InterruptedException {
	    	
	    	Forums_TR createForums = new Forums_TR(driver);
	    	
	    	try {
	    		
	    		
	    		logger.info("TC-01 --> Verify User is navigate to the forum page by clicking on Forum ");
	    		Thread.sleep(5000);
		    	createForums.forumNavigation(driver);
		    	
		    	Thread.sleep(3000);
		    	logger.info("Tc -01 Verify User is able to enter name and email address in subscription popup ");
	        	 
	        	 logger.info("TC- 02 --> Verify User is able to select terms and conditions checkbox");
	        	 
	        	 logger.info("TC-03 --> Verify User is able to subscribe news letter by clicking submit button");
	        	 createForums.subscribeNewsLater("Will John", "user23@yopmail.com");
	        	 
	        	 Thread.sleep(3000);
		    	logger.info("TC-02 --> Verify Create Forum screen is displaying or not by clicking Create Forum");
		    	createForums.createForumClick();
		    	
		    	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		    	
		    	logger.info("TC-03 --> Verify User is able to select forum category and Selected category is displaying or not");
		    	
		    	WebElement forumCategory = wait.until(ExpectedConditions.elementToBeClickable(By.id("react-select-lazy-category-input")));
		    	forumCategory.click();
		    	forumCategory.sendKeys("TravelForum");

		    	WebElement option = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@id,'react-select-lazy-category-option') and text()='TravelForum']")));
		    	option.click();
		    	  	
		    	logger.info("TC-04 --> Verify User is able to add forum title");
		    	createForums.createTitle(p.getProperty("forumTitle_Tr"));
		    	
		    	logger.info("TC-05 --> Verify User is able to add forum description");
		    	createForums.forumDescriptionAdd(p.getProperty("forumDescription_Tr"));
		    	
		    	logger.info("TC-06 --> Verify Forum is getting created or not by clicking Publish");
		    	createForums.forumPublishBtn();
		    	
		    	WebElement toastMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Forum is created successfully.')]")));
		    	
		    	String toastTxt = toastMsg.getText();
		  
		    	//Forum is created successfully.


		    	Assert.assertTrue(toastTxt.contains("Forum is created successfully."), " No similiar toast message is found ");
		    	
	    	}
	    	
	    	catch(Exception e) {
	    		
	    		logger.error("Test failed due to exception: ", e);
	   		    Assert.fail("Failed due to:"+e.getMessage());
	    	}
	    		    	
	    }
       
           //@Test(priority=3,dependsOnMethods= {"logInDetails"})
           void searchForum() throws InterruptedException {
   	
        	Forums_TR createForums = new Forums_TR(driver);
   	
	    	try {
   		
   	  	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
   		
   		    logger.info("TC-01 --> Verify User is navigate to the forum page by clicking on Forum ");
	    	Thread.sleep(5000);
	    	createForums.forumNavigation(driver);
	    	
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
	    
	      // @Test(priority=4,dependsOnMethods= {"logInDetails"})
	       void searchNdEdit() throws InterruptedException {
	    	
           Forums_TR createForums = new Forums_TR(driver);
	       	
           try {
        	   
        	logger.info("TC-01 --> Verify User is navigate to the forum page by clicking on Forum ");
   	    	Thread.sleep(5000);
   	    	createForums.forumNavigation(driver);
   	    	

	    	Thread.sleep(3000);
	    	logger.info("Tc -01 Verify User is able to enter name and email address in subscription popup ");
        	 
        	 logger.info("TC- 02 --> Verify User is able to select terms and conditions checkbox");
        	 
        	 logger.info("TC-03 --> Verify User is able to subscribe news letter by clicking submit button");
        	 createForums.subscribeNewsLater("Will John", "user23@yopmail.com");
        	 
        	 Thread.sleep(3000);
        	 
   	    	logger.info("TC-02 --> Verify User is navigate to my forum page");
   	    	createForums.myForumNavigation();
   	    	
   	    	logger.info("TC-03 --> Verify User is able to search forum name");
   	    	threadTime();
   	    	//createForums.searchForum("Automation Forum");
   	    	
   	    	logger.info("TC-04 --> Verify Edit Forum screen is displaying by clicking edit icon");
   	    	
   	    	createForums.searchAndEdit(driver, "A road to heaven");
   	    	threadTime();
   	        
 	    	logger.info("TC-05 --> Verify User is able to Edit forum Title");
   	    	threadTime();
   	    	
   	    	createForums.updateTitle();
   	    	
   	    	createForums.createTitle(p.getProperty("forumTitleUpdated_Tr"));
   	    	    	
   	    	logger.info("TC-06 --> Verify User is able to Edit forum description");
   	    	
   	    	createForums.forumDescriptionAdd(p.getProperty("forumDescriptionUpdated_Tr"));
   	    	
   	    	logger.info("TC-07 --> Verify Forum details are getting updated by clicking publish button");
   	    	createForums.forumPublishBtn();
   	    	
           } catch(Exception e) {
        	   
        	   logger.error("Failed:"+e);
        	   Assert.fail("It is failed due to:"+e.getMessage());
           }
	    	
	    }	
	    
	    @Test(priority=5,dependsOnMethods= {"logInDetails"})
	    void searchNdComment() throws InterruptedException {
	    	
	    	   Forums_TR createForums = new Forums_TR(driver);
		       
	    	   Thread.sleep(6000);
	    	   
	    	   try {
	    		   
	    		   logger.info("TC-01 --> Verify User is navigate to the forum page by clicking on Forum ");
			       createForums.forumNavigation(driver);
			    
			  	   Thread.sleep(3000);
		    	 	WebElement closeSubs = driver.findElement(By.xpath(" //button[@aria-label='Close popup']//*[name()='svg']"));
		   			closeSubs.click();
		   			
		   			Thread.sleep(3000);
		   			
		    	   logger.info("TC-01 --> Verify User is navigate to the All post");
		     	   createForums.allForum();
		    	   
		    	   logger.info("TC-02 --> Verify User is able to search the specific forum");
		      	 
		      	   logger.info("TC-03 --> Verify User is forum is displaying according to searching ");
		      	 
		      	   logger.info("TC-04 --> Verify User is able to view searched forum");
		      	 
		      	   threadTime();
		    	   
		    	   createForums.searchedNdClick(driver, "Rain in the Jungle");
		    	   
		    	   Thread.sleep(5000);
		    	   
		    	   logger.info("TC-05 --> Verify User is able to add text in comment field");
		           
		           logger.info("TC-06 --> Verify Emoji picker is getting open by clicking on Emoji icon");
		           
		           logger.info("TC-07 --> Verify User is able to search specific emoji ");
		           
		           logger.info("TC-08 --> Verify selected emoji is displaying in the comment text field");
		           
		            createForums.txtComment(driver, "A very interesting forum");
		          threadTime();
		           createForums.addEmoji(driver);
		                      
		          logger.info("TC-09 --> Verify Comment is getting send to the specific forum by clicking on send icon");
		           
		          createForums.sendComment();
		          Thread.sleep(7000);
		             
		  		   threadTime();
		  		   
		  		  logger.info("TC-11 --> Verify User is navigate to the user profile page by clicking on User Profile logo");
		  		 
		  		  logger.info("TC-12 --> Verify User is able to follow user by clicking on Follow");
		  		   
		  		  logger.info("TC-13 --> Verify User is able to unfollow user if he is following that user");
		  		  
		  		//  createForums.userProfile();
		  		  
	    	   } catch(Exception e) {
	    		   
	    		   logger.error("Failed");
	    		   Assert.fail("It is failed due to:"+e.getMessage());
	    	   } 		  	  		  	               	
	    }
	    
	  //  @Test(priority=6,dependsOnMethods= {"logInDetails"})
	     void searchedAndDelete() throws InterruptedException {
	    	
	    	Forums_TR createForums = new Forums_TR(driver);
	    	
	        	try {
	          
	    	   	logger.info("TC-01 --> Verify User is navigate to the forum page by clicking on Forum ");
	    	   	Thread.sleep(5000);
	    	   	createForums.forumNavigation(driver);
	    	   	
	    	    Thread.sleep(3000);
	    	 	WebElement closeSubs = driver.findElement(By.xpath(" //button[@aria-label='Close popup']//*[name()='svg']"));
	   			closeSubs.click();
	   			
	   			Thread.sleep(3000);
	    	   	logger.info("TC-02 --> Verify User is navigate to my forum page");
	    	   	createForums.myForumNavigation();
	    	   	
	    	   	logger.info("TC-03 --> Verify User is able to search forum name");
	    	   	threadTime();
	    	   
	    	   	logger.info("TC-04 --> Verify User is able to delete searched forum by clicking on delete icon");
	    	   	
	    	   	createForums.searchAndDelete(driver, "My Original Street Food");
	    	   	
	    	   	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
	    	   	
	    	   	WebElement toastMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Removal request submitted for admin approval.')]")));
		       	
		       	String toastTxt = toastMsg.getText();
		       
		       	Assert.assertTrue(toastTxt.contains("Removal request submitted for admin approval."), "No similiar toast message is found");
                        
	         	} catch(Exception e) {
	    		
	    		logger.error("Failed:"+e);
	        	Assert.fail("It is failed due to:"+e.getMessage());
	    	}
	    	
	    }	
	     
       //@Test(priority=7,dependsOnMethods= {"logInDetails"})
	     void followCategory() {
	    	 
	    	 Forums_TR createForums = new Forums_TR(driver);
		    	
	    	 try {
	    		
	    	   logger.info("TC-01 --> Verify User is navigate to the forum page by clicking Forums");
	    	    
	    	   Thread.sleep(3000);
	    	   createForums.forumNavigation(driver);
	    	   
	    	   Thread.sleep(3000);
	    	 	WebElement closeSubs = driver.findElement(By.xpath(" //button[@aria-label='Close popup']//*[name()='svg']"));
	   			closeSubs.click();
	   			
	   			Thread.sleep(3000);
	   			
	    	   logger.info("TC-02 --> Verify User is able to follow specific category by clicking Follow ");
	    	   
	    	   logger.info("TC-03 --> Verify User is able to unfollow specific category by clicking Unfollow");
	    	   
	    	   logger.info("TC-04 --> Verify more fourms categories are displaying by clicking Load more button");
	    	   
	    	   createForums.followCategory("TravelForum");
	    	   
	    	   }
	    	 
	    	  catch(Exception e) {
	    		 
	    		 logger.error("It is Failed");
	    		 Assert.fail("It is failed due to:" + e.getMessage());
	    		 
	    	 }
	     }
	     
	     
	 // @Test(priority=9,dependsOnMethods= {"logInDetails"})
	     void categoryFilter() {
	    	 
             Forums_TR createForums = new Forums_TR(driver);
             
	    	 try {
		    		
	    		 logger.info("TC-01 --> Verify User is navigate to the forum page by clicking Forums");
	    		 Thread.sleep(4000);
	    		 		
	    		 createForums.forumNavigation(driver);
	    		
	    		 Thread.sleep(3000);
		    	 WebElement closeSubs = driver.findElement(By.xpath(" //button[@aria-label='Close popup']//*[name()='svg']"));
		   		 closeSubs.click();
		   			
		   		 Thread.sleep(3000);
	    		 
	    		 threadTime();
	    	     logger.info("TC-02 --> Verify User is navigate to All post");
	    	     createForums.allForum();
	    	     
	    	     logger.info("TC-03 --> Verify Category filter dropdown is open by clicking on category filter");
	    	     
	    	     logger.info("TC-04 --> Verify User is able to select category from the category dropdown");
	    	     createForums.categoriesFilter();
	    	     
	    	     threadTime();
	    	     
	    	 }
	    	 
	    	 catch(Exception e) {
	    		 
	    		 logger.error("It is Failed");
	    		 Assert.fail("It is failed due to:" +e.getMessage());
	    		 
	    	 }	    	 
	     }
	     
	  // @Test(priority=10,dependsOnMethods= {"logInDetails"})
	     void sortestFilter() {
	    	 
	    	 Forums_TR createForums = new Forums_TR(driver);
	    	 
	    	 try {
		    	
	    		 logger.info("TC-01 --> Verify User is navigate to the forum page by clicking Forums");
	    	     //	 createForums.forumNavigation();
	    		 
	    	     logger.info("TC-02 --> Verify User is navigate to All post");
	    	     threadTime();
	    	     //   createForums.allForum();
	    	     
	    	     logger.info("TC-03 --> Verify User is able to apply filter by selecting the Newest");
	    	     
	    	     logger.info("TC-04 --> Verify User is able to change apply filter and select the new filter from the dropdown");
	    	     createForums.sortestFilter();
	    	     
	    	     threadTime();
	    	     
	    	 }
	    	 
	    	 catch(Exception e) {
	    		 
	    		 logger.error("It is Failed");
	    		 Assert.fail("It is failed due to:" +e.getMessage());
	    		 
	    	 }
	     }	 
	     
	   //  @Test(priority=11,dependsOnMethods= {"logInDetails"})
	     void followUser() throws InterruptedException {
	    	 
	    	 Forums_TR createForums = new Forums_TR(driver);
		       
	    	   Thread.sleep(3000);
	    	   
	    	   try {
	    		   
	    		    logger.info("TC-01 --> Verify User is navigate to the forum page by clicking on Forum ");
			        createForums.forumNavigation(driver);
			    
			  	    Thread.sleep(3000);
		    	 	WebElement closeSubs = driver.findElement(By.xpath(" //button[@aria-label='Close popup']//*[name()='svg']"));
		   			closeSubs.click();
		   			
		   			Thread.sleep(3000);
		   			
		    	    logger.info("TC-01 --> Verify User is navigate to the All post");
		     	    createForums.allForum();
		    	   
		    	    logger.info("TC-02 --> Verify User is able to search the specific forum");
		      	 
		      	    logger.info("TC-03 --> Verify User is forum is displaying according to searching ");
		      	 
		      	    logger.info("TC-04 --> Verify User is able to view searched forum");
		      	 
		      	    threadTime();
		    	   
		    	    createForums.searchedNdClick(driver, "New Mountain");
		    	    
		    	    Thread.sleep(5000);
		    	   
		  		   logger.info("TC-05 --> Verify User is navigate to the user profile page by clicking on User Profile logo");
			  		 
		  		   logger.info("TC-06 --> Verify User is able to follow user by clicking on Follow");
		  		   
		  		   logger.info("TC-07 --> Verify User is able to unfollow user if he is following that user");
		  		  
		  		   createForums.userProfile();
	     
        } catch(Exception e) {
	  
	              logger.error("It is failed");
	              Assert.fail("It is failed due to:"+e.getMessage());
	      
}    	   
	     }
	     
	    // @Test(priority=12,dependsOnMethods= {"logInDetails"})
	     void blockUser() throws InterruptedException {
	    	 
	    	 Forums_TR createForums = new Forums_TR(driver);
		       
	    	   Thread.sleep(3000);
	    	   
	    	  try {
	    		   
	    		    logger.info("TC-01 --> Verify User is navigate to the forum page by clicking on Forum ");
			        createForums.forumNavigation(driver);
			    
			  	    Thread.sleep(3000);
		    	 	WebElement closeSubs = driver.findElement(By.xpath(" //button[@aria-label='Close popup']//*[name()='svg']"));
		   			closeSubs.click();
		   			
		   			Thread.sleep(3000);
		   			
		    	    logger.info("TC-01 --> Verify User is navigate to the All post");
		     	    createForums.allForum();
		    	   
		    	    logger.info("TC-02 --> Verify User is able to search the specific forum");
		      	 
		      	    logger.info("TC-03 --> Verify User is forum is displaying according to searching ");
		      	 
		      	    logger.info("TC-04 --> Verify User is able to view searched forum");
		      	 
		      	    threadTime();
		    	   
		    	    createForums.searchedNdClick(driver, "New Mountain");
		    	    
		    	    Thread.sleep(5000);
		    	    
		    	    logger.info("Verify Block option is displaying by clicking on three dot");
		    	    
		    	    logger.info("Verify Block user confirmation popup is displaying by clicking block user");
		    	    
		    	    logger.info("Verify User is getting block after clicking confirm");
		    	    
		    
		    	    createForums.blockUser();
		    	    
	     } catch(Exception e) {
	   	  
             logger.error("It is failed");
             Assert.fail("It is failed due to:"+e.getMessage());
     
}    	        
	     }
     }
