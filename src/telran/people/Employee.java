package telran.people;

public class Employee extends Person {
	private static final int BASIC_SALARY = 100;	
	private int salary;
	private static int minBirthYear = 1950;
	private static int maxBirthYear = 2000;

	public static int getMinBirthYear() {
		return minBirthYear;
	}

	public static void setMinBirthYear(int minBirthYear) {
		Employee.minBirthYear = minBirthYear;
	}

	public static int getMaxBirthYear() {
		return maxBirthYear;
	}

	public static void setMaxBirthYear(int maxBirthYear) {
		Employee.maxBirthYear = maxBirthYear;
	}

	public Employee(long id, int birthYear, String email, int salary) {
		super(id, birthYear, email);
		if (birthYear < minBirthYear || birthYear > maxBirthYear) {
			throw new IllegalArgumentException(String.format("%d - wrong birth year, " + "should be in range [%d - %d]",
					birthYear, minBirthYear, maxBirthYear));
		}
		setSalary(salary);
	}

	public void setSalary(int salary) {
		if (BASIC_SALARY > salary) {
			throw new IllegalArgumentException(
					String.format("%d is not enough,"+
			" should be not less then %d", salary, BASIC_SALARY));
		} else {
			this.salary = salary;
		}
	}

	public int computePay() {
		return BASIC_SALARY;
	}

}
