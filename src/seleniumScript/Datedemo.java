package seleniumScript;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Datedemo {

	public static void main(String[] args) 
	{
		/*SimpleDateFormat st= new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
		Date todaydate= new Date();
		String s1= st.format(todaydate);
		System.out.println("today date is "+s1);*/
		
		SimpleDateFormat sd= new SimpleDateFormat ("dd/MM/yyyy hh:mm:ss");
		Date d= new Date();		
		String s1 =sd.format(d);
		System.out.println("date is "+s1);
	
	}

}
