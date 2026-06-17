package stepDefinitions;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.en.*;
import pageObjects.CheckoutPage;
import pageObjects.LandingPage;
import utils.TestContextSetup;

public class CheckPageStepDef {

	WebDriver driver;
	public String landingPage;
	public String OfferPage;
	public CheckoutPage checkoutPage;
	TestContextSetup testContextSetup;

	public CheckPageStepDef(TestContextSetup testContextSetup) {
		this.testContextSetup = testContextSetup;
		this.checkoutPage = testContextSetup.pageObjectManager.getCheckoutPage();
	}

	@Then("verify user has ability to enter promo code and plce the order")
	public void verify_user_has_ability_to_enter_promo_code_and_plce_the_order() throws InterruptedException {
		Thread.sleep(5000);
		Assert.assertTrue(checkoutPage.verifyPromoButton());
		Assert.assertTrue(checkoutPage.verifyPlaceOrder());
	}

	@Then("^user proceed to checkbox and validate the (.+) items in checkout page$")
	public void user_proceed_to_checkbox_and_validate_the_tom_items_in_checkout_page(String name) throws InterruptedException {
		Thread.sleep(5000);
		checkoutPage.CheckoutItems();
	}

}
