package utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;

public class Utils 
{
	public static WebDriver openBrowser(String browser) throws Exception
	{
		WebDriver driver;
		
		if(browser.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver",
					"C:\\Selenium Catalogue\\Drivers\\Chrome\\chromedriver_win32\\chromedriver.exe");
			driver= new ChromeDriver();
			System.out.println("Chrome browser is launched.");
			
		}else if(browser.equalsIgnoreCase("firefox") || browser.equalsIgnoreCase("ff"))
		{
			System.setProperty("webdriver.gecko.driver", "C:\\Selenium Catalogue\\Drivers\\FireFox\\geckodriver-v0.26.0-win64\\geckodriver.exe");
			driver= new FirefoxDriver();
			System.out.println("Firefox browser is launched.");
			
		}else if (browser.equalsIgnoreCase("internet explorer") || browser.equalsIgnoreCase("ie")) {
			System.setProperty("webdriver.ie.driver", "C:\\Selenium Catalogue\\Drivers\\IE\\IEDriverServer_Win32_3.141.59\\IEDriverServer.exe");
			driver= new InternetExplorerDriver();
			System.out.println("IE browser is launched.");
			
		}else if (browser.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.edge.driver", "C:\\Selenium Catalogue\\Drivers\\Edge\\edgedriver_win32\\msedgedriver.exe");
			driver= new EdgeDriver();
			System.out.println("Edge browser is launched.");
			
		}else if (browser.equalsIgnoreCase("opera")) {
			System.setProperty("webdriver.opera.driver", "C:\\Selenium Catalogue\\Drivers\\Opera\\operadriver_win64\\operadriver_win64\\operadriver.exe");
			driver= new OperaDriver();
			System.out.println("Opera browser is launched.");
		}else {
			System.out.println("Browser name is not correct.");
			throw  new Exception();
		}
		
		driver.manage().window().maximize();
		System.out.println("Window is maximized.");
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		System.out.println("ImplicitlyWait is applied.");
		
		return driver;
	}

	public static void closeBrowser(WebDriver driver) {
		driver.close();
		System.out.println("Browser is closed. ");
	}
}
