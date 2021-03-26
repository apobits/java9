package apo.java.practice.daily;

public class Generic<T extends String> {
    private T t;

    public void setT(T t) {
	this.t = t;
    }

    public T getT() {
	return t;
    }

    public static <U> U process(U... us) {
	return us[1];
    }

}
