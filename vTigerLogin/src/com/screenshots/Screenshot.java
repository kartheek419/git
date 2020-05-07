package com.screenshots;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.vTigerLogin.base;

public class Screenshot extends base
{
	@Test
	public void takeScreenShot() throws IOException
	{
//		WebDriver driver = new ChromeDriver();
//		driver.manage().window().maximize();
//		driver.get("https://www.google.com");
		
		Date d = new Date();
		System.out.println(d);
		String time = d.toString();
		time = time.replace(" ", "").replace(":", "-");
		System.out.println(time);
		
		TakesScreenshot sh =  (TakesScreenshot)driver;
		
		File src = sh.getScreenshotAs(OutputType.FILE);
		
		File dest = new File("./ScreenShots/"+ time + ".png");
		
		FileUtils.copyFile(src, dest);
		
		//driver.close();
	}
	
}