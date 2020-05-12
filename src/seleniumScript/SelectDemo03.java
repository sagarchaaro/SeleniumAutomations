package seleniumScript;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectDemo03
{
	////// list box ....///
	
	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium Catalogue\\Drivers\\Chrome\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver= new ChromeDriver ();
		driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_select_multiple");
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		driver.switchTo().frame("iframeResult");
		WebElement s3=driver.findElement(By.xpath("//select[@name='cars']"));
		Select sc3= new Select(s3);
		
		sc3.selectByIndex(2);
		System.out.println("Opel selected ...");
		Thread.sleep(3000);
		
		sc3.selectByIndex(1);
		System.out.println("Saab selected ...");
		Thread.sleep(3000);
		
		sc3.deselectAll();
		System.out.println("Deselected all value");
		Thread.sleep(3000);
		
		sc3.selectByValue("audi");
		System.out.println("audi is select");
		
		sc3.selectByValue("opel");
		System.out.println("Opel is select");
		
		sc3.selectByVisibleText("Volvo");		
		System.out.println("Volvo is selected");
		Thread.sleep(3000);
		
		sc3.deselectByIndex(3);
		System.out.println("audi out");
		
		sc3.deselectByValue("volvo");
		System.out.println("volvo out");
		
		sc3.deselectByVisibleText("Opel");
		System.out.println("opel out");
		
		boolean boo=sc3.isMultiple();
		if (boo)
		{
			System.out.println("it is multiple");
		}else
		{
			System.out.println("it is not multiple");
		}
		driver.close();
		
		
		
		
		
		
	}
	

}
