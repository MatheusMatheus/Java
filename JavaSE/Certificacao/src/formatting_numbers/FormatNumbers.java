package formatting_numbers;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class FormatNumbers {
	public static void main(String[] args) throws ParseException{
		int attendeesPerYear = 3_200_000;
		int attendeesPerMonth = attendeesPerYear / 12;
		NumberFormat us = NumberFormat.getInstance(Locale.US);
		System.out.println("US: " + us.format(attendeesPerMonth));

		NumberFormat g = NumberFormat.getInstance(Locale.GERMANY);
		System.out.println("Germany: " + g.format(attendeesPerMonth));

		NumberFormat ca = NumberFormat.getInstance(Locale.CANADA_FRENCH);
		System.out.println("Canada:" + ca.format(attendeesPerMonth));

		Locale ptBr = new Locale("pt", "BR");
		double price = 48;
		NumberFormat currencyInstance = NumberFormat.getCurrencyInstance(new Locale("aa", "aa"));
		System.out.println("Hue Hue BR: " + currencyInstance.format(price));
		
		String amt = "R$ 92.807,99";
		NumberFormat cf = NumberFormat.getCurrencyInstance();
		System.out.println("Current: " + cf.parse(amt));
		
		Number n = ca.parse("123 00");
		System.out.println(n);
	}
}
