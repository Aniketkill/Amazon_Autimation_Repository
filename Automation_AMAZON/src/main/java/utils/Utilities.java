package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Utilities {
	
	
	public static String dataInput(String fileName, String sheetName, int rowNo, int cellNo)
			throws EncryptedDocumentException, IOException {

		String commonPath = "C:\\Users\\kadam\\OneDrive\\Desktop\\Test Cases\\" + fileName + ".xlsx";
		FileInputStream file = new FileInputStream(commonPath);

		Workbook book = WorkbookFactory.create(file);
 
		try {
			String data = book.getSheet(sheetName).getRow(rowNo).getCell(cellNo).getStringCellValue();
			System.out.println("try");
			return data;
		}

		catch (IllegalStateException e) {
			double numericCellValue = book.getSheet(sheetName).getRow(rowNo).getCell(cellNo).getNumericCellValue();
			String data = numericCellValue + "";
			System.out.println("catch");
			return data;
		}

	}
	
	
	public static void captureScreenshot (WebDriver driver, String s) throws IOException
	{
		Date dt = new Date();
		String date = new SimpleDateFormat("dd-MMM-YYYY_HH mm ss SS").format(dt);
		
		File src =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File dest = new File ("test-output/FailedTestCases"+ s + date +".jpg");
		FileHandler.copy(src, dest);
	}
	
	



	
	
	
	
	
	
	
}
