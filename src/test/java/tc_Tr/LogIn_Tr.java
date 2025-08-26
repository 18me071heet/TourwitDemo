package tc_Tr;

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
		
		logger.info("Verify User is able to add email");
		threadTime();
		login.addEmail(p.getProperty("email_tr"));
		
		logger.info("Verify User is able to add password");
		threadTime();
		login.addPass(p.getProperty("password_tr"));
		
		logger.info("Verify User is able to login by clicking on Login Button");
		threadTime();
		login.loginBtn();
		
	}
	
}
