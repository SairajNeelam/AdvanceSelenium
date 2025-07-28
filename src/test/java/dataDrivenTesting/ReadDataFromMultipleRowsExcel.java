package dataDrivenTesting;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromMultipleRowsExcel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream("C:\\Users\\HP\\Desktop\\SMD\\Selenium\\Advance Selenium\\multipleData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("Sheet1");
		int lastRowCount = sh.getLastRowNum();
		
		System.out.println("Product Category  ----  ProductName ");
		
		for(int row = 1; row<=lastRowCount; row++) {
			String productCategory = sh.getRow(row).getCell(0).getStringCellValue();
			String productName = sh.getRow(row).getCell(1).getStringCellValue();
			
			System.out.println("    "+productCategory+"                "+productName);
		}
		
		fis.close();

	}

}
