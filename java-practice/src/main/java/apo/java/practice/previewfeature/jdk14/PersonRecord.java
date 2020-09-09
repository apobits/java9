package apo.java.practice.previewfeature.jdk14;

//Records extends Record class and defines it's parameters as final fields(By the compiler)
//Records defines toString(), equals(), hashcode() methods(By the compiler)
//Records do not generate getters and setters, it's properties are accessed by methods called as the same as the properties(By the compiler)
public record PersonRecord(String name, String lastName) {

    //Records can have static fields, they cannot have instance fields
    public static String surName;

    //Records can have compact constructors, canonical constructors or custom constructor

    //Custom constructor
    public PersonRecord(String lastName) {
	this(null, lastName);
    }

    public static void main(String[] args) {
	PersonRecord personRecord = new PersonRecord("Albin", "Perez");
	System.out.println(personRecord);

    }

    //Records can have static methods
    public static void doSomething() {
	System.out.println("Printing something");
    }

    //Records can have instance methods
    public void print() {
	System.out.println(name + lastName);
    }

}
