package apo.java.practice.general.inheritance.b;

import apo.java.practice.general.inheritance.a.Animal;

public class Lion extends Animal {

    public void checkingAccessibility(){
        //private fields are not accessible in any subclass from other package
	//System.out.println(this.type);

	//protected fields are accessible in any subclass from other package
	System.out.println(speed);

	//public fields are accessible in any subclass from other package
	System.out.println(aggresivness);

	//package private fields are not accessible in any subclass from other package
	//System.out.println(this.vision);
    }
}
