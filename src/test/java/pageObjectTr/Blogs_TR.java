package pageObjectTr;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Blogs_TR {

	public WebDriver driver;
	
	public Blogs_TR(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
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
 
	public void blogNavigation() {
		
		blogsLink.click();
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
	
	
}

