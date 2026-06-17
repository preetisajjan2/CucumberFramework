package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class OfferPage {

	public WebDriver driver;

	public OfferPage(WebDriver driver) {
		this.driver = driver;
	}

	By search = By.xpath("//input[@id='search-field']");
	By prodNameinOP = By.xpath("//tbody/tr/td[1]");

	public void EnterSearchItem(String veggie) {
		driver.findElement(search).sendKeys(veggie);
	}

	public String getProductName() {
		return driver.findElement(prodNameinOP).getText();
	}

}
