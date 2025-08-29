package utilityTr;

import java.awt.Desktop;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportTR implements ITestListener {

	public ExtentSparkReporter sparkReporter;
	public ExtentReports extent;
	public ExtentTest test;
	String rep;
	

	 public void onStart(ITestContext context) {
		 
		 String timeStemp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		 
		 rep = "Tourwit-Report-" + timeStemp + ".html";
		 
		 
		 sparkReporter = new ExtentSparkReporter(".//reports//" + rep);
		 sparkReporter.config().setDocumentTitle("Tourwit");
		 sparkReporter.config().setReportName("Tourwit modules testing");
		 sparkReporter.config().setTheme(Theme.DARK);
		 
		 
		 extent =new ExtentReports();
		 extent.attachReporter(sparkReporter);
		 
		 
		 extent.setSystemInfo("Application", "Toruwit");
		 extent.setSystemInfo("Module Name", "M3 Milestones");
		 extent.setSystemInfo("Sub Module", "User");
		 extent.setSystemInfo("User Name",System.getProperty("user.name"));
		 extent.setSystemInfo("Environment", "QA");
		 
		 String Os = context.getCurrentXmlTest().getParameter("os");
		 extent.setSystemInfo("Operating System",Os);
		 
		 String br = context.getCurrentXmlTest().getParameter("browser");
		 extent.setSystemInfo("Browser",br);
		 
		 List<String> includeGroups = context.getCurrentXmlTest().getIncludedGroups();
		 
		 if(!includeGroups.isEmpty())
			 
		 {
			 extent.setSystemInfo("Group", includeGroups.toString());
		 }
		 
		  }

		
	   public void onTestSuccess(ITestResult result) {
			  
		    test=extent.createTest(result.getMethod().getMethodName());
		    test.assignCategory(result.getMethod().getGroups());
		    test.log(Status.PASS, "Test Case is Passed:"+ result.getName());
		  }

		  public void onTestFailure(ITestResult result) {
			  
			    test=extent.createTest(result.getMethod().getMethodName());
			    test.assignCategory(result.getMethod().getGroups());
			    test.log(Status.FAIL, "Test Case is Failed:"+ result.getName());
			    test.log(Status.INFO, "Test Case is Failed due to :"+ result.getThrowable().getMessage());
	
		  }

		  
		  
		  public void onTestSkipped(ITestResult result) {
			  
			    test=extent.createTest(result.getMethod().getMethodName());
			    test.assignCategory(result.getMethod().getGroups());
			    test.log(Status.SKIP, "Test Case is Skipped:"+ result.getName());	
			    
			    
			    }
		  
		  public void onFinish(ITestContext context) {
			  
			    extent.flush();
			    
			    String pathOfExtentReport = System.getProperty("user.dir")+"\\reports\\" + rep;
			    
			    File extentReport = new File(pathOfExtentReport);
			    
			    try {
			    	
			    	Desktop.getDesktop().browse(extentReport.toURI());
			    }
			    
			    catch(Exception e) {
			    	e.printStackTrace();
			    }
			  }

}
