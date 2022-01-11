package greeting.greet;

import java.util.Locale;

public interface Greet {
    String sayHi(String name);

    Locale getLocale();
}
