package testcases;

import java.io.IOException;
import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import POM.AddProduct;
import POM.HomePage;
import POM.LoginPage;
import baseclass.BaseClass;
import excelFileUtility.GetDataFromExcelFile;
import javaUtility.JavaUtility;
import propertiesFileUtility.GetDataFromPropertiesFile;
import webDriverUtility.WebDriverUtility;
@Listeners(listenersUtility.ListenersImplementation.class)

public class NinzaCRM_TC05_Test extends BaseClass{

	@Test
	public void createProduct() throws IOException, InterruptedException {
		
		GetDataFromPropertiesFile pUtil = new GetDataFromPropertiesFile();
		GetDataFromExcelFile eUtil = new GetDataFromExcelFile();
		WebDriverUtility wUtil = new WebDriverUtility();
		JavaUtility jUtil = new JavaUtility();
		
		
		String PRODUCT_NAME = eUtil.getDataFromExcel("Product", 1, 2);
		String QUANTITY = eUtil.getDataFromExcel("Product", 1, 3);
		String PRICE_PER_UNIT = eUtil.getDataFromExcel("Product", 1, 4);
		
		
		HomePage hp = new HomePage(driver);
		AddProduct ap = new AddProduct(driver);
		
		// Create Product
		hp.getProduct().click();
		hp.getAddProduct().click();
		ap.getProductName().sendKeys(PRODUCT_NAME);
		ap.getQuantity().sendKeys(QUANTITY);
//		ap.getPricePerUnit().sendKeys(PRICE_PER_UNIT);
		
		
		WebElement productCat = ap.getProductCategory();
		WebElement vend = ap.getVendorId();
		
		
		wUtil.select(productCat, "Electricals");
		Thread.sleep(2000);
		wUtil.select(vend, 10);
		

		Thread.sleep(2000);
		ap.getPricePerUnit().clear();
		ap.getPricePerUnit().sendKeys(PRICE_PER_UNIT);
		
		ap.getAddProductBtn().click();
		
		// Verify if Product is created
		WebElement toast = hp.getToastMsg();
		wUtil.waitForVisibilityOfElement(driver, toast);
		String msg = toast.getText();
		
		if(msg.contains(PRODUCT_NAME)) {
			System.out.println("Product is created!");
		}
		else {
			System.out.println("Product is not created!");
		}
		
		hp.getCloseMsg().click();

	}

}
