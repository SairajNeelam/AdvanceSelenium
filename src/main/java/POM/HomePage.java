package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText = "Campaigns")
	private WebElement campaign;
	
	@FindBy(linkText = "Contacts")
	private WebElement contact;
	
	@FindBy(linkText = "Products")
	private WebElement product;
	
	@FindBy(xpath = "//span[text()='Create Campaign']")
	private WebElement createCampaign;
	
	@FindBy(xpath = "//span[text()='Add Product']")
	private WebElement addProduct;

	@FindBy(className = "user-icon")
	private WebElement userIcon;
	
	@FindBy(xpath = "//div[text()='Logout ']")
	private WebElement logoutBtn;
	
	@FindBy(xpath = "//div[@role='alert']")
	private WebElement toastMsg;
	
	@FindBy(xpath = "//button[@aria-label='close']")
	private WebElement closeMsg;
	
	

	public WebElement getCampaign() {
		return campaign;
	}

	public WebElement getContact() {
		return contact;
	}

	public WebElement getProduct() {
		return product;
	}

	public WebElement getCreateCampaign() {
		return createCampaign;
	}
	
	public WebElement getAddProduct() {
		return addProduct;
	}

	public WebElement getUserIcon() {
		return userIcon;
	}

	public WebElement getLogoutBtn() {
		return logoutBtn;
	}

	public WebElement getToastMsg() {
		return toastMsg;
	}

	public WebElement getCloseMsg() {
		return closeMsg;
	}
	
	

}
