package seleniumScript;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

// Drop down............//

public class SelectDemo02 {

	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium Catalogue\\Drivers\\Chrome\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver= new ChromeDriver ();
		driver.get("https://www.amazon.com");
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		WebElement s2= driver.findElement(By.xpath("//select[@title='Search in']"));
	
		Select sc2= new Select(s2);
		sc2.selectByIndex(13);
		System.out.println("Select catogery index is 13");
		Thread.sleep(3000);
	
		 sc2.selectByValue("search-alias=fashion-womens");
		 System.out.println("womens selected from dropbox");
		 Thread.sleep(3000);
		 
		 sc2.selectByVisibleText("Baby");
		 System.out.println("Baby is selected...");
		 Thread.sleep(3000);
	
		 String b= sc2.getFirstSelectedOption().getText();
		 System.out.println("FirstSelectedOption ..."+b);
		 
		 boolean boo= sc2.isMultiple();
		 if(boo)
		 {
			 System.out.println("it is multiple");
		 }else
		 {
			System.out.println("it is not multiple"); 
		 }
		 
		 boolean avilable = false;
		 List<WebElement> web= sc2.getOptions();
		 for(WebElement we:web) 
		 {
			 String st= we.getText(); 
			 if (st.equalsIgnoreCase("Tools & Home Improvement"))
			 {
				 sc2.selectByVisibleText(st);
				avilable= true;
				 System.out.println("Tools & Home Improvement");
				 break;
			 } //else
			 //{
				// System.out.println("Toys & Games");
				// sc2.selectByVisibleText("Toys & Games");
			 //}
		 }if (!avilable)
		 {
			 sc2.selectByVisibleText("Toys & Games");
		 }
		 
		 
		 
		 driver.close();
	}
	
	
	

}
