package seleniumScript;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Script02
{
	
	//script 02
	
	public static void main(String[] args) throws Throwable 
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium Catalogue\\Drivers\\Chrome\\chromedriver_win32\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver (); 
	
		
		driver.get("https://seleniumtesters-trials6562.orangehrmlive.com/auth/login");
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(25,TimeUnit.SECONDS);
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
				
		// Click on Employee list
		//driver.findElement(By.xpath("//li[@class='level2 active current']//a/span[2]")).click();
		driver.findElement(By.xpath("(//span[@class='left-menu-title'])[48]")).click();
		
		driver.findElement(By.xpath("//*[@id=\"employeeListTable\"]/tbody/tr[1]/td[2]")).click();
		Thread.sleep(3000);
		
		//clear last name
		//driver.findElement(By.xpath("//input[@class='ng-pristine ng-valid ng-not-empty ng-valid-schema-form ng-touched']")).clear();
		
		driver.findElement(By.xpath("//*[@id=\"lastName\"]")).clear();
		
		/// add last name
		
		driver.findElement(By.xpath("//*[@id=\"lastName\"]")).sendKeys("Mango");
		
		//click D.O.B (09/19/1988)
		
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//i[@class='material-icons action-icon date-picker-open-icon'])[1]")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("((//div[@class='picker__header'])[1]/div/input)[1]")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("((//div[@class='picker__header'])[1]/div/ul/li[9]/span)[1]")).click();
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("(//div[@class='picker__header'])[1]/div[2]/input")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//div[@class='picker__header'])[1]/div[2]/ul/li[36]/span")).click();
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("//div[@aria-label='Mon, 19 Sep 1988']")).click();
		Thread.sleep(5000);
		
		// select nationality
		
		driver.findElement(By.xpath("//div[@id='nation_code_inputfileddiv']/div/input")).click();
		driver.findElement(By.xpath("//div[@id='nation_code_inputfileddiv']/div/ul/li[83]/span")).click();
		
		//save button
		driver.findElement(By.xpath("(//button[@ng-click='buttonClick($event,form)'])[1]")).click();
		System.out.println("*** Passed ****");
		
		// Successfully updated
		
		// blood group
		
		driver.findElement(By.xpath("//div[@id='1_inputfileddiv']/div/input")).click();
		driver.findElement(By.xpath("//div[@id='1_inputfileddiv']/div/ul/li[2]/span")).click();
		
		// click on save button
		driver.findElement(By.xpath("(//button[@ng-click='buttonClick($event,form)'])[2]")).click();
		Thread.sleep(5000);
		// Successfully updated
		
		//Select the Sports (Football & Squash) Checkboxes
		
		// (//div[@ng-repeat='val in titleMapValues track by $index'])[4]/label
		
		//driver.findElement(By.xpath("//div[@ng-repeat='val in titleMapValues track by $index'])[4]/label")).click();
		
		driver.findElement(By.xpath("//label[@for='15Baseball']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//label[@for='15Basketball']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//label[@for='15Football']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//label[@for='15Golf']")).click();
		Thread.sleep(10000);
		
		// click on save button
		driver.findElement(By.xpath("(//button[text()='save'])[1]")).click();
		Thread.sleep(9000);
		
		//Click on Global Manager HR Link
		//driver.findElement(By.xpath("//span[@id='account-job']/i")).click();
		//Thread.sleep(5000);
		
		WebElement element = driver.findElement(By.xpath("//*[@id='account-job']/i"));
	      ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
	      ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
		
		//log out
		driver.findElement(By.xpath("//ul[@id='user_menu']/li[3]/a")).click();
		Thread.sleep(3000);
		
		driver.close();
		
		
		
		
	}

}
