package pageObjectTr;

import java.time.Duration;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BlockUser_TR {

	public WebDriver driver;
	
	public BlockUser_TR(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
		
	@FindBy(xpath="//a[normalize-space()='My Profile']")
	WebElement btnProfile;

	@FindBy(xpath=" //input[@placeholder='Search...']")
	WebElement searchBox;
	
	@FindBy(xpath="//button[normalize-space()='Unblock']")
	WebElement unBlock;
	
	@FindBy(xpath="//button[normalize-space()='Confirm']")
	WebElement btnConfirm;
	
	public void clickMyProfile() {
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
		WebElement btnProfile = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='My Profile']")));
		
		btnProfile.click();
	}
	
	
	public void blockMembers() {
		
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

	    
	    WebElement clickBlockMembers = wait.until(
	        ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[normalize-space()='Blocked Members']"))
	    );

	        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", clickBlockMembers);

	     
	        wait.until(ExpectedConditions.elementToBeClickable(clickBlockMembers)).click();
	}

	
	public void searchName(String user) {
		
		searchBox.sendKeys(user);
	}

	
     /*	public void unBlockUser() {
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		WebElement unBlock=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Unblock']")));
		unBlock.click();
	}
	*/
	
	public void unBlockUser(String userName) {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	    WebElement userElement = wait.until(
		    ExpectedConditions.presenceOfElementLocated(
		        By.xpath("//h3[normalize-space()='" + userName + "']")
		    )
		);

      
		WebElement unblockButton = userElement.findElement(
			    By.xpath("following::button[normalize-space()='Unblock'][1]")
			);

    
		wait.until(ExpectedConditions.elementToBeClickable(unblockButton)).click();
		System.out.println("Unblocked user: " + userName);
	}

	
	
	public void confirmUnBlock() {
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
		WebElement btnConfirm = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Confirm']")));
		btnConfirm.click();
		
	}
	
	
}
