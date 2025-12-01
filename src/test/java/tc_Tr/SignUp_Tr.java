package tc_Tr;


import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import baseClassTr.BaseClassTr;
import pageObjectTr.Login_TR;
import pageObjectTr.Signup_TR;

   public class SignUp_Tr extends BaseClassTr{

	 void threadTime() throws InterruptedException {
  	   
  	   Thread.sleep(3000);
  	   
      }
	 
	@Test()
	void signUpDetails() throws InterruptedException {
		
	Login_TR login = new Login_TR(driver);
	Signup_TR signup = new Signup_TR(driver);

	
	try {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		
		logger.info("TC-01 --> Verify Sign up screen is displaying or not by clicking on Signup button");
		login.clickSignUpLink();
		
		logger.info("TC-02 --> Verify User is able to fill the first name");

		signup.addFname(p.getProperty("firstname_tr"));
		
		logger.info("TC-03 --> Verify User is able to fill the last name");
		signup.addLname(p.getProperty("lastname_tr"));

		logger.info("TC-04 --> Verify User is able to fill email field");
	    signup.addEmail(p.getProperty("emailExist_tr"));

	    logger.info("TC-05 --> Verify User is able to select country");
	    
	    WebElement countryInput = wait.until(ExpectedConditions
		           .elementToBeClickable(By.id("react-select-lazy-country-input")));
		countryInput.click();
		countryInput.sendKeys("India");

		  WebElement countryOption = wait.until(ExpectedConditions
		           .visibilityOfElementLocated(By.xpath("//div[contains(@id,'react-select-lazy-country-option') and text()='India']")));
		 countryOption.click();
		       
		       
		logger.info("TC-06 --> Verify User is able to fill Insta Id");
		signup.addInstaId(p.getProperty("insta_tr"));

		
		logger.info("TC-07 --> Verify User is able to fill the Password");
		signup.addPassword(p.getProperty("password_tr"));

	/*  logger.info("TC-09 --> Verify validation message is displaying while entering different password");
	  signup.addConfirmPassword(p.getProperty("differentPassword_tr"));
	  signup.btnSignUp();
	
	    
	  WebElement errorMessagePassword = wait.until(
			    ExpectedConditions.visibilityOfElementLocated(
			        By.xpath("//*[contains(text(),'Passwords must match')]")
			    )
			);
			Assert.assertTrue(errorMessagePassword.isDisplayed(), "Validation message not displayed");
			logger.info("Validation message displayed: " + errorMessagePassword.getText());
			
	   threadTime();
	   
	 */
	   
		logger.info("TC-08--> Verify User is able to fill the Confirm Password");
		signup.addConfirmPassword(p.getProperty("confirmPassword_tr"));
		
	/*	logger.info("Verify Validation message is displaying without selecting terms and conditions");
		
		signup.btnSignUp();
     WebElement clickTerms = wait.until(ExpectedConditions.visibilityOfElementLocated(
    	  By.xpath("//*[contains(text(),'You must agree to the Terms & Conditions')]")));
  	Assert.assertTrue(clickTerms.isDisplayed(), "Terms validation message not displayed");
  	
  	*/
    		
		
	        logger.info("TC-09 --> Verify User is able to select terms and conditions");
			threadTime();
		    WebElement terms = wait.until(ExpectedConditions.elementToBeClickable(By.id("ToCAgreed")));
		    terms.click();
	
	    Thread.sleep(3000);
	    
		logger.info("TC-10 --> Verify User is able to Sign up by clicking Sign up button");
		signup.btnSignUp();
	

	//	WebElement errorEmail = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'User with email user23@yopmail.com is already verified and registered.')]")));
	//	Assert.assertTrue(errorEmail.isDisplayed(),"User with email user23@yopmail.com is already verified and registered.");
		
	//	logger.info("Verify Validation message is displayed while entering existing email address:"+errorEmail.getText());
		

	   } catch(Exception e) {
		
		logger.error("Failed:"+e);
		Assert.fail("It is failed due to:"+e.getMessage());
	}
	
	}
}
