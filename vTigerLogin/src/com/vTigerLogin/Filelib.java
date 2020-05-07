package com.vTigerLogin;

import java.io.FileInputStream;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;


public class Filelib 
{
	Properties prop = null;
	public WebDriver driver = null;
	
	/***
	 * This method is used to get the value of the key from the properties file
	 * @param Key
	 * @return value
	 */
	public String getPropertyValue(String key)
	{
		try
		{
		FileInputStream ip = new FileInputStream("./testdata\\commonData.properties");
		prop = new Properties();
		prop.load(ip);
		}
		catch (Exception e) {
		}
		
		return prop.getProperty(key);
		
		
	}
	
	/**
	 * This method is used to get the data form the excel sheet based on the header of the column and the sheet name
	 * @param Key
	 * @param Sheet
	 * @return data
	 */

	public String getExcelData(String Key, String Sheet)
	{
		String data = null;
		try
		{
		FileInputStream ip = new FileInputStream("C:\\Users\\Kartheek\\Desktop\\Selenium\\VtigerInputs.xlsx");
		
		Workbook wb = WorkbookFactory.create(ip);
		
		Sheet sh = wb.getSheet(Sheet);
		
		Row r = sh.getRow(0);
		
		int lastcell = r.getLastCellNum();
		
			for(int i=0; i< lastcell; i++)
			{
				
				if(r.getCell(i).getStringCellValue().equalsIgnoreCase(Key))
				{
					if(sh.getRow(1).getCell(i).getCellType()== CellType.STRING)
					{
						data = sh.getRow(1).getCell(i).getStringCellValue();
						return data;
					}
					else if(sh.getRow(1).getCell(i).getCellType()== CellType.NUMERIC) 
					{
						data = String.valueOf(sh.getRow(1).getCell(i).getNumericCellValue());
						return data;
					}
					
				}
			}
		
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return data;
	}
	
	/**
	 * This method is used to navigate to the particular web element
	 * @param element
	 * @param driver
	 */
	public void navigate(WebElement element, WebDriver driver)
	{
		Actions action = new Actions(driver);
		action.moveToElement(element).perform();
		
	}
	
	/**
	 * This method is used to select the web element based on index
	 * @param wb
	 * @param index
	 */
	public void select(WebElement wb, int index)
	{
		Select sel = new Select(wb);
		sel.selectByIndex(index);
	}
	/**
	 * This method is used to select the web element based on value
	 * @param wb
	 * @param Value
	 */
	public void select(WebElement wb, String Value)
	{
		Select sel = new Select(wb);
		sel.selectByValue(Value);
	}
	
	/**
	 * This method is used to select the web element based on Visibletext
	 * @param Visibletext
	 * @param wb
	 */

	public void select(String Visibletext, WebElement wb)
	{
		Select sel = new Select(wb);
		sel.selectByVisibleText(Visibletext);
	}
	
	/**
	 * This method is used to navigate to other window and perform action on that window
	 * @param driver
	 * @param data
	 */
	public void actionOnSeperateWindow(WebDriver driver, String data)
	{
		//Switch between window
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		System.out.println(data);
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> i = windows.iterator();
		String parent = i.next();
		String child = i.next();
								
		driver.switchTo().window(child);
								
		driver.findElement(By.linkText(data)).click();
			
		try
		{
		Alert alert = driver.switchTo().alert();
		alert.accept();
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		driver.switchTo().window(parent);
	}
	
//	public boolean validateField(WebElement element, String key, String Sheet, String elementName)
//	{
//		String var = getExcelData(key, Sheet);
//		
//		if(var.equalsIgnoreCase(elementName))
//		
//		return element.isDisplayed();
//		
//	}
}
