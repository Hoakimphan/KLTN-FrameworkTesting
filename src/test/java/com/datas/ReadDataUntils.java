package com.datas;

import java.io.IOException;

public class ReadDataUntils {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		getDataFromExcel data = new getDataFromExcel("D:\\Auto_Test\\DataTest.xlsx");
			System.out.println(data.readData("Sheet1", "Age", 1));
		

	}

}
