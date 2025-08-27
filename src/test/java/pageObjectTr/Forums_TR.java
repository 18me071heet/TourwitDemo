package pageObjectTr;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Forums_TR {

	public WebDriver driver;
	
	public Forums_TR(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//a[normalize-space()='Forum']")
	WebElement forumLink;
	
	@FindBy(xpath="//button[normalize-space()='Create new post']")
	WebElement createForum;
	
	@FindBy(xpath="//input[@id='name']")
	WebElement forumTitle;
	
	@FindBy(xpath="//div[@class='custom-ql-editor']")
	WebElement forumDescription;
	
	@FindBy(xpath="//button[normalize-space()='Publish']")
	WebElement forumPublish;
	
	@FindBy(xpath="//button[normalize-space()='My Posts']")
	WebElement myForums;
	
	@FindBy(xpath="//input[@placeholder='Search by keywords...']")
	WebElement searchBox;
	
	@FindBy(xpath="//span[contains(@class,'filter')]/svg")
	WebElement editForumIcon;
	
	
	
	public void forumNavigation() {
		
		forumLink.click();
	}
	
	public void createForumClick() {
		
		createForum.click();
	}
	
	public void createTitle(String title) {
		
		forumTitle.sendKeys(title);
		
	}
	
	public void forumDescriptionAdd(String description) {
		
		forumDescription.sendKeys(description);
	}
	
	public void forumPublishBtn() {
		
		forumPublish.click();
	}
	
	public void myForumNavigation() {
		
		myForums.click();
	}
	
	public void searchForum(String name) {
		
		searchBox.sendKeys(name);
	}
	
	public void editForum() {
		
		editForumIcon.click();
	}
	
	public void updateForumName() {
		
		forumTitle.clear();
		
	}
	
	public void updateForumDescription() {
		
		forumDescription.clear();
	}
	
	
}
