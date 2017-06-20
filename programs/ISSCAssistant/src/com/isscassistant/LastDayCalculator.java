package com.isscassistant;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class LastDayCalculator {

	public LocalDate calculateLastCSPDay(LocalDate firstDay, int availableCSPDays) {
		return calculateLastDay(firstDay, availableCSPDays);
	}

	public LocalDate caclulateLastSSPDay(LocalDate firstDay, int availableSSPDays) {
		return calculateLastDay(firstDay, availableSSPDays);
	}

	private LocalDate calculateLastDay(LocalDate firstDay, int availableDays) {
		LocalDate lastDate = firstDay;
		int daysSpent = 0;
		if (isWorkDay(lastDate)) {
			daysSpent += 1;
		}

		// A cikluson belül addig növelem a lastDate-et, amíg nem fogynak el az
		// availableDays.
		while (daysSpent < availableDays) {
			// Következõ nap.
			lastDate = lastDate.plusDays(1);

			// A következõ nap munkanap?
			if (isWorkDay(lastDate)) {
				// Ha munkanap, akkkor növelem a daysSpent értékét:
				daysSpent += 1;
			}
		}

		return lastDate;
	}

	// Ha hétvége, akkor nem munkanap.
	private boolean isWorkDay(LocalDate day) {
		if (day.getDayOfWeek() == DayOfWeek.SATURDAY || day.getDayOfWeek() == DayOfWeek.SUNDAY) {
			return false;
		}

		return true;
	}
}
