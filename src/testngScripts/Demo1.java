package testngScripts;


import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Demo1 
{
	@Test
	public void testDemo01() 
	{
		System.out.println("01");
	}

	@Test
	public void testDemo02()
	{
		System.out.println("02");
	}
	
	
	@Test
	public void testDemo03() 
	{
		System.out.println("03");
	}
	
	@AfterMethod
	public void afterMethod()
	{
		System.out.println("AfterMethod. Demo1");
	
	}
	
	@Test
	public void testDemo04()
	{
		System.out.println("04");
	}
	
	@BeforeMethod
	public void beforeMethod()
	{
		System.out.println("BeforeMethod.Demo1");
	}
	
	@BeforeClass
	public void beforeClass()
	{
		System.out.println(" **** Before class Demo01****");
	}
	
	@AfterClass
	public void afterClass()
	{
		System.out.println(" **** After Class Demo01 ****");
	}
	
	
	
	
	
	
	
	
	
	
	
	
}

