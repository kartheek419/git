package com.testscripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

public class Stale {

	@FindBy(name = "user_name")
	static WebElement userName;
	
	public static void main(String[] args) 
	{
	
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost:8888/");
		login(driver);
	
	}
	
	public static void login(WebDriver driver)
	{
		userName.sendKeys("admin");
	}

}
