package org.testng;

import org.commonlibrary.GenericConfigFunctions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class SwitchToWindowsTest extends GenericConfigFunctions {

	@Test
	public void selectWindowsTest() {

		driver.findElement(By.id("username")).sendKeys("user");

		driver.findElement(By.name("pwd")).sendKeys("user");

		driver.findElement(By.cssSelector("#loginButton > div")).click();

		Wait<WebDriver> wait = new WebDriverWait(driver, 30);

		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("logoutLink")));

		driver.findElement(By.cssSelector("div.popup_menu_icon.support_icon")).click();

		driver.findElement(By.linkText("User Guide")).click();

		gnWdFunctions.selectWindow(driver, "Time Tracking Software | actiTIME");

		wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Getting Started")));

		driver.findElement(By.linkText("Getting Started")).click();
		
		gnWdFunctions.selectWindow(driver, "actiTIME - Enter Time-Track");

		wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Logout")));

		driver.findElement(By.linkText("Logout")).click();

	}

}
