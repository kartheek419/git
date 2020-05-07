package com.testscripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.vTigerLogin.base;

public class CreateOrganization extends base
{
	/*public CreateOrganization()
	{
		this.driver = driver;
	}*/
	
	/**
	 * This method is used to create Organizations
	 * @param driver
	 */
	@Test
	public void createOrganization(WebDriver driver)
	{
		
		
		WebElement wb = null;
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//Click on Organizations
		driver.findElement(By.linkText("Organizations")).click();
		
		//delete any existing Organizations with same name if any
//		String text = driver.findElement(By.xpath("//a[@title='Organizations']")).getText();
//		if(lib.getExcelData("Organization Name","Organization").equalsIgnoreCase(text))
//		{
//		driver.findElement(By.name("selectall")).click();
//		driver.findElement(By.xpath("//input[@value='Delete']")).click();
//		
//		Alert alert = driver.switchTo().alert();
//		alert.accept();
//		}
//		//Click on Create icon
		driver.findElement(By.xpath("//img[@alt = 'Create Organization...']")).click();
		//Enter product name
//		driver.findElement(By.name("accountname")).sendKeys(lib.getExcelData("Organization Name","Organization"));
//		
//		//Select industry
//		wb = driver.findElement(By.name("industry"));
//		lib.select(wb, lib.getExcelData("industry","Organization"));
//		
//		//Select rating
//		wb = driver.findElement(By.name("rating"));
//		lib.select(wb, lib.getExcelData("rating","Organization"));
//		
//		//Select accounttype
//		wb = driver.findElement(By.name("accounttype"));
//		lib.select(wb, lib.getExcelData("accounttype","Organization"));
//				
//		//Enter Billing Address		
//		driver.findElement(By.name("bill_street")).sendKeys(lib.getExcelData("Billing Street","Organization"));
//		driver.findElement(By.name("bill_city")).sendKeys(lib.getExcelData("Billing City","Organization"));
//		driver.findElement(By.name("bill_state")).sendKeys(lib.getExcelData("Billing State","Organization"));
//		driver.findElement(By.name("bill_code")).sendKeys(lib.getExcelData("Billing Code","Organization"));
//		driver.findElement(By.name("bill_country")).sendKeys(lib.getExcelData("Billing Country","Organization"));
//		
//		if(lib.getExcelData("Shipping Address","Organization").equalsIgnoreCase("same"))
//		{
//			driver.findElement(By.xpath("//b[text()='Copy Billing address']/../input")).click();
//		}
//		
//		else
//		{
//			//Enter Shipping Address		
//			driver.findElement(By.name("ship_street")).sendKeys(lib.getExcelData("Shiping Street","Organization"));
//			driver.findElement(By.name("ship_city")).sendKeys(lib.getExcelData("Shiping City","Organization"));
//			driver.findElement(By.name("ship_state")).sendKeys(lib.getExcelData("Shiping State","Organization"));
//			driver.findElement(By.name("ship_code")).sendKeys(lib.getExcelData("Shiping Code","Organization"));
//			driver.findElement(By.name("ship_country")).sendKeys(lib.getExcelData("Shiping Country","Organization"));
//		}
//		
//		//Click on Save
//		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	}
}
