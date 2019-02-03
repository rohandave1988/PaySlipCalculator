package com.payslip.calculator.domain;
import junit.framework.TestCase;
import org.junit.Before;

public class TaxSlabsTest extends TestCase {
	private TaxSlabs item;
	
	@Before
	public void setUp(){
		item = new TaxSlabs();
	}
	
	public void testDerivedTaxItem(){
		
		item.setIncomeTaxRate(0.32);
		item.setTaxLimitMin(37000);
		item.setTaxLimitMax(87000);
		item.setTopUpCost(3572);
		
		assertEquals(item.getIncomeTaxRate(),0.32);
		assertEquals(item.getTaxLimitMin(),37000);
		assertEquals(item.getTaxLimitMax(),87000);
		assertEquals(item.getTopUpCost(),3572.0);
	}
}
