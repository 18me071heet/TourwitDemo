package utilityTr;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtilityTR {

	public static FileInputStream fi;
	public static FileOutputStream fo;
    public static XSSFWorkbook wb;
    public static XSSFSheet ws;
    public static XSSFRow row;
    public static XSSFCell cell;
    String path;
    
    
    
    public ExcelUtilityTR(String path) {
    	
    	this.path=path;
    }
    
    public int getrowCount(String xlsheet) throws IOException {
    	
    	fi=new FileInputStream(path);
    	wb=new XSSFWorkbook(fi);
    	ws=wb.getSheet(xlsheet);
    	
    	int rowCount = ws.getLastRowNum();
    	wb.close();
    	fi.close();
		return rowCount;
    	
    }
    
    public int getcellCount(String xlsheet,int rowNum) throws IOException {
    	fi=new FileInputStream(path);
    	wb=new XSSFWorkbook(fi);
    	ws=wb.getSheet(xlsheet);
    	row=ws.getRow(rowNum);
    	
    	int cellCount = row.getLastCellNum();
    	wb.close();
    	fi.close();
		return cellCount;
    }
    
    
    
    public String getcellData(String xlsheet,int rowNum,int coloumNum) throws IOException {
    	fi=new FileInputStream(path);
    	wb=new XSSFWorkbook(fi);
    	ws=wb.getSheet(xlsheet);
    	row=ws.getRow(rowNum);
    	cell=row.getCell(coloumNum);
    	
    	String data;
    	
    	try {
    		
    		
    		DataFormatter formatter = new DataFormatter();
    		data = formatter.formatCellValue(cell);
    	}
    	
    	catch(Exception e) {
    		
    		data="";
    	}
    	
    	wb.close();
    	fi.close();
    	return data;
    }
	
    
    public void setcellData(String xlsheet,int rowNum,int coloumNum,String data) throws IOException {
    	
    	fi=new FileInputStream(path);
    	wb=new XSSFWorkbook(fi);
    	ws=wb.getSheet(xlsheet);
    	row=ws.getRow(rowNum);
    	cell=row.createCell(coloumNum);
    	cell.setCellValue(data);
    	  	
    	fo=new FileOutputStream(path);
    	wb.write(fo);
    	wb.close();
    	fi.close();
    	fo.close();
    	
    }
}
