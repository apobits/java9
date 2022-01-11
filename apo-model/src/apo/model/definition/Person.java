package apo.model.definition;

public class Person {
    private String name;
    private String lastName;

    public Person(String name, String lastName) {
	this.name = name;
	this.lastName = lastName;
    }

    public String getName() {
	return name;
    }

    public String getLastName() {
	return lastName;
    }

    @Override
    public String toString() {
	return "Person{" + "name='" + name + '\'' + ", lastName='" + lastName + '\'' + '}';
    }
}
