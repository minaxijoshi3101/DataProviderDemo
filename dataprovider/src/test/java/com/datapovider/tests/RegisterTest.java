package com.datapovider.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.datapovider.pages.EBayPage;
import com.datapovider.pages.RegisterPage;
import com.datapovider.testbase.TestBase;
import com.datapovider.utility.TestUtil;

public class RegisterTest extends TestBase{
	RegisterPage reg;
	EBayPage ebayObj;
	public RegisterTest()
	{
		super();
	}
	@BeforeMethod
	public void setup()
	{
		initialization();
		ebayObj = new EBayPage();
		reg = new RegisterPage();
	}
	@DataProvider
	public Object[][] getDatafromExcel()
	{
		Object[][] data = TestUtil.getTestDataFromExcel("Sheet1");
		return data;
	}
	@Test(dataProvider = "getDatafromExcel")
	public void registerTest(String fname,String lname,String email,String pwd)
	{
		ebayObj.clickMyEBayLink();
		reg.enterData(fname,lname,email,pwd);
	}
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}
