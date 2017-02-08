package org.testng;

import org.commonlibrary.GenericConfigFunctions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class SeriesOfActionsTest extends GenericConfigFunctions{
	
	@Test
	public void testActions(){
		
		WebElement element = driver.findElement(By.name("q"));
		
		Actions builder = new Actions(driver);

		   Action setOfActions= builder
		       .moveToElement(element).click()
		       .keyDown(element,Keys.SHIFT)
		       .sendKeys(element,"selenium")
		       .keyUp(element, Keys.SHIFT)
               .sendKeys(element,Keys.SPACE)
		       .sendKeys(element, Keys.chord(Keys.CONTROL,"a"))
		       .contextClick(element)
		       .sendKeys(Keys.ARROW_DOWN)
		       .sendKeys(Keys.ENTER)
				.build();
		   setOfActions.perform();
		
	}

}





