package dates.formatacao;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;

public class FormatacaoCustom {
	public static void main(String[] args) {
		LocalDate date = LocalDate.of(2020, Month.JANUARY, 20);
		LocalTime time = LocalTime.of(11, 12, 34);
		LocalDateTime dateTime = LocalDateTime.of(date, time);
		DateTimeFormatter f = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		System.out.println(dateTime.format(f)); // January 20, 2020, 11:12
		System.out.println(f.format(dateTime));
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy");
		LocalDate localDate = LocalDate.parse("01-02-2015", formatter);
		LocalTime localTime = LocalTime.parse("11:22");
		System.out.println(localDate); // 2015–01–02
		System.out.println(localTime); // 11:22
	}
}
