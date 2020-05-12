package seleniumScript;

import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;

public class RandomDemo 
{

	public static void main(String[] args) 
	{
		Random ra1= new Random();
		int a= ra1.nextInt(100);
		System.out.println(a);
		
		int b= ra1.nextInt(1000);
		System.out.println(b);
		
		int c= ra1.nextInt(10000);
		System.out.println(c);
		
		RandomStringUtils rst = new RandomStringUtils();
		String d =rst.randomNumeric(3);
		System.out.println(d);
		
		String e= rst.randomAlphabetic(4);
		System.out.println(e);
	
		String f= rst.randomAlphanumeric(6);
		System.out.println(f);
	
		String g= rst.random(4, "abcd");
		System.out.println(g);
	}

}
