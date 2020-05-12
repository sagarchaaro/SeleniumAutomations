package seleniumScript;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Demo02 
{

	public static void main(String[] args) throws Throwable 
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium Catalogue\\Drivers\\Chrome\\chromedriver_win32\\chromedriver.exe");
		
		WebDriver driver= new ChromeDriver ();
		
		driver.get("https://seleniumtesters-trials6562.orangehrmlive.com/auth/login");
		
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		driver.manage().window().maximize();
		//username
		By username= By.xpath("//input[@id='txtUsername']");
		WebElement W1 =driver.findElement(username);
		W1.sendKeys("Admin");
		//Thread.sleep(2000);
		
		//password
		By userpassword =By.xpath("//input[@name='txtPassword']");
		WebElement W2=driver.findElement(userpassword);
		W2.sendKeys("Admin@123");
		//Thread.sleep(2000);
		
		//login
		By  key = By.xpath("//input[@name='Submit'] [@class='button']");
		WebElement W3= driver.findElement(key);
		W3.click();
		
		//pim
		driver.findElement(By.xpath("//span[text ()='PIM']")).click();
		Thread.sleep(2000);
		
		//Add employees
				
		driver.findElement(By.xpath("//span[text ()='Add Employee']")).click();
		Thread.sleep(20000);
		
		driver.findElement(By.xpath("//div[@class='select-wrapper initialized']/input[@type='text']")).click();
		
		String s1="Texas R&D";
		//List<WebElement> options = (List<WebElement>) driver.findElement(By.xpath("//ul[contains(@id,'select-options-')]"));
		List<WebElement> options =driver.findElements(By.xpath("(//ul[contains(@id,'select-options-')])[2]/li"));
	    for(WebElement opt : options)
	    {
	    	String s2=opt.getText().trim();
	    	System.out.println(s2);
	        if (s1.equalsIgnoreCase(s2)) {
	        	
	        
	        opt.click();
	        System.out.println("matched location is ..."+s2);
	        break;
	        }
	    }
		
	}

}
