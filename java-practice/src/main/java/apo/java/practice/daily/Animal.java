package apo.java.practice.daily;

public interface Animal {

    static Animal createAnimal() {
	return new Lion();
    }
}
