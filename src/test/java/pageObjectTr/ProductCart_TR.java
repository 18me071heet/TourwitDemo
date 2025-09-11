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

public class ProductCart_TR {
	
	public WebDriver driver;
	WebDriverWait wait;
	
	public ProductCart_TR(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	@FindBy(xpath="//a[@href='/crafts/my-cart']")
	WebElement cartIcon;
	
	@FindBy(xpath=" //button[normalize-space()='Proceed to checkout']")
	WebElement checkOut;
	
	@FindBy(xpath="//span[contains(@class,'searchclickMac')]")
	WebElement searchProduct;

	@FindBy(xpath="//input[@placeholder='Search Here...']")
    WebElement searchBox;
	
	@FindBy(xpath="//a[@class='text-lg font-semibold text-secondary' and normalize-space()='Heritage Doll']")
	WebElement txtHeritageDoll;
	
	@FindBy(xpath="//button[normalize-space()='Go to Cart']")
	WebElement btnGotoCart;
	
	@FindBy(xpath="//input[@id='ToCAgreed']")
	WebElement checkTerms;
	
	@FindBy(xpath=" //button[normalize-space()='Proceed to checkout']")
	WebElement lastCheckOut;
	
	@FindBy(xpath=" //input[@placeholder='Mobile number']")
	WebElement addNumber;
	
	@FindBy(xpath=" //button[@type='button'][normalize-space()='Continue']")
	WebElement btnNumberContinue;
	
	@FindBy(xpath=" //input[@placeholder='Card Number']")
	WebElement cardNo;
	
	@FindBy(xpath=" //input[@placeholder='CVV']")
	WebElement txtCvv;
	
	@FindBy(xpath=" //input[@placeholder='MM / YY']")
	WebElement addDate;
	
	@FindBy(xpath="//input[@name='save']")
	WebElement checkT;
	
	@FindBy(xpath="//button[normalize-space()='Continue']")
	WebElement btnContinue;
	
	
	public void cartPage() {
		
		WebElement cartPage = wait.until(ExpectedConditions.elementToBeClickable(cartIcon));
		cartPage.click();
	}
	
	public void checkOut() {
			
		WebElement checkOutBtn = wait.until(ExpectedConditions.elementToBeClickable(checkOut));
		checkOutBtn.click();
	}
	
	public void search() {
		
		WebElement searchProduct = wait.until(ExpectedConditions.elementToBeClickable(
		        By.xpath("//span[contains(@class,'searchclickMac')]")
		));
		searchProduct.click();
	
	}
	
	public void searchBoxPro(String search) {
		
		searchBox.sendKeys(search);
		
	}
	
	public void productClick() {
		
		WebElement clickonProduct = wait.until(ExpectedConditions.elementToBeClickable(txtHeritageDoll));
		clickonProduct.click();
		
	}
	
	public void goToCart() {
		
		WebElement clickOnCart = wait.until(ExpectedConditions.elementToBeClickable(btnGotoCart));
		clickOnCart.click();
	
	}
	
	public void checkT() {
		
		
		checkTerms.click();
		
	}
	
	public void lastCheckOutBtn() {
		
		lastCheckOut.click();
		
	}
	
	public void numberAdd(String number) {
		
		addNumber.sendKeys(number);
		
	}
	
	public void clickContinue() {
		
		btnNumberContinue.click();
		
	}
	
   public void cardN(String number) {
		
	cardNo.sendKeys(number);
	
	}
   
   public void cvv(String number) {
	
	txtCvv.sendKeys(number);
	
   }
	
   public void addDateN(String date) {
	   
	   addDate.sendKeys(date);
	   
   }
   
   public void checkTerms() {
	   
	   checkT.click();
   }
   
   public void Save() {
	   
	   btnContinue.click();
   }
   
}
