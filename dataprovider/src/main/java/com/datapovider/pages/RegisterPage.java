package com.datapovider.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.datapovider.testbase.TestBase;

public class RegisterPage extends TestBase{
	public RegisterPage() {
		PageFactory.initElements(driver, this);
	}
	@FindBy(how=How.XPATH,using="//span[contains(text(),'Register')]")
	WebElement registerLink;
	public void clickRegister()
	{
		registerLink.click();
	}
	@FindBy(id="firstname")
	WebElement fName;
	@FindBy(id="lastname")
	WebElement lName;
	@FindBy(name="email")
	WebElement email;
	@FindBy(name="PASSWORD")
	WebElement password;
	public void enterData(String firstName,String lastName,String emailAddr, String pwd)
	{
		fName.sendKeys(firstName);
		lName.sendKeys(lastName);
		email.sendKeys(emailAddr);
		password.sendKeys(pwd);
		
	}
}
