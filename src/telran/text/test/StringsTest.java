package telran.text.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static telran.text.Strings.*;

class StringsTest {
	String date1 = "10/08/2021";
	String date2 = "30/12/2020";
	String date3 = "5/08/2021";
	
	String [] testArray = new String [3];
	String [] expectationArray = new String [3];

	@BeforeEach
	void setUp() throws Exception {
		testArray [0] = date1;
		testArray [1] = date2;
		testArray [2] = date3;
		
		expectationArray [0] = date1;
		expectationArray [1] = date2;
		expectationArray [2] = date3;

	}

	@Test
	void testSortStringsAsDates() {
		assertArrayEquals (expectationArray, sortStringsAsDates(testArray));
	}

}
