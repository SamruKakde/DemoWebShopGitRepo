package com.gitProj;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WebShopLog4jProp {
	static Logger log=Logger.getLogger(WebShopLog4jProp.class.getName());
    WebDriver driver;
    Properties pro=new Properties();
	@BeforeSuite
	public void beforeSuite() throws IOException
	{
		FileInputStream fis=new FileInputStream("C:\\Users\\Samruddhi\\Selenium-workspace\\GitProject\\src\\com\\gitProj\\WebShopPropertyF.properties");
		pro.load(fis);
		System.setProperty("webdriver.chrome.driver", "E:\\Selenium Class\\Selenium softwares\\chromedriver.exe");		
		driver=new ChromeDriver();
		log.debug("Browser open..");
	}
	@BeforeTest
	public void beforeTest()
	{
		driver.get(pro.getProperty("url"));
		log.info("URL open..");
		log.info(driver.getTitle());

	}
	@BeforeClass
	public void beforeClass()
	{
		  driver.manage().window().maximize();
		  log.info("Maximize window..");
	}
	
	@BeforeMethod
	public void beforeMethod()
	{
		log.info("Inside beforeMethod()...");
	}
	
	@Test
	public void register()
	{
		log.info("Test case started..");
		
		 driver.findElement(By.xpath("//input[@id='gender-female']")).click();
		 driver.findElement(By.xpath("//input[@id='FirstName']")).sendKeys(pro.getProperty("firstnm"));
		 driver.findElement(By.xpath("//input[@id='LastName']")).sendKeys(pro.getProperty("lastnm"));
		 driver.findElement(By.xpath("//input[@id='Email']")).sendKeys(pro.getProperty("email"));
		 driver.findElement(By.xpath("//input[@id='Password']")).sendKeys(pro.getProperty("pass"));
		 log.warn("Confirm Password..");
		 driver.findElement(By.xpath("//input[@id='ConfirmPassword']")).sendKeys(pro.getProperty("confpass"));
		 driver.findElement(By.xpath("//input[@id='register-button']")).click();
		 log.fatal("Test case ended..");
	}
	

}
