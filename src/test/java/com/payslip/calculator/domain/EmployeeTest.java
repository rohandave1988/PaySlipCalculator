package com.payslip.calculator.domain;
import org.junit.Before;

import com.payslip.calculator.exception.MonthlyPayCalculatorException;

import junit.framework.TestCase;

public class EmployeeTest extends TestCase {
	private Employee employee;

	@Before
	public void setUp() {
		employee = new Employee("rohan", "dave", 80000, 0.20, "01 April - 30 April");
	}

	public void testIfAnnualSalaryIsInvalid() {
		try {
			employee.setAnnualSalary(-4000);
		} catch (MonthlyPayCalculatorException ex) {
			assertEquals("Invalid Annual Salary", ex.getMessage());
		}
	}
	
	public void testIfEmployeeInstanceIsCreated() {
		assertNotNull(employee);
	}

	public void testSuperRateIsInvalid() {
		try {
			employee.setSuperRate(80.0);
		} catch (MonthlyPayCalculatorException ex) {
			assertEquals("Rate of Super should be between 0- 50 %", ex.getMessage());
		}
		try {
			employee.setAnnualSalary(-10000);
			employee.setSuperRate(43.0);
		} catch (MonthlyPayCalculatorException ex) {
			assertEquals("Invalid Annual Salary", ex.getMessage());
		}
	}
}
