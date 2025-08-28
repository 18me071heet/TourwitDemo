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

public class LogIn_Tr extends BaseClassTr {
    

	 void threadTime() throws InterruptedException {
 	   
 	   Thread.sleep(3000);
     }
	 
	@Test
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
			
			logger.error("Failed :"+e);
			Assert.fail("Failed due to:"+e.getMessage());
		}
		
	}
	
	@Test(priority=2,dependsOnMethods= {"logInDetails"})
	void logOut() throws InterruptedException {
		
		Login_TR login = new Login_TR(driver);
		
		logger.info("TC-01 --> Verify Logout option menu is displaying or not by clicking profile icon");
		Thread.sleep(4000);
		login.profileIconClick();
		
		logger.info("TC-01 --> Verify log out confirmation popup is displaying by clicking logout button");
		threadTime();
		login.logOut();
		
		logger.info("TC-02 --> Verify User is logged out by clicking on Logout confirmation");
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	    	
	   	 WebElement logoutConfirmation = wait.until(
	   	    ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Logout')]")));
	   	logoutConfirmation.click();
	}
	
}
