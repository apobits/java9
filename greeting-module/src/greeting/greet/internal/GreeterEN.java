package greeting.greet.internal;

import greeting.greet.Greet;

import java.util.Locale;

public class GreeterEN implements Greet {
    @Override
    public String sayHi(String name) {
	return "Hello " + name;
    }

    @Override
    public Locale getLocale() {
	return Locale.ENGLISH;
    }
}
