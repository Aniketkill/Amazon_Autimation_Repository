package browserSetup;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base {

	public static WebDriver openChromeBrowser() {
		System.setProperty("webdriver.chrome.driver",
				"src\\test\\resources\\browserDrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		return driver;
	}

	public static WebDriver openFirefoxBrowser() {
		System.setProperty("webdriver.gecko.driver",
				"src/test/resources/browserDrivers/geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		return driver;
	}

	public static WebDriver openEdgeBrowser() {
		System.setProperty("webdriver.edge.driver",
				"src/test/resources/browserDrivers/msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		return driver;
	}
	
	
	public static String dataInput(String fileName, String sheetName, int rowNo, int cellNo)
			throws EncryptedDocumentException, IOException {

		String commonPath = "C:\\Users\\kadam\\OneDrive\\Desktop\\Test Cases\\" + fileName + ".xlsx";
		FileInputStream file = new FileInputStream(commonPath);

		Workbook book = WorkbookFactory.create(file);

		Sheet sheet = book.getSheet(sheetName);
		try {
			String data = sheet.getRow(rowNo).getCell(cellNo).getStringCellValue();
			System.out.println("try");
			return data;
		}

		catch (IllegalStateException e) {
			double numericCellValue = sheet.getRow(rowNo).getCell(cellNo).getNumericCellValue();
			String data = numericCellValue + "";
			System.out.println("catch");
			return data;
		}

	}
}
