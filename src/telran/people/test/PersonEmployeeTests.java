package telran.people.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import telran.people.*;

class PersonEmployeeTests {

	private static final long ID = 123;
	private static final int BIRTH_YEAR = 2000;
	private static final String EMAIL_1 = "vasya@gmail.com";
	private static final String EMAIL_2 = "vasya@telran.com";
	private static final int SALES = 50;
	private static final int PERCENT_PAY = 50;
	private static final int WAGE = 200;
	private static final int HOURS = 5;
	private static final int WAGE_EMPLOYEE_SALARY = 2000;
	private static final int SALES_PERSON_SALARY = 1025;
	private static final int ANOTHER_BASIC_SALARY = 10000;
	private static final int ANOTHER_SALES = 500;
	private static final int ANOTHER_PERCENT_PAY = 10;
	private static final int ANOTHER_WAGE = 300;
	private static final int ANOTHER_HOURS = 20;
	private static final int ANOTHER_WAGE_EMPLOYEE_SALARY = 7000;
	private static final int ANOTHER_SALES_PERSON_SALARY = 1050;
	private static final int BASIC_SALARY = 100;
	private static final int POOR_SALARY = 99;
	private static final int REACH_SALARY = 101;
	private static final String WRONG_EMAIL = "***@gmail.com";

	@Test
	void personTest() {
		Person person = new Person(ID, BIRTH_YEAR, EMAIL_1);
		// Person constructor and getters test
		assertEquals(ID, person.getId());
		assertEquals(BIRTH_YEAR, person.getBirthYear());
		assertEquals(EMAIL_1, person.getEmail());
		/***************************************/
		// Person setter test
		person.setEmail(EMAIL_2);
		assertEquals(EMAIL_2, person.getEmail());
	}

	void employeeTest() {
		Employee empl = new Employee(ID, BIRTH_YEAR, EMAIL_1, BASIC_SALARY);
		// Employee constructor test
		assertEquals(ID, empl.getId());
		assertEquals(BIRTH_YEAR, empl.getBirthYear());
		assertEquals(EMAIL_1, empl.getEmail());
		/******************************************************/
		// Employee computePay test
		assertEquals(BASIC_SALARY, empl.computePay());
		/***********************************************************/
		// Employee setter test
		empl.setSalary(ANOTHER_BASIC_SALARY);
		assertEquals(ANOTHER_BASIC_SALARY, empl.computePay());
	}

	@Test
	void wageEmployeeTest() {
		WageEmployee wageEmpl = new WageEmployee(ID, BIRTH_YEAR, EMAIL_1, BASIC_SALARY, WAGE, HOURS);
		// WageEmployee constructor test
		assertEquals(ID, wageEmpl.getId());
		assertEquals(BIRTH_YEAR, wageEmpl.getBirthYear());
		assertEquals(EMAIL_1, wageEmpl.getEmail());
		/**********************************************/
		// WageEmployee computePay test
		// assertEquals(WAGE_EMPLOYEE_SALARY, wageEmpl.computePay());
		/***********************************************************/
		// WageEmployee setters test
		wageEmpl.setHours(ANOTHER_HOURS);
		wageEmpl.setWage(ANOTHER_WAGE);
		// assertEquals(ANOTHER_WAGE_EMPLOYEE_SALARY, wageEmpl.computePay());
	}

	@Test
	void salesPersonTest() {
		SalesPerson salesPerson = new SalesPerson(ID, BIRTH_YEAR, EMAIL_1, BASIC_SALARY, SALES, PERCENT_PAY);
		// SalesPerson constructor
		assertEquals(ID, salesPerson.getId());
		assertEquals(BIRTH_YEAR, salesPerson.getBirthYear());
		assertEquals(EMAIL_1, salesPerson.getEmail());
		/**********************************************/
		// SalesPerson computePay test
		// assertEquals(SALES_PERSON_SALARY, salesPerson.computePay());
		/***********************************************************/
		// SalesPerson setters test
		salesPerson.setSales(ANOTHER_SALES);
		salesPerson.setPercentPay(ANOTHER_PERCENT_PAY);
		// assertEquals(ANOTHER_SALES_PERSON_SALARY, salesPerson.computePay());
	}

	@Test
	void wrongBirthYearTest() {
		boolean flException = false;
		try {
			new SalesPerson(123, 2018, "sp@com", 1000, 100, 50);

		} catch (IllegalArgumentException e) {
			flException = true;
			System.out.println(e.getMessage());
		}
		assertTrue(flException);
		try {
			new Employee(100, 1913, EMAIL_2, BASIC_SALARY);
		} catch (IllegalArgumentException e) {
			flException = true;
			System.out.println(e.getMessage());
		}
	}

	@Test
	void wrongBasicSalaryTestTrue() {

		boolean res = false;
		Employee emp1 = new Employee(ID, BIRTH_YEAR, EMAIL_1, BASIC_SALARY);

		try {
			emp1.setSalary(POOR_SALARY);
		} catch (IllegalArgumentException e) {
			res = true;
		}

		assertTrue(res);
	}
	
	@Test
	void wrongBasicSalaryTestFalse() {

		boolean res = true;
		Employee emp1 = new Employee(ID, BIRTH_YEAR, EMAIL_1, BASIC_SALARY);
		
		try {
			emp1.setSalary(REACH_SALARY);
		} catch (IllegalArgumentException e) {
			res = false;
		}
		assertTrue(res);
	}
	
	@Test
	void wrongEmailTest() {
		Employee emp1 = new Employee(ID, BIRTH_YEAR, EMAIL_1, BASIC_SALARY);
		boolean res = false;
		
		try {
			emp1.setEmail(WRONG_EMAIL);
		} catch (IllegalArgumentException e) {
			res = true;
		}
		assertTrue(res);
	}
}
