package org.testng;

import org.commonlibrary.GenericConfigFunctions;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class TakeScreenShotOnFailureTest extends GenericConfigFunctions{
	
	@Test
	public void test() {
		driver.findElement(By.name("q")).sendKeys("Selenium");
		eDriver.findElement(By.name("qq")).sendKeys("Selenium");
	}

}







