package tc_Tr;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import baseClassTr.BaseClassTr;
import pageObjectTr.EditAddress_TR;
import pageObjectTr.Login_TR;

public class EditAddress_Tr extends BaseClassTr {

	
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
	void changeAddress() throws InterruptedException {
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
		
		Login_TR login = new Login_TR(driver);
		
		EditAddress_TR address = new EditAddress_TR(driver);
		
		logger.info("TC-01 --> Verify options are dispalying by clicking on profile icon");
		Thread.sleep(4000);
		login.profileIconClick();
		
		logger.info("TC-02 --> Verify profile screen is displaying by clicking edit profile");
		address.myProfile();
		
		logger.info("TC-03 --> Verify Address screen is displaying by clicking saved address");
		Thread.sleep(5000);
		address.clickAddress();
				
    	//	address.clickDefault();
		
		logger.info("TC-04 --> Verify User is able to change first name");
		address.changeFname("Smith");
		
		logger.info("TC-05 --> Verify User is able to change last name");
		address.changeLname("Johnn");
		
		logger.info("TC-06 --> Verify User is able to change phone");
		address.changePhone("9911991199");
		
		logger.info("TC-07 --> Verify User is able to change email address");
		address.changeEmail("user24@yopmail.com");
		
		logger.info("TC-08 --> Verify User is able to change address");
   	    address.changeAddress("Beside Chruch Street , Outside ray beach");
   	    
   	    logger.info("TC-09 --> Verify User is able to change and select state from the list ");
   	    
   	    WebElement stateList = wait.until(ExpectedConditions.elementToBeClickable(By.id("react-select-lazy-stateId-input")));
   	    stateList.click();
   	    stateList.sendKeys("Gujarat");
   	    
   	    WebElement stateSelect = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@role='option' and text()='Gujarat']")));
   	    stateSelect.click();
   	    
   	    logger.info("TC-10 --> Verify User is able to change city and select city from the list");
   	    
   	    WebElement cityList = wait.until(ExpectedConditions.elementToBeClickable(By.id("react-select-lazy-cityId-input")));
   	    cityList.click();
   	    cityList.sendKeys("Ahmedabad");
   	    
   	    WebElement citySelect = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@role='option' and text()='Ahmedabad']")));
   	    citySelect.click();
		
		logger.info("TC-11 --> Verify User is able to change zip code");
		address.changeCode("360011");
		
		logger.info("TC-12 --> Verify change details are getting saved or not");
		address.saveAddress();
		
	}
}
