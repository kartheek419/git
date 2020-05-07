package com.testscripts;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.vTigerLogin.base;

public class CreateLeads extends base
{
	/**
	 * This method is used to create Leads
	 */
	@Test
	public void createLeads()
	{
		WebElement wb = null;
		
		//Click on Leads
		driver.findElement(By.linkText("Leads")).click();
		
		//Delete any existing Opportunities with same name if any
		try
		{
		String text = driver.findElement(By.xpath("//a[@title='Leads']")).getText();
		if(lib.getExcelData("Lead Name","Leads").equalsIgnoreCase(text))
		{
		driver.findElement(By.name("selectall")).click();
		driver.findElement(By.xpath("//input[@value='Delete']")).click();
		
		Alert alert = driver.switchTo().alert();
		alert.accept();
		}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		//Click on Create icon
		driver.findElement(By.xpath("//img[@alt = 'Create Lead...']")).click();
		
		//Select suffix
		wb = driver.findElement(By.name("salutationtype"));
		lib.select(wb, lib.getExcelData("suffix","Leads"));
		
		//Enter Lead name
		driver.findElement(By.name("firstname")).sendKeys(lib.getExcelData("First Name","Leads"));
		driver.findElement(By.name("lastname")).sendKeys(lib.getExcelData("Last Name","Leads"));
		
		//Enter the Company
		driver.findElement(By.name("company")).sendKeys(lib.getExcelData("company", "Leads"));
		
		//Select leadsource
		wb = driver.findElement(By.name("leadsource"));
		lib.select(wb, lib.getExcelData("leadsource","Leads"));
		
		//Select industry
		wb = driver.findElement(By.name("industry"));
		lib.select(wb, lib.getExcelData("industry","Leads"));
		
		//Select rating
		wb = driver.findElement(By.name("rating"));
		lib.select(wb, lib.getExcelData("rating","Leads"));
		
		//Select leadstatus
		wb = driver.findElement(By.name("leadstatus"));
		lib.select(wb, lib.getExcelData("leadstatus","Leads"));
		
		try 
		{
			//Enter Address		
			driver.findElement(By.name("lane")).sendKeys(lib.getExcelData("Street","Leads"));
			driver.findElement(By.name("city")).sendKeys(lib.getExcelData("City","Leads"));
			driver.findElement(By.name("state")).sendKeys(lib.getExcelData("State","Leads"));
			driver.findElement(By.name("code")).sendKeys(lib.getExcelData("Code","Leads"));
			driver.findElement(By.name("country")).sendKeys(lib.getExcelData("Country","Leads"));
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	
		//Click Submit
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		System.out.println("Lead got Created Successfully");
	}

}
