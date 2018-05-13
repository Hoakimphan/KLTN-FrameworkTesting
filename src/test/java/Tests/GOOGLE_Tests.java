package Tests;

import org.testng.annotations.Test;

import Modules.GOOGLE_Modules;

public class GOOGLE_Tests extends BaseTest {
	GOOGLE_Modules mol = new GOOGLE_Modules();
	@Test
	public void TC001()
	{
		mol.searchByKeyWord("selenium");
		mol.clickTheResult();
		mol.getTitle();
	}
}
