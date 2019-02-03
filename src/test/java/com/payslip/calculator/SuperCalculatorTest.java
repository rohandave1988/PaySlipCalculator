package com.payslip.calculator;
import junit.framework.TestCase;
import org.junit.Before;

public class SuperCalculatorTest extends TestCase {
	
	public void testSuperCalculator(){
		int result = SuperCalculator.calculate(5004,0.09);
		assertEquals(450, result);
	}
}
