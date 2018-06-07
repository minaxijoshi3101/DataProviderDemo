package com.datapovider.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.datapovider.testbase.TestBase;

public class EBayPage extends TestBase{
	public EBayPage() {
		PageFactory.initElements(driver, this);
	}

	//Page Factory or Object Repository
	@FindBy(how=How.XPATH,using ="//li[@id='gh-eb-My']//a[1]")
	WebElement myEBay;
	public void clickMyEBayLink()
	{
		myEBay.click();
	}
	
}
