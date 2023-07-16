package Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class Utility {
	
	
	public static void captureScreenshot(WebDriver driver,String TESTID) throws IOException, InterruptedException {
	
	TakesScreenshot ts=(TakesScreenshot)driver;
	File src=ts.getScreenshotAs(OutputType.FILE);
	
	Date d=new Date();
	SimpleDateFormat sdf=new SimpleDateFormat(" dd-MM-YYYY HH-mm-sss");
	
	String timestamp=sdf.format(d);
	File tar=new File("C:\\Users\\sanja\\eclipse-workspace\\Maven-IteraAppProj1\\test-output\\FailTestScreenshots\\"+TESTID+" "+ timestamp +".png");
	
//	FileUtils.copyFile(src, tar);
	FileHandler.copy(src, tar);
	Thread.sleep(800);
	
	} 
		
	public static String getExcelData(String sheetName,int rowNo,int cellNo) throws IOException  {
			
 String path="C:\\Users\\sanja\\eclipse-workspace\\Maven-IteraAppProj1\\src\\main\\resources\\Data\\FinalExcelTestData.xlsx";

	FileInputStream file= new FileInputStream(path);
 
    Workbook book=WorkbookFactory.create(file);
   Sheet sheet=book.getSheet(sheetName);
   Row row=sheet.getRow(rowNo);
  Cell cell=row.getCell(cellNo);
   String ExcelData;
    	
	try {
	      ExcelData =cell.getStringCellValue();
        }

	catch(IllegalStateException e) {
		 double value=cell.getNumericCellValue();
		 ExcelData=String.valueOf(value);
	   //ExcelData=Double.toString(value);
	}
	return ExcelData;	
	
	
	}	
	
}


//try {
////	String data =book.getSheet("Maindata").getRow(1).getCell(0).getStringCellValue();
//	String data =book.getSheet(sheet).getRow(row).getCell(cell).getStringCellValue();
//		
//	System.out.println(data);
//	file.close();
//	}
//
//
//	catch(IllegalStateException e) {
//	
////	   double value=book.getSheet("Maindata").getRow(1).getCell(1).getNumericCellValue();
//		 double value=book.getSheet(sheet).getRow(row).getCell(cell).getNumericCellValue();
//	   String data=Double.toString(value);
//	   System.out.println(data);
//	}
//	return path;	
//	

//
//public static String getExcelData(String sheet,int row,int cell) throws EncryptedDocumentException, IOException  {
//	
//String path="C:\\Users\\sanja\\eclipse-workspace\\Maven-IteraAppProj1\\src\\main\\resources\\Data\\FinalExcelTestData.xlsx";
//	
//FileInputStream file= new FileInputStream(path);
////XSSFWorkbook book=new XSSFWorkbook(file);
//
//Workbook book=WorkbookFactory.create(file);
//
//	
//try {
//
//String data =book.getSheet(sheet).getRow(row).getCell(cell).getStringCellValue();
//	
//System.out.println(data);
//
//}
//
//
//catch(IllegalStateException e) {
//
//
//	 double value=book.getSheet(sheet).getRow(row).getCell(cell).getNumericCellValue();
//   String data=Double.toString(value);
//   System.out.println(data);
//}
//return path;	
//
//
//}	
//
//}


















