package tc_Tr;

import java.time.Duration;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import baseClassTr.BaseClassTr;
import pageObjectTr.Login_TR;
import pageObjectTr.ProductCart_TR;

public class ProductCart_Tr extends BaseClassTr{
	
	
	void threadTime() throws InterruptedException {
 	   
 	   Thread.sleep(5000);
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
	 
	 
	 @Test(priority=2,dependsOnMethods= {"logInDetails"})
	 void addProductCart() throws InterruptedException{
		 
		 ProductCart_TR products = new ProductCart_TR(driver);
		 
	     threadTime();
		 logger.info("TC-01 --> Verify search box is displaying by clicking on search icon");
		 products.search();
		 
		 logger.info("TC-02 --> Verify User is able to fill search box");
		 products.searchBoxPro("Heritage Doll");
		 
		 logger.info("TC-03 --> Verify Product details page is displaying by clicking on specific searched product");
		 products.productClick();
		 
		 threadTime();
		 
   /*    logger.info("TC-04 --> Verify Product is added into the cart by clicking on Add to Cart button");
   
		 WebElement addToCartBtn = driver.findElement(By.xpath("//button[normalize-space()='Add to cart']"));
		 ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", addToCartBtn);

		 wait.until(ExpectedConditions.elementToBeClickable(addToCartBtn));

		 addToCartBtn.click();
		 
		 */
		 
		 logger.info("TC-05 --> Verify User is navigate to the cart page by clicking Go to cart ");
		 
		 products.goToCart();
		 
		 logger.info("TC-06 --> Verify User is able to procceed the checkout");
		 
		 products.checkOut();
		 
		 logger.info("TC-07 --> Verify User is able to select Terms and Condtions");
		 
		 products.checkT();
		 
		 logger.info("TC-08 --> Verify User is do final checkout by clicking checkout button on cart page");
		 
		 products.lastCheckOutBtn();
		 
		
		//logger.info("TC-09 --> Verify User is able to add mobile number");
		 
	    //products.numberAdd("9911991199");
		 
	  /*	 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		  
	  WebElement razorpayFrame = wait.until(
		         ExpectedConditions.presenceOfElementLocated(By.cssSelector("iframe.razorpay-checkout-frame"))
		 );
	  
		 driver.switchTo().frame(razorpayFrame);


		 WebElement cardFrame = wait.until(
			        ExpectedConditions.presenceOfElementLocated(By.cssSelector("iframe[name*='card.number']"))
			);
			
			driver.switchTo().frame(cardFrame);
			
			wait.until(ExpectedConditions.elementToBeClickable(By.name("card.number"))).sendKeys("4242424242424242");

		
		driver.switchTo().parentFrame();
		
		*/

		 
		 logger.info("TC-10 --> Verify User is able to add card number");
		 
		 products.cardN(p.getProperty("cardNumber_tr"));
		 
		 logger.info("TC-11 --> Verify User is able to add Cvv number");
		 
		 products.cvv(p.getProperty("cardCvv_tr"));
		 
		 logger.info("TC-12 --> Verify User is able to add Date");
		 
		 products.addDateN(p.getProperty("cardDate_tr"));
		 
		 logger.info("TC-13 --> Verify User is able to select Terms and Conditions of Bank");
		 
		 products.checkTerms();
		 
		 logger.info("TC-14 --> Verify Payment is successfull or not by clicking continue");
		 
		 products.Save();

		 
	 }
}
