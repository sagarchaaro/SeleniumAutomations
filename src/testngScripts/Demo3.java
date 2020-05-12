package testngScripts;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Demo3 {
  
	@Test
  public void test_demo3_01 ()
	{
		System.out.println(" Demo3");
	}
	
	@BeforeTest
	public void beforetest()
	{
		System.out.println("333333 {Before Test} 33333");
	}

	@AfterTest
	public void aftertest()
	{
		System.out.println("  333333 {after Test} 33333");
	}

	@BeforeClass
	public void beforeclass()
	{
		System.out.println(" before class demo03 ");
	}


	@AfterClass
	public void afterclass()
	{
		System.out.println(" after class demo03 ");
	}



}
