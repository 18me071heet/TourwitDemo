package tc_Tr;

import org.testng.Assert;
import org.testng.annotations.Test;
import baseClassTr.BaseClassTr;
import pageObjectTr.BlockUser_TR;
import pageObjectTr.Login_TR;

public class BlockUser_Tr extends BaseClassTr{

 
	 void threadTime() throws InterruptedException{
		 
		 Thread.sleep(4000);
	 }
	 
	 
	 @Test(priority=1)
	   void logInDetails() throws InterruptedException {
		
		Login_TR login = new Login_TR(driver);
		
		try {
			
			logger.info("TC-01 --> Verify User is able to add email");
           login.addEmail(p.getProperty("email_tr"));
	   		
	   		logger.info("TC-02 --> Verify User is able to add password");
	   		login.addPass(p.getProperty("password_tr"));
	   		
	   		logger.info("TC-03 --> Verify User is able to login by clicking on Login Button");
           login.loginBtn();
	   		
		}  catch(Exception e) {
			
			logger.error("Failed:"+e);
			Assert.fail("Failed due to:"+e.getMessage());
		}
		
		
	}
	 
	 @Test(priority=2,dependsOnMethods= {"logInDetails"})
	 void blockMember() throws InterruptedException {
		 
		 Login_TR login = new Login_TR(driver);
		 
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
		 blockUser.unBlockUser("Malay Darji");
		 
		 logger.info("TC-05 --> Verify User is able to Unblock user by clicking confirm");
		 blockUser.confirmUnBlock();
		 
	 }
	 
}
