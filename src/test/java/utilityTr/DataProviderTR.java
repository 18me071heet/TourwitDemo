package utilityTr;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;

public class DataProviderTR {

	WebDriver driver;
	
	@DataProvider(name="DP")
	public String[][] data() throws IOException{
		
		String path ="./testDataTr/LogInTr.xlsx";
		
		ExcelUtilityTR utility = new ExcelUtilityTR(path);
		
		int rowCount = utility.getrowCount("Sheet1");
		
		int cellCount = utility.getcellCount("Sheet1", 1);
		
		String logIn[][]= new String[rowCount][cellCount];
		
		for(int r=1;r<=rowCount;r++) {
			
			for(int c=0;c<cellCount;c++) {
				
				logIn[r-1][c]=utility.getcellData("Sheet1", r, c);
			}
		}
		
		return logIn;
		
	}
}
