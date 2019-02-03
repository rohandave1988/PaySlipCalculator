package com.payslip.calculator.io;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.payslip.calculator.domain.Employee;
import com.payslip.calculator.exception.MonthlyPayCalculatorException;

public class PaySlipFileReader {
	
	public List<Employee> readFile(String fileName) throws MonthlyPayCalculatorException {
		List<Employee> employeeList = new ArrayList<Employee>();
		try (Stream<String> stream = Files
				.lines(Paths.get(getClass().getClassLoader().getResource(fileName).toURI()))) {
			employeeList = stream.filter(line -> !line.isEmpty()).map(convertToEmployee())
					.collect(Collectors.toList());

		} catch (FileNotFoundException  e) {
			throw new MonthlyPayCalculatorException("File '" + fileName + "' not found");
		}  catch (Exception e) {
			throw new MonthlyPayCalculatorException("File '" + fileName + "' not found");
		}
		return employeeList;
	}

	private Function<String, Employee> convertToEmployee() {
		return csvLine -> {
			String[] fields = readCsvFields(csvLine);
			Employee employee = new Employee();
			employee.setFirstName(fieldData(fields[0]));
			employee.setLastName(fieldData(fields[1]));
			employee.setAnnualSalary(Long.parseLong(fieldData(fields[2])));
			employee.setPaymentStartDate(fields[4]);
			employee.setSuperRate(deducePercentageDouble(fields[3]));
			return employee;
		};
	}
	
	public double deducePercentageDouble(String value) throws MonthlyPayCalculatorException{
		if(!value.endsWith("%")) {
			throw new MonthlyPayCalculatorException("Value not correct");
		}

		return Double.parseDouble(value.substring(0, value.length() - 1)) / 100;
	}
	
	private String[] readCsvFields(String csvLine) {
		String[] fields = csvLine.split(",");
		return fields;
	}

	private String fieldData(String field) {
		return field.trim();
	}

}
