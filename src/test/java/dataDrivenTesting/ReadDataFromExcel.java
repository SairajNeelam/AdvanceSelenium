package dataDrivenTesting;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ReadDataFromExcel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
//		
//		FileInputStream fis = new FileInputStream("./TestData/TestScriptDataAdv.xlsx"); 
//		Workbook wb = WorkbookFactory.create(fis); Sheet sh = wb.getSheet("Campaign"); 
//		Row row = sh.getRow(1); 
//		String Campname = row.getCell(2).getStringCellValue(); 
//		String size = row.getCell(3).getStringCellValue();
		
		FileInputStream fis = new FileInputStream("./testData/TestScriptData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("Campaign");
		Row rw = sh.getRow(1);
		String campName = rw.getCell(2).getStringCellValue();
		String size = rw.getCell(3).getStringCellValue();
		
//		WebDriver driver = new ChromeDriver();
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//		driver.get("https://www.instagram.com/");
//		
//		driver.findElement(By.name("username")).sendKeys(userName);
//		driver.findElement(By.name("password")).sendKeys(pwd);
		
		wb.close();

	}

}
