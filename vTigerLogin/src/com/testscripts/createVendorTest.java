package com.testscripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.vTigerLogin.base;

public class createVendorTest extends base
{

	/**
	 * This method is used to create Vendors
	 */
	@Test
	public void createVendor()
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//Navigate to More
		WebElement wb =driver.findElement(By.xpath("//a[@href='javascript:;']")); 
		lib.navigate(wb,driver);
		//Click on Vendors
		driver.findElement(By.name("Vendors")).click();
		Reporter.log("Clicked on Vendors", true);
		//Click on Create Vendor icon
		driver.findElement(By.xpath("//img[@alt='Create Vendor...']")).click();
		Reporter.log("Clicked on Create Vendors", true);
		//Enter vendor Name
		driver.findElement(By.name("vendorname")).sendKeys(lib.getExcelData("Vendor Name", "Vendor"));
		Reporter.log("Vendors name entered", true);
		//Assert.assertTrue(false);
		//Click on Save
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		Reporter.log("New Vendor submitted", true);
		
	}
}
