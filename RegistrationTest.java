package org.testng;

import org.commonlibrary.GenericConfigFunctions;
import org.commonlibrary.GenericWebDriverFunctions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class RegistrationTest extends GenericConfigFunctions{
	
	GenericWebDriverFunctions gnWdFunctions=new GenericWebDriverFunctions();
	
	@Test
	public void registerTest() {

		driver.findElement(By.linkText("REGISTER")).click();

		driver.findElement(By.name("firstName")).sendKeys("test");

		driver.findElement(By.name("lastName")).sendKeys("test123`");

		driver.findElement(By.name("phone")).sendKeys("68738686785");

		driver.findElement(By.id("userName")).sendKeys("test@gmail.com");

		driver.findElement(By.name("address1")).sendKeys("klsdflks");

		driver.findElement(By.name("address2")).sendKeys("gmldkg");

		driver.findElement(By.name("city")).sendKeys("dfgsl");

		driver.findElement(By.name("state")).sendKeys("dglkdl");

		driver.findElement(By.name("postalCode")).sendKeys("kdlfml");

		WebElement objCountry=driver.findElement(By.name("country"));
		
		gnWdFunctions.selectOptionByText(objCountry, "INDIA");
		gnWdFunctions.selectOptionByText(objCountry, "GHANA");
		
		driver.findElement(By.id("email")).sendKeys("test123");

		driver.findElement(By.name("password")).sendKeys("test123");

		driver.findElement(By.name("confirmPassword")).sendKeys("test123");

		driver.findElement(By.name("register")).click();

	}

}
