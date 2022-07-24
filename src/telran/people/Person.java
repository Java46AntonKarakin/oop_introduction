package telran.people;

public class Person implements Comparable<Person> {
	private long id;
	private int birthYear;
	private String email;

	public Person(long id, int birthYear, String email) {
		this.id = id;
		this.birthYear = birthYear;
		setEmail(email);
	}

	public String getEmail() {
		return email;
	}

	
	public void setEmail(String email) {
		String emailRegex = "(([0-9a-zA-Z.-]+)@([0-9a-zA-Z]+).[a-z]+)?";
		if (!email.matches(emailRegex)) {
			throw new IllegalArgumentException(String.format("\"%s\" wrong email format", email));
		} else {
			this.email = email;
		}
		this.email = email;
	}
	
	

	public long getId() {
		return id;
	}

	public int getBirthYear() {
		return birthYear;
	}

	@Override
	public int compareTo(Person o) {

		return Long.compare(this.id, o.id);
	}

}
