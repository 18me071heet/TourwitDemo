package tc_Tr;

import org.testng.annotations.Test;

import baseClassTr.BaseClassTr;
import pageObjectTr.ForgotPassword_TR;

public class ForgotPassword_Tr extends BaseClassTr{
	
	 void threadTime() throws InterruptedException {
	 	   
	 	   Thread.sleep(3000);
	     }
	 
	 @Test()
	 void forgotPassword() throws InterruptedException {
		 
		 ForgotPassword_TR forgot = new ForgotPassword_TR(driver);
		 
		 logger.info("TC-01 --> Verify forgot password popup is displaying by clicking on Forgot password link");
		 
		 forgot.clickLink();
		 threadTime();
		 
		 logger.info("TC-02 --> Verify User is able to add email address");
		 forgot.addEmail(p.getProperty("email_tr"));
		 threadTime();
		 
		 logger.info("TC-03 --> Verify Password reset link is getting send to the enter email adddress");
		 forgot.btnResetClick();
	 }
}
