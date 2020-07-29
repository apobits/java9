package apo.java.practice.general.visibility.letter;

import apo.java.practice.general.visibility.vowel.A;

public class B extends A {

    public void accessingAProtectedPropertySubclassing() {
	//A::name protected property is accessible from a subclass in another package
	System.out.println(name);
    }

    public void accessingAProtectedProperty() {
	var a = new A();
	//A::name Protected property is not accessible from a class in another package
	System.out.println();
    }

    public void accessingAPackagePrivateProperty() {
	var a = new A();
	//A::nameReference package private property is not accessible from any class or subclass outside its package
	System.out.println();
    }
}
