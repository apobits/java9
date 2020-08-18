package apo.greeting.contract;

import apo.greeting.imp.GreetingImp;

public interface Greeting {
    String greet(String name);

    static Greeting newGreeting() {
	return new GreetingImp();
    }
}
