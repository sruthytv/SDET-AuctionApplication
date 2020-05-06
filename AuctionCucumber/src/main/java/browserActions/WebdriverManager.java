package browserActions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebdriverManager {
	public static WebDriver driver;
public static WebDriver setupBrowser() {
	String driverPath= System.getProperty("user.dir")+"//drivers//chromedriver.exe";
	System.setProperty("webdriver.chrome.driver", driverPath);
	// Create object of ChromeOptions class
	ChromeOptions options = new ChromeOptions();
	 
	// add parameter which will disable the extension
	options.addArguments("--disable-extensions");
	driver = new ChromeDriver(options);
	
	driver.manage().window().maximize();
	return driver;
}
public static void closeDriver() {
	driver.close();
	driver.quit();
}
}
