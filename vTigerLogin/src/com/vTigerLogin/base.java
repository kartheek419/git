package com.vTigerLogin;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class base 
{
	public Filelib lib = new Filelib();
	public WebDriver driver = null;
	public static WebDriver staticDriver = null;
	@BeforeClass
	public void configBC()
	{
		if(lib.getPropertyValue("browser").equalsIgnoreCase("Chrome"))
		{
			driver = new ChromeDriver();
		}
		else if (lib.getPropertyValue("browser").equalsIgnoreCase("firefox"))
		{
			driver = new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		staticDriver = driver;
		driver.get(lib.getPropertyValue("url"));
		
		driver.findElement(By.name("user_name")).sendKeys(lib.getPropertyValue("UserName"));
		driver.findElement(By.name("user_password")).sendKeys(lib.getPropertyValue("Password"),Keys.ENTER);
	}
	
	@BeforeMethod
	public void configBM()
	{
		//driver.findElement(By.name("user_name")).sendKeys(lib.getPropertyValue("UserName"));
		//driver.findElement(By.name("user_password")).sendKeys(lib.getPropertyValue("Password"),Keys.ENTER);
		
	}

	
	@AfterMethod
	public void configAM()
	{
		//Actions action = new Actions(driver);
		//WebElement wb = driver.findElement(By.className("small"));
		//action.moveToElement(wb).perform();
		
	}
	
	@AfterClass
	public void configAC()
	{
		Actions action = new Actions(driver);
		WebElement wb = driver.findElement(By.className("small"));
		action.moveToElement(wb).perform();
		driver.quit();
	}
}
