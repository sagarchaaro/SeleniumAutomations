package seleniumScript;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RobotDemo 
{

	public static void main(String[] args) throws AWTException, Throwable 
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium Catalogue\\Drivers\\Chrome\\chromedriver_win32\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver (); 
	
		
		driver.get("https://seleniumtesters-trials6562.orangehrmlive.com/auth/login");
		
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		driver.manage().window().maximize();
		
		Robot ro= new Robot();
		ro.keyPress(KeyEvent.VK_TAB);
		ro.keyRelease(KeyEvent.VK_TAB);
		Thread.sleep(3000);
		// username
		ro.keyPress(KeyEvent.VK_A);
		ro.keyRelease(KeyEvent.VK_A);
		
		ro.keyPress(KeyEvent.VK_D);
		ro.keyRelease(KeyEvent.VK_D);
		
		ro.keyPress(KeyEvent.VK_M);
		ro.keyRelease(KeyEvent.VK_M);
		
		ro.keyPress(KeyEvent.VK_I);
		ro.keyRelease(KeyEvent.VK_I);
		
		ro.keyPress(KeyEvent.VK_N);
		ro.keyRelease(KeyEvent.VK_N);
		
		// passsword
		ro.keyPress(KeyEvent.VK_TAB);
		ro.keyRelease(KeyEvent.VK_TAB);
		
		ro.keyPress(KeyEvent.VK_A);
		ro.keyRelease(KeyEvent.VK_A);
		
		ro.keyPress(KeyEvent.VK_D);
		ro.keyRelease(KeyEvent.VK_D);
		
		ro.keyPress(KeyEvent.VK_M);
		ro.keyRelease(KeyEvent.VK_M);
		
		ro.keyPress(KeyEvent.VK_I);
		ro.keyRelease(KeyEvent.VK_I);
		
		ro.keyPress(KeyEvent.VK_N);
		ro.keyRelease(KeyEvent.VK_N);
		
		ro.keyPress(KeyEvent.VK_AT);
		ro.keyRelease(KeyEvent.VK_AT);
		
		ro.keyPress(KeyEvent.VK_1);
		ro.keyRelease(KeyEvent.VK_1);
		
		ro.keyPress(KeyEvent.VK_2);
		ro.keyRelease(KeyEvent.VK_2);
		
		ro.keyPress(KeyEvent.VK_3);
		ro.keyRelease(KeyEvent.VK_3);
		
		ro.mousePress(MouseEvent.BUTTON1); 
		ro.mouseRelease(MouseEvent.BUTTON1);

		
		System.out.println("good ");
		
		

	}

}
