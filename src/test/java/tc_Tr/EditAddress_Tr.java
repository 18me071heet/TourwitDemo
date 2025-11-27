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
  		
	//@Test(priority=2)
	void changeAddress() throws InterruptedException {
		
		 WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
		 Login_TR login = new Login_TR(driver);
		
		 Thread.sleep(3000);
		 EditAddress_TR address = new EditAddress_TR(driver);
		
		 logger.info("TC-01 --> Verify options are dispalying by clicking on profile icon");
		 Thread.sleep(4000);
		 login.profileIconClick();
		
		 logger.info("TC-02 --> Verify profile screen is displaying by clicking edit profile");
		 address.myProfile();
		 
		 Thread.sleep(5000);
      	 logger.info("Tc -04 Verify User is able to enter name and email address in subscription popup ");
      	 
      	 logger.info("TC- 05 --> Verify User is able to select terms and conditions checkbox");
      	 
      	 logger.info("TC-06--> Verify User is able to subscribe news letter by clicking submit button");
      	 login.subscribeNewsLater("Will John", "user23@yopmail.com");
      	 
		 logger.info("TC-07 --> Verify Address screen is displaying by clicking saved address");
		 Thread.sleep(5000);
		 address.clickAddress();
			
	 	 logger.info("TC-08 --> Verify user is able to change country and select country from the list");
   	     
   	     WebElement countryList = wait.until(ExpectedConditions.elementToBeClickable(By.id("react-select-lazy-countryId-input")));
   	     countryList.click();
   	     countryList.sendKeys(p.getProperty("editCountry"));
   	    
   	     WebElement countrySelect = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@role='option' and text()='Australia']")));
     	 countrySelect.click();
     	 threadTime();
   	    
   	     logger.info("TC-09 --> Verify User is able to change and select state from the list ");
   	    
   	     WebElement stateList = wait.until(ExpectedConditions.elementToBeClickable(By.id("react-select-lazy-stateId-input")));
   	     stateList.click();
   	     stateList.sendKeys(p.getProperty("editState"));
   	    
   	     WebElement stateSelect = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@role='option' and text()='Queensland']")));
   	     stateSelect.click();
   	     threadTime();
   	     
   	     logger.info("TC-10 --> Verify User is able to change city and select city from the list");
   	    
   	     WebElement cityList = wait.until(ExpectedConditions.elementToBeClickable(By.id("react-select-lazy-cityId-input")));
   	     cityList.click();
   	     cityList.sendKeys(p.getProperty("editCity"));
   	    
   	     WebElement citySelect = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@role='option' and text()='Ascot']")));
   	     citySelect.click();
   	     threadTime();
		
   	     logger.info("TC-11 --> Verify User is able to change first name");
		 address.changeFname(p.getProperty("editFname"));
		 threadTime();
		 
		 logger.info("TC-12 --> Verify User is able to change last name");
		 address.changeLname(p.getProperty("editLname"));
		 threadTime();
		 
		 logger.info("TC-13 --> Verify User is able to change phone");
		 address.changePhone(p.getProperty("editPhone"));
		 threadTime();
		 
		 logger.info("TC-14 --> Verify User is able to change email address");
		 address.changeEmail(p.getProperty("editEmail"));
		 threadTime();
		
		 logger.info("TC-15 --> Verify User is able to change address");
	     address.changeAddress(p.getProperty("editAddress"));
	     threadTime();
	     
		 logger.info("TC-16 --> Verify User is able to change zip code");
		 address.changeCode(p.getProperty("editZip"));
		 threadTime();
		
		 logger.info("TC-17 --> Verify change details are getting saved or not");
		 address.clickSaveAddressJS();
		 
		 WebElement toast = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Address updated successfully')]")));
		 String successMsg = toast.getText();
		 Assert.assertTrue(successMsg.contains("Address updated successfully"), "No success toast msg found");
		 
		 wait.until(ExpectedConditions.invisibilityOf(toast));
		 
		 logger.info("TC-18 --> Verify user is able to set specific address as default");
		 
		 address.setDefaultForUser("Smith Williams");
		 
		 WebElement defaultAddressToast = wait.until(
			        ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Default address updated successfully')]")));
		 
		 String defaultToast = defaultAddressToast.getText();
		 
		 logger.info("TC-19 --> Verify success message toast is displaying or not after set default address");
		 
		 Assert.assertTrue(defaultToast.contains("Default address updated successfully"), "No similiar toast msg is found");
		 
		 wait.until(ExpectedConditions.invisibilityOf(defaultAddressToast));
		
	}
	
	
	@Test(priority=3,dependsOnMethods= {"logInDetails"})
	void addAddress() throws InterruptedException {
		
		 
		 WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
		 Login_TR login = new Login_TR(driver);
		
		 EditAddress_TR address = new EditAddress_TR(driver);
		
		 logger.info("TC-01 --> Verify options are dispalying by clicking on profile icon");
		 Thread.sleep(4000);
		 login.profileIconClick();
		
		 
		 logger.info("TC-02 --> Verify profile screen is displaying by clicking edit profile");
		 address.myProfile();
		 
		 Thread.sleep(3000);
   
		 address.clickSavedAddress();
      	      	  
		 logger.info("TC-06 --> Verify Address screen is displaying by clicking saved address");
		 Thread.sleep(5000);
		 address.clickAddNewAddress();
		
		 Thread.sleep(3000);
		 
		 logger.info("TC-07 --> Verify user is able to select country from the country dropdown");
		// CLICK DROPDOWN
		 WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(
		         By.xpath("//div[@id='react-select-lazy-countryId-placeholder']/parent::div")));
		 dropdown.click();
		 Thread.sleep(500);

		 // TYPE USING ACTIVE ELEMENT (React sets focus automatically)
		 WebElement activeInput = driver.switchTo().activeElement();
		 activeInput.sendKeys("Canada");
		 Thread.sleep(1000);

		 // SELECT OPTION
		 WebElement option = wait.until(ExpectedConditions.elementToBeClickable(
		         By.xpath("//div[@role='option' and contains(.,'Canada')]") ));
		 option.click();

	
   	  logger.info("TC-08 --> Verify User is able to change and select state from the list ");
   	    
   	     WebElement Statedropdown = wait.until(ExpectedConditions.elementToBeClickable(
		         By.xpath("//div[@id='react-select-lazy-stateId-placeholder']/parent::div")));
   	     
   	     Statedropdown.click();
		 Thread.sleep(500);
		 
		
		 WebElement activeState = driver.switchTo().activeElement();
		 activeState.sendKeys("Alberta");
		 Thread.sleep(1000);

		 WebElement stateOption = wait.until(ExpectedConditions.elementToBeClickable(
		         By.xpath("//div[@role='option' and contains(.,'Alberta')]") ));
		 stateOption.click();
   	     
		 logger.info("TC-09 --> Verify User is able to change and select city  from the list ");
     	 Thread.sleep(3000); 
         
     	
     			 WebElement cityDropdown = wait.until(ExpectedConditions.elementToBeClickable(
     			         By.xpath("//div[@id='react-select-lazy-cityId-placeholder']/parent::div")));
     			 cityDropdown.click();
     			 Thread.sleep(500);

     			
     			 WebElement cityInput = driver.switchTo().activeElement();
     			 cityInput.sendKeys("Bassano");
     			 Thread.sleep(1000);

     			
     			 WebElement cityOption = wait.until(ExpectedConditions.elementToBeClickable(
     			         By.xpath("//div[@role='option' and contains(.,'Bassano')]")));
     			 cityOption.click();
     			 
     	 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'app_ModalpopoutBottom')]//input[@id='firstName']")));
   	
   	     logger.info("TC-10 --> Verify User is able to add first name");
		 address.addFname(p.getProperty("addFname"));
		 threadTime();
		 
		 logger.info("TC-11 --> Verify User is able to add last name");
		 address.addLname(p.getProperty("addLname"));
		 threadTime();
		 
		 logger.info("TC-12 --> Verify User is able to add phone number");
		 address.addPhone(p.getProperty("addPhone"));
		 threadTime();
		 
		 logger.info("TC-13 --> Verify User is able to add email address");
		 address.addEmail(p.getProperty("addEmail"));
		 threadTime();
		
		 logger.info("TC-14 --> Verify User is able to change address");
	     address.addAddress(p.getProperty("addAddress"));
	     threadTime();
	     
		 logger.info("TC-15 --> Verify User is able to change zip code");
		 address.addCode(p.getProperty("addZip"));
		 threadTime();
		
		 logger.info("TC-16 --> Verify change details are getting saved or not");
		 address.clickSaveAddressJS();
		 
		 WebElement toast = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Address updated successfully')]")));
		 String successMsg = toast.getText();
		 Assert.assertTrue(successMsg.contains("Address updated successfully"), "No success toast msg found");
		 
		 wait.until(ExpectedConditions.invisibilityOf(toast));	
		 
		 
	}
}
