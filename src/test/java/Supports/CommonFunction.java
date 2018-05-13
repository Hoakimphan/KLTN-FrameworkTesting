package Supports;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonFunction{
	private WebDriver driver = null;
	//private static String sBinary;
	private static final String OPERA_BINARY = "C:\\Program Files\\Opera\\52.0.2871.64\\opera.exe";
	private static final String COCCOC_BINARY = "C:\\Users\\Vu\\AppData\\Local\\CocCoc\\Browser\\Application\\browser.exe";
	public static enum DriverType
	{
		CHROME_DRIVER,
		FIREFOX_DRIVER,
		IE_DRIVER,
		EGDE_DRIVER,
		OPERA_DRIVER,
		OPERA_CHROMIUM,
		COCCOC_DRIVER
	}
	public static enum How
	{
		ID,
		NAME,
		XPATH,
		LINK_TEXT,
		PARTIAL_LINK_TEXT,
		TAG_NAME,
		CLASS_NAME,
		CSS_SELECTOR,
	}
	public static enum TypeOfWait
	{
		ALERT_IS_PRESENT,
		ELEMENT_SELECTION_STATE_TO_BE,
		ELEMENT_TO_BE_CLICKABLE,
		ELEMENT_TO_BE_SELECTED,
		FRAME_TO_BE_AVALIABLE_AND_SWITCH_TO_IT,
		INVISIBILITY_OF_THE_ELEMENT_LOCATED,
		INVISIBILITY_OF_ELEMENT_WITH_TEXT,
		//PRESENCE_OF_ALL_ELEMENTS_LOCATED_BY,
		PRESENCE_OF_ELEMENT_LOCATED,
		TEXT_TO_BE_PRESENT_IN_ELEMENT,
		TEXT_TO_BE_PRESENT_IN_ELEMENT_LOCATED,
		TEXT_TO_BE_PRESENT_IN_ELEMENT_VALUE,
		TITLE_IS,
		TITLE_CONTAINS,
		VISIBILITY_OF,
//		VISIBILITY_OF_ALL_ELEMENTS,
//		VISIBILITY_OF_ALL_ELEMENTS_LOCATED_BY,
		VISIBILITY_OF_ELEMENTS_LOCATED
	}
	public CommonFunction(DriverType driverType)
	{
		switch (driverType) {
		case CHROME_DRIVER:
			driver = new ChromeDriver();
			break;
		case FIREFOX_DRIVER:
			driver = new FirefoxDriver();
			break;
		case IE_DRIVER:
			driver = new InternetExplorerDriver();
			break;
		case EGDE_DRIVER:
			driver = new EdgeDriver();
			break;
		case OPERA_DRIVER:
			driver = new OperaDriver();
		case OPERA_CHROMIUM:
			ChromeOptions options = new ChromeOptions();
			options.setBinary(OPERA_BINARY);
			DesiredCapabilities cap = new DesiredCapabilities();
			cap.setCapability(ChromeOptions.CAPABILITY, options);
			OperaDriver driverOpera = new OperaDriver(cap);
			driver = driverOpera;
			break;
		case COCCOC_DRIVER:
			ChromeOptions options2 = new ChromeOptions();
			options2.setBinary(COCCOC_BINARY);
			driver = new ChromeDriver(options2);
		default:
			break;
		}
	}
	public void get(String url) {
		driver.get(url);
	}	
	public WebElement getElement (How how, String locator)
	{
		//how = how.toLowerCase();
		switch (how) {
		case ID:
			return driver.findElement(By.id(locator));
		case NAME:
			return driver.findElement(By.name(locator));
		case XPATH:
			return driver.findElement(By.xpath(locator));
		case LINK_TEXT:
			return driver.findElement(By.linkText(locator));
		case PARTIAL_LINK_TEXT:
			return driver.findElement(By.partialLinkText(locator));
		case TAG_NAME:
			return driver.findElement(By.tagName(locator));
		case CLASS_NAME:
			return driver.findElement(By.className(locator));
		case CSS_SELECTOR:
			return driver.findElement(By.cssSelector(locator));
		default:
			return null;
		}
	}
	//click function
	public void click(How how, String locator)
	{
		getElement(how, locator).click();
	}
//	public void wait(String elementName, String locator)
//	{
//		try
//		{
////			WebDriverWait wait = new WebDriverWait(driver, 20);
////			WebElement txtElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
//			WebElement txtElement = (new WebDriverWait(driver, 20)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
//			System.out.println("Click successfully!!!" + elementName);
//		}
//		catch (Exception e) {
//			System.out.println("Could not click on " + elementName);
//			   throw (e);
//		}
//	}
	//send text function
	public void fill(How how, String locator, String text)
	{
		getElement(how, locator).sendKeys(text);
	}
	public void getText(How how, String locator)
	{
		getElement(how, locator).getText();
	}
	//scroll function
	public void scrollDownByPixel(double x, double y)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(" + x + "," + y + ")");
	}
	public void scrollByElement(How how, String locator)//using for scroll vertical and horizontal by element
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement element = getElement(how, locator);
		js.executeScript("arguments[0].scrollIntoView();", element);
	}
	public void scrollDownToBottom()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
	}
	public void scrollUptoOnTop()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(document.body.scrollHeight,0)");
	}
	//
//	public ExpectedConditions caculateExpectedCondidtion(TypeOfWait typeOfWait, How how, String locator)
//	{
//		switch(typeOfWait)
//		{
//		case VISIBILITY_OF_ELEMENTS_LOCATED:
//			//return ExpectedConditions.visibilityOfElementLocated(how, locator);
//		}
//		return null;
//	}
//	//wait function
//	public void waitForElement(How how, String locator, long timeOutDefault)
//	{
//		//new WebDriverWait(driver, timeOutDefault).until(ExpectedConditions.visibilityOfElementLocated(how,locator));
//		
//	}


//	public void input(How how, String locator, String textInput)
//	{
//		new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOfElementLocated(By));
//		getElement(how, locator).clear();
//		getElement(how, locator).sendKeys(textInput);
//		
//	}
}
