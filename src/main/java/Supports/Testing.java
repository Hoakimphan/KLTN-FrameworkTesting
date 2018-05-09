package Supports;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Supports.CommonFunction.How;

public class Testing {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "D:\\SeleniumWebdriver\\ChromeDriver\\chromedriver.exe");
		//System.setProperty("webdriver.opera.driver", "D:\\OperaDriver\\operadriver.exe");
		//System.setProperty("webdriver.chrome.driver", "D:\\chrome\\chromedriver.exe");
//		ChromeOptions options = new ChromeOptions();
//	options.setBinary("C:\\Program Files\\Opera\\52.0.2871.64\\opera.exe");
		
//		DesiredCapabilities cap = new DesiredCapabilities();
//		cap.setCapability(ChromeOptions.CAPABILITY, options);
		WebDriver driver = new ChromeDriver();
//		CommonFunction com = new CommonFunction(CommonFunction.DriverType.CHROME_DRIVER);
//		com.get("http://www.google.com");
//		com.fill(How.XPATH, "//*[@id=\"lst-ib\"]", "abc");
		//implicit wait'
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//explicit wait
		WebDriverWait wait = new WebDriverWait(driver, 20);
		driver.get("http://demo.guru99.com/test/guru99home/");
		driver.manage().window().maximize();
		//driver.findElement(By.xpath("//*[@id=\"rt-header\"]/div/div[2]/div/ul/li[6]/a")).click();
		WebElement guru99 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"rt-header\"]/div/div[2]/div/ul/li[6]/a")));
		guru99.click();
		//PageFactory.
		

	}

}
