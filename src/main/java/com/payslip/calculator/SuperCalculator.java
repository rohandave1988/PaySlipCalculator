package com.payslip.calculator;


/**
 * @author Rohan Dave
 *
 */
public class SuperCalculator {
	
	public static int calculate(double grossIncome, double superRate){
		return (int)Math.round(grossIncome * superRate);
	}
}
