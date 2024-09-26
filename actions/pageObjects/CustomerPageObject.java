package pageObjects;

import org.openqa.selenium.WebDriver;

import common.BasePage1;
import pageUI.CustomerPageUI;

public class CustomerPageObject extends BasePage1 {
	WebDriver driver;

	public CustomerPageObject(WebDriver driver) {

		this.driver = driver;
	}

	public String getFirtNameTextboxAttributeValue() {
		waitForElementVisible(driver, CustomerPageUI.FIRSTNAME_TEXTBOX);
		return getElementText(driver, CustomerPageUI.FIRSTNAME_TEXTBOX);
	}

	public String getLastNameTexboxAttributeValue() {
		waitForElementVisible(driver, CustomerPageUI.LASTNAME_TEXTBOX);
		return getElementText(driver, CustomerPageUI.LASTNAME_TEXTBOX);
	}

	public String getEmailAdressTextboxAttributeValue() {
		waitForElementVisible(driver, CustomerPageUI.EMAILADDRESS_TEXTBOX);
		return getElementText(driver, CustomerPageUI.EMAILADDRESS_TEXTBOX);
	}

}
