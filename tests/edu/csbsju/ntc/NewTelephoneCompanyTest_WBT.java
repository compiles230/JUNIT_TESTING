package edu.csbsju.ntc;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class NewTelephoneCompanyTest_WBT {
private NewTelephoneCompany ntc;
	
	@Before
	public void setUp() throws Exception {
		ntc = new NewTelephoneCompany();

	}

	@Test
	public void testGetStartTime() {
		int expResult = 0;
        int result = ntc.getStartTime();
        assertEquals("Start time is: " + expResult,expResult, result);
	}

	@Test
	public void testSetStartTime() {
		int expResult = 45;
		ntc.setStartTime(45);
        int result = ntc.getStartTime();
        assertEquals("Start time is: " + expResult,expResult, result);
	}

	@Test
	public void testGetDuration() {
		int expResult = 0;
		int result = ntc.getDuration();
        assertEquals("Duration is: " + expResult,expResult, result);

	}

	@Test
	public void testSetDuration() {
		int expResult = 60;
		ntc.setDuration(60);
		int result = ntc.getDuration();
        assertEquals("Duration is: " + expResult,expResult, result);
	}
	
	
	/*
	Description							Input st		Input length	Expected output
	Invalid st 								-5				10				invalid st
											-1				10				invalid st
											2544			10				invalid st
											2400			10				invalid st
											2401			10				invalid st
											1578			10				invalid st
											1160			10				invalid st
											1161			10				invalid st
	Invalid duration						799				-5				invalid length
											1800			0				invalid length
											1801			-1				invalid length

	discounted st and discounted length		500				100				1768.0
											759				61				1078.48
											2359			65				1149.20 
											1959			61				1078.48
	discounted st							0				60				1248.00
	 										400				59				1227.20
	 										759				1				20.80
	 										1800			10				208.00  >>  Originally written as 208.80 in
	 										1801			10				208.00	>>	the write up, however the
	 										2359			10				208.00	>>	correct value is actually 208.00
	 										
	discounted duration						800				65				2298.40
											900				61				2156.96
											
	no discounts							1000			40				1664.00
											800				1				41.60
											801				59				2454.40
											1759			60				2496.00


 */
	
	//**********************  INVALID START TIME  **********************
	@Test(expected=UnsupportedOperationException.class)
	public void testComputeCharge_InvalidStartTime_Case1() {
		ntc.setStartTime(-5);
		ntc.setDuration(10);
		ntc.computeCharge();
	}
	
	@Test(expected=UnsupportedOperationException.class)
	public void testComputeCharge_InvalidStartTime_Case2() {
		ntc.setStartTime(-1);
		ntc.setDuration(10);
		ntc.computeCharge();
	}
	
	@Test(expected=UnsupportedOperationException.class)
	public void testComputeCharge_InvalidStartTime_Case3() {
		ntc.setStartTime(2544);
		ntc.setDuration(10);
		ntc.computeCharge();
	}
	
	@Test(expected=UnsupportedOperationException.class)
	public void testComputeCharge_InvalidStartTime_Case4() {
		ntc.setStartTime(2400);
		ntc.setDuration(10);
		ntc.computeCharge();
	}
	
	@Test(expected=UnsupportedOperationException.class)
	public void testComputeCharge_InvalidStartTime_Case5() {
		ntc.setStartTime(2401);
		ntc.setDuration(10);
		ntc.computeCharge();
	}
	
	@Test(expected=UnsupportedOperationException.class)
	public void testComputeCharge_InvalidStartTime_Case6() {
		ntc.setStartTime(1578);
		ntc.setDuration(10);
		ntc.computeCharge();
	}
	
	@Test(expected=UnsupportedOperationException.class)
	public void testComputeCharge_InvalidStartTime_Case7() {
		ntc.setStartTime(1160);
		ntc.setDuration(10);
		ntc.computeCharge();
	}
	
	@Test(expected=UnsupportedOperationException.class)
	public void testComputeCharge_InvalidStartTime_Case8() {
		ntc.setStartTime(1161);
		ntc.setDuration(10);
		ntc.computeCharge();
	}
	
	
	//**********************  INVALID DURATION  **********************
	@Test(expected=UnsupportedOperationException.class)
	public void testComputeCharge_InvalidDuration_Case1() {
		ntc.setStartTime(799);
		ntc.setDuration(-5);
		ntc.computeCharge();
	}
	
	@Test(expected=UnsupportedOperationException.class)
	public void testComputeCharge_InvalidDuration_Case2() {
		ntc.setStartTime(1800);
		ntc.setDuration(0);
		ntc.computeCharge();
	}
	
	@Test(expected=UnsupportedOperationException.class)
	public void testComputeCharge_InvalidDuration_Case3() {
		ntc.setStartTime(1801);
		ntc.setDuration(-1);
		ntc.computeCharge();
	}
	
	//**********************  BOTH DISCOUNTS  **********************
	@Test
	public void testComputeCharge_BothDiscounts() {
		ntc.setStartTime(500);
		ntc.setDuration(100);
		double expResult = 1768.0;
		ntc.computeCharge();
		assertTrue("A call starting at " + ntc.getStartTime() + " for a duration of " + ntc.getDuration()+ expResult,expResult==ntc.computeCharge());
	
		ntc.setStartTime(759);
		ntc.setDuration(61);
		expResult = 1078.48;
		ntc.computeCharge();
		assertTrue("A call starting at " + ntc.getStartTime() + " for a duration of " + ntc.getDuration()+ expResult,expResult==ntc.computeCharge());
	
		ntc.setStartTime(1959);
		ntc.setDuration(61);
		expResult = 1078.48;
		ntc.computeCharge();
		assertTrue("A call starting at " + ntc.getStartTime() + " for a duration of " + ntc.getDuration()+ expResult,expResult==ntc.computeCharge());
	
		ntc.setStartTime(2359);
		ntc.setDuration(65);
		expResult = 1149.20;
		ntc.computeCharge();
		assertTrue("A call starting at " + ntc.getStartTime() + " for a duration of " + ntc.getDuration()+ expResult,expResult==ntc.computeCharge());
	}
	
	//**********************  DISCOUNTED START TIME  **********************
	@Test
	public void testComputeCharge_DiscountStartTime() {
		ntc.setStartTime(0);
		ntc.setDuration(60);
		double expResult = 1248.00;
		ntc.computeCharge();
		assertTrue("A call starting at " + ntc.getStartTime() + " for a duration of " + ntc.getDuration()+  " " + expResult,expResult==ntc.computeCharge());
	
		ntc.setStartTime(400);
		ntc.setDuration(59);
		expResult = 1227.20;
		ntc.computeCharge();
		assertTrue("A call starting at " + ntc.getStartTime() + " for a duration of " + ntc.getDuration()+  " " + expResult,expResult==ntc.computeCharge());
	
		ntc.setStartTime(759);
		ntc.setDuration(1);
		expResult = 20.80;
		ntc.computeCharge();
		assertTrue("A call starting at " + ntc.getStartTime() + " for a duration of " + ntc.getDuration()+  " " + expResult,expResult==ntc.computeCharge());
	
		ntc.setStartTime(1800);
		ntc.setDuration(10);
		expResult = 208.0;
		ntc.computeCharge();
		assertTrue("A call starting at " + ntc.getStartTime() + " for a duration of " + ntc.getDuration()+ " "  + expResult,expResult==ntc.computeCharge());
	
		ntc.setStartTime(1801);
		ntc.setDuration(10);
		expResult = 208.00;
		ntc.computeCharge();
		assertTrue("A call starting at " + ntc.getStartTime() + " for a duration of " + ntc.getDuration()+  " " + expResult,expResult==ntc.computeCharge());
	
		ntc.setStartTime(2359);
		ntc.setDuration(10);
		expResult = 208.00;
		ntc.computeCharge();
		assertTrue("A call starting at " + ntc.getStartTime() + " for a duration of " + ntc.getDuration()+  " " + expResult,expResult==ntc.computeCharge());
	}
	
	//**********************  DISCOUNTED DURATION  **********************
	@Test
	public void testComputeCharge_DiscountDuration() {
		ntc.setStartTime(800);
		ntc.setDuration(65);
		double expResult = 2298.40;
		ntc.computeCharge();
		assertTrue("A call starting at " + ntc.getStartTime() + " for a duration of " + ntc.getDuration()+  " " + expResult,expResult==ntc.computeCharge());
	
		ntc.setStartTime(900);
		ntc.setDuration(61);
		expResult = 2156.96;
		ntc.computeCharge();
		assertTrue("A call starting at " + ntc.getStartTime() + " for a duration of " + ntc.getDuration()+  " " + expResult,expResult==ntc.computeCharge());
	}
	
	//**********************  NO DISCOUNTS  **********************
	@Test
	public void testComputeCharge_NoDiscount() {
		ntc.setStartTime(1000);
		ntc.setDuration(40);
		double expResult = 1664.00;
		ntc.computeCharge();
		assertTrue("A call starting at " + ntc.getStartTime() + " for a duration of " + ntc.getDuration()+ " " + expResult,expResult==ntc.computeCharge());
	
		ntc.setStartTime(800);
		ntc.setDuration(1);
		expResult = 41.60;
		ntc.computeCharge();
		assertTrue("A call starting at " + ntc.getStartTime() + " for a duration of " + ntc.getDuration()+  " " + expResult,expResult==ntc.computeCharge());
		
		ntc.setStartTime(801);
		ntc.setDuration(59);
		expResult = 2454.40;
		ntc.computeCharge();
		assertTrue("A call starting at " + ntc.getStartTime() + " for a duration of " + ntc.getDuration()+  " " + expResult,expResult==ntc.computeCharge());
	
		ntc.setStartTime(1759);
		ntc.setDuration(60);
		expResult = 2496.00;
		ntc.computeCharge();
		assertTrue("A call starting at " + ntc.getStartTime() + " for a duration of " + ntc.getDuration()+  " " + expResult,expResult==ntc.computeCharge());
	
	}

}
