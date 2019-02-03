package com.payslip.calcualtor.io;
import java.util.ArrayList;

import org.easymock.EasyMock;
import org.junit.Before;

import com.payslip.calculator.domain.Employee;
import com.payslip.calculator.io.PaySlipFileWriter;

import junit.framework.TestCase;

public class PaySlipFileWriterTest extends TestCase{
	private PaySlipFileWriter writer;
	
	@Before
	public void setUp(){
		writer = new PaySlipFileWriter();
	}
	
	public void testWriteDataToFile(){
		 Employee e1 = EasyMock.createNiceMock(Employee.class);
		 ArrayList<Employee> employees = new ArrayList<>();
		 EasyMock.replay(e1);
		 employees.add(e1);
		 writer.writeToFile("output.txt",employees);
	}
}
