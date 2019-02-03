package com.payslip.calculator;
import java.util.ArrayList;

import com.payslip.calculator.domain.TaxSlabs;
import com.payslip.calculator.exception.MonthlyPayCalculatorException;


/**
 * @author Rohan Dave
 *
 */
public class TaxCalculator {

	private static ArrayList<TaxSlabs> initializeTaxItems() {
		ArrayList<TaxSlabs> taxItems = new ArrayList<>();

		TaxSlabs taxSlabOne = new TaxSlabs(18200, 37000, 0.19, 0);
		TaxSlabs taxSlabTwo = new TaxSlabs(37000, 87000, 0.325, 3572);
		TaxSlabs taxSlabThree = new TaxSlabs(87000, 180000, 0.37, 19822);
		TaxSlabs taxSlabFour = new TaxSlabs(180000, Integer.MAX_VALUE, 0.45, 54232);
		taxItems = new ArrayList<>();
		taxItems.add(taxSlabOne);
		taxItems.add(taxSlabTwo);
		taxItems.add(taxSlabThree);
		taxItems.add(taxSlabFour);
		return taxItems;
	}

	public static long calculate(long annualSalary)
	throws MonthlyPayCalculatorException {
		if (annualSalary < 0) {
			throw new MonthlyPayCalculatorException("Invalid Annual Salary");
		}
		for (TaxSlabs item : initializeTaxItems()) {
			if (annualSalary > item.getTaxLimitMin() && annualSalary <= item.getTaxLimitMax()) {
				return Math.round((item.getTopUpCost() + (annualSalary - item.getTaxLimitMin()) * item.getIncomeTaxRate()) / 12);
			}
		}
		return annualSalary;
	}
}
