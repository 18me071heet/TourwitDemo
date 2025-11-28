package tc_Tr;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import baseClassTr.BaseClassTr;
import pageObjectTr.BlockUser_TR;
import pageObjectTr.Login_TR;

public class BlockUser_Tr extends BaseClassTr{

 
	 void threadTime() throws InterruptedException{
		 
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
	 
	 @Test(priority=2,dependsOnMethods= {"logInDetails"})
	 void blockMember() throws InterruptedException {
		 
		 Login_TR login = new Login_TR(driver);
	   	 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		 logger.info("TC-01 --> Verify options are displaying by clicking on profile icon");
		 
		 threadTime();
		 login.profileIconClick();
		 
		 BlockUser_TR blockUser = new BlockUser_TR(driver);
		 
		 logger.info("TC-02 --> Verify User is navigate to profile screen by clicking My Profile");
		 blockUser.clickMyProfile();
		 
		 logger.info("TC-02 --> Verify User is navigate to the block memeber screen ");
		 threadTime();
		 blockUser.blockMembers();
		 
		 logger.info("TC-03 --> Verify User is able to search any block memeber");
		 blockUser.searchName(p.getProperty("UnblockUser_tr"));
		 
		 logger.info("TC-04 --> Verify Unblock user confirm popup is displaying by clicking UnBlock");
		 threadTime();
		 blockUser.unBlockUser("Rinkal Patel");
		 
		 logger.info("TC-05 --> Verify User is able to Unblock user by clicking confirm");
		 blockUser.confirmUnBlock();
		 
		 //User has been unblocked successfully
		 
		 WebElement toastMsg = wait.until(
 	   		    ExpectedConditions.visibilityOfElementLocated(
 	   		        By.xpath("//div[contains(text(),'User has been unblocked successfully')]")));
 	   	 
 	     String toastTxt = toastMsg.getText();
 	   	 
 	     Assert.assertTrue(toastTxt.contains("User has been unblocked successfully"),"Toast msg displaying wrong");
 	   	 
  	     wait.until(ExpectedConditions.invisibilityOf(toastMsg));
	 }
	 
}
