package Tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Modules.GOOGLE_Modules;
import Supports.CommonFunction;

public class GOOGLE_Tests extends GOOGLE_Modules {
	public WebDriverWait wait;
	public WebDriver driver;
	GOOGLE_Modules mol = new GOOGLE_Modules(DriverType.CHROME_DRIVER);
	@BeforeClass
	public void setUp()
	{
		System.setProperty("webdriver.chrome.driver", "D:\\SeleniumWebdriver\\ChromeDriver\\chromedriver.exe");
		CommonFunction com = new CommonFunction(CommonFunction.DriverType.CHROME_DRIVER);
		//wait for load
		wait = new WebDriverWait(driver, 15);
		//maximize windows
		driver.manage().window().maximize();	
	}
	public GOOGLE_Tests(DriverType driverType) {
		super(driverType);
		// TODO Auto-generated constructor stub
	}
	@Test
	public void TC001()
	{
		mol.searchByKeyWord("selenium");
		mol.clickTheResult();
		mol.getTitle();
	}
	@AfterClass
	public void quitTest()
	{
		driver.quit();
	}
}
