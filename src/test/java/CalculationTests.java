package test.java;

import org.junit.Test;

import main.java.Compact;
import main.java.Optimal;
import main.java.Product;

public class CalculationTests {
	@Test
	public void testCompact1() {
		Product compact = new Compact();
		assert (compact.calculate(100) == 65000);
	}

	@Test
	public void testCompact2() {
		Product compact = new Compact();
		assert (compact.calculate(42.42) == 27573);
	}

	@Test
	public void testCompact3() {
		Product compact = new Compact();
		assert (compact.calculate(1) == 650);
	}

	@Test
	public void testOptimal1() {
		Product optimal = new Optimal();
		assert (optimal.calculate(100) == 70000);
	}

	@Test
	public void testOptimal2() {
		Product optimal = new Optimal();
		assert (optimal.calculate(42.42) == 29694);
	}

	@Test
	public void testOptimal3() {
		Product optimal = new Optimal();
		assert (optimal.calculate(1) == 700);
	}
}
