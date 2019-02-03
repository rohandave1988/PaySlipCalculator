package com.payslip.calculator.io;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import com.payslip.calculator.domain.Employee;
import com.payslip.calculator.exception.MonthlyPayCalculatorException;

public class PaySlipFileWriter {
	
	public boolean writeToFile(String fileName, List<Employee> employees){
		
		Path path = Paths.get(fileName);
		 
		try (BufferedWriter writer = Files.newBufferedWriter(path))
		{
			for (Employee employee : employees) {
			writer.append(employee.toString());
			writer.newLine();
			}
		} catch (IOException e) {
			throw new MonthlyPayCalculatorException("Exception while Printing File");
		}
		return true;
	}
	
	
}
