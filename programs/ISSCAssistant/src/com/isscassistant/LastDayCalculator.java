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

		// A cikluson bel�l addig n�velem a lastDate-et, am�g nem fogynak el az
		// availableDays.
		while (daysSpent < availableDays) {
			// K�vetkez� nap.
			lastDate = lastDate.plusDays(1);

			// A k�vetkez� nap munkanap?
			if (isWorkDay(lastDate)) {
				// Ha munkanap, akkkor n�velem a daysSpent �rt�k�t:
				daysSpent += 1;
			}
		}

		return lastDate;
	}

	// Ha h�tv�ge, akkor nem munkanap.
	private boolean isWorkDay(LocalDate day) {
		if (day.getDayOfWeek() == DayOfWeek.SATURDAY || day.getDayOfWeek() == DayOfWeek.SUNDAY) {
			return false;
		}

		return true;
	}
}
