package sample.java.util;

import java.util.Calendar;
import java.util.Formatter;
import java.util.GregorianCalendar;
import static java.util.Calendar.*;
import java.util.Locale;

public class FormatterSample {

	public static void main(String[] args) {
//		test_1();
		test_2();
	}

	public static void test_2() {
		Formatter formatter = new Formatter();
		Appendable out = formatter.out();
		System.out.println(out);
	}
	
	public static void test_1() {
		StringBuilder sb = new StringBuilder();
		Formatter formatter = new Formatter(sb, Locale.US);

		formatter.format("%4$3s %3$2s %2$3s %1$2s", "a", "b", "c", "d");

		formatter.format(Locale.FRANCE, "e = %+10.4f", Math.E);

		formatter.format("Amount gained or lost since last statement: $ %(,.2f", -1.2345324);
		
		   System.out.format("Local time: %tT", Calendar.getInstance());
		   
		   System.err.printf("Unable to open file '%1$s': %2$s",
		                     "/user/local/none.file", null);
		   
		   Calendar c = new GregorianCalendar(1995, MAY, 23);
		   String s = String.format("Duke's Birthday: %1$tb %1$te, %1$tY", c);
		   System.out.println(s);
		   s = String.format("Duke's Birthday: %1$tm %1$te,%1$tY", c);
		   System.out.println(s);
		   
		   formatter.format("%2$s %s %<s %s", "a", "b", "c", "d");
		   // -> "b a a b"
		   // "c" and "d" are ignored because they are not referenced
		   
		System.out.println(sb.toString());
	}
}


