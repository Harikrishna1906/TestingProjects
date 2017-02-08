package org.testng;

import java.util.concurrent.TimeUnit;

import org.commonlibrary.GenericConfigFunctions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ActiTimeLoginTest extends GenericConfigFunctions {
	
	@DataProvider(name="LoginData")
	public static Object[][] getExcelData(){
		
		Object[][] testData=gnHelperFunctions.getTestData
				(excelWorkBookPath, excelSheetName, excelTableName);
		
		return testData;
	}

	@Test(dataProvider="LoginData")
	public void loginTest(String userName, String password) {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		WebElement objUserName = driver.findElement(By.name("username"));
		if (objUserName.isDisplayed()) {
			Reporter.log("Username element found in Application and Script executing ....", true);
			if (objUserName.isEnabled()) {				
				Reporter.log("Username element is enable for typing");
				objUserName.sendKeys(userName);
				driver.findElement(By.name("pwd")).sendKeys(password);
				driver.findElement(By.xpath("//a[@id='loginButton']/div")).click();
				driver.findElement(By.linkText("Logout")).click();
			} else {
				Reporter.log("Username element is disable for typing");
			}
		}

		else {
			Reporter.log("Username element not found in Application");
		}
	}

}
