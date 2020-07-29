package apo.java.practice.hackerrank.java.datastructures;

import java.util.*;

public class JavaPriorityQueue {
    private final static Scanner scan = new Scanner(System.in);
    private final static Priorities priorities = new Priorities();

    public static void main(String[] args) {
	try (Scanner scanner = new Scanner(System.in)) {
	    var events = scanner.nextInt();
	    scanner.nextLine();
	    List<String> eventList = new ArrayList<>(events);
	    while (events-- > 0) {
		eventList.add(scanner.nextLine());
	    }
	    var students = new Priorities().getStudents(eventList);
	    if (students.isEmpty()) {
		System.out.println("EMPTY");
	    } else {
		students.forEach(t -> System.out.println(t.getName()));
	    }
	}
    }

}

class Priorities {
    public List<Student> getStudents(List<String> events) {
	Comparator<Student> comparator = Comparator.comparing(Student::getCgpa).reversed()
			.thenComparing(Student::getName).thenComparing(Student::getId);
	PriorityQueue<Student> students = new PriorityQueue<>(comparator);
	for (String event : events) {
	    String[] array = event.split(" ");
	    if (array.length > 1) {
		students.offer(new Student(Integer.parseInt(array[3]), array[1], Double.parseDouble(array[2])));
	    } else {
		students.poll();
	    }
	}
	var studentList = new ArrayList<>(students);
	studentList.sort(comparator);
	return studentList;
    }
}

class Student {
    private int id;
    private String name;
    private double cgpa;

    public Student(int id, String name, double cgpa) {
	this.id = id;
	this.name = name;
	this.cgpa = cgpa;
    }

    public double getCgpa() {
	return cgpa;
    }

    public int getId() {
	return id;
    }

    public String getName() {
	return name;
    }

    @Override
    public String toString() {
	return "Student{" + "id=" + id + ", name='" + name + '\'' + ", cgpa=" + cgpa + '}';
    }
}
