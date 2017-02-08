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

public class MobileWebTestOnRealDevices {
	
	public AndroidDriver<WebElement> driver;

	@BeforeClass
	public void setUp()throws Exception{		
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "169cdce2");
		cap.setCapability(MobileCapabilityType.VERSION, "6.0.1");
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		cap.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
		driver = new AndroidDriver<WebElement>(new URL("http://localhost:4723/wd/hub"), cap);
		driver.get("http://www.google.co.in");
	}

	@Test
	public void searchTest() {		
		WebElement searchElement = driver.findElement(By.id("lst-ib"));
		searchElement.sendKeys("Selenium Testing");
		searchElement.clear();
		searchElement.sendKeys("Selenium WebDriver");
		driver.findElement(By.name("btnG")).click();
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
		Reporter.log("Script executed and Browser Closed");
	}

}
