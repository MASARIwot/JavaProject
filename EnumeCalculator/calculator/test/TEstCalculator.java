package calculator.test;

import static org.junit.Assert.*;

import org.junit.Test;

import calculator.Calculator;
import calculator.Operation;

public class TEstCalculator {

	@Test
	public void testADD() {
		assertTrue(12 == Calculator.calculate(Operation.ADD, 10, 2));
		assertTrue(-10.5 == Calculator.calculate(Operation.ADD, -11.5, 1));

	}

	@Test
	public void testROOT() {
		assertTrue(5 == Calculator.calculate(Operation.ROOT, 25, 2));
	}

	@Test(expected = ArithmeticException.class)
	public void testDIVIDE() {
		Calculator.calculate(Operation.DIVIDE, 25, 0); // ArithmeticException
	}

	@Test
	public void testDEGREE() {
		assertTrue(25 == Calculator.calculate(Operation.DEGREE, 5, 2));
	}

	@Test
	public void testSUBTRACT() {
		assertTrue(10 == Calculator.calculate(Operation.SUBTRACT, 12, 2));
	}

}
