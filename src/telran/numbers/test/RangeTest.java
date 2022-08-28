package telran.numbers.test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import telran.numbers.*;
import java.util.*;

class RangeTest {
	Range range = new Range(-2, 3);
	ArrayList<Integer> sourceArrayList = getArrayListFromRange();

	@BeforeEach
	void setUp() throws Exception {
		range = new Range(-2, 3);
		sourceArrayList = getArrayListFromRange();
	}

	@Test
	void lengthTest() {
		assertEquals(6, range.length());
	}

	@Test
	void iterableNoPredicateTest() {
		Integer expected[] = { -2, -1, 0, 1, 2, 3 };
		assertArrayEquals(expected, sourceArrayList.toArray(new Integer[0]));
	}

	@Test
	void iterablePredicateTest() {
		Integer expectedEven[] = { -2, 0, 2 };
		Integer expectedOdd[] = { -1, 1, 3 };
		var actualEvenAL = new ArrayList<Integer>();
		var actualOddAL = new ArrayList<Integer>();

		sourceArrayList.stream().forEach(num -> {
			// implement ternary variation of the code below
			if (num % 2 == 0) {
				actualEvenAL.add(num);
			} else {
				actualOddAL.add(num);
			}
		});

		assertArrayEquals(expectedEven, actualEvenAL.toArray(new Integer[0]));
		assertArrayEquals(expectedOdd, actualOddAL.toArray(new Integer[0]));
	}

	private ArrayList<Integer> getArrayListFromRange() {
		var res = new ArrayList<Integer>();
		for (Integer i : range) {
			res.add(i);
		}
		return res;
	}
}
