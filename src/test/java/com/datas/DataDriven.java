package com.datas;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import org.openqa.selenium.WebDriver;

import com.modules.Bmi_Calculate_Functions;
import com.utils.CommonFunction;
import org.openqa.selenium.support.How;

public class DataDriven {
	WebDriver driver;
	XSSFWorkbook workbook;
	XSSFSheet sheet;
	XSSFCell cell;
	Bmi_Calculate_Functions f= new Bmi_Calculate_Functions();
	CommonFunction com = new CommonFunction();
	public void ReadData() throws IOException
	{
		File src = new File("/FrameworkAutoTest/src/test/resources/Data/DataTest.xlsx");
		FileInputStream fis = new FileInputStream(src);
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheet("Sheet1");
		for(int i=1; i<=sheet.getLastRowNum();i++)
		{
			//input age
			cell=sheet.getRow(i).getCell(0);
			cell.setCellType(Cell.CELL_TYPE_STRING);
			f.inputAge(cell.getStringCellValue());
			//select male
			f.selectSexMale();
			//input feet
			cell = sheet.getRow(i).getCell(1);
			cell.setCellType(Cell.CELL_TYPE_STRING);
			f.inputHeightFeet(cell.getStringCellValue());
			//input inches
			cell = sheet.getRow(i).getCell(2);
			cell.setCellType(Cell.CELL_TYPE_STRING);
			f.inputHeightInches(cell.getStringCellValue());
			//input weight
			cell = sheet.getRow(i).getCell(3);
			cell.setCellType(Cell.CELL_TYPE_STRING);
			f.inputWeight(cell.getStringCellValue());
			//click calculate
			f.clickTheCaculate();
			//get result
			
			//equal
			//assertEquals(com.getText(How.XPATH, CALCULATE_RESULT), expected);
			
		}
	}

}
