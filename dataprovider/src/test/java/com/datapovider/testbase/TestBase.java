package com.datapovider.testbase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	
	public TestBase()
	{
		try {
			prop = new Properties();
			FileInputStream fis = new FileInputStream("src\\main\\resources\\config.properties");
			prop.load(fis);
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void initialization()
	{
		if(prop.getProperty("browsername").equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "\\src\\test\\resources\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(300, TimeUnit.SECONDS);
	}

}
