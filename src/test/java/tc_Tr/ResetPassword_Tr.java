package tc_Tr;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import baseClassTr.BaseClassTr;
import pageObjectTr.ForgotPassword_TR;
import pageObjectTr.Login_TR;
import pageObjectTr.ResetPassword_TR;

public class ResetPassword_Tr extends BaseClassTr{

	
	  @Test(priority=1)
	   	void logInDetails() throws InterruptedException {
	   		
	   		Login_TR login = new Login_TR(driver);
	   		
	   		try {
	   			
	   			logger.info("Verify User is able to add email");
	   	   		login.addEmail(p.getProperty("email_tr"));
	   	   		
	   	   		logger.info("Verify User is able to add password");
	   	   		login.addPass(p.getProperty("password_tr"));
	   	   		
	   	   		logger.info("Verify User is able to login by clicking on Login Button");
         		login.loginBtn();
         		Thread.sleep(4000);
	   	   		
	   		} catch(Exception e) {
	   			
	   			logger.error("Failed:"+e);
	   			Assert.fail("It is failed due to:"+e.getMessage());
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
			
			logger.info("TC-02 --> Verify Reset Password screen is displaying by clicking Reset Password");
			Thread.sleep(3000);
	        resetPass.resetPassword(driver);
			
			//logger.info("Tc-03 --> Verify User is able to add old password");
	    	//resetPass.addOldPassword(p.getProperty("password_tr"));
	    	
	    	logger.info("TC-04 --> Verify Validation message is displaying by entering incorrect old password");
		    resetPass.addOldPassword(p.getProperty("invalidPassword_tr"));
			
			logger.info("TC-05 --> Verify User is able to add new password");
			resetPass.addNewPassword(p.getProperty("resetNewPassword_tr"));
			
			logger.info("TC-06 --> Verify validation message is displaying by entering different confirm password");
			resetPass.addConfirmPassword(p.getProperty("resetConfirmPassword_tr"));
			resetPass.resetPass();
			
		    WebElement errorOldMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Old password is incorrect')]")));
		    
		    Assert.assertTrue(errorOldMsg.isDisplayed(), "No Validation message is displaying");
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
		    
		}catch(Exception e) {
			
			logger.error("Test case is failed");
			Assert.fail("Failed due to:"+e.getMessage());
		}
	
	}
}
