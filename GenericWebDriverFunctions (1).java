package org.commonlibrary;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;

public class GenericWebDriverFunctions {

	public void selectOptionByText(WebElement objProperty, String optionToSelect) {
		
		String status = "false";

		Select select = new Select(objProperty);

		List<WebElement> options = select.getOptions();

		int optionsCount = options.size();
		Reporter.log("Options Count" + optionsCount);

		if (optionsCount > 0) {

			for (WebElement option : options) {

				Reporter.log("Available Options In dropDown " + option.getText());

				if (option.getText().equals(optionToSelect)) {

					select.selectByVisibleText(optionToSelect);
					Reporter.log("Option with '"+optionToSelect+"' is available in Dropdown");
					status = "true";
					break;
				}
			}
			if (!(status == "true")) {
				Reporter.log("Option with ' "+optionToSelect+" ' is  not available in Dropdown");
			}
		} else {
			Reporter.log("There were no options available in Dropdown");
		}
	}
	
	
	public void selectWindow(WebDriver driver, String titleOfWindow){
		
		 Set<String> wndHandles=driver.getWindowHandles();
		    
		    int wndCount=wndHandles.size();
		    
		    Reporter.log(" Windows Count "+wndCount);
		    
		    for (String windowHandle : wndHandles) {
				Reporter.log(" Windows Handles " + windowHandle);
				
				String title = driver.switchTo().window(windowHandle).getTitle();
				Reporter.log(" Windows Title " + title);
				
				if (title.equalsIgnoreCase(titleOfWindow)) {
					
					driver.switchTo().window(windowHandle);
					Reporter.log("Windows title matched and selected expected window");
					
					break;				
				}
			}	
		
	}

}
