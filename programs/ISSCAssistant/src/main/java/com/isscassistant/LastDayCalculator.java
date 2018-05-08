package com.isscassistant;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LastDayCalculator {

	private static final LocalDate[] HOLIDAYS_UK_ARRAY = { LocalDate.of(2016, 1, 1), LocalDate.of(2016, 3, 25),
			LocalDate.of(2016, 3, 28), LocalDate.of(2016, 5, 2), LocalDate.of(2016, 5, 30), LocalDate.of(2016, 8, 29),
			LocalDate.of(2016, 12, 26), LocalDate.of(2016, 12, 27), LocalDate.of(2017, 1, 2), LocalDate.of(2017, 4, 14),
			LocalDate.of(2017, 4, 17), LocalDate.of(2017, 5, 1), LocalDate.of(2017, 5, 29), LocalDate.of(2017, 8, 28),
			LocalDate.of(2017, 12, 25), LocalDate.of(2017, 12, 26), LocalDate.of(2018, 1, 1), LocalDate.of(2018, 3, 30),
			LocalDate.of(2018, 4, 2), LocalDate.of(2018, 5, 7), LocalDate.of(2018, 5, 28), LocalDate.of(2018, 8, 27),
			LocalDate.of(2018, 12, 25), LocalDate.of(2018, 12, 26), LocalDate.of(2019, 1, 1), LocalDate.of(2019, 4, 19),
			LocalDate.of(2019, 4, 22), LocalDate.of(2019, 5, 6), LocalDate.of(2019, 5, 27), LocalDate.of(2019, 8, 26),
			LocalDate.of(2019, 12, 25), LocalDate.of(2019, 12, 26) };

	private static final Set<LocalDate> HOLIDAYS_UK = new HashSet<>(Arrays.asList(HOLIDAYS_UK_ARRAY));

	public LocalDate calculateLastDay(LocalDate firstDay, int availableDays, boolean[] workSchedule) {
		LocalDate lastDate = firstDay;

		// Ez váltogatja az A meg B hetet:
		int bWeekOffset = 0;

		// Ez számlálja le a fölhasznált entitlement-et:
		int daysSpent = 0;

		// Leellenõrzi, hogy az adott nap szabadnapra vagy hétvégére esik-e:
		if (!isHoliday(lastDate) && workSchedule[lastDate.getDayOfWeek().getValue() + bWeekOffset - 1]) {
			daysSpent += 1;
		}
		while (daysSpent < availableDays) {

			// Elõrelép egy napot:
			lastDate = lastDate.plusDays(1);

			if (!isHoliday(lastDate) && workSchedule[lastDate.getDayOfWeek().getValue() + bWeekOffset - 1]) {
				daysSpent += 1;
			}

			// Átvált a másik hétre, ha van B hét is:
			if (lastDate.getDayOfWeek() == java.time.DayOfWeek.MONDAY && workSchedule.length > 7) {
				if (bWeekOffset == 0) {
					bWeekOffset = 7;
				} else {
					bWeekOffset = 0;
				}
			}
		}

		return lastDate;
	}

	private boolean isHoliday(LocalDate day) {
		return HOLIDAYS_UK.contains(day);
	}
}
