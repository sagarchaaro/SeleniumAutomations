package testngScripts;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class Demo4 {
  @Test
  public void test_demo4_01() 
  {
	  System.out.println("I Am in demo4");
  }
  
  @BeforeSuite
  public void beforeSuite() 
  {
	  System.out.println(" ~~~~~~ before suite ~~~~~~");
  }

  @AfterSuite
  public void afterSuite() 
  {
	  System.out.println(" ~~~~~~ after suite ~~~~~~~~");
  }

}
