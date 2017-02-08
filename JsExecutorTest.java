package org.testng;

import org.commonlibrary.GenericConfigFunctions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class JsExecutorTest extends GenericConfigFunctions{
	
	@Test
	public void testJsExecutor() {

		String title = ((JavascriptExecutor) driver)
				.executeScript("return document.title;").toString();
		Reporter.log(title);

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		
		jse.executeScript("document.getElementById('lst-ib').value = 'selenium'");

		WebElement searchBox = driver.findElement(By.name("q"));

		gnWdFunctions.highlight(driver,searchBox);

		jse.executeScript("arguments[0].value = 'selenium testing'", searchBox);

		WebElement searchButton = driver.findElement(By.name("btnG"));

		gnWdFunctions.highlight(driver,searchButton);

		jse.executeScript("arguments[0].click()", searchButton);

	}	

}
