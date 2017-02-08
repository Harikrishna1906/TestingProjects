package org.grid;

import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class GridTest2 {
	public static WebDriver driver;

	@BeforeClass
	@Parameters({"url" })
	public void setUp(String url) throws Exception{
		DesiredCapabilities capability =DesiredCapabilities.chrome();
		driver =new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capability);
		driver.get(url);
		driver.manage().window().maximize();
	}

	@Test
	public void loginTest() throws Exception{

		WebElement element=driver.findElement(By.name("userName"));
		element.sendKeys("mercury");
		driver.findElement(By.name("password")).sendKeys("mercury");
		driver.findElement(By.name("login")).click();
		Thread.sleep(30000);
		driver.findElement(By.linkText("SIGN-OFF")).click();
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
