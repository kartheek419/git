package com.testscripts;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.vTigerLogin.base;

public class CreateQuotation extends base
{
	
	/**
	 * This method is used to create Quotations
	 */
	@Test
	public void createQuotation()
	{
		//Navigate to More
		WebElement wb =driver.findElement(By.xpath("//a[@href='javascript:;']")); 
		lib.navigate(wb,driver);
		//Click on Quotes
		driver.findElement(By.name("Quotes")).click();
		//Click on Create icon
		driver.findElement(By.xpath("//img[@alt='Create Quote...']")).click();
		
		//Enter the subject name
		driver.findElement(By.name("subject")).sendKeys(lib.getExcelData("Subject Name", "Quote"));
		
		//Select Carrier
		wb = driver.findElement(By.name("carrier"));
		lib.select(wb, lib.getExcelData("Carrier", "Quote"));
		
		//Select Quote Stage
		wb = driver.findElement(By.name("quotestage"));
		lib.select(wb, lib.getExcelData("Quote stage", "Quote"));
		
		//Select Organization
		driver.findElement(By.xpath("//input[@name='account_name']/following-sibling::img[@title='Select']")).click();
		
		//Switch between window
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> i = windows.iterator();
		String parent = i.next();
		String child = i.next();
		
		driver.switchTo().window(child);
		
		driver.findElement(By.linkText(lib.getExcelData("Organization Name", "Organization"))).click();
		
		Alert alert = driver.switchTo().alert();
		alert.accept();
		
		driver.switchTo().window(parent);
		
		//Enter the item name
		driver.findElement(By.xpath("//img[@title='Products']")).click();
		
		Set<String> windows2 = driver.getWindowHandles();
		Iterator<String> j = windows2.iterator();
		parent = j.next();
		child = j.next();
		
		driver.switchTo().window(child);
		
		driver.findElement(By.linkText(lib.getExcelData("Product Name", "Products"))).click();
		
		driver.switchTo().window(parent);
		
		//Enter the item quantity
		driver.findElement(By.name("qty1")).sendKeys(lib.getExcelData("Item Quantity", "Quote"));
		
		//Enter the item Price
		driver.findElement(By.name("listPrice1")).clear();
		driver.findElement(By.name("listPrice1")).sendKeys(lib.getExcelData("Item Price", "Quote"));
		
		//Click Submit
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
				
		System.out.println("Quote got Created Successfully");
		
	}

}
