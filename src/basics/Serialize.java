package basics;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;


//in-complete, complete it from https://www.baeldung.com/java-serialization
public class Serialize {
	public static void main(String[] args) {

	}
}

class Person implements Serializable {
	private int age;
	private String name;
	private Address country; // must be serializable too

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Address getCountry() {
		return country;
	}

	public void setCountry(Address country) {
		this.country = country;
	}

}

class Employee implements Serializable {
	private static final long serialVersionUID = 1L;
	private transient Address address;
	private Person person;

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	private void writeObject(ObjectOutputStream oos) throws IOException {
		oos.defaultWriteObject();
		oos.writeObject(address.getStreet());
	}

	private void readObject(ObjectInputStream ois) throws ClassNotFoundException, IOException {
		ois.defaultReadObject();
		String street = (String) ois.readObject();
		Address a = new Address();
		a.setStreet(street);
		this.setAddress(a);
	}
}