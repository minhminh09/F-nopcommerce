package common;

import java.awt.Point;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.yaml.snakeyaml.introspector.BeanAccess;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	private WebDriver driver;
	private String projectpath = System.getProperty("user.dir");

	protected WebDriver getBrowserDriver(String browserName) {
		BrowserList browser = BrowserList.valueOf(browserName.toUpperCase());

		switch (browser) {
		case FIREFOX:

			driver = WebDriverManager.firefoxdriver().create();
			break;
		case CHROME:
			driver = WebDriverManager.chromedriver().create();
			break;
		case EDGE:
			driver = WebDriverManager.edgedriver().create();
			break;
		case OPERA:
			driver = WebDriverManager.operadriver().create();
			break;
		case SAFARI:
			driver = WebDriverManager.safaridriver().create();
			break;

		default:
			throw new RuntimeException("Browser name is not valid");

		}
		driver.manage().window().setPosition(new org.openqa.selenium.Point(0, 0));
		// setPosition(new Point(0, 0));
		driver.manage().window().setSize(new Dimension(1920, 1080));
		driver.get("http://demo.nopcommerce/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		return driver;
	}

	public String getEmailRandom() {
		Random rand = new Random();
		return "auto" + rand.nextInt(9999) + "@gmail.com";
	}

	protected void closeBrowser() {
		if (driver == null) {
			System.out.println("Browser is close");
		} else {
			driver.quit();
		}
	}
}
