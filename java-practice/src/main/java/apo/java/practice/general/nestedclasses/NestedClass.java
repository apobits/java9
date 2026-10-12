package apo.java.practice.general.nestedclasses;

import java.util.function.Consumer;

//Nested classes except for static member ones cannot have static members, only final static fields(constants)
public class NestedClass {

    private int one = 0;

    public static void main(String[] args) {
        var n = new NestedClass();
        n.someMethod();

        n.new MemberClass();
    }

    public void someMethod() {
        class LocalNestedClass {
            static int l;
             void some() {
                System.out.println(one);
            }
        }
        var c = new LocalNestedClass();
        c.some();

    }

    public void someOtherMethod() {
        Consumer<String> anonymousClass = new Consumer<String>() {
            @Override
            public void accept(String s) {

            }
        };
    }

    private static class StaticMemberClass {
        public static void lol(){

        }
    }

    class MemberClass {
        private static int x;
        public static void lol(){}
    }
}
