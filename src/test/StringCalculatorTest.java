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
	public void testAdd01() throws Exception {
		// Empty String
		assertTrue(cl.Add("")==0);
	}
  
	@Test
	public void testAdd02() throws Exception {
		// Single Number
		assertTrue(cl.Add("1")==1);
	}
	
	@Test
	public void testAdd03() throws Exception {
		// Two Numbers
		assertTrue(cl.Add("1,2")==3);
	}
	
	@Test
	public void testAdd04() throws Exception {
		// Handle unknown amount of numbers
		assertTrue(cl.Add("1,2,3,4")==10);
	}
	
	@Test
	public void testAdd05() throws Exception {
		// Handle new new lines between numbers
		assertTrue(cl.Add("1\n2,3")==6);
	}
	
	@Test
	public void testAdd06() {
		// Invalid Input with new lines between numbers
		try {
			assertTrue(cl.Add("1,\n")==1);
		}catch(Exception e) {
			assertTrue(e.getMessage().equals("Invalid Input"));
		}
	}
	
	@Test
	public void testAdd07() throws Exception {
		// Support different delimiters 
		assertTrue(cl.Add("//;\n1;2")==3);
	}
	
	@Test
	public void testAdd08() {
		// Negative numbers are not allowed
		try {
			assertTrue(cl.Add("//;\n-1;2")==1);
			throw new Exception("Failed");
		}catch(Exception e) {
			assertTrue(e.getMessage().equals("Negatives not allowed : -1"));
		}
	}
	
	@Test
	public void testAdd09() {
		// Show all negative numbers in the Exception
		try {
			assertTrue(cl.Add("//;\n-1;-2;6")==3);
			throw new Exception("Failed");
		}catch(Exception e) {
			assertTrue(e.getMessage().equals("Negatives not allowed : -1, -2"));
		}
	}

	@Test
	public void testAdd10() throws Exception {
		// Ignore number greater than 1000
		assertTrue(cl.Add("2,1001")==2);
	}
	
	@Test
	public void testAdd11() throws Exception {
		// Support Variable length of delimiter 
		assertTrue(cl.Add("//[***]\n1***2***3")==6);
	}
	
	@Test
	public void testAdd12() throws Exception {
		// Allow  multiple delimiters
		assertTrue(cl.Add("//[*][%]\n1*2%3")==6);
	}
	
	@Test
	public void testAdd13() throws Exception {
		// Allow  multiple delimiters with variable length
		assertTrue(cl.Add("//[****][%%%]\n1****2%%%3")==6);
	}
	
	
}
