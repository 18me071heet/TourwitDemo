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
		
	
		logger.info("TC-01 --> Verify Sign up screen is displaying or not by clicking on Signup button");
		login.clickSignUpLink();
		//signup.SignUpScreen();
		logger.info("TC-02 --> Verify User is able to fill the first name");

		signup.addFname(p.getProperty("firstname_tr"));
		threadTime();

		logger.info("TC-03 --> Verify User is able to fill the last name");
		threadTime();
		signup.addLname(p.getProperty("lastname_tr"));

		logger.info("TC-04 --> Verify User is able to fill email field");
		threadTime();
	    signup.addEmail(p.getProperty("emailSignUp_tr"));

		logger.info("TC-05 --> Verify User is able to fill Insta Id");
		threadTime();
		signup.addInstaId(p.getProperty("insta_tr"));

		logger.info("TC-06 --> Verify User is able to fill the Password");
		threadTime();
		signup.addPassword(p.getProperty("password_tr"));

		logger.info("TC-07 --> Verify User is able to fill the Confirm Password");
		threadTime();
		signup.addConfirmPassword(p.getProperty("confirmPassword_tr"));
		
		Assert.assertEquals(p.getProperty("password_tr"),p.getProperty("confirmPassword_tr"),"Password and Confirm Password not same");
		
		
		logger.info("TC-08 --> Verify User is able to select terms and conditions");
		threadTime();
		signup.checkTerms();

		  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		       WebElement countryInput = wait.until(ExpectedConditions
		           .elementToBeClickable(By.id("react-select-lazy-country-input")));
		       countryInput.click();
		       countryInput.sendKeys("India");

		       WebElement countryOption = wait.until(ExpectedConditions
		           .visibilityOfElementLocated(By.xpath("//div[contains(@id,'react-select-lazy-country-option') and text()='India']")));
		       countryOption.click();


		logger.info("TC-09 --> Verify User is able to Sign up by clicking Sign up button");
		threadTime();
		signup.btnSignUp();

	}catch(Exception e) {
		
		logger.error("Failed:"+e);
		Assert.fail("Failed due to:"+e.getMessage());
	}
	
	}
}
