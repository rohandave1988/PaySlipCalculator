package com.payslip.calculator.exception;

public class MonthlyPayCalculatorException extends RuntimeException{
	private String exceptionMessage;
	
	public MonthlyPayCalculatorException(String exceptionMessage){
		super(exceptionMessage);
	}
	
	public void setMessage(String exceptionMessage) {
		this.exceptionMessage = exceptionMessage;
	}
}
