package apo.java.practice.codewars;

public class FakeBinary {

    public static void main(String[] args) {
	System.out.println(fakeBin("145178"));
    }

    public static String fakeBin(String numberString) {
	return numberString.replaceAll("[0-4]","0").replaceAll("[5-9]","1");
    }

}
