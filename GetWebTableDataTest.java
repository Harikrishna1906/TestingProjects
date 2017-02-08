package org.testng;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.commonlibrary.GenericConfigFunctions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class GetWebTableDataTest extends GenericConfigFunctions{

	@Test
	public void testWebtable() {

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		WebElement tableElement = driver.findElement(By.id("customers"));

		List<WebElement> tableRows = tableElement.findElements(By.tagName("tr"));

		Reporter.log("NUMBER OF ROWS IN THIS TABLE = " + tableRows.size(), true);

		for (WebElement tableRow : tableRows) {
			List<WebElement> tableColumns = tableRow.findElements(By.tagName("td"));

			Reporter.log("NUMBER OF COLUMNS = " + tableColumns.size(), true);

			for (WebElement tableColumn : tableColumns) {
				Reporter.log(tableColumn.getText(), true);

			}
		}
	}

}






