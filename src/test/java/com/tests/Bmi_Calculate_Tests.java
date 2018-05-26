package com.tests;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.modules.Bmi_Calculate_Functions;

public class Bmi_Calculate_Tests{
	Bmi_Calculate_Functions calculatePage = new Bmi_Calculate_Functions();
	@BeforeTest
	public void setUp()
	{
		calculatePage.launchPage();
	}
	@Test
	public void TC001() throws IOException
	{
//		calculatePage.calculateBMIForMale();
	}
	@AfterTest
	public void tearDown()
	{
		calculatePage.closePage();
	}
}
