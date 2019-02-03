package com.payslip.calculator.domain;

public class TaxSlabs {
	private int taxLimitMax;
	private int taxLimitMin;
	private double incomeTaxRate;
	private double topUpCost;
	
	
	public TaxSlabs(){
		this(0,0,0,0);
	}
	public TaxSlabs(int minlimit, int maxLimit, double incomeTaxRate, double topUpCost){
		this.taxLimitMax = maxLimit;
		this.taxLimitMin = minlimit;
		this.incomeTaxRate = incomeTaxRate;
		this.topUpCost = topUpCost;
	}
	public int getTaxLimitMax() {
		return taxLimitMax;
	}
	public void setTaxLimitMax(int taxLimitMax) {
		this.taxLimitMax = taxLimitMax;
	}
	public int getTaxLimitMin() {
		return taxLimitMin;
	}
	public void setTaxLimitMin(int taxLimitMin) {
		this.taxLimitMin = taxLimitMin;
	}
	public double getIncomeTaxRate() {
		return incomeTaxRate;
	}
	public void setIncomeTaxRate(double incomeTaxRate) {
		this.incomeTaxRate = incomeTaxRate;
	}
	public double getTopUpCost() {
		return topUpCost;
	}
	public void setTopUpCost(double topUpCost) {
		this.topUpCost = topUpCost;
	}

	
	
}
