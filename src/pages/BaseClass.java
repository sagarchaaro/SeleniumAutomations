package pages;

import org.openqa.selenium.WebDriver;

public class BaseClass {
	public static WebDriver driver;
	public static boolean status=true;
	public BaseClass(WebDriver driver){
		this.driver=driver;
	}
}
