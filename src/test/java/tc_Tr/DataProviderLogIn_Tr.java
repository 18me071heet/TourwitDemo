package tc_Tr;

import java.time.Duration;
import org.openqa.selenium.TimeoutException;


import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import baseClassTr.BaseClassTr;
import pageObjectTr.DataProviderLogIn;
import pageObjectTr.Login_TR;

public class DataProviderLogIn_Tr extends BaseClassTr {


	 void threadTime() throws InterruptedException {
	   
	   Thread.sleep(3000);
	   
    }
	 
	 
	@Test(dataProvider="dp")
	void login(String email,String password) throws InterruptedException {
		
     	DataProviderLogIn login = new DataProviderLogIn(driver);
		
		Login_TR loginN = new Login_TR(driver);
		
		logger.info("TC-01 --> Verify User email is filled ");
		threadTime();
		login.setEmail(email);
		
		logger.info("TC-02 --> Verify User password is filled");
		threadTime();
		login.setPass(password);
		
		logger.info("TC-03 --> Verify User is able to login with valid email and password");
		threadTime();
		login.logIn();
		threadTime();
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
		
		
	/*	 if (driver.getCurrentUrl().contains("login")) {
		        driver.navigate().refresh();
		    }
		 
		 else 
		 {
			
			 loginN.profileIconClick();
			 loginN.logOut();
			 loginN.logOutConfirm();
		 }
		
		 */
         
		 By profileIcon = By.xpath("//img[@alt='Profile']");
		 
	    try {
		       
		        wait.until(ExpectedConditions.visibilityOfElementLocated(profileIcon));
		        logger.info("Login Successful → Logging out now");

		        if (driver.getCurrentUrl().contains("login")) {
			        driver.navigate().refresh();
			    }
			 
			 else 
			 {
				
				 threadTime();
				 loginN.profileIconClick();
				 loginN.logOut();
				 loginN.logOutConfirm();
			 }
		    
		    } catch (TimeoutException e) {
		        logger.warn("Profile icon not found → Checking for toast error...");
		    }
		   

		}
	
	
	@DataProvider(name="dp")
	Object[][] loginData(){
		
		Object data[][] = 
			
			{
			
			{"user2@yopmail.com","Test@123"},
			{"user7@yopmail.com","Test@123"},
			{"user23@yopmail.com","Test@123"},
			{"tourwitqa@yopmail.com","Test@123"}
		};
		
		return data;
		
		
	}

}
