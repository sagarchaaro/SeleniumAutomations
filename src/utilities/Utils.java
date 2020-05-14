package utilities;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;

public class Utils {
	private static WebDriver driver;
	public static WebDriver openBrowser(String browser) throws Exception{
		if(browser.equalsIgnoreCase("chrome")){
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--incognito");
			options.addArguments("--disable-popup-blocking");
			options.addArguments("--disable-infobars");
			options.addArguments("--ignore-certificate-errors");
			System.setProperty("webdriver.chrome.driver","C:\\Selenium Catalogue\\Drivers\\Chrome\\chromedriver_win32\\chromedriver.exe");
			driver =new ChromeDriver(options);
			Log.info("Chrome browser is launched");
		}else if(browser.equalsIgnoreCase("firefox") || browser.equalsIgnoreCase("ff")){
			System.setProperty("webdriver.gecko.driver", "C:\\Selenium Catalogue\\Drivers\\FF\\geckodriver\\geckodriver.exe");
			driver= new FirefoxDriver();
			Log.info("Firefox browser is launched");
		}else if(browser.equalsIgnoreCase("ie") || browser.equalsIgnoreCase("internet explorer")){
			System.setProperty("webdriver.ie.driver", "C:\\Selenium Catalogue\\Drivers\\IE\\IEDriverServer\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			Log.info("IE browser is launched");
		}else if(browser.equalsIgnoreCase("edge")){
			System.setProperty("webdriver.edge.driver", "C:\\Selenium Catalogue\\Drivers\\Edge\\edgedriver_win32\\msedgedriver.exe");
			driver = new EdgeDriver();
			Log.info("Edge Driver is launched");
		}else if(browser.equalsIgnoreCase("opera")){
			System.setProperty("webdriver.opera.driver", "C:\\Selenium Catalogue\\Drivers\\Opera\\operadriver_win64\\operadriver.exe");
			driver = new OperaDriver();
			Log.info("Opera brower is launched");
		}else{
			Log.info("Browser name is Invalid");
			throw new Exception();
		}
		
		driver.manage().window().maximize();
		Log.info("Browser is maximized");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Log.info("Implicit wait is applied on driver object with 20 seconds");

		return driver;
	}
	
	public static void closeDriver(WebDriver driver){
		driver.quit();
		Log.info("Driver object is closed");
	}
	
	public static void takeScreenshot(String filename, String screenshotPath) throws Exception{
		TakesScreenshot ts= (TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		File dest=new File(screenshotPath+"\\"+filename+".jpg");
		FileUtils.copyFile(src, dest);
		
	}
	
	public static String timeStamp(String format){
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		Date date= new Date();
		String timestamp=sdf.format(date);
		return timestamp;
	}
	
	public static String createFolder(){
		String projectPath = System.getProperty("user.dir");
		String timeStampFormat="dd-MMM-yyy hh-mm-ss";
		String reportPath=projectPath+"\\Reports\\"+Utils.timeStamp(timeStampFormat);
	
		File file = new File(reportPath);
		file.mkdir();
		Log.info("Folder is Created with the Name :"+timeStampFormat);
		return reportPath;
	}
}
