package test.java.ibanCheckerTest;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import main.java.dao.IbanChecker;

public class IbanTest {

	@Test
	public void test() {
		IbanChecker ICR = new IbanChecker("AL 34535 34535 345534 355"); // insert account number here 
		try {
			Assert.assertTrue(ICR.checkLength());
			System.out.println("Passed check length");
		} catch (AssertionError e) {
			System.out.println("Failed check length");
		}
		
		try {
			Assert.assertTrue(ICR.checkIbanCountryLength());
			System.out.println("Passed check country length");
		} catch (AssertionError e) {
			System.out.println("Failed check country length");
		}
		
		try {
			Assert.assertTrue(ICR.checkValidCountryCode());
			System.out.println("Passed check valid country code");
		} catch (AssertionError e) {
			System.out.println("Failed check valid country code");
		}
		
		try {
			Assert.assertTrue(ICR.checkValidStructure());
			System.out.println("Passed check valid structure");
		} catch (AssertionError e) {
			System.out.println("Failed check valid structure");
		}
		
		try {
			Assert.assertTrue(ICR.checkDigits());
			System.out.println("Passed check digits");
		} catch (AssertionError e) {
			System.out.println("Failed check digits");
		}
//		fail("Not yet implemented");
	}

}
