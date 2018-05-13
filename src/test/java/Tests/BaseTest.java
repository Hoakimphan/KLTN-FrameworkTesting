package Tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import Supports.CommonFunction;
import Supports.CommonFunction.DriverType;

public class BaseTest{
	public WebDriverWait wait;
	public WebDriver driver;
	@BeforeClass
	public void setUp()
	{
		System.setProperty("webdriver.chrome.driver", "D:\\SeleniumWebdriver\\ChromeDriver\\chromedriver.exe");
		CommonFunction com = new CommonFunction(DriverType.CHROME_DRIVER);
		//wait for load
		wait = new WebDriverWait(driver, 15);
		//maximize windows
		driver.manage().window().maximize();
		
	}
	@AfterClass
	public void quitTest()
	{
		driver.quit();
	}

}
