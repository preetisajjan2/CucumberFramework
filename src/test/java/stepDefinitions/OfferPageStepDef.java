package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import pageObjects.LandingPage;
import pageObjects.OfferPage;
import io.cucumber.java.en.*;
import utils.TestContextSetup;

public class OfferPageStepDef {
	WebDriver driver;
	public String landingPage;
	public String OfferPageProdName;
	TestContextSetup testContextSetup;

	public OfferPageStepDef(TestContextSetup testContextSetup) {
		this.testContextSetup = testContextSetup;
	}

	@Then("^user searched for (.+) same shortname in offers page to check if product exist$")
	public void user_searched_for_same_shortname_in_offers_page_to_check_if_product_exist(String veggie) throws InterruptedException {
		switchToChild();
		Thread.sleep(5000);
		OfferPage offerPage = new OfferPage(testContextSetup.driver);
		offerPage.EnterSearchItem(veggie);
		OfferPageProdName = offerPage.getProductName();
		System.out.println("Vegitable Name on the Landing is: " + OfferPageProdName);

	}

	public void switchToChild() {
		LandingPage landingPage = testContextSetup.pageObjectManager.landingPage;
		landingPage.SelectTopDealsPage();
		testContextSetup.genericUtils.switchWindoToChild();
	}

	@Then("validate both the name matches")
	public void validate_both_the_name_matches() {
		Assert.assertEquals(testContextSetup.landingPage, OfferPageProdName);
	}

}
