package pageObjects;

import org.openqa.selenium.WebDriver;

import common.BasePage1;
import common.PageGeneratorManager;
import pageUI.HomePageUI;
import pageUI.RegisterPageUI;
import pageUI.basePageUI;

public class HomePageObject extends BasePage1 {
	WebDriver driver;

	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public RegisterPageObject clicktoRegisterLink() {
		waitForElementClick(driver, HomePageUI.REGISTER_LINK);
		clickToElement(driver, HomePageUI.REGISTER_LINK);
		return PageGeneratorManager.getRegisterPage(driver);
	}

	public LoginPageObject clickToLogInLink() {
		waitForElementClick(driver, HomePageUI.LOGIN_LINK);
		clickToElement(driver, HomePageUI.LOGIN_LINK);
		return PageGeneratorManager.getLoginPage(driver);

	}

	public CustomerPageObject clickToMyAccountLink() {
		waitForElementClick(driver, HomePageUI.MYACCOUNT_LINK);
		clickToElement(driver, HomePageUI.MYACCOUNT_LINK);
		return PageGeneratorManager.getCustomerPage(driver);

	}

}
