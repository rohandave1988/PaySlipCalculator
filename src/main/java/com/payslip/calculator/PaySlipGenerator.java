package com.payslip.calculator;
import java.util.List;
import java.util.Scanner;

import com.payslip.calculator.domain.Employee;
import com.payslip.calculator.exception.MonthlyPayCalculatorException;
import com.payslip.calculator.io.PaySlipFileReader;
import com.payslip.calculator.io.PaySlipFileWriter;


/**
 * @author Rohan Dave
 * This file is the main class and which reads values from a CSV File and 
 * generates value in a Output File
 *
 */
public class PaySlipGenerator {
	
	
	public void execute(String inputFile, String outputFile){
		 PaySlipFileReader paySlipFileReader = new PaySlipFileReader();
		 List<Employee> employees = paySlipFileReader.readFile(inputFile);
		
		 for(Employee employee : employees){
			 employee.setIncomeTax((int)calculateIncomeTax(employee.getAnnualSalary()));
			 employee.setSuperAmount((int)calculateSuper(employee.grossIncome(),employee.getSuperRate()));
		 }
		
		PaySlipFileWriter paySlipFileWriter = new PaySlipFileWriter();
		paySlipFileWriter.writeToFile(outputFile,employees);
	}
	
	public static void main(String[] args) {
		System.out.println("Enter the Value of Input and Output File Name Separated with Space");
		Scanner scanner = new Scanner(System.in);
		String arguments = scanner.nextLine();
		String resultArr[] = arguments.split(" ");
		if (resultArr.length == 2) {
			PaySlipGenerator paySlipCalculator = new PaySlipGenerator();
			paySlipCalculator.execute(resultArr[0], resultArr[1]);
		} else {
			throw new MonthlyPayCalculatorException("Invalid Parameters");
		}
	}
	
	public long calculateIncomeTax(long annualSalary){
		return TaxCalculator.calculate(annualSalary);
	}
	
	public double calculateSuper(int grossIncome, double superRate){
		return SuperCalculator.calculate(grossIncome,superRate);
	}
}
