package org.testng;

import org.testng.annotations.Test;

public class DataProviderNextClass {
	
	@Test(dataProvider="test",dataProviderClass=DataProviderExample.class)
	public void testCaseOne(String data1, int data2) {

		Reporter.log(data1, true);
		Reporter.log(String.valueOf(data2), true);
	}

}
