package apo.java.practice;

public interface Interface {
    static class A{

    }

    static interface B{

    }

    default void lol(){
        interface C{

        }
    }
}

interface Child extends Interface{
    default void test(){
        Interface.A a = new A();
    }

}
