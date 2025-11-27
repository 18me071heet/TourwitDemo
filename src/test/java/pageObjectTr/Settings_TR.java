package pageObjectTr;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Settings_TR {

	public WebDriver driver;
	WebDriverWait wait;
	
	public Settings_TR(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver,Duration.ofSeconds(10));
	}
	
	@FindBy(xpath="//a[normalize-space()='My Profile']")
	WebElement btnProfile;
	
	@FindBy(xpath=" //span[normalize-space()='Settings']")
	WebElement btnSettings;
	
	
	public void btnProfileClick() {
		
		btnProfile.click();
	}
	
	public void btnSettingsClick() {
		
		btnSettings.click();
	}
	
	  public void setToggle(String labelText, boolean desiredState) {
	        WebElement toggleContainer = wait.until(
	            ExpectedConditions.elementToBeClickable(
	                driver.findElement(By.xpath("//label[text()='" + labelText + "']/following-sibling::div"))
	            )
	        );

	        WebElement toggleCircle = toggleContainer.findElement(By.xpath("./div"));
	        String bgColor = toggleCircle.getCssValue("background-color");
	        boolean isOn = bgColor.contains("rgb(59, 130, 246)"); // blue = ON

	        if (isOn != desiredState) {
	            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", toggleContainer);
	            System.out.println(labelText + " switch set to " + (desiredState ? "ON" : "OFF"));
	        } else {
	            System.out.println(labelText + " switch is already " + (desiredState ? "ON" : "OFF"));
	        }
	    }
	}
	

