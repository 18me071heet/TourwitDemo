package tc_Tr;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import baseClassTr.BaseClassTr;
import pageObjectTr.Login_TR;
import pageObjectTr.MyBookings_TR;

public class MyBookings_Tr extends BaseClassTr {

	 public void threadTime() throws InterruptedException{
		 
		 Thread.sleep(4000);
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
	 
	 @Test(priority=2,dependsOnMethods= {"logInDetails"},groups= {"Smoke","Functional"})
	 void userBookings() throws InterruptedException {
		 
		 Login_TR login = new Login_TR(driver);
		 
		 
		 try {
			 
			 logger.info("TC-01 --> Verify options are displaying by clicking on profile icon");
			 threadTime();
			 login.profileIconClick();
			 
			 MyBookings_TR bookings = new MyBookings_TR(driver);
			 
			 logger.info("TC-02 --> Verify User is navigate to the booking screen by clicking on My Bookings");
			 
			 bookings.myBookings();
			 
			 logger.info("TC-03 --> Verify User is able to search their booking by their order id");
			 
			 bookings.serachId(p.getProperty("orderIdSearch_Tr"));
			 
			 logger.info("TC-04 --> Verify User is able to see their searched order details by clicking on view details ");
			 
			 bookings.viewDetails();
			 
			 logger.info("TC-05 --> Verify User is navigate to the booking listing page by clicking on Back arrow");
			 
			 bookings.clickBack();
			 
			 logger.info("TC-06 --> Verify User is able to search another order");
			 
			 threadTime();
			 bookings.serachId(p.getProperty("secondOrderId_Tr"));
			 
			 logger.info("TC-07 --> Verify User is able to see another order details by clicking on view details");
			 threadTime();
			 bookings.viewDetails();
			 
			 bookings.clickBack();
			 
			 logger.info("TC-08 --> Verify User is able to filter the bookings by Newest to Oldest / Oldest to Newest");
			 
			 WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
			 WebElement filter = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class,'control')]")));
			 filter.click();
			 
			 WebElement option = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class,'option') and text()='Newest to Oldest']")));
			 option.click();
			 threadTime();
			 
			 logger.info("TC-09 --> Verify User is navigate to the home page by clicking on Home logo");
			 bookings.homeLogoClick();
			 		 
			 logger.info("TC-10 --> Verify User is navigate to the Notification page by clicking on Notification icon");
			 threadTime();
			 bookings.clickNotificationIcon();
			 
			 logger.info("TC-11 --> Verify User is able to see more notifications by clicking on show more");
			 bookings.moreNotification();
			 
			 logger.info("TC-12 --> Verify all notifications are getting cleared by clicking Clear All ");
			 // bookings.clearAllNoti();
			  
		 } catch(Exception e) {
			 
			 logger.error("Test case is failed");
			 Assert.fail("It is failed due to:"+e.getMessage());
			 
		 }
		
			 
	 }
	 
}
