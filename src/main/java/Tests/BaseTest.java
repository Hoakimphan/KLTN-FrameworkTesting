package Tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import Supports.CommonFunction;

public class BaseTest extends CommonFunction {
	public BaseTest(DriverType driverType) {
		super(driverType);
		// TODO Auto-generated constructor stub
	}
	public WebDriverWait wait;
	public WebDriver driver;
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
	@AfterClass
	public void quitTest()
	{
		driver.quit();
	}

}
