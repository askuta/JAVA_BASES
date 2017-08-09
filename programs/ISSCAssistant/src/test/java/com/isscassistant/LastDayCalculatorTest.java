package com.isscassistant;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.time.LocalDate;

import org.junit.Test;

public class LastDayCalculatorTest {

	private LastDayCalculator calculator = new LastDayCalculator();
	
	@Test
	public void testCalculateLastCSPDay() {
		
		boolean[] workSchedule = {true, true, true, true, true, false, false};
		LocalDate firstDay = LocalDate.of(2017, 4, 10);
		evaluateCalculateLastCSPDay(firstDay, 1, workSchedule, LocalDate.of(2017, 4, 10));
		evaluateCalculateLastCSPDay(firstDay, 2, workSchedule, LocalDate.of(2017, 4, 11));
		evaluateCalculateLastCSPDay(firstDay, 3, workSchedule, LocalDate.of(2017, 4, 12));
		evaluateCalculateLastCSPDay(firstDay, 4, workSchedule, LocalDate.of(2017, 4, 13));
		evaluateCalculateLastCSPDay(firstDay, 5, workSchedule, LocalDate.of(2017, 4, 18));
		evaluateCalculateLastCSPDay(firstDay, 6, workSchedule, LocalDate.of(2017, 4, 19));
		evaluateCalculateLastCSPDay(firstDay, 7, workSchedule, LocalDate.of(2017, 4, 20));

		boolean[] workSchedule2 = {false, true, true, true, true, false, false};
		firstDay = LocalDate.of(2017, 4, 7);
		evaluateCalculateLastCSPDay(firstDay, 1, workSchedule2, LocalDate.of(2017, 4, 7));
		evaluateCalculateLastCSPDay(firstDay, 2, workSchedule2, LocalDate.of(2017, 4, 11));
		evaluateCalculateLastCSPDay(firstDay, 3, workSchedule2, LocalDate.of(2017, 4, 12));
		evaluateCalculateLastCSPDay(firstDay, 10, workSchedule2, LocalDate.of(2017, 4, 26));
	}
	
	@Test
	public void testCalculateLastSSPDay() {
		boolean[] workSchedule = {true, true, true, true, true, false, false};
		LocalDate firstDay = LocalDate.of(2017, 4, 10);
		LocalDate sSPDay = LocalDate.of(2017, 3, 10);
		evaluateCalculateLastSSPDay(firstDay, sSPDay, 30, workSchedule, LocalDate.of(2017, 4, 24));
	}
	
	private void evaluateCalculateLastCSPDay(LocalDate firstDay, int availableCSPDays, boolean[] workSchedule, LocalDate expectedLastDay) {
		LocalDate lastDay = calculator.calculateLastCSPDay(firstDay, availableCSPDays, workSchedule);
		assertTrue(lastDay.equals(expectedLastDay));
	}
	
	private void evaluateCalculateLastSSPDay(LocalDate firstDay, LocalDate sSPDay, int availableSSPDays, boolean[] workSchedule, LocalDate expectedLastDay) {
		LocalDate lastDay = calculator.calculateLastSSPDay(firstDay, sSPDay, availableSSPDays, workSchedule);
		assertTrue(lastDay.equals(expectedLastDay));
	}
}
