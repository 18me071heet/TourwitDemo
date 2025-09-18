package pageObjectTr;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Forums_TR {

	public WebDriver driver;
	WebDriverWait wait;
	
	public Forums_TR(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver,Duration.ofSeconds(20));
		
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
	
	@FindBy(xpath="//button[normalize-space()='All Posts']")
	WebElement allPostForum;
	
	@FindBy(xpath=" //textarea[@placeholder='What are your thoughts?']")
	WebElement txtComment;
	
	public void forumNavigation() {
		
		forumLink.click();
	}
	
	public void allForum() {
		
		WebElement allPostForum = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='All Posts']")));	
		allPostForum.click();
		
	}
	public void createForumClick() {
		
		createForum.click();
	}
	
	public void createTitle(String title) {
		
	forumTitle.sendKeys(title);
		
	}
	
	public void updateTitle() {
		
		forumTitle.sendKeys(Keys.CONTROL+"a");
		forumTitle.sendKeys(Keys.DELETE);
		
	}
	
	public void forumDescriptionAdd(String description) {
		
		forumDescription.clear();
		forumDescription.sendKeys(description);
	}
	
	public void forumPublishBtn() {
		
		WebElement forumPublish = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Publish']")));
		forumPublish.click();
	}
	
	public void myForumNavigation() {
		
		myForums.click();
	}
	
	public void searchForum(String name) {
		
		searchBox.sendKeys(name);
	}
	
	public void txtComment(WebDriver driver,String comment) {
		
		WebElement commentForum = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//textarea[@placeholder='What are your thoughts?']")));
		
		commentForum.sendKeys(comment);
	}
	
	public void searchedNdClick(WebDriver driver,String forumTitle) {
		
		WebElement searchForum = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(" //input[@placeholder='Search by keywords...']")));
		
		searchForum.sendKeys(forumTitle);
		
		WebElement searchedForum = wait.until( ExpectedConditions.elementToBeClickable(By.xpath("//td[contains(normalize-space(.),'" + forumTitle + "')]")));

		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", searchedForum);
		
		searchedForum.click();
			
	}
	
	public void addEmoji(WebDriver driver) {
		
		WebElement emojiClick = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[name()='svg' and contains(@class,'lucide-smile')]")));
		
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);",emojiClick);
		
		emojiClick.click();
		
		WebElement searchEmoji = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(" //input[@placeholder='Search']")));
		
		searchEmoji.sendKeys("Blush");
		
		WebElement blushEmoji = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//img[@alt='blush']")));
		
		blushEmoji.click();
		
		  WebElement sendButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@role='button']/*[name()='svg']")));
		  	 ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", sendButton);
		 	   sendButton.click();
		       	 
	}
	
	public void sendComment() {
   	 
	    
	   	  WebElement sendButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@role='button']/*[name()='svg']")));
	  	 ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", sendButton);
	 	   sendButton.click();
	    	 
	     }
		
	public void editIcon() {
		
		WebElement editIcon = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//svg[@width='24' and @height='24' and @viewBox='0 0 24 24'])[1]")));
		
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", editIcon);
		editIcon.click();
		
		List<WebElement> icons = driver.findElements(By.xpath("//svg[@width='24' and @height='24']"));
		System.out.println("Found icons: " + icons.size());
		
	}
	
	public void searchAndEdit(WebDriver driver,String forumTitle) {
		
       WebElement searchForum = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(" //input[@placeholder='Search by keywords...']")));
		
		searchForum.sendKeys(forumTitle);
		searchForum.sendKeys(Keys.ENTER);
				
		   WebElement editButton = wait.until(ExpectedConditions.elementToBeClickable(
			        By.xpath("//h3[normalize-space()='" + forumTitle + "']/following::button[contains(@class,'min-w-5')][1]")
			    ));
		   
		 	    editButton.click();
	}
	
	public void searchAndDelete(WebDriver driver,String forumTitle) {
		
		 WebElement searchForum = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(" //input[@placeholder='Search by keywords...']")));
			
			searchForum.sendKeys(forumTitle);
			searchForum.sendKeys(Keys.ENTER);
			
			WebElement deleteButton = wait.until(ExpectedConditions.elementToBeClickable(
				    By.xpath("//h3[normalize-space()='" + forumTitle + "']/following::button[contains(@class,'min-w-5')][2]")
				));
			
			 deleteButton.click();
			 	    
			 WebElement confirmDelete = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Confirm Removal']")));  
			 confirmDelete.click();
			
	}
	
	public void userProfile() throws InterruptedException {
			
		WebElement profile = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(" //div[contains(@class,'rounded-full') and span]")));
		
		profile.click();
				
		try {
			
			WebElement followUser = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Follow']")));
			
			Thread.sleep(1000);
			
            if(followUser.isDisplayed()) {
            	
            	((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", followUser);
    			
    			followUser.click();
            }
							
		} catch(TimeoutException e) {
			
			WebElement unfollowUser = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Following']")));
			
			Thread.sleep(1000);
			
			if(unfollowUser.isDisplayed()) {
				
             ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", unfollowUser);
    			
             unfollowUser.click();
             
			}
		}
				
	}
	
	public void blockUser() throws InterruptedException {
		
	/*	WebElement editIcon = wait.until(ExpectedConditions.presenceOfElementLocated(
			    By.xpath("//div[contains(@class,'cursor-pointer') and .//svg[@width='32' and @height='32']]")
			));
		
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", editIcon);
		
		editIcon.click();
			*/
		
		Thread.sleep(1000);
		
		WebElement blockOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[normalize-space()='Block User']")));
		blockOption.click();
		
		WebElement confirmBlock = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(" //button[normalize-space()='Confirm']")));
		confirmBlock.click();
		
	}
	
	public void followCategory(String categoryName) throws InterruptedException {
			try {
				// Try to find the Follow button
				WebElement followBtn = wait.until(
					ExpectedConditions.elementToBeClickable(
						By.xpath("//h3[normalize-space()='" + categoryName + "']" +
								 "/ancestor::div[contains(@class,'cursor-pointer')]" +
								 "//button[contains(@class,'lg:inline-flex') and normalize-space()='Follow']")) );

				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", followBtn);
				followBtn.click();
				System.out.println("Now following category: " + categoryName);
				Thread.sleep(3000);

				// Verify button changed to 'Following'
				WebElement followingBtn = wait.until(
					ExpectedConditions.visibilityOfElementLocated(
						By.xpath("//h3[normalize-space()='" + categoryName + "']" +
								 "/ancestor::div[contains(@class,'cursor-pointer')]" +
								 "//button[contains(@class,'lg:inline-flex') and normalize-space()='Following']")) );
				System.out.println("Button changed to: " + followingBtn.getText());

				// Now click 'Following' to unfollow
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", followingBtn);
				followingBtn.click();
				System.out.println("Unfollowed category: " + categoryName);
				Thread.sleep(2000);

				// Verify button changed back to 'Follow'
				WebElement followBtnAgain = wait.until(
					ExpectedConditions.visibilityOfElementLocated(
						By.xpath("//h3[normalize-space()='" + categoryName + "']" +
								 "/ancestor::div[contains(@class,'cursor-pointer')]" +
								 "//button[contains(@class,'lg:inline-flex') and normalize-space()='Follow']")) );
				System.out.println("Button changed back to: " + followBtnAgain.getText());

			} catch (TimeoutException e) {
				System.out.println("Category or button not found: " + categoryName);
			}
		}
	    
}



	

