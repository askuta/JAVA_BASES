package com.isscassistant;

import java.time.LocalDate;
import java.util.Arrays;

public class LastDayCalculator {

	public LocalDate calculateLastCSPDay(LocalDate firstDay, int availableCSPDays, int workScheduleA,
			int workScheduleB) {
		return calculateLastDay(firstDay, availableCSPDays, workScheduleA, workScheduleB, 0);
	}

	public LocalDate calculateLastSSPDay(LocalDate firstDay, LocalDate SSPDay, int availableSSPDays, int workScheduleA,
			int workScheduleB) {

		// Ez itt kiszámolja a CSP és SSP kezdõdátumai közé esõ hétfordulók
		// számát:
		int linkingWeekTurns = 0;
		LocalDate SSPDayCounter = SSPDay;
		while (!SSPDayCounter.equals(firstDay)) {
			SSPDayCounter = SSPDayCounter.plusDays(1);
			if (SSPDayCounter.getDayOfWeek() == java.time.DayOfWeek.MONDAY) {
				linkingWeekTurns++;
			}
		}

		return calculateLastDay(SSPDay, availableSSPDays, workScheduleA, workScheduleB, linkingWeekTurns);
	}

	private LocalDate calculateLastDay(LocalDate firstDay, int availableDays, int workScheduleA, int workScheduleB,
			int linkingWeekTurns) {
		LocalDate lastDate = firstDay;
		int daysSpent = 1;
		boolean isBWeek = false;
		// Ez itt kiszámolja a hétfordulók számából, hogy "A" vagy "B"
		// schedule-rõl indul-e a linking periódus:
		if ((linkingWeekTurns & 1) != 0) {
			isBWeek = true;
		}
		boolean workdayMA = false;
		boolean workdayTuA = false;
		boolean workdayWA = false;
		boolean workdayThA = false;
		boolean workdayFA = false;
		boolean workdaySaA = false;
		boolean workdaySuA = false;
		boolean workdayMB = false;
		boolean workdayTuB = false;
		boolean workdayWB = false;
		boolean workdayThB = false;
		boolean workdayFB = false;
		boolean workdaySaB = false;
		boolean workdaySuB = false;

		// Kibontjuk a workSchedule A-t.
		if (workScheduleA - 64 >= 0) {
			workdaySuA = true;
			workScheduleA -= 64;
		}
		if (workScheduleA - 32 >= 0) {
			workdaySaA = true;
			workScheduleA -= 32;
		}
		if (workScheduleA - 16 >= 0) {
			workdayFA = true;
			workScheduleA -= 16;
		}
		if (workScheduleA - 8 >= 0) {
			workdayThA = true;
			workScheduleA -= 8;
		}
		if (workScheduleA - 4 >= 0) {
			workdayWA = true;
			workScheduleA -= 4;
		}
		if (workScheduleA - 2 >= 0) {
			workdayTuA = true;
			workScheduleA -= 2;
		}
		if (workScheduleA - 1 >= 0) {
			workdayMA = true;
			workScheduleA -= 1;
		}

		// Kibontjuk a workSchedule B-t.
		if (workScheduleB - 64 >= 0) {
			workdaySuB = true;
			workScheduleB -= 64;
		}
		if (workScheduleB - 32 >= 0) {
			workdaySaB = true;
			workScheduleB -= 32;
		}
		if (workScheduleB - 16 >= 0) {
			workdayFB = true;
			workScheduleB -= 16;
		}
		if (workScheduleB - 8 >= 0) {
			workdayThB = true;
			workScheduleB -= 8;
		}
		if (workScheduleB - 4 >= 0) {
			workdayWB = true;
			workScheduleB -= 4;
		}
		if (workScheduleB - 2 >= 0) {
			workdayTuB = true;
			workScheduleB -= 2;
		}
		if (workScheduleB - 1 >= 0) {
			workdayMB = true;
			workScheduleB -= 1;
		}

		// A cikluson belül addig növelem a lastDate-et, amíg nem fogynak el az
		// availableDays-ok, közben minden hétfõn váltunk "A"és "B" hét között.
		while (daysSpent < availableDays) {

			// Következõ nap.
			lastDate = lastDate.plusDays(1);
			
			if (!isHoliday(lastDate)) {

			// Kettébontjuk az "A" és "B" hét leszámolását.
			if (isBWeek) {
				// A következõ nap munkanap a "B" heti work schedule szerint? Ha
				// igen,
				// akkor növelem a daysSpent értékét:
				switch (lastDate.getDayOfWeek()) {
				case MONDAY:
					if (workdayMB) {
						daysSpent += 1;
						break;
					}
				case TUESDAY:
					if (workdayTuB) {
						daysSpent += 1;
						break;
					}
				case WEDNESDAY:
					if (workdayWB) {
						daysSpent += 1;
						break;
					}
				case THURSDAY:
					if (workdayThB) {
						daysSpent += 1;
						break;
					}
				case FRIDAY:
					if (workdayFB) {
						daysSpent += 1;
						break;
					}
				case SATURDAY:
					if (workdaySaB) {
						daysSpent += 1;
						break;
					}
				case SUNDAY:
					if (workdaySuB) {
						daysSpent += 1;
						break;
					}
				default:
					break;
				}
			} else {
				// A következõ nap munkanap az "A" heti work schedule szerint?
				// Ha igen,
				// akkor növelem a daysSpent értékét:
				switch (lastDate.getDayOfWeek()) {
				case MONDAY:
					if (workdayMA) {
						daysSpent += 1;
						break;
					}
				case TUESDAY:
					if (workdayTuA) {
						daysSpent += 1;
						break;
					}
				case WEDNESDAY:
					if (workdayWA) {
						daysSpent += 1;
						break;
					}
				case THURSDAY:
					if (workdayThA) {
						daysSpent += 1;
						break;
					}
				case FRIDAY:
					if (workdayFA) {
						daysSpent += 1;
						break;
					}
				case SATURDAY:
					if (workdaySaA) {
						daysSpent += 1;
						break;
					}
				case SUNDAY:
					if (workdaySuA) {
						daysSpent += 1;
						break;
					}
				default:
					break;
				}
			}}

			// Váltás "A" és "B" hét között.
			if (lastDate.getDayOfWeek() == java.time.DayOfWeek.MONDAY) {
				isBWeek = !isBWeek;
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
			LocalDate.of(2016, 12, 27), LocalDate.of(2017, 1, 2), LocalDate.of(2017, 1, 2), LocalDate.of(2017, 4, 14),
			LocalDate.of(2017, 4, 17), LocalDate.of(2017, 5, 1), LocalDate.of(2017, 5, 29), LocalDate.of(2017, 8, 28),
			LocalDate.of(2017, 12, 25), LocalDate.of(2017, 12, 26), LocalDate.of(2018, 1, 1), LocalDate.of(2018, 3, 30),
			LocalDate.of(2018, 4, 2), LocalDate.of(2018, 5, 7), LocalDate.of(2018, 5, 28), LocalDate.of(2018, 8, 27),
			LocalDate.of(2018, 12, 25), LocalDate.of(2018, 12, 26) };
}
