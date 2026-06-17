package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPage {
	public WebDriver driver;

	public LandingPage(WebDriver driver) {
		this.driver = driver;
	}

	By search = By.xpath("//input[@type='search']");
	By productName = By.xpath("//h4[@class='product-name']");
	By topDeals = By.xpath("//a[text()='Top Deals']");
	By increment = By.xpath("//a[normalize-space()='+']");
	By addtoCart = By.xpath("//button[text()='ADD TO CART']");

	public void EnterSearchItem(String veggie) {
		driver.findElement(search).sendKeys(veggie);
	}

	public String getProductName() {
		return driver.findElement(productName).getText();
	}

	public void SelectTopDealsPage() {
		driver.findElement(topDeals).click();
	}

	public void incrementQuantity(int quantity) {
		int i = quantity;
		while (i > 0) {
			driver.findElement(increment).click();
			i--;
		}
	}

	public void clickOnAddToCart() {
		driver.findElement(addtoCart).click();
	}
}
