package tc_Tr;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import baseClassTr.BaseClassTr;
import pageObjectTr.Login_TR;
import pageObjectTr.Settings_TR;

public class SettingsPage_TR extends BaseClassTr{

	void threadTime() throws InterruptedException {
 	   
 	   Thread.sleep(5000);
 	   
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
			
		} catch(Exception e) {
			
			logger.error("Failed :"+e);
			Assert.fail("Failed due to:"+e.getMessage());
		}
		
	}
	
	@Test(priority=1,dependsOnMethods= {"logInDetails"})
	void settingModule() throws InterruptedException {
		
		Login_TR login = new Login_TR(driver);
		
		logger.info("TC-01 --> Verify options are displaying by clicking on profile icon");
		threadTime();
		login.profileIconClick();
		
		logger.info("TC-02 --> Verify user is navigate to their profile page by clicking on my profile");
		
		Settings_TR settings = new Settings_TR(driver);
		threadTime();
		settings.btnProfileClick();
		
		logger.info("TC-03 --> Verify user is navigate to the settings page by clicking on settings");
		threadTime();
		settings.btnSettingsClick();
		
		logger.info("TC-04 --> Verify user is able to turn on / off New Blog post notification settings");
		threadTime();
		settings.setToggle("New Blog Posts", false);
		settings.setToggle("New Blog Posts", true);
		
		logger.info("TC-05 --> Verify user is able to turn on /off New Forum Post notification settings");
		threadTime();
		settings.setToggle("New Forum Posts", false);
		settings.setToggle("New Forum Posts", true);
		
		logger.info("TC-06 --> Verify user is able to turn on /off Blog Likes notification settings");
		threadTime();
		settings.setToggle("Blog Likes", false);
	    settings.setToggle("Blog Likes", true);
		
		WebElement closeSubs = driver.findElement(By.xpath(" //button[@aria-label='Close popup']//*[name()='svg']"));
		closeSubs.click();
			
		logger.info("TC-07 --> Verify user is able to turn on /off Blog Comments notification settings");
		threadTime();
		settings.setToggle("Blog Comments", false);
		settings.setToggle("Blog Comments", true);
		
		logger.info("TC-08 --> Verify user is able to turn on /off Forum Comments notification settings");
		threadTime();
		settings.setToggle("Forum Comments", false);
	    settings.setToggle("Forum Comments", true);
		
		logger.info("TC-09 --> Verify user is able to turn on /off Forum Likes notification settings");
		threadTime();
		settings.setToggle("Forum Likes", false);
		settings.setToggle("Forum Likes", true);
		
		
		logger.info("TC-10 --> Verify user is able to turn on /off Comments Like notification settings");
		threadTime();
		settings.setToggle("Comments Like", false);
		settings.setToggle("Comments Like", true);
		
		logger.info("TC-11 --> Verify user is able to turn on /off Comments Replies notification settings");
		threadTime();
        settings.setToggle("Comments Replies", false);
		settings.setToggle("Comments Replies", true);
		
	}
}
