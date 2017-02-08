package org.commonlibrary;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;

public class GenericWebDriverFunctions {

	public void selectOptionByText(WebElement objProperty, String optionToSelect) {

		String status = "false";

		Select select = new Select(objProperty);

		List<WebElement> options = select.getOptions();

		int optionsCount = options.size();
		Reporter.log("Options Count" + optionsCount);

		if (optionsCount > 0) {

			for (WebElement option : options) {

				Reporter.log("Available Options In dropDown " + option.getText());

				if (option.getText().equals(optionToSelect)) {

					select.selectByVisibleText(optionToSelect);
					Reporter.log("Option with '" + optionToSelect + "' is available in Dropdown");
					status = "true";
					break;
				}
			}
			if (!(status == "true")) {
				Reporter.log("Option with ' " + optionToSelect + " ' is  not available in Dropdown");
			}
		} else {
			Reporter.log("There were no options available in Dropdown");
		}
	}

	public void selectWindow(WebDriver driver, String titleOfWindow) {

		Set<String> wndHandles = driver.getWindowHandles();

		int wndCount = wndHandles.size();

		Reporter.log(" Windows Count " + wndCount);

		for (String windowHandle : wndHandles) {
			Reporter.log(" Windows Handles " + windowHandle);

			String title = driver.switchTo().window(windowHandle).getTitle();
			Reporter.log(" Windows Title " + title);

			if (title.equalsIgnoreCase(titleOfWindow)) {

				driver.switchTo().window(windowHandle);
				Reporter.log("Windows title matched and selected expected window");

				break;
			}
		}

	}

	public boolean isTextPresent(WebDriver driver, String textToVerify) {

		String bodyText;

		bodyText = driver.findElement(By.tagName("body")).getText();

		if (bodyText.contains(textToVerify)) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isAlertPresent(WebDriver driver) {
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}
	}

	public void getAlert(WebDriver driver) {
		if (isAlertPresent(driver)) {
			Reporter.log("There is alert present", true);
			Alert alert = driver.switchTo().alert();
			alert.accept();
		} else {
			Reporter.log("There were no alerts present", true);
		}
	}

	public String getTextOnAlert(WebDriver driver) {
		
		String alertMessage=null;

		if (isAlertPresent(driver)) {
			Reporter.log("There is alert present", true);
			Alert alert = driver.switchTo().alert();
			alertMessage = alert.getText();

		} else {
			Reporter.log("There were no alerts present", true);
		}

		return alertMessage;
	}
	
	public void highlight(WebDriver driver,WebElement element) {

		((JavascriptExecutor) driver).executeScript(
				"arguments[0].style.border='4px solid yellow'", element);

	}

	
}
