package tc_Tr;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import baseClassTr.BaseClassTr;
import pageObjectTr.DataProviderLogIn;
import pageObjectTr.Login_TR;

public class DataProviderLogIn_Tr extends BaseClassTr {

	@Test(dataProvider="dp")
	void login(String email,String password) throws InterruptedException {
		
		DataProviderLogIn login = new DataProviderLogIn(driver);
		
		Login_TR loginN = new Login_TR(driver);
		
		logger.info("TC-01 --> Verify User email is filled ");
		login.setEmail(email);
		
		logger.info("TC-02 --> Verify User password is filled");
		login.setPass(password);
		
		logger.info("TC-03 --> Verify User is able to login with valid email and password");
		
		login.logIn();
		Thread.sleep(3000);
		
		 if (driver.getCurrentUrl().contains("login")) {
		        driver.navigate().refresh();
		    }
		 
		 else 
		 {
			 loginN.profileIconClick();
			 loginN.logOut();
			 loginN.logOutConfirm();
		 }
		
		
	}
	
	@DataProvider(name="dp")
	Object[][] loginData(){
		
		Object data[][] = 
			
			{
			
			{"user2@yopmail.com","Test@123"},
			{"user7@yopmail.com","Test@123"},
			{"user23@yopmail.com","Test@123"},
			{"heet.n@inheritx.com","Test@123"}
		};
		
		return data;
		
		
	}
		
	

	
}
