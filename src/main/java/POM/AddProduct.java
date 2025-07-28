package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddProduct {
	
	WebDriver driver;
	
	public AddProduct(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(name = "productId")
	private WebElement productId;
	
	@FindBy(name = "productName")
	private WebElement productName;
	
	@FindBy(name = "productCategory")
	private WebElement productCategory;
	
	@FindBy(name = "quantity")
	private WebElement quantity;
	
	@FindBy(name = "price")
	private WebElement pricePerUnit;
	
	@FindBy(name = "vendorId")
	private WebElement vendorId;
	
	@FindBy(xpath = "//button[text()='Add']")
	private WebElement addProductBtn;
	
	
	
	

	public WebElement getProductId() {
		return productId;
	}

	public WebElement getProductName() {
		return productName;
	}

	public WebElement getProductCategory() {
		return productCategory;
	}

	public WebElement getQuantity() {
		return quantity;
	}

	public WebElement getPricePerUnit() {
		return pricePerUnit;
	}

	public WebElement getVendorId() {
		return vendorId;
	}

	public WebElement getAddProductBtn() {
		return addProductBtn;
	}
	
	

}
