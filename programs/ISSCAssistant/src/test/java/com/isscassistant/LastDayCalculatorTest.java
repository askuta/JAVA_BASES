package com.isscassistant;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.time.LocalDate;

import org.junit.Test;

public class LastDayCalculatorTest {

	private LastDayCalculator calculator = new LastDayCalculator();
	
	@Test
	public void testCalculate() {
		
		boolean[] workSchedule = {true, true, true, true, true, false, false};
		LocalDate firstDay = LocalDate.of(2017, 6, 16);
		
		testCalculateLastCSPDay(firstDay, 20, workSchedule, LocalDate.of(2017, 7, 17));
		testCalculateLastCSPDay(firstDay, 21, workSchedule, LocalDate.of(2017, 7, 17));
		testCalculateLastCSPDay(firstDay, 22, workSchedule, LocalDate.of(2017, 7, 18));
		testCalculateLastCSPDay(firstDay, 23, workSchedule, LocalDate.of(2017, 7, 19));
	}
	
	private void testCalculateLastCSPDay(LocalDate firstDay, int availableCSPDays, boolean[] workSchedule, LocalDate expectedLastDay) {
		LocalDate lastDay = calculator.calculateLastCSPDay(firstDay, availableCSPDays, workSchedule);
		assertTrue(lastDay.equals(expectedLastDay));
	}
	
	public LocalDate calculateLastCSPDay(LocalDate firstDay, int availableCSPDays, boolean[] workSchedule) {
		return null;
	}
	
	public LocalDate calculateLastSSPDay(LocalDate firstDay, LocalDate sSPDay, int availableSSPDays,
			boolean[] workSchedule) {
		return null;
	}

}
