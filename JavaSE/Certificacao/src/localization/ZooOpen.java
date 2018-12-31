package localization;

import java.util.Locale;
import java.util.ResourceBundle;

public class ZooOpen {
	public static void main(String[] args) {
		Locale us = new Locale("en", "US");
		Locale france = new Locale("fr", "FR");
		
		printProperties(us);
		System.err.println();
		//printProperties(france);
	}
	
	public static void printProperties(Locale locale) {
		ResourceBundle rb = ResourceBundle.getBundle("localization.Zoo", locale);
		System.out.println(rb.getString("hello"));
		System.out.println(rb.getString("open"));
		System.out.println(rb.getString("aaa"));
	}
}
