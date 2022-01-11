package apo.java.practice.sealed;

public sealed class A {

    public void lol(){

    }

    public static void main(String[] args) {
        var c = new C();
        System.out.println(c instanceof A);
    }
}

non-sealed class B extends A {

}

class C extends B {
    @Override
    public void lol() {
        super.lol();
    }
}
