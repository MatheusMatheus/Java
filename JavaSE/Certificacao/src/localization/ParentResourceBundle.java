package localization;

import java.util.Locale;
import java.util.ResourceBundle;

public class ParentResourceBundle {
	public static void main(String[] args) {
		Locale locale = new Locale("en", "CA");
		ResourceBundle rb = ResourceBundle.getBundle("localization.Zoo", locale);
		System.out.print(rb.getString("hello"));
		System.out.print(". ");
		System.out.print(rb.getString("name"));
		System.out.print(" ");
		System.out.print(rb.getString("open"));
		System.out.print(", ");
		System.out.print(rb.getString("visitor"));
	}
}
