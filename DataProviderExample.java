package org.testng;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderExample {
	
	@DataProvider(name="test")
	public static Object[][] getData() {

		Object[][] data = new Object[3][2];

			data[0][0] = "Test1";
			data[0][1] = 123;

			data[1][0] = "Test2";
			data[1][1] = 321;

			data[2][0] = "Test3";
			data[2][1] = 435;
	
		return data;
	}
	
	@Test(dataProvider="test")
	public void testCaseOne(String data1, int data2) {

		Reporter.log(data1, true);
		Reporter.log(String.valueOf(data2), true);
	}
	
	@Test(dataProvider="test")
	public void testCaseTwo(String data1, int data2) {

		Reporter.log(data1, true);
		Reporter.log(String.valueOf(data2), true);
	}

}








