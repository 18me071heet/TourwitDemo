package tc_Tr;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import baseClassTr.BaseClassTr;
import pageObjectTr.Blogs_TR;
import pageObjectTr.Login_TR;

   public class Blogs_Tr extends BaseClassTr {
   	

	void threadTime() throws InterruptedException {
    	   
    	   Thread.sleep(5000);
    	   
        }
    
	
    @Test(priority=1)
   	void logInDetails() throws InterruptedException {
   		
   		Login_TR login = new Login_TR(driver);
   		
   		try {
   			
   			logger.info("Verify User is able to add email");
   	   		threadTime();
   	   		login.addEmail(p.getProperty("email_tr"));
   	   		
   	   		logger.info("Verify User is able to add password");
   	   		threadTime();
   	   		login.addPass(p.getProperty("password_tr"));
   	   		
   	   		logger.info("Verify User is able to login by clicking on Login Button");
   	   		threadTime();
   	   		login.loginBtn();
   	   		
   		} catch(Exception e) {
   			
   			logger.error("Failed:"+e);
   			Assert.fail("It is failed due to:"+e.getMessage());
   		}
   		
   	}
   	
    
   // @Test(priority=3,dependsOnMethods= {"logInDetails"})
    void createBlog() throws InterruptedException {
   	 	
    	try {
    		
    		 Blogs_TR blogs = new Blogs_TR(driver);
    	   	 
    	   	 threadTime();
    	   	 
    	   	 logger.info("TC-01 --> Verify User is navigate to the blogs page by clicking on Blogs");
    	   	 
    	   	 blogs.blogNavigation(driver);
    	   	
    	   	 Thread.sleep(3000);
    	 	WebElement closeSubs = driver.findElement(By.xpath(" //button[@aria-label='Close popup']//*[name()='svg']"));
   			closeSubs.click();
   			
    	   	 
    	   	 logger.info("TC-02 --> Verify Create Blog screen is displaying by clicking on Create Blog");
    	   	 blogs.createBlog();
    	   	 threadTime();
    	   	   	 
    	   	 logger.info("TC-03 --> Verify User is able to select the blog category");
    	   	 
    	   	 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    	    	
    	   	 WebElement categoryInput = wait.until(
    	   	    ExpectedConditions.elementToBeClickable(By.id("react-select-lazy-category-input")));
    	   	 
    	     categoryInput.click();
    	   	 categoryInput.sendKeys("Adventure"); 
    	   	
    	    	WebElement option = wait.until(
    	   	    ExpectedConditions.visibilityOfElementLocated(
    	   	        By.xpath("//div[contains(@id,'react-select-lazy-category-option') and text()='Adventure']")));
    	   	
    	   	 option.click();
    	         
    	   	 logger.info("TC-04 --> Verify User is able to fill the blog read time");
    	   	 blogs.blogReadTime(p.getProperty("blogReadTime_Tr"));
    	   	 
    	   	 logger.info("TC-05 --> Verify User is able to fill the blog title");
    	   	 blogs.blogTitleAdd(p.getProperty("blogTitle_Tr"));
    	   	 
    	   	 logger.info("TC-06 --> Verify User is able to fill the blog description");
    	   	 blogs.blogDescription(p.getProperty("blogDescription_Tr"));
    	   	 
    	   	 threadTime();
    	   	 
    	   	 logger.info("TC-07 --> Verify User is able to uplaod image from storage");
    	   	 
    	   	 logger.info("TC-08 --> Verify Uploaded Image is displaying in the uplaod image field ");
    	   	 
    	     blogs.uploadCoverImage();
    	      
    	   	 logger.info("TC-09 --> Verify User is able to uplaod thumbail from storage ");
    	   	 
    	   	 logger.info("TC-10 --> Verify uploaded thumbnail is displaying or not in the thumbnail field");
    	   	 
    	     blogs.uploadThumbnailImage();
    	     
    	     logger.info("TC-11 --> Verify User is able to upload image in the description field");
    	     
    	     blogs.uploadDescriptionImage();
  			 
    	   	 Thread.sleep(3000);
    	   	 
    	   	 logger.info("TC-12 --> Verify Blog is getting created or not by clicking Publish button");
    	 	 blogs.publishBlog();
    	   	 
    	 	 WebElement toastMsg = wait.until(
    	   		    ExpectedConditions.visibilityOfElementLocated(
    	   		        By.xpath("//div[contains(text(),'Blog verification sent to the admin.')]")));
    	   	 
    	     String toastTxt = toastMsg.getText();
    	   	 
    	     Assert.assertTrue(toastTxt.contains("Blog verification sent to the admin."),"Toast msg displaying wrong");
    	   	 
     	     wait.until(ExpectedConditions.invisibilityOf(toastMsg));
    	   	 
    	   } catch(Exception e) {
    		
    		 Assert.fail("It is failed");
    	     logger.error("Test failed due to exception: ", e);
    		
    	 }
   	
   }
       
   // @Test(priority=4,dependsOnMethods= {"logInDetails"})
    void searchBlog() throws InterruptedException {
   	 
   	 Thread.sleep(4000);
   	 
   	 try {
   		 
   		Blogs_TR blogs = new Blogs_TR(driver);
      	 
      	 logger.info("TC-01 --> Verify User is navigate to the blogs page by clicking on Blogs");
      	 Thread.sleep(5000);
      	 blogs.blogNavigation(driver); 
      	 
      	 Blogs_TR blogSearch = new Blogs_TR(driver);
      	 
    	 logger.info("TC-02 --> Verify User is able to search blogs");
      	 
      	 blogSearch.searchBlogs("A road to heaven");
      	 threadTime();
      	 
      	 blogSearch.myBlogs();
      	 threadTime();
      	 
      	 logger.info("TC-03 --> Verify blog is displaying according to search and blogs details is displaying or not by clicking on it");
      	 
      	 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
               WebElement blogLink = wait.until(ExpectedConditions
      	        .elementToBeClickable(By.xpath("//a[contains(text(),'A road to heaven')]")));
      
      	 blogLink.click();
       
   	 }
   	 
   	  catch(Exception e)
   	 
   	 {
   		 logger.error("Test failed due to exception: ", e);
		 Assert.fail("Failed due to:"+e.getMessage());
   	 }
     
    }
   
    //@Test(priority=5,dependsOnMethods= {"logInDetails"})
    void editBlog() throws InterruptedException {
   	
   	 Thread.sleep(4000);
   	 
     Blogs_TR blogs = new Blogs_TR(driver);
   	 
     try {
    	 
    	 logger.info("TC-01 --> Verify User is navigate to the blogs page by clicking on Blogs");
       	 
       	 Thread.sleep(5000);
       	 blogs.blogNavigation(driver); 
       	 
       	 Blogs_TR blogSearch = new Blogs_TR(driver);
       	 
       	 logger.info("TC-02 --> Verify User is able to search blogs");
       	 blogSearch.searchBlogs("A road to heaven");
       	 threadTime();
       	 
       	 logger.info("Tc-03 --> Verify User is navigate to my blogs");
       	 blogSearch.myBlogs();
       	 threadTime();
       	 
       	 logger.info("TC-04 --> Verify Edit Blog screen is displaying by clicking Edit icon");
       	 blogSearch.editBlogScreen();
       	 
       	 logger.info("TC-05 --> Verify User is able to change the blog title");
       	 blogs.blogTitleAdd("Updated Automation Blog");
       	 threadTime();
       	 
       	 logger.info("TC-06 --> Verify Blog is getting edited or not by clicking Publish button");
       	 blogs.publishBlog();
       	 
     } catch(Exception e) {
    	 
    	 logger.error("Failed:"+e);
    	 Assert.fail("It is failed due to:"+e.getMessage());
    	 

	}
}

    
  //   @Test(priority=6,dependsOnMethods= {"logInDetails"})
     void deleteBlog() throws InterruptedException {
   	 
     Blogs_TR blogs = new Blogs_TR(driver);
   	 
     try {
    	 
    	 logger.info("TC-01 --> Verify User is navigate to the blogs page by clicking on Blogs");
       	 
       	 Thread.sleep(5000);
       	 blogs.blogNavigation(driver); 
       	 
       	 Blogs_TR blogSearch = new Blogs_TR(driver);
      
       	 logger.info("TC-02 --> Verify User is able to search blogs");
       	
       	 blogSearch.searchBlogs("Automation Blog");
       	 threadTime();
       	 
       	 logger.info("TC-03 --> Verify User is navigate to My blogs");
       	 blogSearch.myBlogs();
       	 threadTime();
       	 
       	 logger.info("TC-04--> Verify Delete Confirmation is displaying or not by clicking Delete icon");
       	 blogs.deleteBlog();
       	 
         logger.info("TC-05 --> Verify Created Blog is getting Deleted or not by clicking Confirm");
         blogs.deleteConfirmBlog();
             
     }
     
     catch(Exception e) {
    	 
    	 logger.error("Failed:"+ e);
    	 Assert.fail("It is failed due to:"+e.getMessage());
     }
   	 
    }
    
    @Test(priority=7,dependsOnMethods= {"logInDetails"})
     void searchedandCommentBlog() throws InterruptedException {
    	 
    	 Blogs_TR blogs = new Blogs_TR(driver);
         threadTime();
         
         try {
        	 
        	 blogs.blogNavigation(driver);
        	 
        	 Thread.sleep(3000);
        	 
        	 logger.info("Tc -01 Verify User is able to enter name and email address in subscription popup ");
        	 
        	 logger.info("TC- 02 --> Verify User is able to select terms and conditions checkbox");
        	 
        	 logger.info("TC-03 --> Verify User is able to subscribe news letter by clicking submit button");
        	 blogs.subscribeNewsLater("Will John", "user23@yopmail.com");
        	 
        	 Thread.sleep(2000);
        	 // blogs.myBlogs();
        	 
        	 logger.info("TC-04 --> Verify User is able to search the specific blog");
        	 
        	 logger.info("TC-05 --> Verify User is blog is displaying according to searching ");
        	 
        	 logger.info("TC-06 --> Verify User is able to view searched blog");
        	 
        	 threadTime();
        	 
             blogs.searchNdClickedBlog(driver, "Pink Big City");
           
             Thread.sleep(3000);
             
             logger.info("TC-07 --> Verify User is able to add text in comment field");
             
             Thread.sleep(3000);
             logger.info("TC-08 --> Verify Emoji picker is getting open by clicking on Emoji icon");
             
             logger.info("TC-09 --> Verify User is able to search specific emoji ");
             
             logger.info("TC-10  --. Verify selected emoji is displaying in the comment text field");
             
             blogs.txtComment(driver, "Good Work , Keep it Up");
             
             threadTime();
             blogs.emojiSelect(driver);
             
             logger.info("TC-11 --> Verify Comment is getting send by clicking on send icon");
             blogs.sendComment();
               	 
         } catch(Exception e) {
        	 
        	 logger.error("Failed");
        	 Assert.fail("It is failed due to:"+e.getMessage());
         }
    	 
     }
     
   //  @Test(priority=8,dependsOnMethods= {"logInDetails"})
     void searchNdEdit() throws InterruptedException {
    	 
    	  Blogs_TR blogs = new Blogs_TR(driver);
    	 
    	  try {
    		  
    		  WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
        	  threadTime();
        	  
        	  
        	  WebElement closeIcon = driver.findElement(By.xpath("//button[@aria-label='Close popup']//*[name()='svg']"));
        	  closeIcon.click();
        	  
        	  logger.info("TC-01 --> Verify User is navigate to the Blogs page by clicking on Blogs from Header");
         	  blogs.blogNavigation(driver);
         	  
         	/*  Thread.sleep(3000);
			 
			  logger.info("TC-02 --> Verify subscription popup is getting close by clicking cross icon");
			  WebElement closeSubs = driver.findElement(By.xpath(" //button[@aria-label='Close popup']//*[name()='svg']"));
		   	  closeSubs.click();
		   	 */
         	  
         	  logger.info("TC-02 --> Verify User is navigate to the My Blogs by clicking on My Blogs");
         	  blogs.myBlogs();
              
         	  logger.info("TC-03 --> Verify User is able to search specific blog");
         	  
         	  logger.info("TC-04 --> Verify Blog is displaying according to searching");
         	  
         	  logger.info("TC-05 --> Verify Edit blog screen is displaying by clicking on Edit icon on the searched blog");
         	  blogs.searchNdEditBlogs(driver, "A road to heaven");
         	  
         	  logger.info("TC-06 --> Verify User is able to update the blog read time");
         	  blogs.updateBlogReadtime(p.getProperty("blogUpdatedReadTime_Tr"));
         	  
         	  logger.info("TC-06 --> Verify User is able to change blog name");
         	  blogs.updateBlogTitle(p.getProperty("blogTitleUpdated_Tr"));
         	  threadTime();
         	  
         	  logger.info("TC-07 --> Verify User is able to update blog description");
         	  blogs.updateBlogDescription(p.getProperty("blogDescriptionUpdated_Tr"));
         	  threadTime();
         	  
         	  logger.info("TC-08 --> Verify User is able to change upload image");
         	  blogs.updateCoverImage();
         	  
         	  logger.info("TC-09 --> Verify User is able to change thumbnail image");
         	  blogs.updateThumbnailImage();
         	  
         	  logger.info("TC-10 --> Verify blog is getting update by clicking publish button");
         	  blogs.publishBlog();

         	  WebElement toast = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Blog updated. Awaiting Approval')]")));
         	  
         	  String editToast = toast.getText();
         	  
         	  Assert.assertTrue(editToast.contains("Blog updated. Awaiting Approval"), "No similiar toast msg is found");
         	 
         	  wait.until(ExpectedConditions.invisibilityOf(toast));
         	  
    	  } catch(Exception e) {
    		  
    		  logger.error("Failed");
    		  Assert.fail("It is failed due to:"+ e.getMessage());
    	  }  	  
     }
     
    //  @Test(priority=9,dependsOnMethods= {"logInDetails"})
     void searchNdDelete() throws InterruptedException {
    	 
    	  Blogs_TR blogs = new Blogs_TR(driver);
    	  
    	  WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
    	  
    	  try {
    		  	  
    		  threadTime();
        	  logger.info("Verify User is navigate to the Blogs page by clicking on Blogs from Header");
        	  
        	  blogs.blogNavigation(driver);
        	  
        	  Thread.sleep(4000);
        	  
        	  logger.info("Verify User is able to close the subscription popup by clicking cross icon");
        	  WebElement closeSubs = driver.findElement(By.xpath(" //button[@aria-label='Close popup']//*[name()='svg']"));
			  closeSubs.click();
			   	 
			   	 Thread.sleep(2000);
        	  logger.info("TC-02 --> Verify User is navigate to the My Blogs by clicking on My Blogs");
         	  blogs.myBlogs();
              
         	  logger.info("TC-03 --> Verify User is able to search specific blog");
         	  
         	  logger.info("TC-04 --> Verify Blog is displaying according to searching");
         	  
         	  logger.info("TC-05 --> Verify Delete confirmation popup is displaying by clicking Delete icon on searched record");
         	  
         	  blogs. searchAndDeleteBlog(driver, "Steven");
         	  
         	  logger.info("TC-06 --> Verify searched blog is getting deleted or not");
         	  
         	  blogs.deleteConfirmBlog();
         	  
         	  WebElement deleteToast = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Deletion request submitted successfully.')]")));
         	  
         	  String toast = deleteToast.getText();
         	  
         	  Assert.assertTrue(toast.contains("Deletion request submitted successfully."), "No any similiar toast is found");
         	  
    	  } catch(Exception e) {
    		  
    		  logger.error("Failed:"+e);
    	      Assert.fail("It is failed due to:"+e.getMessage());
    	    	 
    	     }
    	  
		}

		//@Test(priority=10, dependsOnMethods = {"logInDetails"})
		void sortByNewestToOldest() {

			try {
				
				 Blogs_TR blogs = new Blogs_TR(driver);
                 threadTime();
                 
                 logger.info("TC-01 --> Verify User is navigate to the Blogs page by clicking on Blogs");
				 blogs.blogNavigation(driver);
				 
				 threadTime();
				 
				 logger.info("TC-02 --> Verify subscription popup is getting close by clicking cross icon");
				 WebElement closeSubs = driver.findElement(By.xpath(" //button[@aria-label='Close popup']//*[name()='svg']"));
			   	 closeSubs.click();
			   	 
				logger.info("TC-03 --> Verify User is able to sort blogs by Newest to Oldest");
				
				logger.info("TC-04 --> Verify User is able to sort blogs by Oldest to Newest");
				blogs.sortestFilter();

			} catch (Exception e) {
				
				logger.error("Failed: " + e);
				Assert.fail("It is failed due to: " + e.getMessage());
			}
		}
		
		//@Test(priority=11,dependsOnMethods= {"logInDetails"})
		void selectCategoryFilter() {
			
			try {
				
				Blogs_TR blogs = new Blogs_TR(driver);
				threadTime();
				
				logger.info("TC-01 --> Verify User is navigate to blogs by clicking on Blogs");
			//	blogs.blogNavigation(driver);
				
			 //	 Thread.sleep(3000);
		    	 //	WebElement closeSubs = driver.findElement(By.xpath(" //button[@aria-label='Close popup']//*[name()='svg']"));
		   		//	closeSubs.click();
		   			
				//logger.info("TC-02 --> Verfiy User is navigate to my blogs by clicking on my blogs");
				//blogs.myBlogs();
				
				logger.info("TC-03 --> Verify category dropdown is open by clicking cateogy ");
				
				logger.info("TC-04 --> Verify user is able to select specific category");
				
				blogs.categoriesFilter();
				
			}
			
           catch (Exception e) {
				
				logger.error("Failed: " + e);
				Assert.fail("It is failed due to: " + e.getMessage());
			}
		}
	
   }
