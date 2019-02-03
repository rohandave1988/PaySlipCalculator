package com.payslip.calcualtor.io;
import java.util.List;

import org.junit.Before;

import com.payslip.calculator.domain.Employee;
import com.payslip.calculator.exception.MonthlyPayCalculatorException;
import com.payslip.calculator.io.PaySlipFileReader;

import junit.framework.TestCase;

public class PaySlipFileReaderTest extends TestCase {
	PaySlipFileReader reader;
	
	@Before
	public void setUp(){
		reader = new PaySlipFileReader();
	}
	
	public void testReadFileInvalid(){
		try{
			reader.readFile("sample.txt");
		}catch(MonthlyPayCalculatorException ex){
			assertEquals("File 'sample.txt' not found",ex.getMessage());
		}
	}

	public void testdeducePercentageDouble(){
		try {
			double result = reader.deducePercentageDouble("1");
		}catch(MonthlyPayCalculatorException ex){
			assertEquals("Value not correct",ex.getMessage());
		}
	}
	
	public void testdeducePercentageDoubleValidValue(){
		try {
			double result = reader.deducePercentageDouble("1%");
			assertEquals(0.01, result);
		}catch(MonthlyPayCalculatorException ex){
			//do nothing
		}
	}
	
	public void testReadFileValidRecord(){
		try{
			List<Employee> employees = reader.readFile("input.txt");
			assertEquals(2, employees.size());
			
			Employee e1 = employees.get(0);
			assertEquals("David",e1.getFirstName());
			assertEquals("Rudd",e1.getLastName());
			assertEquals("01 March – 31 March",e1.getPaymentStartDate());
			assertEquals(60050,e1.getAnnualSalary());
			assertEquals(0.09,e1.getSuperRate());

			Employee e2 = employees.get(1);
			assertEquals("Ryan",e2.getFirstName());
			assertEquals("Chen",e2.getLastName());
			assertEquals("01 March – 31 March",e2.getPaymentStartDate());
			assertEquals(120000,e2.getAnnualSalary());
			assertEquals(0.1,e2.getSuperRate());
			
		}catch(Exception ex){
			//do nothing
		}
	}
}
