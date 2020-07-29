package apo.java.practice.general.visibility.vowel;

public class E {

    public void accessingAProperty() {
	var a = new A();
	//Class protected property accessible from another class within its same package
	System.out.println(a.name);
	//Class package private property accessible from another class withing same package
	System.out.println(a.nameReference);
    }
}
