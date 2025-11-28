package tc_Tr;


import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import baseClassTr.BaseClassTr;
import pageObjectTr.BottomNavigation_TR;
import pageObjectTr.Login_TR;

public class BottomNavigation_Tr extends BaseClassTr{

	 void threadTime() throws InterruptedException {
  	   
  	   Thread.sleep(3000);
      }
	 
	 public void smoothScrollToBottom(WebDriver driver) throws InterruptedException {
		    JavascriptExecutor js = (JavascriptExecutor) driver;

		    long lastHeight = (long) js.executeScript("return document.body.scrollHeight");

		    for (int y = 200; y < lastHeight; y += 200) {   // scroll 200px each step
		        js.executeScript("window.scrollTo(0, arguments[0]);", y);
		        Thread.sleep(200);  // wait 0.3s between scrolls for smooth effect
		    }

		  
		    js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
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
	 
	 @Test(priority=2,dependsOnMethods= {"logInDetails"})
	  public void bottomNavigationLinks() throws InterruptedException {
		
		BottomNavigation_TR  bottomNavigation = new BottomNavigation_TR(driver);
		
		try {
			
			logger.info("TC-01 --> Verify User is navigate to Privacy policy");
			((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
			bottomNavigation.privacyPolicy();
			
			logger.info("TC-02 --> Verify User is navigate to the Home page");
			Thread.sleep(3000);
			bottomNavigation.homePage();
			
			logger.info("TC-03 --> Verify User is navigate to the Terms and Condition");
			((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
			bottomNavigation.termsAndCondition();
			
			logger.info("TC-04 --> Verify User is navigate to the About Us page");
			bottomNavigation.aboutUs();
			smoothScrollToBottom(driver);
			
			logger.info("TC-05 --> Verify User is navigate to FAQ page");
			((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
			threadTime();
			bottomNavigation.faqClick();
			smoothScrollToBottom(driver);
			
		} catch(Exception e) {
			
			logger.error("Failed:"+e);
			Assert.fail("Failed due to:"+e.getMessage());
		}
	
		
	}

	
}
