package telran.numbers.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import telran.numbers.OddNumbersPredicate;
import telran.numbers.Range;
import telran.numbers.TruePredicate;

class RangeTest {
	Range range = new Range(-2, 3);

	@BeforeEach
	void setUp() throws Exception {
		range = new Range(-2, 3);
	}

	@Test
	void lengthTest() {
		assertEquals(6, range.length());
	}

	@Test
	void iterableNoPredicateTest() {
		range.setPredicate(null);
		int expected[] = { -2, -1, 0, 1, 2, 3 };
		int actual[] = getActualArray(6);
		assertArrayEquals(expected, actual);
	}

	@Test
	void iterablePredicateTestEven() {
		// Test for HW #12
		int expected[] = { -2, 0, 2 };
		range.setPredicate(new OddNumbersPredicate().negate());
		int actual[] = getActualArray(3);

		assertArrayEquals(expected, actual);
	}

	@Test
	void iterablePredicateTestOdd() {
		// Test for HW #12
		int expected[] = { -1, 1, 3 };
		range.setPredicate(new OddNumbersPredicate());
		int actual[] = getActualArray(3);

		assertArrayEquals(expected, actual);
	}

	@Test
	void iterablePredicateTestFalse() {
		// Test for HW #12
		int expected[] = {};
		range.setPredicate(new TruePredicate().negate());
		int actual[] = getActualArray(0);

		assertArrayEquals(expected, actual);
	}

	@Test
	void iterablePredicateTestTrue() {
		// Test for HW #12
		int expected[] = { -2, -1, 0, 1, 2, 3 };
		range.setPredicate(new TruePredicate());
		int actual[] = getActualArray(6);

		assertArrayEquals(expected, actual);
	}

	private int[] getActualArray(int size) {
		int[] res = new int[size];
		var test = new ArrayList<Integer>();
		int ind = 0;
		for (int num : range) {
			res [ind] = num;		
			ind++;
		}
		return res;
	}

}
