package tc_Tr;

import org.testng.Assert;
import org.testng.annotations.Test;

import baseClassTr.BaseClassTr;
import pageObjectTr.DataProviderLogIn;
import pageObjectTr.Login_TR;
import utilityTr.DataProviderTR;

public class DataProviderUtility_Tr extends BaseClassTr {

	@Test(dataProvider="DP",dataProviderClass=DataProviderTR.class)
	void logInTR(String email,String password,String exp) throws InterruptedException {
		
		DataProviderLogIn login = new DataProviderLogIn(driver);
		
		Login_TR logins = new Login_TR(driver);
		
		logger.info("TC-01 --> Verify User email is filled");
		login.setEmail(email);
		
		logger.info("TC-02 --> Verify User password is filled");
		login.setPass(password);
		
		logger.info("TC-03 --> Verify User is logged in by entering valid email and password");
		login.logIn();
		
		if(exp.equalsIgnoreCase("Valid")) {
  
		
				if(logins.isLoginSuccessful()) {
					
					Assert.assertTrue(true); 
					
					Thread.sleep(4000);
					logins.profileIconClick();
					logins.logOut();
					logins.logOutConfirm();
					
				} else {
					
					Assert.fail("After valid login credentials user is not able to logged in");
					
					 if (driver.getCurrentUrl().contains("login")) {
					        driver.navigate().refresh();
					    }
				}
			
			}
		
		else if(exp.equalsIgnoreCase("Invalid")) {
			
			if(!logins.isLoginSuccessful()) {
				
				Assert.assertTrue(true, "After Invalid credentials user is not able to logged in");
				
				if (driver.getCurrentUrl().contains("login")) {
			        driver.navigate().refresh();
			    }
			}
			
			else {
				
				Thread.sleep(4000);
				logins.profileIconClick();
				logins.logOut();
				logins.logOutConfirm();
				
				Assert.fail("After Invalid credentials user is still able to logged in ");
			}
			
		}
			 		
	}
		
	}

