package com.isscassistant;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;

public class LastDayCalculator {

	public LocalDate calculateLastCSPDay(LocalDate firstDay, int availableCSPDays, boolean[] workSchedule) {
		return calculateLastDay(firstDay, availableCSPDays, workSchedule);
	}

	public LocalDate calculateLastSSPDay(LocalDate firstDay, LocalDate sSPDay, int availableSSPDays,
			boolean[] workSchedule) {
		if (!firstDay.equals(sSPDay) && workSchedule.length == 14) {
			LocalDate mondayCount = firstDay.minusDays(firstDay.getDayOfWeek().getValue() - 1);
			LocalDate mondayCountSSP = sSPDay.minusDays(sSPDay.getDayOfWeek().getValue() - 1);
			if (ChronoUnit.WEEKS.between(mondayCountSSP, mondayCount) % 2 == 1) {
				boolean[] workScheduleTemp = workSchedule;
				workSchedule = new boolean[14];
				System.arraycopy(workScheduleTemp, 0, workSchedule, 7, 7);
				System.arraycopy(workScheduleTemp, 7, workSchedule, 0, 7);
			}
		}

		return calculateLastDay(sSPDay, availableSSPDays, workSchedule);
	}

	private LocalDate calculateLastDay(LocalDate firstDay, int availableDays, boolean[] workSchedule) {
		
		LocalDate lastDate = firstDay;
		int daysSpent = 1;
		int bWeekOffset = 0;

		while (daysSpent < availableDays) {
			lastDate = lastDate.plusDays(1);
			if (!isHoliday(lastDate) && workSchedule[lastDate.getDayOfWeek().getValue() + bWeekOffset - 1]) {
				daysSpent += 1;
			}

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
		if (Arrays.asList(holidaysUK).contains(day)) {
			return true;
		} else {
			return false;
		}
	}

	LocalDate[] holidaysUK = { LocalDate.of(2016, 1, 1), LocalDate.of(2016, 3, 25), LocalDate.of(2016, 3, 28),
			LocalDate.of(2016, 5, 2), LocalDate.of(2016, 5, 30), LocalDate.of(2016, 8, 29), LocalDate.of(2016, 12, 26),
			LocalDate.of(2016, 12, 27), LocalDate.of(2017, 1, 2), LocalDate.of(2017, 4, 14), LocalDate.of(2017, 4, 17),
			LocalDate.of(2017, 5, 1), LocalDate.of(2017, 5, 29), LocalDate.of(2017, 8, 28), LocalDate.of(2017, 12, 25),
			LocalDate.of(2017, 12, 26), LocalDate.of(2018, 1, 1), LocalDate.of(2018, 3, 30), LocalDate.of(2018, 4, 2),
			LocalDate.of(2018, 5, 7), LocalDate.of(2018, 5, 28), LocalDate.of(2018, 8, 27), LocalDate.of(2018, 12, 25),
			LocalDate.of(2018, 12, 26) };
}
