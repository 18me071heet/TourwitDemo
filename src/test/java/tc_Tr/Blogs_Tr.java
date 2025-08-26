package tc_Tr;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import baseClassTr.BaseClassTr;
import pageObjectTr.Blogs_TR;
import pageObjectTr.Login_TR;

   public class Blogs_Tr extends BaseClassTr {
   	
    void threadTime() throws InterruptedException {
    	   
    	   Thread.sleep(3000);
        }
    
    public void applyReactSelectFilter(By filterIconLocator, String placeholderId, String optionText) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // 1️⃣ Click the filter icon
        WebElement filterIcon = wait.until(ExpectedConditions.elementToBeClickable(filterIconLocator));
        js.executeScript("arguments[0].scrollIntoView(true);", filterIcon);
        js.executeScript("arguments[0].click();", filterIcon);

        // 2️⃣ Click the placeholder to open dropdown
        WebElement placeholder = wait.until(ExpectedConditions.presenceOfElementLocated(By.id(placeholderId)));
        js.executeScript("arguments[0].scrollIntoView(true);", placeholder);
        js.executeScript("arguments[0].click();", placeholder);

        // 3️⃣ Type the option in input field
        WebElement input = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//input[contains(@id,'react-select') and @type='text']")));
        input.sendKeys(optionText);

        // 4️⃣ Wait for the option to appear and click
        WebElement option = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//div[contains(@id,'react-select') and text()='" + optionText + "']")));
        js.executeScript("arguments[0].scrollIntoView(true);", option);
        js.executeScript("arguments[0].click();", option);
    }

    
    @Test(priority=1)
   	void logInDetails() throws InterruptedException {
   		
   		Login_TR login = new Login_TR(driver);
   		
   		logger.info("Verify User is able to add email");
   		threadTime();
   		login.addEmail(p.getProperty("email_tr"));
   		
   		logger.info("Verify User is able to add password");
   		threadTime();
   		login.addPass(p.getProperty("password_tr"));
   		
   		logger.info("Verify User is able to login by clicking on Login Button");
   		threadTime();
   		login.loginBtn();
   		
   	}
   	
   // @Test(priority=2,dependsOnMethods= {"logInDetails"})
    void createBlog() throws InterruptedException {
   	 
   	 Blogs_TR blogs = new Blogs_TR(driver);
   	 
   	 logger.info("TC-01 --> Verify User is navigate to the blogs page by clicking on Blogs");
   	 
   	 Thread.sleep(4000);
   	 blogs.blogNavigation();
   	 
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
   	        By.xpath("//div[contains(@id,'react-select-lazy-category-option') and text()='Adventure']")
   	    )
   	);
   	
   	option.click();
         
   	 logger.info("TC-04 --> Verify User is able to fill the blog read time");
   	 blogs.blogReadTime("10");
   	 threadTime();
   	
   	 logger.info("TC-05 --> Verify User is able to fill the blog title");
   	 blogs.blogTitleAdd("Automation Blog");
   	 threadTime();
   	 
   	 logger.info("TC-06 --> Verify User is able to fill the blog description");
   	 blogs.blogDescription("Please go through our new automation blog");
   	 threadTime();
   	 
   	 Thread.sleep(10000);
   	 
   	 logger.info("TC-07 --> Verify Blog is getting created or not by clicking Publish button");
   	 blogs.publishBlog();
   	 
    }
       
   //  @Test(priority=3,dependsOnMethods= {"logInDetails"})
    void searchBlog() throws InterruptedException {
   	 
   	 Thread.sleep(4000);
   	 
     Blogs_TR blogs = new Blogs_TR(driver);
   	 
   	 logger.info("TC-01 --> Verify User is navigate to the blogs page by clicking on Blogs");
   	 
   	 Thread.sleep(5000);
   	 blogs.blogNavigation(); 
   	 
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
    
  //   @Test(priority=4,dependsOnMethods= {"logInDetails"})
    void editBlog() throws InterruptedException {
   	
   	 Thread.sleep(4000);
   	 
     Blogs_TR blogs = new Blogs_TR(driver);
   	 
   	 logger.info("TC-01 --> Verify User is navigate to the blogs page by clicking on Blogs");
   	 
   	 Thread.sleep(5000);
   	 blogs.blogNavigation(); 
   	 
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
   	 
    }
    
     @Test(priority=5,dependsOnMethods= {"logInDetails"})
    void deleteBlog() throws InterruptedException {
   	 
     Blogs_TR blogs = new Blogs_TR(driver);
   	 
   	 logger.info("TC-01 --> Verify User is navigate to the blogs page by clicking on Blogs");
   	 
   	 Thread.sleep(5000);
   	 blogs.blogNavigation(); 
   	 
   	 Blogs_TR blogSearch = new Blogs_TR(driver);
   	 
 
   	 By filterIcon = By.xpath("//span[contains(@class,'filter-icon')]");
 	 applyReactSelectFilter(filterIcon, "react-select-19-placeholder", "Newest to Oldest");
   	
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
   	
}
