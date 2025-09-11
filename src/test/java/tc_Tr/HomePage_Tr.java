package tc_Tr;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import baseClassTr.BaseClassTr;
import pageObjectTr.HomePage_TR;
import pageObjectTr.Login_TR;

public class HomePage_Tr extends BaseClassTr {

 void threadTime() throws InterruptedException{
		 
		 Thread.sleep(4000);
	 }
 
   public WebElement retryFind(By locator, WebDriver driver) {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    return wait.ignoring(StaleElementReferenceException.class)
	               .until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	 
	 
	 @Test(priority=1)
	   void logInDetails() throws InterruptedException {
		
		Login_TR login = new Login_TR(driver);
		
		try {
			
			logger.info("TC-01 --> Verify User is able to add email");
           login.addEmail(p.getProperty("email_tr"));
	   		
	   		logger.info("TC-02 --> Verify User is able to add password");
	   		login.addPass(p.getProperty("password_tr"));
	   		
	   		logger.info("TC-03 --> Verify User is able to login by clicking on Login Button");
           login.loginBtn();
	   		
		}  catch(Exception e) {
			
			logger.error("Failed:"+e);
			Assert.fail("Failed due to:"+e.getMessage());
		}
		
		
	}
	 
	@Test(priority=2,dependsOnMethods= {"logInDetails"})
	 void selectCountryandSuggestBlogs() throws InterruptedException {
		 
		 logger.info("TC-01 --> Verify User is able to select country");
		 
		 HomePage_TR home = new HomePage_TR(driver);
		 
		/* WebElement country = wait.until(ExpectedConditions.elementToBeClickable(By.id("react-select")));
		 
		  threadTime();
		  country.click(); 
		 country.sendKeys("India");
		 
		 logger.info("TC-02 --> Verify selected country is displaying or not");
		 WebElement selectCountry = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@id,'react-select') and contains(@id,'-option') and text()='India']")));
		 
		 selectCountry.click();
		 
		 logger.info("TC-03 --> Verify User is able to enter number of days");  */
		 
		 threadTime();
		 
		 home.travelNavigation();
		 
		 logger.info("TC-02 --> Verify User is able to select specific continent ");
		 
		 home.countrySelection();
		 
		 logger.info("TC-03 --> Verify User is able to select specific country");
		 
		 home.countryClick();
		 
		 logger.info("TC-04 --> Verify User is navigate to the suggest blog page by clicking on any suggest blog");
		 
		 threadTime();
		 
		 home.suggestBlogCick(driver);
		 
		 logger.info("TC-05 --> Verify User is able to add comment");
		 
		 home.txtComment(driver, "Very inspiring blog");
		 
		 logger.info("TC-06 --> Verify Emoji picker is displaying by clicking on Emoji icon");
		 
		 logger.info("TC-07 --> Verify User is able to search any specific emoji");
		 
		 logger.info("TC-08 --> Verify User is able to select searched emoji");
		 
		 threadTime();
		 
		 home.emojiSelect(driver);
		 
		 logger.info("TC-09 --> Verify Comment is getting send by clicking on send icon");
		 
		 home.sendComment();
		
		
		 
		 
	 }
	 

}
