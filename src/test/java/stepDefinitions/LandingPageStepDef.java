package stepDefinitions;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import io.cucumber.java.en.*;
import pageObjects.LandingPage;
import utils.TestContextSetup;

public class LandingPageStepDef {

	WebDriver driver;
	// public String landingPage;
	public String OfferPage;
	TestContextSetup testContextSetup;
	LandingPage landingPage;

	public LandingPageStepDef(TestContextSetup testContextSetup) {
		this.testContextSetup = testContextSetup;
		this.landingPage = testContextSetup.pageObjectManager.getLandingPage();
	}

	@Given("User is on Greencart landing page")
	public void user_is_on_greencart_landing_page() throws IOException {
		testContextSetup.testBase.WebDriverManager();
	}

	@When("^user searched  with Shortname (.+) and extcated actual name of product$")
	public void user_searched_with_shortname_and_extcated_actual_name_of_product(String veggie)
			throws InterruptedException {
		landingPage.EnterSearchItem(veggie);
		Thread.sleep(5000);
		testContextSetup.landingPage = landingPage.getProductName().split("-")[0].trim();
		System.out.println("Vegitable Name on the Landing is: " + landingPage);

	}

	@When("Added {string} items of the selected product to cart")
	public void added_items_of_the_selected_product_to_cart(String quantity) throws InterruptedException {
		Thread.sleep(3000);
		landingPage.incrementQuantity(Integer.parseInt(quantity));
		landingPage.clickOnAddToCart();
	}

}
