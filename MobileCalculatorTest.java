package org.mobile;

import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class MobileCalculatorTest {
	
	public AndroidDriver<WebElement> driver;

	@BeforeClass
	public void setUp() throws Exception {

		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Training");
		cap.setCapability(MobileCapabilityType.VERSION, "5.0.1");
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		cap.setCapability("appPackage", "com.android.calculator2");
		cap.setCapability("appActivity", "com.android.calculator2.Calculator");
		driver = new AndroidDriver<WebElement>(new URL("http://localhost:4723/wd/hub"), cap);
	}

	@Test
	public void cal() {

		WebElement digitEight = driver.findElement(By.id("digit_8"));
		digitEight.click();
		WebElement mulKey = driver.findElement(By.id("op_mul"));
		mulKey.click();
		WebElement digitFive = driver.findElement(By.id("digit_5"));
		digitFive.click();
		WebElement equalsKey = driver.findElement(By.id("eq"));
		equalsKey.click();
		String resultValue = driver.findElement(By.id("formula")).getText();
		Reporter.log("After multiple the value is   " + resultValue, true);

	}

	@AfterClass
	public void tearDown() {

		driver.quit();
	}


}

02157df2d9b64127

adb shell pm list packages -f --- to get the name of all packages in mobile using command prompt

