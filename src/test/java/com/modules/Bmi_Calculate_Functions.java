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

import com.datas.getDataFromExcel;
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
	public void Age(String key)
	{
		com.fill(How.XPATH, CALCULATE_TXT_AGE, key);
		com.fill(How.XPATH, CALCULATE_TXT_WEIGHT, key);
		
	}
	public void genderMale()
	{
		com.click(How.XPATH, CALCULATE_RADIO_BTN_SEX_MALE);
		
	}
	public void genderFemale()
	{
		com.click(How.XPATH, CALCULATE_RADIO_BTN_SEX_FEMALE);
	}
	public void HeightFeet(String key)
	{
		com.fill(How.XPATH, CALCULATE_TXT_HEIGHT_FEET, key);
	}
	public void HeightInches(String key)
	{
		com.fill(How.XPATH, CALCULATE_TXT_HEIGHT_INCHES, key);
	}
	public void Weight(String key)
	{
		com.fill(How.XPATH, CALCULATE_TXT_WEIGHT, key);
	}
	public void Caculate()
	{
		com.click(How.XPATH, CALCULATE_BTN);
	}
	public void closePage()
	{
		com.closePage();
	}
	public void getDataBMIFromExcel(String sheetName, String colName, int rowIn) throws IOException
	{
		getDataFromExcel getData = new getDataFromExcel("D:\\Auto_Test\\DataTest.xlsx");
		getData.readData("Sheet1", "Age", 1);
	}
	
	

}
