package tc_Tr;

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
	   	   		
	   		}catch(Exception e) {
	   			
	   			logger.error("Failed:"+e);
	   			Assert.fail("It is failed due to:"+e.getMessage());
	   		}
	  }
	   		
	@Test(priority=2,dependsOnMethods= {"logInDetails"})
	public void resetPassword() throws InterruptedException {
		
		Login_TR login = new Login_TR(driver);
		
		ResetPassword_TR resetPass = new ResetPassword_TR(driver);
		
		
		login.profileIconClick();
		
		logger.info("TC-01 --> Verify User is navigate to the profile page");
		Thread.sleep(4000);
		resetPass.profileClicks(driver);
		
		logger.info("TC-02 --> Verify Reset Password screen is displaying by clicking Reset Password");
		
		Thread.sleep(4000);
		resetPass.resetPassword(driver);
		
		logger.info("Tc-03 --> Verify User is able to add old password");
		
		resetPass.addOldPassword(p.getProperty("password_tr"));
		
		logger.info("TC-04 --> Verify User is able to add new password");
		
		resetPass.addNewPassword(p.getProperty("resetNewPassword_tr"));
		
		logger.info("TC-05 --> Verify User is able to add confirm password");
		
		resetPass.addConfirmPassword(p.getProperty("resetConfirmPassword_tr"));
		
		logger.info("TC-06 --> Verify Password is getting reset by clicking reset button");
		
		resetPass.resetPass();
				
		
	}
}
