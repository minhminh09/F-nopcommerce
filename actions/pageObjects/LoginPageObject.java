package pageObjects;

import org.openqa.selenium.WebDriver;

import common.BasePage1;
import pageUI.LoginPageUI;

public class LoginPageObject extends BasePage1 {
	WebDriver driver;

	public LoginPageObject(WebDriver driver) {

		this.driver = driver;
	}

	public void enterToEmailTextbox(String emailAdress) {

		waitForAllElementVisible(driver, LoginPageUI.EMAIL_ADRESS_TEXTBOX);
		senkeyToElement(driver, LoginPageUI.EMAIL_ADRESS_TEXTBOX, emailAdress);
	}

	public void enterToPassword(String passWordvalue) {
		waitForAllElementVisible(driver, LoginPageUI.PASSWORD_TEXTBOX);
		senkeyToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, passWordvalue);

	}

	public HomePageObject clickToLogInButton() {
		waitForElementClick(driver, LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
		return new HomePageObject(driver);

	}

}
