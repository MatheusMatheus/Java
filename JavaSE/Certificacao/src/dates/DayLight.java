package dates;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class DayLight {
	public static void main(String[] args) {
		DayLight.Avanca avanca = new DayLight.Avanca();
		avanca.avanca();
		
		System.out.println();
		
		DayLight.Volta volta = new DayLight.Volta();
		volta.volta();
	}

	static class Avanca {
		void avanca() {
			System.out.println("Avança data");
			LocalDate date = LocalDate.of(2018, Month.MARCH, 11);
			LocalTime time = LocalTime.of(1, 30);
			ZoneId zone = ZoneId.of("US/Eastern");
			ZonedDateTime dateTime = ZonedDateTime.of(date, time, zone);
			System.out.println(dateTime); // 2016–03–13T01:30–05:00[US/Eastern]
			dateTime = dateTime.plusHours(1);
			System.out.println(dateTime); // 2016–03–13T03:30–04:00[US/Eastern]
		}
	}

	static class Volta {
		void volta() {
			System.out.println("Volta data");
			LocalDate date = LocalDate.of(2016, Month.NOVEMBER, 6);
			LocalTime time = LocalTime.of(1, 30);
			ZoneId zone = ZoneId.of("US/Eastern");
			ZonedDateTime dateTime = ZonedDateTime.of(date, time, zone);
			System.out.println(dateTime); // 2016–11–06T01:30–04:00[US/Eastern]
			dateTime = dateTime.plusHours(1);
			System.out.println(dateTime); // 2016–11–06T01:30–05:00[US/Eastern]
			dateTime = dateTime.plusHours(1);
			System.out.println(dateTime); // 2016–11–06T02:30–05:00[US/Eastern]
		}
	}
}
