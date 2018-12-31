package dates.formatacao;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class Formatacao {
	public static void main(String[] args) {
		LocalDate date = LocalDate.of(2020, Month.FEBRUARY, 15);
		System.out.println(date.getDayOfWeek());
		System.out.println(date.getDayOfMonth());
		System.out.println(date.getDayOfYear());
		System.out.println(date.getMonth());
		System.out.println(date.getYear());
		
		
		LocalTime time = LocalTime.of(11, 12, 24);
		LocalDateTime dateTime = LocalDateTime.of(date, time);
		ZoneId zone = ZoneId.of("US/Eastern");
		ZonedDateTime zoneTime = ZonedDateTime.of(date, time, zone);
		
		System.out.println(date.format(DateTimeFormatter.ISO_LOCAL_DATE));
		System.out.println(time.format(DateTimeFormatter.ISO_LOCAL_TIME));
		System.out.println(dateTime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
		
		DateTimeFormatter shortDateTime = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT);
		System.out.println(shortDateTime.format(zoneTime));
		System.out.println(shortDateTime.format(date));
	}
}
