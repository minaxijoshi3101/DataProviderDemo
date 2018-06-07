package com.datapovider.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TestUtil {
	static XSSFWorkbook book;
	static Sheet sheet;
	public static String TESTDATA_SHEET_PATH = "\\src\\test\\resources\\EbayTestData.xlsx";
	public static Object[][] getTestDataFromExcel(String sheetName)
	{
		
		try {
			FileInputStream fis = new FileInputStream(TESTDATA_SHEET_PATH);
			book = new XSSFWorkbook(fis);
			XSSFSheet sheet = book.getSheet(sheetName);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		for(int i=0;i<sheet.getLastRowNum();i++)
		{
			for(int j=0;j<sheet.getRow(0).getLastCellNum();j++)
			{
				data[i][j] =  sheet.getRow(i+1).getCell(j).toString();
			}
		}
		return data;
	}

}
