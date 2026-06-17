package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {
	public WebDriver driver;

	public CheckoutPage(WebDriver driver) {
		this.driver = driver;
	}

	By cartBag = By.cssSelector("img[alt='Cart']");
	By checkOutButton = By.xpath("//button[text()='PROCEED TO CHECKOUT']");
	By promoButton = By.cssSelector(".promoBtn");
	By placeOrder = By.xpath("//button[text()='Place Order']");

	public void CheckoutItems() {
		driver.findElement(cartBag).click();
		driver.findElement(checkOutButton).click();
	}

	public boolean verifyPromoButton() {
		return driver.findElement(promoButton).isDisplayed();

	}

	public boolean verifyPlaceOrder() {
		return driver.findElement(placeOrder).isDisplayed();
	}
}
