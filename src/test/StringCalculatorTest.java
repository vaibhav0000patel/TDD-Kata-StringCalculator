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
		assertTrue(cl.Add("")==0);
	}
  
	@Test
	public void testAdd2() {
		assertTrue(cl.Add("1")==1);
	}
	
	@Test
	public void testAdd3() {
		assertTrue(cl.Add("1,2")==3);
	}
  
}
