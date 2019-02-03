package com.payslip.calculator;
import org.junit.Before;

import junit.framework.TestCase;

public class PayslipCalculatorTest extends TestCase{
	private PaySlipGenerator paySlipCalculator;
	
	@Before
	public void setUp(){
		paySlipCalculator = new PaySlipGenerator();
	}
	
	public void testExecute(){
		paySlipCalculator.execute("input.txt","output.txt");
	}
	
}
