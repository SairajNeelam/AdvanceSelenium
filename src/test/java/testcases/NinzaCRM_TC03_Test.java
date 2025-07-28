package testcases;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import POM.CampaignPage;
import POM.HomePage;
import POM.LoginPage;
import baseclass.BaseClass;
import excelFileUtility.GetDataFromExcelFile;
import javaUtility.JavaUtility;
import propertiesFileUtility.GetDataFromPropertiesFile;
import webDriverUtility.WebDriverUtility;
@Listeners(listenersUtility.ListenersImplementation.class)

public class NinzaCRM_TC03_Test extends BaseClass{

	@Test(groups="Smoke")
	public void createStatus() throws EncryptedDocumentException, IOException {
		
		GetDataFromPropertiesFile pUtil = new GetDataFromPropertiesFile();
		GetDataFromExcelFile eUtil = new GetDataFromExcelFile();
		WebDriverUtility wUtil = new WebDriverUtility();
		JavaUtility jUtil = new JavaUtility(); 
		
		String CAMPAIGN_NAME = eUtil.getDataFromExcel("Campaign", 1, 2);
		String SIZE = eUtil.getDataFromExcel("Campaign", 1, 3);
		String STATUS = eUtil.getDataFromExcel("Campaign", 1, 4);
		
		HomePage hp = new HomePage(driver);
		CampaignPage cp = new CampaignPage(driver);
		
		// Create Campaign
		hp.getCreateCampaign().click();
		
		cp.getCampaignName().sendKeys(CAMPAIGN_NAME);
		cp.getCampaignStatus().sendKeys(STATUS);
		cp.getTargetSize().sendKeys(SIZE);
		cp.getCreateCampaign().click();
		
		
		// Verify if campaign is created
		WebElement toast = hp.getToastMsg();
		wUtil.waitForVisibilityOfElement(driver, toast);
		String msg = toast.getText();
		
		if(msg.contains(CAMPAIGN_NAME)) {
			System.out.println("Campaign is created!");
		}
		else {
			System.out.println("Campaign is not created!");
		}
		
		hp.getCloseMsg().click();

	}

}
