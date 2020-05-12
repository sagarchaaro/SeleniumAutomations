package seleniumScript;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CalanderBox 
{

	public static void main(String[] args) 
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium Catalogue\\Drivers\\Chrome\\chromedriver_win32\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver (); 
	
		driver.get("https://www.irctc.co.in/nget/train-search");
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);

		//click on ok
		driver.findElement(By.xpath("//button[text()='Ok']")).click();
		
		//click on calendar
		driver.findElement(By.xpath("//span[@class='ui-button-icon-left ui-clickable fa fa-fw fa-calendar']")).click();
		
		String dob="20/June/2020";
		String day=dob.split("/")[0];
		System.out.println("Day is " +day);
		String month=dob.split("/")[1];
		System.out.println("Month is "+month);
		String year=dob.split("/")[2];
		System.out.println("Year is "+year);
	
		for(int i=1; i<=12; i++)
		{
			String monthtx=driver.findElement(By.xpath("//div[@class='ui-datepicker-title']/span[1]")).getText();
			if (monthtx.equalsIgnoreCase(month))
			{
				break;
			}
			driver.findElement(By.xpath("//span[@class='fa fa-angle-right']")).click();
		
		
		}
		
		List<WebElement> web=driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar ng-tns-c12-5 ng-star-inserted']/tbody/tr/td"));
		for(WebElement we:web) 
		{
			String st= we.getText();
			if(st.equalsIgnoreCase(day))
			{
				we.click();
				System.out.println("Day "+st+" is clicked");
				break;
			}
			
		}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
		System.out.println("Good to Go");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
