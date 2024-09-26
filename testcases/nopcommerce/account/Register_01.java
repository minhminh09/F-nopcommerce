package nopcommerce.account;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import common.BasePage1;
import pageObjects.CustomerPageObject;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.MyAccountPageObject;
import pageObjects.RegisterPageObject;

public class Register_01 extends BasePage1 {

	private WebDriver driver;
	private String projectpath = System.getProperty("user.dir");
	private HomePageObject homepage;
	private RegisterPageObject registerpage;
	private LoginPageObject loginpage;
	private CustomerPageObject customerpage;
	private MyAccountPageObject myAccountpage;
	private String emailAdress = getEmailRandom();
	private String firtName = "auto";
	private String lastName = "test";
	private String passWord = "123456";

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {

		if (browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", projectpath + "\\browserDrivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", projectpath + "\\browserDrivers\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.edge.driver", projectpath + "\\browserDrivers\\msedgedriver.exe");
			driver = new EdgeDriver();
		} else {
			throw new RuntimeException("Browser name is not valid");
		}
		// System.setProperty("webdriver.chrome.driver", projectpath + "\\browserDrivers\\chromedriver.exe");
		// driver = new ChromeDriver();
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		// Mo 1 url ra no o page nao thi khoi tao page do
		// tu 1 page nay chuyen qua page kia thi khoi tao page do len
		homepage = new HomePageObject(driver);

	}

	@Test
	public void Register_01_Empty_Data() {
		homepage.clicktoRegisterLink();
		// Tu homepage click Register link de chuyen sang trang Register
		registerpage = new RegisterPageObject(driver);
		registerpage.clickToRegisterButton();

		Assert.assertEquals(registerpage.getFirtNameErrorMessageText(), "First name is required.");
		Assert.assertEquals(registerpage.getLastNameErrorMessageText(), "Last name is required.");
		Assert.assertEquals(registerpage.getEmailNameErrorMessageText(), "Email is required.");
		// Assert.assertEquals(registerpage.getPasswordNameErrorMessageText(), "Password is required.");
		Assert.assertEquals(registerpage.getConfirmPasswordNameErrorMessageText(), "Password is required.");

	}

	@Test
	public void Register_02_Invalid_Email() {
		registerpage.clickToNopcommerceLogo();
		homepage = new HomePageObject(driver);
		homepage.clicktoRegisterLink();
		registerpage = new RegisterPageObject(driver);

		registerpage.enterToFirtNameTextbox(firtName);
		registerpage.enterToLastNameTextbox(lastName);
		registerpage.enterToEmailNameTextbox("123");
		registerpage.enterToPasswordTextbox(passWord);
		registerpage.enterToConfirmPasswordTextbox(passWord);

		registerpage.clickToRegisterButton();
		Assert.assertEquals(registerpage.getEmailNameErrorMessageText(), "Please enter a valid email address.");
	}

	@Test
	public void Register_03_Invalid_Password() {
		registerpage.clickToNopcommerceLogo();
		homepage = new HomePageObject(driver);
		homepage.clicktoRegisterLink();
		registerpage = new RegisterPageObject(driver);

		registerpage.enterToFirtNameTextbox(firtName);
		registerpage.enterToLastNameTextbox(lastName);
		registerpage.enterToEmailNameTextbox(getEmailRandom());
		registerpage.enterToPasswordTextbox("1");
		registerpage.enterToConfirmPasswordTextbox(passWord);

		registerpage.clickToRegisterButton();
		Assert.assertEquals(registerpage.getConfirmPasswordNameErrorMessageText(), "The password and confirmation password do not match.");
	}

	@Test
	public void Register_04_Incorrect_confirm_password() {
		registerpage.clickToNopcommerceLogo();
		homepage = new HomePageObject(driver);
		homepage.clicktoRegisterLink();
		registerpage = new RegisterPageObject(driver);

		registerpage.enterToFirtNameTextbox(firtName);
		registerpage.enterToLastNameTextbox(lastName);
		registerpage.enterToEmailNameTextbox(getEmailRandom());
		registerpage.enterToPasswordTextbox(passWord);
		registerpage.enterToConfirmPasswordTextbox("2");

		registerpage.clickToRegisterButton();
		Assert.assertEquals(registerpage.getConfirmPasswordNameErrorMessageText(), "The password and confirmation password do not match.");
	}

	@Test
	public void Register_05_Succesfull() {
		registerpage.clickToNopcommerceLogo();
		homepage = new HomePageObject(driver);
		homepage.clicktoRegisterLink();
		registerpage = new RegisterPageObject(driver);

		registerpage.enterToFirtNameTextbox(firtName);
		registerpage.enterToLastNameTextbox(lastName);
		registerpage.enterToEmailNameTextbox(emailAdress);
		registerpage.enterToPasswordTextbox(passWord);
		registerpage.enterToConfirmPasswordTextbox(passWord);

		registerpage.clickToRegisterButton();
		Assert.assertEquals(registerpage.getRegisterSuccesMessageText(), "Your registration completed");

	}

	@Test
	public void Login_Succesfull() {
		registerpage.clickToLogoutLink();
		homepage = new HomePageObject(driver);
		homepage.clickToLogInLink();
		loginpage = new LoginPageObject(driver);
		loginpage.enterToEmailTextbox(emailAdress);
		loginpage.enterToPassword(passWord);
		loginpage.clickToLogInButton();
		homepage = new HomePageObject(driver);
		homepage.clickToMyAccountLink();
		customerpage = new CustomerPageObject(driver);

		Assert.assertEquals(customerpage.getFirtNameTextboxAttributeValue(), firtName);
		Assert.assertEquals(customerpage.getLastNameTexboxAttributeValue(), lastName);
		Assert.assertEquals(customerpage.getEmailAdressTextboxAttributeValue(), emailAdress);

	}

	public String getEmailRandom() {
		Random rand = new Random();
		return "auto" + rand.nextInt(9999) + "@gmail.com";
	}

	@AfterClass
	public void afterClass() {

		driver.quit();

	}

}
