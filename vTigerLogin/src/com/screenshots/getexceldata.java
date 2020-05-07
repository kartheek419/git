package com.screenshots;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class getexceldata 
{
	public static void main(String[] args) throws Exception 
	{
		getExceldata();
		
	}
	
	public static Object[][] getExceldata() throws Exception
	{
		String data = null;
		
		FileInputStream ip = new FileInputStream("C:\\Users\\Kartheek\\Desktop\\Selenium\\VtigerInputs.xlsx");
		
		Workbook wb = WorkbookFactory.create(ip);
		
		Sheet sh = wb.getSheet("Products");
		
		
		int r = sh.getLastRowNum();
		
		int c = sh.getRow(0).getLastCellNum();
		
		Object[][] data1 = new Object[r][c];
		
		
			for(int i=1; i<= r; i++)
			{
				for(int j = 0; j<c; j++)
				{
					System.out.println(i);
					System.out.println(j);
					data1[i-1][j]=(sh.getRow(i).getCell(j).getStringCellValue());
					System.out.println(data1[i-1][j]);
				}
			}
				
		return data1;
	}

}
