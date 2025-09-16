package pageObjectTr;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BottomNavigation_TR {

	public WebDriver driver;
	
	public BottomNavigation_TR(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//a[normalize-space()='Privacy Policies']")
	WebElement privacyLink;
	
	@FindBy(xpath=" //a[normalize-space()='Terms & Conditions']")
	WebElement tC;
	
    @FindBy(xpath="//a[text()='Home']")
    WebElement btnHome;
    
    @FindBy(xpath="//a[text()='About Us']")
    WebElement btnAboutus;
    
    @FindBy(xpath="//a[normalize-space()='FAQs']")
    WebElement btnFaq;
    
    
    public void privacyPolicy() {
    	
    	privacyLink.click();
    }
    
    public void termsAndCondition() {
    	
    	tC.click();
    }
    
    public void homePage() {
    	
    	btnHome.click();
    }
    
    public void aboutUs() {
    	
    	btnAboutus.click();
    }
    
    public void faqClick() {
    	
    	btnFaq.click();
    }
		
}
