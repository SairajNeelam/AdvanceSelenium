package baseclass;

import java.io.IOException;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import POM.HomePage;
import POM.LoginPage;
import propertiesFileUtility.GetDataFromPropertiesFile;

public class BaseClass {
	public WebDriver driver = null;
	public static WebDriver sDriver = null;
	public GetDataFromPropertiesFile pUtil = new GetDataFromPropertiesFile();
	
	@BeforeSuite(groups= {"Smoke", "Regression"})
	public void beforeSuite() {
		Reporter.log("DB Connectivity Open", true);
	}
	
	@BeforeTest(groups= {"Smoke", "Regression"})
	public void beforeTest() {
		Reporter.log("Preconditions", true);
	}
	
//	@Parameters("BROWSER")
	@BeforeClass(groups= {"Smoke", "Regression"})
	public void beforeClass() throws IOException {
		String BROWSER = pUtil.getDataFromPropertiesFile("Browser");
		if (BROWSER.equalsIgnoreCase("Edge")) {
			driver = new EdgeDriver();
			driver.manage().window().maximize();
		}
		else if (BROWSER.equalsIgnoreCase("Chrome")) {
			driver = new ChromeDriver();
			driver.manage().window().maximize();
		}
		else if (BROWSER.equalsIgnoreCase("Chrome")) {
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
		}
		sDriver = driver;
		System.out.println("Launching Browser");
	}
	
	@BeforeMethod(groups= {"Smoke", "Regression"})
	public void beforeMethod() throws IOException {
		String BROWSER = pUtil.getDataFromPropertiesFile("Browser");
		String URL = pUtil.getDataFromPropertiesFile("Url");
		String USERNAME = pUtil.getDataFromPropertiesFile("Username");
		String PASSWORD = pUtil.getDataFromPropertiesFile("Password");
		
		driver.get(URL);
		
		LoginPage lp = new LoginPage(driver);
		lp.getUN().sendKeys(USERNAME);
		lp.getPW().sendKeys(PASSWORD);
		lp.getLoginBtn().click();
		
		System.out.println("Login Done");
	}
	
	@AfterMethod(groups= {"Smoke", "Regression"})
	public void afterMethod() {
		HomePage hp = new HomePage(driver);
		hp.getUserIcon().click();
		hp.getLogoutBtn().click();
		
		System.out.println("Logout Done");
	}
	
	@AfterClass(groups= {"Smoke", "Regression"})
	public void afterClass() {
		driver.quit();
		
		System.out.println("Closing Browser");
	}
	
	@AfterTest(groups= {"Smoke", "Regression"})
	public void afterTest() {
		System.out.println("Post conditions");
	}
	
	@AfterSuite(groups= {"Smoke", "Regression"})
	public void afterSuite() {
		System.out.println("Close DB Connectivity");
	}
	
}
