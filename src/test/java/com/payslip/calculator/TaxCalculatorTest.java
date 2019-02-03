package com.payslip.calculator;
import junit.framework.TestCase;

public class TaxCalculatorTest extends TestCase {
	
	public void testInvalidAnnualIncome() {
		try {
			TaxCalculator.calculate(-1000);
		} catch (Exception ex) {
			assertEquals(ex.getMessage(), "Invalid Annual Salary");
		}
	}

	public void testTaxableIncomeCalculation()
	throws Exception {
		double result = TaxCalculator.calculate(120000);
		assertEquals(2669, (long) result);
	}
}
