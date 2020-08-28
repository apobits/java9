package apo.java.practice.daily;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class DailyPractice {

    public static void main(String[] args) throws IOException {

    }
}

class Person {
    private String name;
    private int id;

    public Person(String name, int id) {
	this.name = name;
	this.id = id;
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public int getId() {
	return id;
    }

    public void setId(int id) {
	this.id = id;
    }
}
