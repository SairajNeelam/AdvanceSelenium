package dataDrivenTesting;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.bidi.network.BytesValue.Type;

public class WriteDataInExcel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream("C:\\Users\\HP\\Desktop\\SMD\\Selenium\\Advance Selenium\\excelProp.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("Sheet1");
		Row rw = sh.getRow(7);
		Cell c = rw.createCell(4);
//		c.setCellType(Type.STRING);
		c.setCellValue("writing in excel");
		
		FileOutputStream fos = new FileOutputStream("C:\\Users\\HP\\Desktop\\SMD\\Selenium\\Advance Selenium\\excelProp.xlsx");
		wb.write(fos);
		fis.close();

	}

}
