package localization;

import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;

public class PropertiesExemplo {
	public static void main(String[] args) {
		Locale us = new Locale("en", "US");
		Locale france = new Locale("fr", "FR");
		//printProperties(us);
		//printProperties(france);		
		
		ResourceBundle rb = ResourceBundle.getBundle("localization.Zoo", france);
		Properties props = new Properties();
		rb.keySet().stream()
				.forEach(k -> props.put(k, rb.getString(k))); 
		
		System.out.println(props.get("open"));
		System.out.println(props.getProperty("asdads", "123"));
	}
	
	static void printProperties(Locale locale) {
		ResourceBundle rb = ResourceBundle.getBundle("localization.Zoo", locale);
		System.out.println(rb.getString("hello"));
		System.out.println(rb.getString("open"));
		
	}
}
