package com.testscripts;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.vTigerLogin.base;

public class CreateProductTest extends base
{
	
	createVendorTest cv = new createVendorTest();
	
	/**
	 * This method is used to create Products
	 */
	@Test
	public void products()
	{
		cv.createVendor();
		
		WebElement wb = null;
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		//Navigate to More
//		wb =driver.findElement(By.xpath("//a[@href='javascript:;']")); 
//		lib.navigate(wb,driver);
//		//Click on Vendors
//		driver.findElement(By.name("Vendors")).click();
//		//Click on Create Vendor icon
//		driver.findElement(By.xpath("//img[@alt='Create Vendor...']")).click();
//		//Enter vendor Name
//		driver.findElement(By.name("vendorname")).sendKeys(lib.getExcelData("Vendor Name", "Vendor"));
//		//Click on Save
//		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//Click on Products
		driver.findElement(By.linkText("Products")).click();
		//Click on Create icon
		driver.findElement(By.xpath("//img[@alt = 'Create Product...']")).click();
		//Enter product name
		driver.findElement(By.name("productname")).sendKeys(lib.getExcelData("Product Name", "Products"));
		
		//Select manufacturer
		wb = driver.findElement(By.name("manufacturer"));
		lib.select(wb, lib.getExcelData("Manufacturer", "Products"));
		
		//Select Product Category
		wb = driver.findElement(By.name("productcategory"));
		lib.select(wb, lib.getExcelData("Product Category", "Products"));
		
		//Click on Add vendor icon
		driver.findElement(By.xpath("//img[@alt='Select']")).click();
		
		//Switching between tabs
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> i = windows.iterator();
		String parent = i.next();
		String child = i.next();
		
		//Switch to child tab
		driver.switchTo().window(child);
		
		//Selecting the Vendor
		driver.findElement(By.linkText(lib.getExcelData("Vendor Name", "Vendor"))).click();
		
		//Switch back to parent tab
		driver.switchTo().window(parent);
		
		//Select Quantity in Stock
		driver.findElement(By.id("qtyinstock")).sendKeys(lib.getExcelData("Quantity", "Products"));
		
		//Upload the image
		driver.findElement(By.id("my_file_element")).sendKeys(lib.getExcelData("Image", "Products"));
		
		//Click on Save
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		System.out.println("Test Script Passed");
	}
	
}
