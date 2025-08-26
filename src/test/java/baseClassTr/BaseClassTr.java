package baseClassTr;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Parameters;

public class BaseClassTr {

	public WebDriver driver;
	public Properties p;
	public Logger logger = LogManager.getLogger(this.getClass()); 
	 
	public String randomString() {
	
		String generatedString = RandomStringUtils.randomAlphabetic(5);
		return generatedString;
		
	}
	
	public String randomNumber() {
		
		String generatedNumeric = RandomStringUtils.randomNumeric(10);
		return generatedNumeric;
	}
	
	public String alphaNumeric() {
		
		String alaphaNumber = RandomStringUtils.randomAlphanumeric(8);
		return alaphaNumber;
	}
	
	@BeforeClass
	@Parameters({"browser"})
	public void signUp(String br)throws IOException {
		
		logger = LogManager.getLogger(this.getClass());
	    logger.info(">>> @BeforeClass executed, initializing driver with browser: " + br);
		FileReader file = new FileReader("./src//test//resources//config.properties");
		
		p=new Properties();
		p.load(file);
		
		  if (br.equalsIgnoreCase("chrome")) {
	            driver = new ChromeDriver();
	        } else if (br.equalsIgnoreCase("firefox")) {
	            driver = new FirefoxDriver();
	        } else {
	            throw new IllegalArgumentException("Invalid Browser: " + br);
	        }
		
		System.out.println(">>> Driver initialized: " + driver);
		driver.get(p.getProperty("appUrlSignUp_tr"));
		driver.manage().window().maximize();;
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		
	}
	
	// @AfterClass
	    public void tearDown() {
	        if (driver != null) {
	            driver.quit();
	        }
	    }


	
}
