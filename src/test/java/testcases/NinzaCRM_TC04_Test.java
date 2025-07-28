package testcases;

import java.time.Duration;
import java.util.Random;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NinzaCRM_TC04_Test {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.get("http://49.249.28.218:8098/");
		
		// Login
		driver.findElement(By.id("username")).sendKeys("rmgyantra");
		driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
		driver.findElement(By.xpath("//button[text()='Sign In']")).click();
		
		// creating random object to give unique names to our campaign name
		Random ran = new Random();
		int ranCount = ran.nextInt(1000);
		
		// Create Contact
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		driver.findElement(By.xpath("//span[text()='Create Contact']")).click();
		driver.findElement(By.name("organizationName")).sendKeys("AdvSelContact "+ranCount);
		driver.findElement(By.name("title")).sendKeys("AdvSelTitle "+ranCount);
		driver.findElement(By.name("contactName")).sendKeys("ABC "+ranCount);
		driver.findElement(By.name("mobile")).sendKeys(ranCount+"3452"+ranCount);
		
		String parentWindow = driver.getWindowHandle();
		driver.findElement(By.xpath("//*[name()='svg' and @data-icon='plus']")).click();
		
		Set<String> windows = driver.getWindowHandles();
		windows.remove(parentWindow);
		
		for(String child:windows) {
			driver.switchTo().window(child);
			
			WebElement selectCamp = driver.findElement(By.id("search-criteria"));
			Select camp = new Select(selectCamp);
			camp.selectByIndex(1);
			Thread.sleep(3000);
//			camp.selectByValue("Campaign Name");
			
			driver.findElement(By.id("search-input")).sendKeys("AdvSelCamp");
			driver.findElement(By.xpath("//button[text() = 'Select']")).click();
		}
		
		driver.switchTo().window(parentWindow);
		driver.findElement(By.xpath("//button[text()='Create Contact']")).click();
		
		// Verify if contact is created
		WebElement toast = driver.findElement(By.xpath("//div[@role='alert']"));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(toast));
		String msg = toast.getText();
		
		if(msg.contains("ABC")) {
			System.out.println("Contact is created!");
		}
		else {
			System.out.println("Contact is not created!");
		}
		
		// logout 
		driver.findElement(By.xpath("//button[@aria-label='close']")).click();
		
		Actions act = new Actions(driver);
		WebElement icon = driver.findElement(By.xpath("//div[@class='user-icon']"));
		act.moveToElement(icon).perform();
		
		WebElement logoutBtn = driver.findElement(By.xpath("//div[text()='Logout ']"));
		act.click(logoutBtn).perform();

	}

}
