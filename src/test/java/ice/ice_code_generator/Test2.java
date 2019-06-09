package ice.ice_code_generator;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Test2 {

	public static void main(String[] args) {
		long millis=1000*60*60*24*30;
		long now=System.currentTimeMillis();
		long before=now+millis;
		Date nowb=new Date(before);
		Date nown=new Date(now);
		System.out.println(now);
		System.out.println(before);
		System.out.println(nowb);
		System.out.println(nown);
		
		
		Date today = new Date(System.currentTimeMillis());
		Calendar cal = Calendar.getInstance();
		cal.setTime(today);
		cal.add(Calendar.DAY_OF_MONTH, -30);
		System.out.println(cal.getTime());
	}

}
