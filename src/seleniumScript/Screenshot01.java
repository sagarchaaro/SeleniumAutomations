package seleniumScript;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Screenshot01 
{

	

	public static void main(String[] args) throws IOException, InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium Catalogue\\Drivers\\Chrome\\chromedriver_win32\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver (); 
	
		
		driver.get("https://seleniumtesters-trials6562.orangehrmlive.com/auth/login");
		
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		driver.manage().window().maximize();
		
		SimpleDateFormat st= new SimpleDateFormat("ddMMyyyy hhmmss");
		Date date= new Date();
		String timestamp= st.format(date);
		
		TakesScreenshot t1=(TakesScreenshot)driver;
		File source1=t1.getScreenshotAs(OutputType.FILE);
		File destination1= new File("C:\\Selenium Catalogue\\Documents\\Screenshots\\HRMHome_"+timestamp+".png");
		FileUtils.copyFile(source1, destination1);
		
	
		
		
		//username
		By username= By.xpath("//input[@id='txtUsername']");
		WebElement We1 =driver.findElement(username);
		We1.sendKeys("Admin");
		Thread.sleep(2000);
						
		//password
		By userpassword =By.xpath("//input[@name='txtPassword']");
		WebElement W2=driver.findElement(userpassword);
		W2.sendKeys("Admin@123");
		Thread.sleep(2000);
						
		//login
		By  key = By.xpath("//input[@name='Submit'] [@class='button']");
		WebElement W3= driver.findElement(key);
		W3.click();
		Thread.sleep(9000);
		
		Date date2= new Date();
		File source2= t1.getScreenshotAs(OutputType.FILE);
		File destination2 = new File("C:\\Selenium Catalogue\\Documents\\Screenshots\\loginmainpage_"+timestamp+".png");
		FileUtils.copyFile(source2, destination2);
		
		//pim
		driver.findElement(By.xpath("//span[text ()='PIM']")).click();
		Thread.sleep(2000);
				
		// Click on Employee list
		//driver.findElement(By.xpath("//li[@class='level2 active current']//a/span[2]")).click();
		driver.findElement(By.xpath("(//span[@class='left-menu-title'])[48]")).click();
		
		driver.findElement(By.xpath("//*[@id=\"employeeListTable\"]/tbody/tr[1]/td[2]")).click();
		Thread.sleep(9000);
		
		Date date3= new Date();
		File source3 =t1.getScreenshotAs(OutputType.FILE);
		File destination3= new File("C:\\Selenium Catalogue\\Documents\\Screenshots\\Addemp_"+timestamp+".png");
		FileUtils.copyFile(source3, destination3);
		
		
		
		
		
		System.out.println("good 2 go...");
		
	}

}
