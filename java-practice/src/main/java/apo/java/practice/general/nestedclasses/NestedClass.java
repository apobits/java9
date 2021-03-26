package apo.java.practice.general.nestedclasses;

import java.util.function.Consumer;

//Nested classes except for static member ones cannot have static members, only final static fields(constants)
public class NestedClass {

    public void someMethod(){
        class LocalNestedClass{

	}
    }

    public void someOtherMethod(){
	Consumer<String> anonymousClass = new Consumer<String>() {
	    @Override
	    public void accept(String s) {

	    }
	};
    }

    private static class StaticMemberClass{

    }

    private class MemberClass{

    }
}
