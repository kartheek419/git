package com.testscripts;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.vTigerLogin.base;

public class CreateOppertunities extends base
{
	CreateOrganization co = new CreateOrganization();
	
	/**
	 * This method is used to create Opportunities
	 */
	@Test
	public void createOppertunities()
	{
		co.createOrganization(driver);
		//this.driver=driver;
		
		
		WebElement wb = null;
		
		//Click on Opportunities
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.linkText("Opportunities")).click();
		
		//Delete any existing Opportunities with same name if any
		String text = driver.findElement(By.xpath("//a[@title='Opportunities']")).getText();
		if(lib.getExcelData("Oppertunity Name","Oppertunity").equalsIgnoreCase(text))
		{
		driver.findElement(By.name("selectall")).click();
		driver.findElement(By.xpath("//input[@value='Delete']")).click();
		
		Alert alert = driver.switchTo().alert();
		alert.accept();
		}
		//Click on Create icon
		driver.findElement(By.xpath("//img[@alt = 'Create Opportunity...']")).click();
		//Enter Opportunity name
		driver.findElement(By.name("potentialname")).sendKeys(lib.getExcelData("Oppertunity Name","Oppertunity"));
		
		//Select the Organization
		driver.findElement(By.xpath("//img[@alt='Select']")).click();
		
		//Switching between tabs
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> i = windows.iterator();
		String parent = i.next();
		String child = i.next();
				
		//Switch to child tab
		driver.switchTo().window(child);
				
		//Selecting the Organization
		driver.findElement(By.linkText(lib.getExcelData("Organization Name", "Organization"))).click();
				
		//Switch back to parent tab
		driver.switchTo().window(parent);
		
		//Select opportunity_type
		wb = driver.findElement(By.name("opportunity_type"));
		lib.select(wb, lib.getExcelData("opportunity_type","Oppertunity"));
		
		//Select leadsource
		wb = driver.findElement(By.name("leadsource"));
		lib.select(wb, lib.getExcelData("leadsource","Oppertunity"));
		
		//Select closingdate
		driver.findElement(By.name("closingdate")).sendKeys(lib.getExcelData("closingdate", "Oppertunity"));
		
		//Select sales_stage
		wb = driver.findElement(By.name("sales_stage"));
		lib.select(wb, lib.getExcelData("sales_stage","Oppertunity"));
		
		//Click Submit
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		System.out.println("Oppertunity Created Successfully");
		
		
	}

}
