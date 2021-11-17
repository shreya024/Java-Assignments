import java.io.*;

class A {
    private int x = 5;

    void show() {
        System.out.println(x);
    }

    void f1() {
        System.out.println("INSIDE F1");
    }
}

class B extends A {
    private int x = 7;

    void show() {
        System.out.println(+x);
        super.show();
    }

    void f2() {
        System.out.println("INSIDE F2");
    }
}

class C extends B {
    private int x = 9;

    void show() {
        System.out.println(+x);
        super.show();
    }

    void f3() {
        System.out.println("INSIDE F3");
    }
}

public class Assignment5 {

    public static void main(String[] args) throws IOException {

        C c1 = new C();
        c1.show();
        c1.f1();
        c1.f2();
        c1.f3();
    }

}