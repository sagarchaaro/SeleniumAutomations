package seleniumScript;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Script03 {

	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium Catalogue\\Drivers\\Chrome\\chromedriver_win32\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver (); 
	
		
		driver.get("https://seleniumtesters-trials6562.orangehrmlive.com/auth/login");
		
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		driver.manage().window().maximize();
		
		String title = driver.getTitle();
		System.out.println("Title of website is .."+title);
		if (title.equalsIgnoreCase("OrangeHRM"))
		{
			System.out.println("Right");
		}else
		{
			System.out.println("Wrong");
		}
		
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
		Thread.sleep(2000);
		
		//Click on Leave link
		driver.findElement(By.xpath("//li[@id='menu_leave_viewLeaveModule']")).click();
		Thread.sleep(9000);
		
		//Select the Leave type as "Casual Leave"
		driver.findElement(By.xpath("//span[contains(text(),'Apply')]")).click();
		
		//Select the Leave type as "Casual Leave"
		
		//driver.findElement(By.xpath("(//div[@ng-submit='ng-submit']/materializecss-decorator/div/sf-decorator/div)[1]/div/input")).click();
		//driver.findElement(By.xpath("(//input[starts-with(@type,'text')])[1]")).click();
		//driver.findElement(By.xpath("(//input[starts-with(@type,'text')])[1]/../ul/li[2]/span[contains(text(),'Casual Leave')]")).click();
		//driver.findElement(By.xpath("(//div[@ng-submit='ng-submit']/materializecss-decorator/div/sf-decorator/div)[1]/div/ul/li[2]/span")).click();
		//driver.findElement(By.xpath("//div[starts-with(@id,'leaveType_input')]/div/input")).click();
		//driver.findElement(By.xpath("//div[starts-with(@id,'leaveType_input')]/div/ul/li[2]/span")).click();
		driver.findElement(By.xpath("//div[@class='select-wrapper initialized']/input")).click();
		driver.findElement(By.xpath("//div[@class='select-wrapper initialized']/ul/li[2]/span")).click();
		Thread.sleep(3000);
		
		//Select From Date as "15/04/2020"
		
		driver.findElement(By.xpath("(//i[contains(text(),'date_range')])[1]")).click();
		driver.findElement(By.xpath("(//div[@title='Next month'])[1]")).click();
		driver.findElement(By.xpath("(//div[@aria-label='Wed, 22 Apr 2020'])[1]")).click();
		Thread.sleep(3000);
		
		//Select To Date as "16/04/2020"
		
		driver.findElement(By.xpath("(//i[contains(text(),'date_range')])[2]")).click();
		driver.findElement(By.xpath("(//div[@aria-label='Thu, 23 Apr 2020'])[2]")).click();
		Thread.sleep(4000);
		
		//Select Partial Days as "None"
		
		driver.findElement(By.xpath("//input[contains(@value,'None')]")).click();
		
		//Enter the Comment as "Personal Work"
		
		driver.findElement(By.xpath("//textarea[contains(@class,'materialize')]")).sendKeys("going out of town");
		Thread.sleep(3000);
		
		//Click on Apply Link
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(3000);
		
		
		driver.findElement(By.xpath("(//a[contains(@class,'modal-action waves-effect')])[1]")).click();
		System.out.println("Okbutton is clicked");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@ng-click='modal.cancel()']")).click();
		System.out.println("cancel button is clicked");
		Thread.sleep(6000);
		
		//Alert at=driver.switchTo().alert();
		//String s1=at.getText();
		
		//driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(6000);
		
		//Click on Global Manager HR Link
		
		WebElement element = driver.findElement(By.xpath("//*[@id='account-job']/i"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
		System.out.println("good");
		Thread.sleep(3000);
		
		//Click on Logout link
		
		driver.findElement(By.xpath("//ul[@id='user_menu']/li[3]/a")).click();
		Thread.sleep(3000);
		
		
		//Close the Browser
		
		System.out.println("Its working.. no worries... (@ ^ @)");	
		driver.close();

	}

}
