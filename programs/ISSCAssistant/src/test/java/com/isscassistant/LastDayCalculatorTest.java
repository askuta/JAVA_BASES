package com.isscassistant;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;

import org.junit.Test;

public class LastDayCalculatorTest {

	private LastDayCalculator calculator = new LastDayCalculator();
	
	@Test
	public void testCalculate() {
		System.out.println("Borzburger");
		LocalDate firstDay = LocalDate.of(2017, 6, 16);
		LocalDate lastDay = calculator.calculateLastCSPDay(firstDay, 30, 31, 31);
		
		LocalDate expectedLastDay = LocalDate.of(2017, 7, 27);
		assertEquals(expectedLastDay, lastDay);
		System.out.println(lastDay);
	}
}
