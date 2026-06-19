package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase {

	public WebDriver driver;

	public WebDriver WebDriverManager() throws IOException {

		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "//src//test//resources//global.properties");

		Properties prop = new Properties();
		prop.load(fis);

		String url = prop.getProperty("QAUrl");
		String browser = prop.getProperty("browser");
		String headless = prop.getProperty("headless");

		if (driver == null) {

			if (browser.equalsIgnoreCase("chrome")) {

				ChromeOptions options = new ChromeOptions();

				if (headless.equalsIgnoreCase("true")) {
					options.addArguments("--headless=new");
				}

				driver = new ChromeDriver(options);
				driver.manage().window().maximize();
				driver.get(url);

			} else if (browser.equalsIgnoreCase("firefox")) {

				driver = new FirefoxDriver();
				driver.manage().window().maximize();
				driver.get(url);
			}
		}

		return driver;
	}
}