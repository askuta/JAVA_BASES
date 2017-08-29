package com.isscassistant;

import static org.junit.Assert.assertTrue;
import java.time.LocalDate;

import org.junit.Test;

public class LastDayCalculatorTest {

	private LastDayCalculator calculator = new LastDayCalculator();
	
	@Test
	public void testCalculateLastDay() {
		
		boolean[] workSchedule = {true, true, true, true, true, false, false};
		LocalDate firstDay = LocalDate.of(2017, 4, 10);
		evaluateCalculateLastDay(firstDay, 1, workSchedule, LocalDate.of(2017, 4, 10));
		evaluateCalculateLastDay(firstDay, 2, workSchedule, LocalDate.of(2017, 4, 11));
		evaluateCalculateLastDay(firstDay, 3, workSchedule, LocalDate.of(2017, 4, 12));
		evaluateCalculateLastDay(firstDay, 4, workSchedule, LocalDate.of(2017, 4, 13));
		evaluateCalculateLastDay(firstDay, 5, workSchedule, LocalDate.of(2017, 4, 18));
		evaluateCalculateLastDay(firstDay, 6, workSchedule, LocalDate.of(2017, 4, 19));
		evaluateCalculateLastDay(firstDay, 7, workSchedule, LocalDate.of(2017, 4, 20));

		boolean[] workSchedule2 = {false, true, true, true, true, false, false};
		firstDay = LocalDate.of(2017, 4, 7);
		evaluateCalculateLastDay(firstDay, 1, workSchedule2, LocalDate.of(2017, 4, 7));
		evaluateCalculateLastDay(firstDay, 2, workSchedule2, LocalDate.of(2017, 4, 11));
		evaluateCalculateLastDay(firstDay, 3, workSchedule2, LocalDate.of(2017, 4, 12));
		evaluateCalculateLastDay(firstDay, 10, workSchedule2, LocalDate.of(2017, 4, 26));
	}
	
	private void evaluateCalculateLastDay(LocalDate firstDay, int availableDays, boolean[] workSchedule, LocalDate expectedLastDay) {
		LocalDate lastDay = calculator.calculateLastDay(firstDay, availableDays, workSchedule);
		assertTrue(lastDay.equals(expectedLastDay));
	}
}
