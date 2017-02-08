package org.commonlibrary;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

public class GenericHelperFunctions {
	
    public  String[][] getTestData(String excelPath, String sheetName,String tableName) {
		
		String[][] testData = null;

		try {

			Workbook workbook = Workbook.getWorkbook(new File(excelPath));
			Sheet sheet = workbook.getSheet(sheetName);

			int ci, cj, rowStart, rowEnd, colStart, colEnd;

			Cell tableStart = sheet.findCell(tableName);

			rowStart = tableStart.getRow();
			colStart = tableStart.getColumn();

			Cell tableEnd = sheet.findCell(tableName, colStart + 1,
					rowStart + 1, 100, 64000, false);

			rowEnd = tableEnd.getRow();
			colEnd = tableEnd.getColumn();

			// TestData=new String[10-5-1][10-2-1];
			testData = new String[rowEnd - rowStart - 1][colEnd - colStart - 1];

			ci = 0; // to store data into two dimensional array row wise
			for (int i = rowStart + 1; i < rowEnd; i++, ci++) {

				cj = 0; // to store data into two dimensional array column wise
				for (int j = colStart + 1; j < colEnd; j++, cj++) {
					testData[ci][cj] = sheet.getCell(j, i).getContents();
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return testData;
	}
    
    public String getTimeStamp(){    	

		Date date = new Date();

		DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");

		String currentTimeStamp = dateFormat.format(date);

		return currentTimeStamp;
    }


}


