package apo.java.practice.previewfeature.jdk14;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class PatterMatchingInstanceOf {

    private static String helper = "Default";

    public static void main(String[] args) {
	Object object = new Helper("Albin", 38);
	Object object1 = new HelperChild("Danna", 15, "Perez");

	printString(object);
	intiableScope(object);
	stream(Arrays.asList(object, object1));

    }

    public static void stream(List<Object> objects) {
	Stream stream = objects.stream()
			.filter(t -> t instanceof HelperChild helperChild && helperChild.lastName.equals("Danna"));
	stream.forEach(t -> System.out.println(((HelperChild) t).lastName));
    }

    public static boolean simplifiedOperations(Object object, String name) {
	return object instanceof Helper helper && helper.name.equals(name);
    }

    public static void printString(Object object) {
	if (object instanceof Helper helper) {
	    System.out.println(helper.name);
	}
    }

    public static void intiableScope(Object object) {
	if (object instanceof Helper helper) {
	    System.out.println(helper.name);
	} else {
	    System.out.println(helper);
	}
    }

    static class Helper {
	private String name;
	private int age;

	public Helper(String name, int age) {
	    this.name = name;
	    this.age = age;
	}
    }

    static class HelperChild extends Helper {

	private String lastName;

	public HelperChild(String name, int age) {
	    super(name, age);
	    this.lastName = "";
	}

	public HelperChild(String name, int age, String lastName) {
	    super(name, age);
	    this.lastName = lastName;
	}
    }

}
