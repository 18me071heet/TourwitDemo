package tc_Tr;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import baseClassTr.BaseClassTr;
import pageObjectTr.Login_TR;
import pageObjectTr.ProductCart_TR;

public class ProductCart_Tr extends BaseClassTr{
	
	
	void threadTime() throws InterruptedException {
 	   
 	   Thread.sleep(3000);
     }
	
	
	 public void smoothScrollToBottom(WebDriver driver) throws InterruptedException {
		    JavascriptExecutor js = (JavascriptExecutor) driver;

		    long lastHeight = (long) js.executeScript("return document.body.scrollHeight");

		    for (int y = 200; y < lastHeight; y += 200) {   // scroll 200px each step
		        js.executeScript("window.scrollTo(0, arguments[0]);", y);
		        Thread.sleep(200);  // wait 0.3s between scrolls for smooth effect
		    }

		  
		    js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		}
		
	 @Test(priority=1)
	 void logInDetails() {
		 
		 Login_TR login = new Login_TR(driver);
		 
			try {
	   			
	   			logger.info("Verify User is able to add email");
	   	   		threadTime();
	   	   		login.addEmail(p.getProperty("email_tr"));
	   	   		
	   	   		logger.info("Verify User is able to add password");
	   	   		threadTime();
	   	   		login.addPass(p.getProperty("password_tr"));
	   	   		
	   	   		logger.info("Verify User is able to login by clicking on Login Button");
	   	   		threadTime();
	   	   		login.loginBtn();
	   	   		
	   		}catch(Exception e) {
	   			
	   			logger.error("Failed:"+e);
	   			Assert.fail("It is failed due to:"+e.getMessage());
	   		}
		 

	 }
	 
	 @Test(priority=2,dependsOnMethods= {"logInDetails"})
	 void addProductCart() throws InterruptedException{
		 
		 ProductCart_TR productCart = new ProductCart_TR(driver);
		 
		 WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
		 
		 logger.info("TC-01 --> Verify User is able to add product into the cart");
		 
		 
		 WebElement productCarts = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//h5[text()='Heritage Doll']/ancestor::div[contains(@class,'product')]//button[contains(text(),'Add to cart')]")));
		 
		 ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", productCarts);

		 Actions actions = new Actions(driver);
		 actions.moveToElement(productCarts).pause(Duration.ofSeconds(1)).perform();
		 productCarts.click();
		 
		 logger.info("TC-02 --> Verify User is navigate to the Cart page by clicking on Cart icon");
		 
		 productCart.cartPage(driver);
		 
		 logger.info("TC-03 --> Verify User is navigate to the next page by clicking processed to checkout");
		 
		 productCart.checkOut(driver);
		
	
		 
	 }
}
