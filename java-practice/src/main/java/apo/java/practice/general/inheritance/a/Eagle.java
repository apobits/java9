package apo.java.practice.general.inheritance.a;

public class Eagle extends Animal {

    public void checkingAccessibility(){
        //private fields are not accessible in any subclass in the same package
        //System.out.println(this.type);

	//protected fields are accessible in any subclass in the same package
	System.out.println(this.speed);

	//public fields are accessible in any subclass in the same package
	System.out.println(this.aggresivness);

	//package private fields are accessible in any subclass in the same package
	System.out.println(this.vision);
    }
}
