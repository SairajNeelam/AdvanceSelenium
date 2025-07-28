package dataDrivenTesting;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class PropertiesFile {

	public static void main(String[] args) throws IOException {
		
		FileInputStream fis = new FileInputStream("C:\\Users\\HP\\Desktop\\SMD\\Selenium\\Advance Selenium\\propertiesData.properties");
		
		// create object of Properties
		Properties prop = new Properties();
		
		// load all the keys
		prop.load(fis);
		
		// get the properties
		String browser = prop.getProperty("Browser");
		String url = prop.getProperty("Url");
		String userName = prop.getProperty("Username");
		String pwd = prop.getProperty("Password");
		
		WebDriver driver = null;
		
		if(browser.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}
		else if(browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}
		
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.get(url);
		driver.findElement(By.id("username")).sendKeys(userName);
		driver.findElement(By.id("inputPassword")).sendKeys(pwd);
		driver.findElement(By.xpath("//button[text()='Sign In']")).click();
		

	}

}
