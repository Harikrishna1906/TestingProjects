package org.testng;

import java.util.concurrent.TimeUnit;

import org.commonlibrary.GenericConfigFunctions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.annotations.Test;

public class FileUploadTest extends GenericConfigFunctions{

	@Test
	public  void upload() throws Exception {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.findElement(By.id("Email")).sendKeys("seleniumwebdriver167");
		driver.findElement(By.id("next")).click();
		driver.findElement(By.id("Passwd")).sendKeys("seleniumwebdriver167");
		driver.findElement(By.id("signIn")).click();
		driver.findElement(By.xpath("//div[contains(text(),'COMPOSE')]")).click();
		driver.findElement(By.name("to")).sendKeys("sreenivasulu2k3@gmail.com");
		driver.findElement(By.name("subjectbox")).sendKeys("UploadFile");
		WebElement attachFileElement = driver.findElement(By.xpath
				("//div[text()='Send']/ancestor::tr/td[4]/div/div"));
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click()", attachFileElement);
		
		Thread.sleep(2000);
		Screen screen = new Screen();
		Pattern pattern = new Pattern("Images\\Filename.png");
		screen.type(pattern.similar((float) 0.76).targetOffset(-78, -1), "E:\\SeleniumTrainingV2.doc");
		Thread.sleep(2000);
		screen.click("Images\\Open.png");
		Thread.sleep(5000);
		
		WebElement sendFileElement = driver.findElement(By.xpath("//div[text()='Send']"));
		jse.executeScript("arguments[0].click()", sendFileElement);

	}

}


R31026, 
12TH,
ALPHA COMPUTERS.

9885659589
ALPHACOMPUTERS2004@REDIFFMAIL.COM




