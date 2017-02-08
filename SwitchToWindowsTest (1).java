package org.testng;

import java.util.Set;

import org.commonlibrary.GenericConfigFunctions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class SwitchToWindowsTest extends GenericConfigFunctions{
	
	@Test
	public void selectWindowsTest() {		

		driver.findElement(By.id("username")).sendKeys("user");
		
		driver.findElement(By.name("pwd")).sendKeys("user");
		
		driver.findElement(By.cssSelector("#loginButton > div")).click();
		
		Wait<WebDriver> wait=new WebDriverWait(driver, 30);
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("logoutLink")));

		String parentWindow= driver.getWindowHandle();
		
		driver.findElement(By.cssSelector("div.popup_menu_icon.support_icon")).click();
		
	    driver.findElement(By.linkText("User Guide")).click();

	    Set<String> wndHandles=driver.getWindowHandles();
	    
	    int wndCount=wndHandles.size();
	    
	    Reporter.log(" Windows Count "+wndCount);
	    
	    for (String windowHandle : wndHandles) {
			Reporter.log(" Windows Handles " + windowHandle);
			
			String title = driver.switchTo().window(windowHandle).getTitle();
			Reporter.log(" Windows Title " + title);
			
			if (title.equalsIgnoreCase("Time Tracking Software | actiTIME")) {
				
				driver.switchTo().window(windowHandle);
				Reporter.log("Windows title matched and selected expected window");
				
				break;				
			}
		}	
	    
	    wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Getting Started")));
		
		driver.findElement(By.linkText("Getting Started")).click();
				
		driver.switchTo().window(parentWindow);
				
		wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Logout")));

		driver.findElement(By.linkText("Logout")).click();

	}


}
