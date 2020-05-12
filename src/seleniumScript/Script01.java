package seleniumScript;

import java.sql.Driver;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Coordinates;
import org.openqa.selenium.interactions.Locatable;
import org.openqa.selenium.support.ui.Select;
	
	//script 01

public class Script01
{

	public static void main(String[] args) throws Throwable 
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium Catalogue\\Drivers\\Chrome\\chromedriver_win32\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver (); 
	
		
		driver.get("https://seleniumtesters-trials6562.orangehrmlive.com/auth/login");
		
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		String titleofPage =driver.getTitle();
		System.out.println("Title is ...."+titleofPage);
		if (titleofPage.equalsIgnoreCase("OrangeHRM"))
		{
			System.out.println("Title is matched");
		}else
		{
			System.out.println("Title is not matched.");
		}
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
		//Thread.sleep(2000);
		
		//Add employees
		driver.findElement(By.xpath("//span[text ()='Add Employee']")).click();
		//Thread.sleep(20000);
		
		//firstname
		driver.findElement(By.xpath("//input[contains(@ng-model,'firstName')]")).sendKeys("Orange");
		//Thread.sleep(3000);
		
		//middlename
		driver.findElement(By.xpath("//input[@class= 'ng-pristine ng-untouched ng-valid ng-empty ng-valid-schema-form']")).sendKeys("Banana");
		//Thread.sleep(3000);
		
		//lastname
		driver.findElement(By.xpath("//input[@id='lastName']")).sendKeys("Mango");
		
		// click on india
		
		driver.findElement(By.xpath("//div[@class='select-wrapper initialized']/input[@type='text']")).click();
		
		driver.findElement(By.xpath("//span[contains(text(),'Indian Development Center')]")).click();
		
		
		driver.findElement(By.xpath("//a[@id='systemUserSaveBtn']")).click();
		Thread.sleep(20000);
		
		//select bloodgroup
		
		/* Ask to sagar 
		driver.findElement(By.xpath("//form[@sf-model='customFieldSection.model']/materializecss-decorator/div/sf-decorator/div/div/input")).click();
		driver.findElement(By.xpath("//form[@sf-model='customFieldSection.model']/materializecss-decorator/div/sf-decorator/div/div/ul/li[4]/span[contains(text(),'B')")).click();
		driver.findElement(By.xpath("//div[@class='select-wrapper initialized ng-not-empty ng-dirty ng-valid-parse ng-empty-add ng-valid-remove ng-invalid-add ng-invalid-tv4-302-add ng-valid-schema-form-remove ng-invalid-schema-form-add']/input")).click();
		driver.findElement(By.xpath("//form[@sf-form='customFieldSection.form']/materializecss-decorator/div/sf-decorator/div/div/input")).click();
		*/
		
		driver.findElement(By.xpath("//div[@id='1_inputfileddiv']/div/input")).click();
		driver.findElement(By.xpath("//div[@id='1_inputfileddiv']/div/ul/li[4]/span[contains(text(),'B')]")).click();
		
		//Select hobbies
		driver.findElement(By.xpath("//*[@id=\"5\"]")).sendKeys("Reading Books & Plating Cricket");
		
		//click button
		driver.findElement(By.xpath("//button[@ng-click='vm.onNextStep()']")).click();
		Thread.sleep(15000);
		
		//Select region 
		driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/section[1]/div[2]/ui-view[1]/div[2]/div[1]/custom-fields-panel[1]/div[1]/form[1]/materializecss-decorator[1]/div[1]/sf-decorator[1]/div[1]/div[1]/input[1]")).click();
		driver.findElement(By.xpath("//div[@id='9_inputfileddiv']/div/ul/li[3]/span[contains(text(),'Region-2')]")).click();
		
		//Select F.T.E
		driver.findElement(By.xpath("//div[@id='10_inputfileddiv']/div/input[@type='text']")).click();
		driver.findElement(By.xpath("//div[@id='10_inputfileddiv']/div/ul/li[3]/span")).click();
		
		//select Dept
		
		driver.findElement(By.xpath("//div[@id='11_inputfileddiv']/div/input[@type='text']")).click();
		driver.findElement(By.xpath("//div[@id='11_inputfileddiv']/div/ul/li[3]/span[contains(text(),'Sub unit-2')]")).click();
		
		// button
		driver.findElement(By.xpath("//button[@ng-click='vm.onFinish()']")).click();
		
		
		//HR Link
		//driver.findElement(By.xpath("(//i[@class='material-icons'])[1]")).click();
		//driver.findElement(By.xpath("//span[@id='account-job']")).click();
		
		WebElement element = driver.findElement(By.xpath("//*[@id='account-job']/i"));
	      ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
	      ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
		System.out.println("good");
		
		//log out
		driver.findElement(By.xpath("//ul[@id='user_menu']/li[3]/a")).click();
		Thread.sleep(3000);
				
		driver.close();
	
	
	
	
	
	
	
	}
	
}
