package com.modules;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;

import com.objects.Bmi_Calculate_Page;
import com.utils.CommonFunction;
import org.openqa.selenium.support.How;

public class Bmi_Calculate_Functions extends Bmi_Calculate_Page{

	CommonFunction com = new CommonFunction();
	public void launchPage()
	{
		com.setUp();
		com.get(URL);
	}
	public void inputAge(String key)
	{
		com.fill(How.XPATH, CALCULATE_TXT_AGE, key);
		com.fill(How.XPATH, CALCULATE_TXT_WEIGHT, key);
		
	}
	public void selectSexMale()
	{
		com.click(How.XPATH, CALCULATE_RADIO_BTN_SEX_MALE);
		
	}
	public void selectSexFemale()
	{
		com.click(How.XPATH, CALCULATE_RADIO_BTN_SEX_FEMALE);
	}
	public void inputHeightFeet(String key)
	{
		com.fill(How.XPATH, CALCULATE_TXT_HEIGHT_FEET, key);
	}
	public void inputHeightInches(String key)
	{
		com.fill(How.XPATH, CALCULATE_TXT_HEIGHT_INCHES, key);
	}
	public void inputWeight(String key)
	{
		com.fill(How.XPATH, CALCULATE_TXT_WEIGHT, key);
	}
	public void clickTheCaculate()
	{
		com.click(How.XPATH, CALCULATE_BTN);
	}
	public void closePage()
	{
		com.closePage();
	}
	WebDriver driver;
	XSSFWorkbook workbook;
	XSSFSheet sheet;
	XSSFCell cell;
	public void calculateBMIForMale() throws IOException
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
			inputAge(cell.getStringCellValue());
			//select male
			selectSexMale();
			//input feet
			cell = sheet.getRow(i).getCell(1);
			cell.setCellType(Cell.CELL_TYPE_STRING);
			inputHeightFeet(cell.getStringCellValue());
			//input inches
			cell = sheet.getRow(i).getCell(2);
			cell.setCellType(Cell.CELL_TYPE_STRING);
			inputHeightInches(cell.getStringCellValue());
			//input weight
			cell = sheet.getRow(i).getCell(3);
			cell.setCellType(Cell.CELL_TYPE_STRING);
			inputWeight(cell.getStringCellValue());
			//click calculate
			clickTheCaculate();
			//equal
			cell = sheet.getRow(i).getCell(4);
			cell.setCellType(Cell.CELL_TYPE_STRING);
			assertEquals(com.getText(How.XPATH, CALCULATE_RESULT),cell.getStringCellValue());
			FileOutputStream fos = new FileOutputStream(src);
			//message to write in Result cell
			String message = "pass";
			//
			sheet.getRow(i).createCell(5).setCellValue(message);
			//finally write content
			workbook.write(fos);
			//close the file
			fos.close();
		}
	}

//	public void calculateBMIForMale(String age, String feet, String inches, String weight)
//	{
//		inputAge(age);
//		selectSexMale();
//		inputHeightFeet(feet);
//		inputHeightInches(inches);
//		inputWeight(weight);
//		clickTheCaculate();
//		getResult();
//	}
//	public void calculateBMIForFemale(String age, String feet, String inches, String weight)
//	{
//		inputAge(age);
//		selectSexFemale();
//		inputHeightFeet(feet);
//		inputHeightInches(inches);
//		inputWeight(weight);
//		clickTheCaculate();
//		getResult();
	

}
