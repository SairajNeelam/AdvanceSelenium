package dataDrivenTesting;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ReadDataFromJson {

	public static void main(String[] args) throws FileNotFoundException, IOException, ParseException {
		// parse Json file in java object
		JSONParser parser = new JSONParser();
		Object obj = parser.parse(new FileReader("./configData/commonData.json"));
		
		// convert java object to json object
		JSONObject jsonObj = (JSONObject)obj;
		
		// read data using get()
		System.out.println(jsonObj.get("Browser"));
		System.out.println(jsonObj.get("Url"));
		System.out.println(jsonObj.get("Username"));
		System.out.println(jsonObj.get("Password"));
		
		String browser = jsonObj.get("Browser").toString();
 		String url = jsonObj.get("Url").toString();
		String userName = jsonObj.get("Username").toString();
		String pwd = jsonObj.get("Password").toString();
		
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(url);
		
		driver.findElement(By.id("username")).sendKeys(userName);
		driver.findElement(By.id("inputPassword")).sendKeys(pwd);
		driver.findElement(By.xpath("//button[text()='Sign In']")).click();

	}

}
