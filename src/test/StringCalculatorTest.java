package test;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import main.StringCalculator;

public class StringCalculatorTest {
	
	static StringCalculator cl ;
	
	@BeforeClass
	public static void setUp() {
		cl = new StringCalculator();
	}
	
	@AfterClass
	public static void tearDown()  {
		cl = null;
	}

	@Test
	public void testAdd1() {
		// Empty String
		assertTrue(cl.Add("")==0);
	}
  
	@Test
	public void testAdd2() {
		// Single Number
		assertTrue(cl.Add("1")==1);
	}
	
	@Test
	public void testAdd3() {
		// Two Numbers
		assertTrue(cl.Add("1,2")==3);
	}
	
	@Test
	public void testAdd4() {
		// Handle unknown amount of numbers
		assertTrue(cl.Add("1,2,3,4")==10);
	}
	
	@Test
	public void testAdd5() {
		// Handle new new lines netween numbers
		assertTrue(cl.Add("1\n2,3")==6);
	}
	
	@Test
	public void testAdd6() {
		// Invalid Input
		assertTrue(cl.Add("1,\n")==-1);
	}
	
	@Test
	public void testAdd7() {
		// Support different delimiters 
		assertTrue(cl.Add("//;\\n1;2")==3);
	}
	
	@Test
	public void testAdd8() {
		// Negative numbers are not allowed 
		try {
			assertTrue(cl.Add("-1,2")==1);
		}catch(Exception e) {
			assertTrue(e.getMessage().equals("negatives not allowed : -1"));
		}
	}
	
	@Test
	public void testAdd9() {
		// Show all negative numbers in the Exception
		try {
			assertTrue(cl.Add("-1,-2,6")==3);
		}catch(Exception e) {
			assertTrue(e.getMessage().equals("negatives not allowed : -1, -2"));
		}
	}

	@Test
	public void testAdd10() {
		// Ignore number greater than 100
		assertTrue(cl.Add("2,1001")==2);
	}
	
	@Test
	public void testAdd11() {
		// Support Variable length of delimiter 
		assertTrue(cl.Add("//[***]\\n1***2***3")==6);
	}
	
	@Test
	public void testAdd12() {
		// Allow  multiple delimiters
		assertTrue(cl.Add("//[*][%]\\n1*2%3")==6);
	}
	
	@Test
	public void testAdd13() {
		// Allow  multiple delimiters with variable length
		assertTrue(cl.Add("//[****][%%%]\\\\n1****2%%%3")==6);
	}
	
	
}
