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
import pageObjectTr.UserProfile_TR;

public class UserProfile_Tr extends BaseClassTr{
 
	
	 void threadTime() throws InterruptedException {
		 
		 Thread.sleep(4000);
	 }
	 
	 @Test(priority=1)
 	   void logInDetails() throws InterruptedException {
 		
 		Login_TR login = new Login_TR(driver);
 		
 		try {
 			
 			logger.info("TC-01 --> Verify User is able to add email");
            login.addEmail(p.getProperty("deleteAccountEmail_tr"));
	   		
	   		logger.info("TC-02 --> Verify User is able to add password");
	   		login.addPass(p.getProperty("password_tr"));
	   		
	   		logger.info("TC-03 --> Verify User is able to login by clicking on Login Button");
            login.loginBtn();
	   		
 		}  catch(Exception e) {
 			
 			logger.error("Failed:"+e);
 			Assert.fail("Failed due to:"+e.getMessage());
 		}		
 		
 	}
	 
	// @Test(priority=2,dependsOnMethods= {"logInDetails"})
	 void editProfile() throws InterruptedException {
		 
		 
		 WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
		 Login_TR login = new Login_TR(driver);
		 
		 UserProfile_TR profile = new UserProfile_TR(driver);
		 
		 threadTime();
		 logger.info("TC-01 --> Verify Options are displaying by clicking on profile icon");
		 
		 login.profileIconClick();
		 
		 logger.info("TC-02 --> Verify User is navigate to the profile page by clicking on My profile");
		 profile.myProfileClick();
		 
		 threadTime();
		 logger.info("TC-03 --> Verify User is able to Edit their first name");
		 
		 profile.editFirstName();
		 
		 profile.editFnames("Will");
		 
		 logger.info("TC-04 --> Verify Update name is getting saved by clicking on Save");
		 
		 profile.btnSaveClick();
		 threadTime();
		 
		 logger.info("TC-05 --> Verify User is able to Edit their last name");
		 
		 profile.editLastName();
		 
		 profile.editLnames("John");
		 
		 profile.btnSaveClick();
		 
		 logger.info("TC-06 --> Verify User is able to Edit their Insta Id");
		 
		 profile.editInsta();
		 
		 profile.editInstaId("Will100");
		 
		 profile.btnSaveClick();
		 
		 logger.info("TC-07 --> Verify User is able to Edit their Country from Country dropdown");
		 
		 threadTime();
		 profile.editCountry();
		 
		 WebElement country = wait.until(ExpectedConditions.elementToBeClickable(By.id("react-select-lazy-country-input")));
		 
		 country.click();
		 country.sendKeys("Australia");
		 
		 logger.info("TC-08 --> Verify Selected country is displaying in the country field");
		 
		 WebElement countryOptionSelected = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@id,'react-select-lazy-country-option') and text()='Australia']")));
		 countryOptionSelected.click();
		
		 profile.btnSaveClick();
		 
		 logger.info("TC-09 --> Verify User is able to view their followers list");
		 
		 Thread.sleep(3000);
		 
		 // profile.clickFollowersView();
		 
		 logger.info("TC-10 --> Verify User is able to search specific follower");
	
	     //	 profile.search("Lisa Menon");
		 
		 logger.info("TC-11 --> Verify User is able to view their following list");
		 
		 profile.clickFollowingView();
		 
		 logger.info("TC-12 --> Verify User is able to search specific following");
		 
		 profile.search(p.getProperty("followingSearch_Tr"));
		 
		 logger.info("TC-13 --> Verify User is able to unfollow user by clicking on Unfollow");
		 
		 profile.unfollowUser();
		 		 
	 }
	 
	 
	 @Test(priority=3,dependsOnMethods= {"logInDetails"})
	 void deleteMyAccount() throws InterruptedException {
		 
		 try {
			 
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
			
			 threadTime();
			 UserProfile_TR profile = new UserProfile_TR(driver);
			 
			 threadTime();
			 logger.info("TC-01 --> Verify Options are displaying by clicking on profile icon");
			 
			 profile.profileImage();
			 
			 logger.info("TC-02 --> Verify User is navigate to the profile page by clicking on My profile");
			 profile.myProfileClick();
			 
			 logger.info("TC-03 --> Verify Delete account confirmation popup is displaying by clicking Delete my account");
			 
			 threadTime();
			 profile.deleteAccount();
			 
	     	WebElement deleteMsg = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(text(),'User deleted successfully')]")));
			 
              String toast = deleteMsg.getText();
			 
			  Assert.assertTrue(toast.contains("User deleted successfully"), "No similiar toast msg is found");
			 
			 
	     /*	  WebElement deleteToast = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'User deleted successfully')]")));
			 
			 String toast = deleteToast.getText();
			 
			 Assert.assertTrue(toast.contains("User deleted successfully"), "No similiar toast msg is found");
			 
			 */
			 	 
		 }  catch(Exception e) {
			
			 logger.error("Failed:"+e);
			 Assert.fail("It is failed due to :"+ e.getMessage());
			 
		 }
		
	 }
}
