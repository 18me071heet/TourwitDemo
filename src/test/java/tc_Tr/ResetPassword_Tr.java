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
import pageObjectTr.ResetPassword_TR;

public class ResetPassword_Tr extends BaseClassTr{

void threadTime() throws InterruptedException{
		
		Thread.sleep(3000);
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
	public void resetPassword() throws InterruptedException {
		
		
		Login_TR login = new Login_TR(driver);
		
		ResetPassword_TR resetPass = new ResetPassword_TR(driver);
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
		
		Thread.sleep(3000);
		login.profileIconClick();
	  
			
		try {
			
			logger.info("TC-01 --> Verify User is navigate to the profile page");
		    resetPass.profileClicks(driver);
		    
			/*Thread.sleep(3000);
			 	WebElement closeSubs = driver.findElement(By.xpath(" //button[@aria-label='Close popup']//*[name()='svg']"));
					closeSubs.click();*/
		    
		    Thread.sleep(3000);
       	 
       	 logger.info("Tc -01 Verify User is able to enter name and email address in subscription popup ");
       	 
       	 logger.info("TC- 02 --> Verify User is able to select terms and conditions checkbox");
       	 
       	 logger.info("TC-03 --> Verify User is able to subscribe news letter by clicking submit button");
       	 login.subscribeNewsLater("Will John", "user23@yopmail.com");
					
			logger.info("TC-02 --> Verify Reset Password screen is displaying by clicking Reset Password");
			Thread.sleep(3000);
	        resetPass.resetPassword(driver);
			
			//logger.info("Tc-03 --> Verify User is able to add old password");
	    	//resetPass.addOldPassword(p.getProperty("password_tr"));
	    	
	    	logger.info("TC-04 --> Verify Validation message is displaying by entering incorrect old password");
	    	Thread.sleep(2000);
		    resetPass.addOldPassword(p.getProperty("invalidPassword_tr"));
			
			logger.info("TC-05 --> Verify User is able to add new password");
			Thread.sleep(2000);
			resetPass.addNewPassword(p.getProperty("resetNewPassword_tr"));
			
			logger.info("TC-06 --> Verify validation message is displaying by entering different confirm password");
			resetPass.addConfirmPassword(p.getProperty("resetConfirmPassword_tr"));
			resetPass.resetPasswordClick();
			
		    WebElement errorOldMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Old password is incorrect')]")));
		    
		    Assert.assertTrue(errorOldMsg.isDisplayed(), "No any Validation message is displaying");
		    logger.info("Validation message is displaying:"+errorOldMsg.getText());
		    
		/*	WebElement errorMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Passwords must match')]")));
			
			Assert.assertTrue(errorMsg.isDisplayed(), "No Validation Message displaying");
			logger.info("Validation message is displaying:"+errorMsg.getText());
			
			*/
			
		/*	resetPass.clearCpass();
			
			logger.info("TC-07 --> Verify User is able to add confirm password");
			resetPass.addConfirmPassword(p.getProperty("resetConfirmPassword_tr"));
			
			logger.info("TC-08 --> Verify Password is getting reset by clicking reset button");
			resetPass.resetPass();
					
			*/
		    
		    logger.info("TC-07 --> Verify Password is getting clear or not after entering old password");
		    resetPass.clearOldPassword();
		    
		    logger.info("TC-08--> Verify user is able to enter correct old password");
			Thread.sleep(2000);
		    resetPass.addOldPassword(p.getProperty("password_tr"));
		    
		    logger.info("TC-09 --> Verify password is getting changed by clicking reset password");
		    resetPass.resetPasswordClick();
		    
		    WebElement successMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Password changed successfully')]")));
		    
		    String successToast = successMsg.getText();
		    
		    Assert.assertTrue(successToast.contains("Password changed successfully"), "No success toast is displaying");
		    
		    wait.until(ExpectedConditions.invisibilityOf(successMsg));
		    
		    Thread.sleep(5000);
		    
		}catch(Exception e) {
			
			logger.error("Test case is failed");
			Assert.fail("Failed due to:"+e.getMessage());
		}
		
		//Password changed successfully
	
	}
	
	@Test(priority=3,dependsOnMethods= {"logInDetails"})
	void logout() throws InterruptedException {
		
        Login_TR login = new Login_TR(driver);
		
		ResetPassword_TR resetPass = new ResetPassword_TR(driver);
		
		logger.info("TC-01 --> Verify options are displaying by clicking on profile icon");
		resetPass.avtarClick();
		
		Thread.sleep(3000);
		logger.info("TC-02 --> Verify logout confirmation message is displaying by clicking logout option");
		
		resetPass.logOut();
		
	}
	
	 @Test(priority=4,dependsOnMethods= {"logout"})
	   	void logInAfterResetPassword() throws InterruptedException {
	   		
	   		Login_TR login = new Login_TR(driver);
	   		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
	   		
	   		try {
	   			
	   			logger.info("Verify User is able to add email");
	   	   		login.addEmail(p.getProperty("email_tr"));
	   	   		
	   	   		logger.info("Verify User is able to add password");
	   	   		login.addPass(p.getProperty("resetNewPassword_tr"));
	   	   		
	   	   		logger.info("Verify User is able to login by clicking on Login Button");
      		    login.loginBtn();
      		     Thread.sleep(2000);
      		     
      		    /* WebElement loginToast = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Login successfull')]")));
      		     
      		    String toast = loginToast.getText();
      		     
      		     Assert.assertTrue(toast.contains("Login successfull"),"No toast message is displaying"); */
      		   
      		     WebElement profileImage = driver.findElement(By.xpath("//img[@alt='Profile']"));
      		     
      		   Assert.assertTrue(profileImage.isDisplayed(), "❌ Profile image not displayed after login.");
      		    logger.info("✅ Profile image is displayed successfully after login with new password.");    
  
	   	   		
	   		} catch(Exception e) {
	   			
	   			logger.error("Failed:"+e);
	   			Assert.fail("It is failed due to:"+e.getMessage());
	   		}
	 }
}
