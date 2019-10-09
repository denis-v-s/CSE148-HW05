/**
 * Person
 */
public class Person {
	private String name;
	private String address;
	private int age;
  private String phoneNumber;
  private String gender;
  
  public Person() {}

  public Person(String name, String address, int age, String phoneNumber, String gender) {
    this.name = name;
    this.address = address;
    this.age = age;
    this.phoneNumber = phoneNumber;
    this.gender = gender;
  }

	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}

	// getters / setters for name, address, age, and phone
	public String getAddress() {
		return this.address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

	public int getAge() {
		return this.age;
	}
	public void setAge(int age) {
		this.age = age;
	}

	public String getPhoneNumber() {
		return this.phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
  }
  
  public String getGender() {
    return this.gender;
  }
  public void setGender(String gender) {
    this.gender = gender;
  }

  @Override
	public String toString() {
		return String.format(
				"My name is %S, I'm %d years old, %s",
				this.getName(),
				this.getAge(),
				this.getGender()
		);
  }
  
  // equals if name, age, and gender are the same
  @Override
  public boolean equals(Object o) {
    Person p = (Person) o;
    return (
      this.getName().equals(p.getName()) && 
			this.getAge() == p.getAge() &&
			this.getAddress().equals(p.getAddress()) &&
			this.getPhoneNumber().equals(p.getPhoneNumber()) &&
			this.getGender().equals(p.getGender())
    );
  }

	public static void main(String[] args) {
		// Write appropriate getter and setter methods. Test the program by creating two
		// instances (objects) and printing out the information.

		Person p1 = new Person();
		Person p2 = new Person();

		p1.setName("John Doe");
		p1.setAddress("123 whatever street");
		p1.setAge(21);
		p1.setPhoneNumber("321 456 4566");

		p2.setName("Jane Doe");
		p2.setAddress("456 another street");
		p2.setAge(19);
		p2.setPhoneNumber("888 454 2221");

		System.out.println(p1);
		System.out.println(p2);
	}
}