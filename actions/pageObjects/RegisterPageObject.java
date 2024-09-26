package pageObjects;

import org.openqa.selenium.WebDriver;

import common.BasePage1;
import common.PageGeneratorManager;
import pageUI.RegisterPageUI;
import pageUI.basePageUI;

public class RegisterPageObject extends BasePage1 {
	WebDriver driver;

	public RegisterPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToRegisterButton() {
		waitForElementClick(driver, RegisterPageUI.REGISTER_BUTTON);
		clickToElement(driver, RegisterPageUI.REGISTER_BUTTON);
	}

	public String getFirtNameErrorMessageText() {
		waitForElementVisible(driver, RegisterPageUI.FIRTNAME_ERROR_MSG);
		return getElementText(driver, RegisterPageUI.FIRTNAME_ERROR_MSG);
	}

	public String getLastNameErrorMessageText() {
		waitForAllElementVisible(driver, RegisterPageUI.LASTNAME_ERROR_MSG);
		return getElementText(driver, RegisterPageUI.LASTNAME_ERROR_MSG);
	}

	public String getEmailNameErrorMessageText() {
		waitForAllElementVisible(driver, RegisterPageUI.EMAIL_ERROR_MSG);
		return getElementText(driver, RegisterPageUI.EMAIL_ERROR_MSG);
	}

	public String getPasswordNameErrorMessageText() {
		waitForAllElementVisible(driver, RegisterPageUI.PASSWORD_ERROR_MSG);
		return getElementText(driver, RegisterPageUI.PASSWORD_ERROR_MSG);
	}

	public String getConfirmPasswordNameErrorMessageText() {
		waitForAllElementVisible(driver, RegisterPageUI.CONFIRM_PASSWORD_ERROR_MSG);
		return getElementText(driver, RegisterPageUI.CONFIRM_PASSWORD_ERROR_MSG);
	}

	public HomePageObject clickToNopcommerceLogo() {
		waitForElementClick(driver, RegisterPageUI.LOGO_IMG);
		clickToElement(driver, RegisterPageUI.LOGO_IMG);
		return PageGeneratorManager.getHomePage(driver);

	}

	public void enterToFirtNameTextbox(String firstName) {
		waitForAllElementVisible(driver, RegisterPageUI.FIRTNAME_TEXTBOX);
		senkeyToElement(driver, RegisterPageUI.FIRTNAME_TEXTBOX, firstName);

	}

	public void enterToLastNameTextbox(String lastName) {
		waitForAllElementVisible(driver, RegisterPageUI.LASTNAME_TEXTBOX);
		senkeyToElement(driver, RegisterPageUI.LASTNAME_TEXTBOX, lastName);

	}

	public void enterToEmailNameTextbox(String emailAdress) {
		waitForAllElementVisible(driver, RegisterPageUI.EMAIL_TEXTBOX);
		senkeyToElement(driver, RegisterPageUI.EMAIL_TEXTBOX, emailAdress);

	}

	public void enterToPasswordTextbox(String password) {
		waitForAllElementVisible(driver, RegisterPageUI.PASSWORD_TEXTBOX);
		senkeyToElement(driver, RegisterPageUI.PASSWORD_TEXTBOX, password);
	}

	public void enterToConfirmPasswordTextbox(String password) {
		waitForAllElementVisible(driver, RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX);
		senkeyToElement(driver, RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX, password);

	}

	// public String getEmailErrorMessageText() {
	// waitForAllElementVisible(driver, RegisterPageUI.EMAIL_ERROR_MSG);
	// return getElementText(driver, RegisterPageUI.EMAIL_ERROR_MSG);
	// }
	//
	// public String getPasswordErrorMessageText() {
	// waitForAllElementVisible(driver, RegisterPageUI.PASSWORD_ERROR_MSG);
	// return getElementText(driver, RegisterPageUI.PASSWORD_ERROR_MSG);
	// }
	//
	// public String getConfirmPasswordErrorMessageText() {
	// waitForAllElementVisible(driver, RegisterPageUI.CONFIRM_PASSWORD_ERROR_MSG);
	// return getElementText(driver, RegisterPageUI.CONFIRM_PASSWORD_ERROR_MSG);
	// }

	public String getRegisterSuccesMessageText() {
		waitForAllElementVisible(driver, RegisterPageUI.REGISTRATION_COMPLETED_MSG);
		return getElementText(driver, RegisterPageUI.REGISTRATION_COMPLETED_MSG);
	}
	//
	// public HomePageObject clickToLogoutLink() {
	// waitForElementClick(driver, RegisterPageUI.LOGOUT_LINK);
	// clickToElement(driver, RegisterPageUI.LOGOUT_LINK);
	// return new HomePageObject(driver);
	//
	// }

	public HomePageObject clickToLogoutLink() {
		waitForElementClick(driver, RegisterPageUI.LOGOUT_LINK);
		clickToElement(driver, RegisterPageUI.LOGOUT_LINK);
		return PageGeneratorManager.getHomePage(driver);

	}

}
