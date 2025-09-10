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
   	
   //@Test(priority=2,dependsOnMethods= {"logInDetails"})
    void createBlog() throws InterruptedException {
   	 	
    	try {
    		
    		 Blogs_TR blogs = new Blogs_TR(driver);
    	   	 
    	   	 threadTime();
    	   	 
    	   	 logger.info("TC-01 --> Verify User is navigate to the blogs page by clicking on Blogs");
    	   	 
    	   	 blogs.blogNavigation(driver);
    	   	 
    	   	 logger.info("TC-02 --> Verify Create Blog screen is displaying by clicking on Create Blog");
    	   	 blogs.createBlog();
    	   	 threadTime();
    	   	   	 
    	   	 logger.info("TC-03 --> Verify User is able to select the blog category");
    	   	 
    	   	 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    	    	
    	   	 WebElement categoryInput = wait.until(
    	   	    ExpectedConditions.elementToBeClickable(By.id("react-select-lazy-category-input"))
    	    	);
    	   	 
    	     categoryInput.click();
    	   	 categoryInput.sendKeys("Adventure"); 
    	   	
    	    	WebElement option = wait.until(
    	   	    ExpectedConditions.visibilityOfElementLocated(
    	   	        By.xpath("//div[contains(@id,'react-select-lazy-category-option') and text()='Adventure']")));
    	   	
    	   	 option.click();
    	         
    	   	 logger.info("TC-04 --> Verify User is able to fill the blog read time");
    	   	 blogs.blogReadTime("10");
    	   	 
    	   	 logger.info("TC-05 --> Verify User is able to fill the blog title");
    	   	 blogs.blogTitleAdd(p.getProperty("blogTitle_Tr"));
    	   	 
    	   	 logger.info("TC-06 --> Verify User is able to fill the blog description");
    	   	 blogs.blogDescription(p.getProperty("blogDescription_Tr"));
    	   	 
    	   	 
    	   	 Thread.sleep(15000);
    	   	 logger.info("TC-07 --> Verify Blog is getting created or not by clicking Publish button");
    	   	 blogs.publishBlog();
    	   	 
    	   	 WebElement toastMsg = wait.until(
    	   		    ExpectedConditions.visibilityOfElementLocated(
    	   		        By.xpath("//div[contains(text(),'Blog verification sent to the admin.')]")));
    	   	 
    	   	 String toastTxt = toastMsg.getText();
    	   	 
    	   	 Assert.assertTrue(toastTxt.contains("Blog verification sent to the admin."),"Toast msg displaying wrong");
    	   	 
    	 //  	 wait.until(ExpectedConditions.invisibilityOf(toastMsg));
    	   	 
    	   	 
    	} catch(Exception e) {
    		
    	     logger.error("Test failed due to exception: ", e);
    		 throw e;
    	}
   	
    }
       
 //   @Test(priority=3,dependsOnMethods= {"logInDetails"})
    void searchBlog() throws InterruptedException {
   	 
   	 Thread.sleep(4000);
   	 
   	 try {
   		 
   		Blogs_TR blogs = new Blogs_TR(driver);
      	 
      	 logger.info("TC-01 --> Verify User is navigate to the blogs page by clicking on Blogs");
      	 Thread.sleep(5000);
      	 blogs.blogNavigation(driver); 
      	 
      	 Blogs_TR blogSearch = new Blogs_TR(driver);
      	 
      	 logger.info("TC-02 --> Verify User is able to search blogs");
      	 blogSearch.searchBlogs("Automation Blog");
      	 threadTime();
      	 
      	 blogSearch.myBlogs();
      	 threadTime();
      	 
      	 logger.info("TC-03 --> Verify blog is displaying according to search and blogs details is displaying or not by clicking on it");
      	 
      	 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
               WebElement blogLink = wait.until(ExpectedConditions
      	        .elementToBeClickable(By.xpath("//a[contains(text(),'Automation Blog')]")));
      
      	 blogLink.click();
       
   	 }
   	 
   	 catch(Exception e)
   	 
   	 {
   		 logger.error("Test failed due to exception: ", e);
		 Assert.fail("Failed due to:"+e.getMessage());
   	 }
     
    }
   
  //  @Test(priority=4,dependsOnMethods= {"logInDetails"})
    void editBlog() throws InterruptedException {
   	
   	 Thread.sleep(4000);
   	 
     Blogs_TR blogs = new Blogs_TR(driver);
   	 
     try {
    	 
    	 logger.info("TC-01 --> Verify User is navigate to the blogs page by clicking on Blogs");
       	 
       	 Thread.sleep(5000);
       	 blogs.blogNavigation(driver); 
       	 
       	 Blogs_TR blogSearch = new Blogs_TR(driver);
       	 
       	 logger.info("TC-02 --> Verify User is able to search blogs");
       	 blogSearch.searchBlogs("Automation Blog");
       	 threadTime();
       	 
       	 logger.info("Tc-03 --> Verify User is navigate to my blogs");
       	 blogSearch.myBlogs();
       	 threadTime();
       	 
       	 logger.info("TC-04 --> Verify Edit Blog screen is displaying by clicking Edit icon");
       	 blogSearch.editBlogScreen();
       	 
       	 logger.info("TC-05 --> Verify User is able to change the blog title");
       	 blogs.clearTitle();
       	 blogs.blogTitleAdd("Updated Automation Blog");
       	 threadTime();
       	 
       	 logger.info("TC-06 --> Verify Blog is getting edited or not by clicking Publish button");
       	 blogs.publishBlog();
       	 
     } catch(Exception e) {
    	 
    	 logger.error("Failed:"+e);
    	 Assert.fail("It is failed due to:"+e.getMessage());
     }
   	 
   	 
    }
    
  //   @Test(priority=5,dependsOnMethods= {"logInDetails"})
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
    	 
    	 logger.error("Failed:"+e);
    	 Assert.fail("It is failed due to:"+e.getMessage());
     }
   	 
    }
    
   @Test(priority=3,dependsOnMethods= {"logInDetails"})
     void searchedandCommentBlog() throws InterruptedException {
    	 
    	 Blogs_TR blogs = new Blogs_TR(driver);
    	 
         threadTime();
    	 blogs.blogNavigation(driver);
    	 
    	// blogs.myBlogs();
    	 
    	 logger.info("TC-01 --> Verify User is able to search the specific blog");
    	 
    	 logger.info("TC-02 --> Verify User is blog is displaying according to searching ");
    	 
    	 logger.info("TC-03 --> Verify User is able to view searched blog");
    	 
    	 threadTime();
    	 
         blogs.searchandClickedBlog(driver, p.getProperty("blogTitle_Tr"));
       
         logger.info("TC-04 --> Verify User is able to add text in comment field");
         
         logger.info("TC-05 --> Verify Emoji picker is getting open by clicking on Emoji icon");
         
         logger.info("TC-06 --> Verify User is able to search specific emoji ");
         
         logger.info("TC-07  --. Verify selected emoji is displaying in the comment text field");
         
         blogs.txtComment(driver, "Good Work , Keep it Up");
         
         threadTime();
         blogs.emojiSelect(driver);
         
         logger.info("TC-08 --> Verify Comment is getting send by clicking on send icon");
         blogs.sendComment();
       
       	 
     }
   	
}
