package dates;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Zonas {
	public static void main(String[] args) {
		ZoneId zone = ZoneId.of("US/Eastern");
		ZonedDateTime zoned1 = ZonedDateTime.of(2015, 1, 20, 6, 15, 30, 200, zone);

		LocalDate date1 = LocalDate.now();
		LocalTime time1 = LocalTime.of(15, 30);
		LocalDateTime dateTime1 = LocalDateTime.of(date1, time1);

		ZonedDateTime zoned2 = ZonedDateTime.of(date1, time1, zone);
		ZonedDateTime zoned3 = ZonedDateTime.of(dateTime1, zone);
		
		/*
		 * System.out.println(zone); System.out.println(zoned1);
		 * System.out.println(date1); System.out.println(time1);
		 * System.out.println(zoned2); System.out.println(zoned3);
		 * 
		 * System.out.println(ZoneId.systemDefault());
		 */

		Map<String, Set<String>> map = ZoneId.getAvailableZoneIds()
				.stream()
				.collect(Collectors.groupingBy(Zonas::getStr, Collectors.toSet()));

		System.out.println(map.keySet());
	}

	static String getStr(String s) {
		return s.substring(0, s.indexOf("/") + 1);
	}
}
