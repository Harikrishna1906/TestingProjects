package org.commonlibrary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class GenericConfigFunctions {

	public static WebDriver driver;
	public static String excelWorkBookPath;
	public static String excelSheetName;
	public static String excelTableName;
	public EventFiringWebDriver eDriver;
	public GenericWebDriverFunctions gnWdFunctions = new GenericWebDriverFunctions();

	public static GenericHelperFunctions gnHelperFunctions = new GenericHelperFunctions();

	@BeforeMethod
	public void setUp() {
		eDriver = new EventFiringWebDriver(driver);
		eDriver.register(new EventFiring());
	}

	@BeforeTest
	@Parameters({ "excelPath", "sheetName", "tableName" })
	public void getExcelDetails(String excelPath, String sheetName, String tableName) {

		excelWorkBookPath = excelPath;
		excelSheetName = sheetName;
		excelTableName = tableName;
	}

	@BeforeClass
	@Parameters({ "browserName", "url" })
	public void setUp(String browserName, String url) {

		if (browserName.equals("IExplore")) {
			System.setProperty("webdriver.ie.driver", "Resources\\IEDriverServer32Bit.exe");
			driver = new InternetExplorerDriver();
			Reporter.log("Script execting on " + browserName + "browser", true);
		} else if (browserName.equals("Firefox")) {
			driver = new FirefoxDriver();
			Reporter.log("Script execting on " + browserName + "browser", true);
		} else if (browserName.equals("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "Resources\\chromedriver.exe");
			driver = new ChromeDriver();
			Reporter.log("Script execting on " + browserName + "browser", true);
		} else {
			driver = new FirefoxDriver();
			Reporter.log("Script execting on default firefox browser", true);
		}

		driver.get(url);
		driver.manage().window().maximize();
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
