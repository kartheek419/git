package com.testscripts;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.vTigerLogin.base;

public class CreateSalesOrder extends base
{
	
	/**
	 * This method is used to create Sales Order
	 */
	@Test
	public void createSalesOrder()
	{
		
		//Navigate to More
		WebElement wb =driver.findElement(By.xpath("//a[@href='javascript:;']")); 
		lib.navigate(wb,driver);
		//Click on Sales Order
		driver.findElement(By.name("Sales Order")).click();
		//Click on Create icon
		driver.findElement(By.xpath("//img[@alt='Create Sales Order...']")).click();
				
		//Enter the subject name
		driver.findElement(By.name("subject")).sendKeys(lib.getExcelData("Subject Name", "Sales"));
				
		//Select Carrier
		wb = driver.findElement(By.name("carrier"));
		lib.select(wb, lib.getExcelData("Carrier", "Sales"));
				
		//Select Quote name
		driver.findElement(By.xpath("//input[@name='quote_name']/following-sibling::img[@title='Select']")).click();
		lib.actionOnSeperateWindow(driver, lib.getExcelData("Subject Name", "Quote"));
		
		
		//Select Organization
		driver.findElement(By.xpath("//input[@name='account_name']/following-sibling::img[@title='Select']")).click();
		lib.actionOnSeperateWindow(driver, lib.getExcelData("Organization Name", "Organization"));
	
		//Enter the item name
		driver.findElement(By.xpath("//img[@title='Products']")).click();
		lib.actionOnSeperateWindow(driver, lib.getExcelData("Product Name", "Products"));
				
		//Enter the item quantity
		driver.findElement(By.name("qty1")).clear();
		driver.findElement(By.name("qty1")).sendKeys(lib.getExcelData("Item Quantity", "Sales"));
				
		//Enter the item Price
		driver.findElement(By.name("listPrice1")).clear();
		driver.findElement(By.name("listPrice1")).sendKeys(lib.getExcelData("Item Price", "Sales"));
				
		//Click Submit
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
						
		System.out.println("Sales Order got Created Successfully");		
	
	}

}
