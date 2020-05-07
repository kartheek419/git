package com.testscripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.vTigerLogin.base;

public class CreateInvoice extends base
{
	/**
	 * This method is used to create the invoice
	 */
	@Test
	public void createInvoice()
	{
		
		//Navigate to More
		WebElement wb =driver.findElement(By.xpath("//a[@href='javascript:;']")); 
		lib.navigate(wb,driver);
		//Click on Invoice
		driver.findElement(By.name("Invoice")).click();
		//Click on Create icon
		driver.findElement(By.xpath("//img[@alt='Create Invoice...']")).click();
						
		//Enter the subject name
		driver.findElement(By.name("subject")).sendKeys(lib.getExcelData("Subject Name", "Invoice"));
						
		//Select Sales name
		driver.findElement(By.xpath("//input[@name='salesorder_name']/following-sibling::img[@title='Select']")).click();
		lib.actionOnSeperateWindow(driver, lib.getExcelData("Subject Name", "Sales"));
				
				
		//Select Organization
		driver.findElement(By.xpath("//input[@name='account_name']/following-sibling::img[@title='Select']")).click();
		lib.actionOnSeperateWindow(driver, lib.getExcelData("Organization Name", "Organization"));
			
		//Enter the item name
		driver.findElement(By.xpath("//img[@title='Products']")).click();
		lib.actionOnSeperateWindow(driver, lib.getExcelData("Product Name", "Products"));
						
		//Enter the item quantity
		driver.findElement(By.name("qty1")).clear();
		driver.findElement(By.name("qty1")).sendKeys(lib.getExcelData("Item Quantity", "Invoice"));
						
		//Enter the item Price
		driver.findElement(By.name("listPrice1")).clear();
		driver.findElement(By.name("listPrice1")).sendKeys(lib.getExcelData("Item Price", "Invoice"));
						
		//Click Submit
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
								
		System.out.println("Invoice got Created Successfully");		
	}

}
