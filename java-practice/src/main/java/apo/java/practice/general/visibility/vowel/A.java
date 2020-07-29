package apo.java.practice.general.visibility.vowel;

public class A {
    protected final String name = A.class.getName();
    final String nameReference = name;
}
