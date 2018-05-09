package Modules;

import Supports.CommonFunction;

public class GOOGLE_Modules extends CommonFunction {
	public static String BASE_URL = "https://www.google.com/";
	public static String SEARCH_TXT_XP = "//*[@id=\"lst-ib\"]";
	public static String CLICK_SEARCH_RESULT = "//*[@id=\"rso\"]/div[1]/div/div/div/div/h3/a";
	public static String TITLE = "//*[@id=\"mainContent\"]/h2[1]";

	CommonFunction com = new CommonFunction(DriverType.CHROME_DRIVER);
	public GOOGLE_Modules(DriverType driverType) {
		super(driverType);
		// TODO Auto-generated constructor stub
	}
	public void searchByKeyWord(String key)
	{
		com.get(BASE_URL);
		com.fill(How.XPATH, SEARCH_TXT_XP, key);
		com.getElement(How.XPATH, SEARCH_TXT_XP).submit();	
	}
	public void clickTheResult()
	{
		com.click(How.XPATH, CLICK_SEARCH_RESULT);
	}
	public void getTitle()
	{
		com.getText(How.XPATH, TITLE);
	}

}
