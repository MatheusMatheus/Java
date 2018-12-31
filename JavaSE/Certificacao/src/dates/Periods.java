package dates;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;

public class Periods {
	public static void main(String[] args) {
		LocalDate start = LocalDate.of(2015, Month.JANUARY, 1);
		LocalDate end = LocalDate.of(2015, Month.MARCH, 30);

		Period period = Period.ofMonths(1);
		Period annually = Period.ofYears(1); // every 1 year
		Period quarterly = Period.ofMonths(3); // every 3 months
		Period everyThreeWeeks = Period.ofWeeks(3); // every 3 weeks
		Period everyOtherDay = Period.ofDays(2); // every 2 days
		Period everyYearAndAWeek = Period.of(1, 0, 7); // every year and 7 days
		
		System.out.println(everyYearAndAWeek);
		System.out.println();
		
		performAnimalEnrichment(start, end, everyThreeWeeks);
		
		
	}

	private static void performAnimalEnrichment(LocalDate start, LocalDate end, Period period) {
		LocalDate upTo = start;
		while (upTo.isBefore(end)) { // check if still before end
			System.out.println("give new toy: " + upTo);
			upTo = upTo.plus(period); // add a month
		}
	}
}
