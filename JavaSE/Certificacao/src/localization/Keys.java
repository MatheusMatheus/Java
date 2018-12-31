package localization;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Set;

public class Keys {
	public static void main(String[] args) {
		Locale france = new Locale("fr", "FR");
		Locale us = new Locale("en", "US");
		ResourceBundle rb = ResourceBundle.getBundle("localization.Zoo", us);
		Set<String> keys = rb.keySet();
		keys.stream().map(k -> k + " - " + rb.getString(k)).forEach(System.out::println);
	
	}
}
