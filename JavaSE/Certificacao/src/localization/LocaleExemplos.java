package localization;

import java.util.Locale;

public class LocaleExemplos {
	public static void main(String[] args) {
		Locale locale = Locale.getDefault();
		System.out.println(locale);
		System.out.println(Locale.GERMAN);
		System.out.println(Locale.CHINA + " " + Locale.CHINESE);
		
		System.out.println(new Locale("mt"));
		System.out.println(new Locale("MT", "mt"));
		System.out.println("Invalido: " + new Locale("xx", "xx"));
		
		Locale l1 = new Locale.Builder()
				.setLanguage("en")
				.setRegion("US")
				.build();
		System.out.println(l1);
		
		// BAD - Não fazer isso
		Locale l2 = new Locale.Builder()
				.setLanguage("US")
				.setRegion("en")
				.build();
		System.out.println("Bad: " + l2);
		
		 System.out.println(Locale.getDefault()); // en_US
		 Locale l3 = new Locale("fr");
		 Locale.setDefault(l3); // change the default
		 System.out.println(Locale.getDefault()); // fr 
	}
}
