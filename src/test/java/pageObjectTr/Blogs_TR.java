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

public class Blogs_TR {

	public WebDriver driver;
	WebDriverWait wait;
	
	public Blogs_TR(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
		 wait = new WebDriverWait(driver,Duration.ofSeconds(20));
		
	}
	
	@FindBy(xpath="//a[normalize-space()='Blogs']")
	WebElement blogsLink;
	
	@FindBy(xpath="//button[normalize-space()='Create new blog']")
	WebElement btnCreateBlog;
	
	@FindBy(xpath="//input[@id='readTime']")
	WebElement readTime;
	
	@FindBy(xpath="//input[@id='name']")
	WebElement txtTitle;
	
	@FindBy(xpath=" //div[@class='custom-ql-editor']")
	WebElement txtDescription;
	
	@FindBy(xpath="//button[normalize-space()='Publish']")
	WebElement btnPublish;
	
	@FindBy(xpath="//p[text()='My Blogs']")
	WebElement myBlogLink;
	
	@FindBy(xpath="//input[@placeholder='Search by keywords...']")
	WebElement searchBlog;
	
	@FindBy(xpath="//span[contains(@class,'flex h-8 w-8')][contains(@class,'bg-primary')]")
	WebElement editBlogIcon;
	
	@FindBy(xpath="//span[contains(@class,'bg-red-700') and contains(@class,'rounded-full')]")
	WebElement deleteBlogIcon;
	
	@FindBy(xpath="//button[normalize-space()='Confirm']")
	WebElement deleteConfirm;
 
	@FindBy(xpath=" //textarea[@placeholder='What are your thoughts?']")
	WebElement txtCommentField;
	
	public void blogNavigation(WebDriver driver) {
		
		    WebElement blogElement = wait.until(ExpectedConditions.elementToBeClickable(blogsLink));
		    blogElement.click();
	}
	
	public void createBlog() {
		
		btnCreateBlog.click();
	}
	
	public void blogReadTime(String time) {
		
		readTime.sendKeys(time);
	}
	
	public void blogTitleAdd(String title) {
		
		txtTitle.sendKeys(title);
	}
	
	public void clearTitle() {
		
		txtTitle.clear();
	}
	
	public void blogDescription(String description) {
		
		txtDescription.sendKeys(description);
	}
	
	public void publishBlog() {
		
		btnPublish.click();
	}
	
	public void searchBlogs(String blogName) {
		
		searchBlog.sendKeys(blogName);
	}
	
	public void myBlogs() {

		myBlogLink.click();
	}
	
	public void editBlogScreen() {
		
		editBlogIcon.click();
	}
	
	public void deleteBlog() {
		
		deleteBlogIcon.click();
		
	}
	
	public void deleteConfirmBlog() {
		
		deleteConfirm.click();
	}
	
	public void txtComment(WebDriver driver,String comment) {
		
	WebElement txtCommentField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//textarea[@placeholder='What are your thoughts?']")));
		
	txtCommentField.sendKeys(comment);
		
	}
	
     public void searchandClickedBlog(WebDriver driver,String blogTitle) {
		
		
		WebElement searchBlog = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='Search by keywords...']")));
		
		searchBlog.sendKeys(blogTitle);
		
		WebElement searchedBlogClick = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(normalize-space(.),'" + blogTitle + "')]")));
		
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", searchedBlogClick);
		
		searchedBlogClick.click();
		
	}
     
     public void emojiSelect(WebDriver driver) throws InterruptedException {
    	 
     	 
    	  WebElement smileIcon = wait.until(ExpectedConditions.elementToBeClickable(
    		        By.xpath("//*[name()='svg' and contains(@class,'lucide-smile')]")));
    	  
    	  ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", smileIcon);
    	  smileIcon.click();
    	  
    	  WebElement blush = driver.findElement(By.xpath(" //input[@placeholder='Search']"));
    	  blush.sendKeys("Blush");
    	  
    	  WebElement smileEmoji = wait.until(ExpectedConditions.elementToBeClickable(
    		        By.xpath("//img[@alt='blush']")));
    	  
  		  ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", smileEmoji);
    	  smileEmoji.click();
	 
    	  WebElement sendButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@role='button']/*[name()='svg']")));
     	 ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", sendButton);
    	   sendButton.click();
       	 
       	 Thread.sleep(3000);
       	 
     }
     
     public void sendComment() {
    	 
    
   	  WebElement sendButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@role='button']/*[name()='svg']")));
  	 ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", sendButton);
 	   sendButton.click();
    	 
     }
	

	
}

