package apo.greeting.imp;

import apo.greeting.contract.Greeting;

public class GreetingImp implements Greeting {

    @Override
    public String greet(String name) {
	return "Welcome to Java modularity: " + name;
    }
}
