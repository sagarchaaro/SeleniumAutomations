package testngScripts;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Demo2 
{
	@Test
	public void test_Demo2_01() 
	{
		System.out.println("This is test_Demo2_01");
	}

	@Test
	public void test_Demo2_02()
	{
		System.out.println("This is test_Demo2_02");
	}

	@BeforeMethod
	public void beforeMethod()
	{
		System.out.println("I am in BeforeMethod.");
	}

	@AfterMethod
	public void afterMethod()
	{
		System.out.println("I am in AfterMethod.");
	
	}
	
	@BeforeClass
	public void beforeClass()
	{
		System.out.println(" **** Before class ****");
	}
	
	@AfterClass
	public void afterClass()
	{
		System.out.println(" $$$$  After Class $$$$$");
	}


















}
