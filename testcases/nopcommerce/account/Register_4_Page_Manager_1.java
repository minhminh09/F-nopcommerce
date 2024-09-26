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
import common.BaseTest;
import pageObjects.CustomerPageObject;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.MyAccountPageObject;
import pageObjects.NewProductions;
import pageObjects.RegisterPageObject;

public class Register_4_Page_Manager_1 extends BaseTest {

	private WebDriver driver;
	private HomePageObject homepage;
	private RegisterPageObject registerpage;
	private LoginPageObject loginpage;
	private CustomerPageObject customerpage;
	private MyAccountPageObject myAccountpage;
	private NewProductions newProductions;
	private String emailAdress = getEmailRandom();
	private String firtName = "auto";
	private String lastName = "test";
	private String passWord = "123456";

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {

		driver = getBrowserDriver(browserName);
		homepage = new HomePageObject(driver);
	}

	@Test
	public void Register_01_Empty_Data() {
		registerpage = homepage.clicktoRegisterLink();
		// registerpage = new RegisterPageObject(driver);
		registerpage.clickToRegisterButton();

		Assert.assertEquals(registerpage.getFirtNameErrorMessageText(), "First name is required.");
		Assert.assertEquals(registerpage.getLastNameErrorMessageText(), "Last name is required.");
		Assert.assertEquals(registerpage.getEmailNameErrorMessageText(), "Email is required.");
		Assert.assertEquals(registerpage.getConfirmPasswordNameErrorMessageText(), "Password is required.");

	}

	@Test
	public void Register_02_Invalid_Email() {
		homepage = registerpage.clickToNopcommerceLogo();
		// homepage = new HomePageObject(driver);
		registerpage = homepage.clicktoRegisterLink();
		// registerpage = new RegisterPageObject(driver);

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
		homepage = registerpage.clickToNopcommerceLogo();
		// homepage = new HomePageObject(driver);
		registerpage = homepage.clicktoRegisterLink();
		// registerpage = new RegisterPageObject(driver);

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
		homepage = registerpage.clickToNopcommerceLogo();
		// homepage = new HomePageObject(driver);
		registerpage = homepage.clicktoRegisterLink();
		// registerpage = new RegisterPageObject(driver);

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
		homepage = registerpage.clickToNopcommerceLogo();
		// homepage = new HomePageObject(driver);
		registerpage = homepage.clicktoRegisterLink();
		// registerpage = new RegisterPageObject(driver);

		registerpage.enterToFirtNameTextbox(firtName);
		registerpage.enterToLastNameTextbox(lastName);
		registerpage.enterToEmailNameTextbox(emailAdress);
		registerpage.enterToPasswordTextbox(passWord);
		registerpage.enterToConfirmPasswordTextbox(passWord);

		registerpage.clickToRegisterButton();
		Assert.assertEquals(registerpage.getRegisterSuccesMessageText(), "Your registration completed");

	}

	@Test
	public void switchPage() {

		homepage = registerpage.openHomePage(driver);

		newProductions = homepage.openToNewProduct(driver);

		myAccountpage = newProductions.openToMyAccount(driver);
	}

	public void Login_Succesfull() {
		homepage = registerpage.clickToLogoutLink();
		// homepage = new HomePageObject(driver);
		loginpage = homepage.clickToLogInLink();
		// loginpage = new LoginPageObject(driver);
		loginpage.enterToEmailTextbox(emailAdress);
		loginpage.enterToPassword(passWord);
		homepage = loginpage.clickToLogInButton();
		// homepage = new HomePageObject(driver);
		customerpage = homepage.clickToMyAccountLink();
		// customerpage = new CustomerPageObject(driver);

		Assert.assertEquals(customerpage.getFirtNameTextboxAttributeValue(), firtName);
		Assert.assertEquals(customerpage.getLastNameTexboxAttributeValue(), lastName);
		Assert.assertEquals(customerpage.getEmailAdressTextboxAttributeValue(), emailAdress);

	}

	@AfterClass
	public void afterClass() {

		closeBrowser();

	}

}
