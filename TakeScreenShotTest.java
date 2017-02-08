package org.testng;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.commonlibrary.GenericConfigFunctions;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.Test;

public class TakeScreenShotTest extends GenericConfigFunctions{
	
	@Test
	public void takeScreenShot() {
		
		File screenShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);	
		
		try {
			String screenShotLocation = "E:\\ScreenShots\\ScreenShot.png";
			FileUtils.copyFile(screenShot, new File(screenShotLocation));
			
			Reporter.log("<a href=file:///" + screenShotLocation + ">Screen Shot Link</a>");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


}







