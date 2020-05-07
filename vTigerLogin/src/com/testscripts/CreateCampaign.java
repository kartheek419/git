package com.testscripts;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.vTigerLogin.base;

public class CreateCampaign extends base
{
	@Test
	public void createCampaign()
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//Navigate to More
		WebElement wb =driver.findElement(By.xpath("//a[@href='javascript:;']")); 
		lib.navigate(wb,driver);
		//Click on Campaigns
		driver.findElement(By.name("Campaigns")).click();
		//Click on Create Campaign icon
		driver.findElement(By.xpath("//img[@alt='Create Campaign...']")).click();
		//Enter Campaign Name
		driver.findElement(By.name("campaignname")).sendKeys(lib.getExcelData("Campaign Name", "Campaign"));
		
		//Select campaign status
		wb = driver.findElement(By.name("campaignstatus"));
		lib.select(wb, lib.getExcelData("Campaignstatus","Campaign"));
				
		//Select campaign type
		wb = driver.findElement(By.name("campaigntype"));
		lib.select(wb, lib.getExcelData("campaigntype","Campaign"));
				
		//Enter closing date
		driver.findElement(By.name("closingdate")).sendKeys(lib.getExcelData("closingdate","Campaign"));
				
		//Click on Save
		driver.findElement(By.xpath("//input[@type='submit']")).click();
	}

}
