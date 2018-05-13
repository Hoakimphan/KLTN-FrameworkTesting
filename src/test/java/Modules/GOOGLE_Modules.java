package Modules;

import Objects.GOOGLE_Objects;
import Supports.CommonFunction;
import Supports.CommonFunction.DriverType;
import Supports.CommonFunction.How;

public class GOOGLE_Modules extends GOOGLE_Objects{
	CommonFunction com = new CommonFunction(DriverType.CHROME_DRIVER);
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
