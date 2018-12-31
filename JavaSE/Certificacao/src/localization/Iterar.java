package localization;

import java.util.Enumeration;
import java.util.Locale;
import java.util.ResourceBundle;

public class Iterar {
	public static void main(String[] args) {
		Locale locale = new Locale("fr", "CA");
		ResourceBundle rb = ResourceBundle.getBundle("localization.Zoo", locale);
		Enumeration<String> bundleKeys = rb.getKeys();
		while(bundleKeys.hasMoreElements()) {
			String key = (String)bundleKeys.nextElement();
			String value = rb.getString(key);
			System.out.println("key = " + key + ", " + "value = " + value);
		}
	}
}
