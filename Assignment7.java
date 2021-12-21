import java.io.*;

abstract class A {
    abstract void f1();

    abstract class B {
        abstract void f2();
    }
}

interface C {
    void f3();
}

interface D {
    void f4();
}

interface E extends C, D {
    void f5();
}

interface F {
    void f6();

    abstract class G {
        abstract void f7();
    }
}

interface H {
    void f8();

    interface I {
        void f9();
    }
}

// Implement A,B,C,D,E,F,G,H,I in a single class with minimum object creation
public class Assignment7 extends A implements E, F, H, H.I {
    public void f1() {
        System.out.println("Inside method A.f1");
    }

    public void f3() {
        System.out.println("Inside method C.f3");
    }

    public void f4() {
        System.out.println("Inside method D.f4");
    }

    public void f5() {

        f3();
        f4();
        System.out.println("Inside method E.f5");
    }

    public void f6() {
        System.out.println("Inside method F.f6");
    }

    public void f8() {
        System.out.println("Inside method H.f8");
    }

    public void f9() {
        f8();
        System.out.println("Inside method I.f9");

    }

    public static void main(String[] args) throws IOException {
        A obj2 = new Assignment7();
        obj2.f1();
        A.B obj5 = new Assignment7().new B() {

            void f2() {

                System.out.println("Inside method B.f2");
            }
        };
        obj5.f2();
        E obj = new Assignment7();
        obj.f5();

        F obj4 = new Assignment7();
        obj4.f6();
        F.G obj3 = new F.G() {

            void f7() {
                System.out.println("Inside method G.f7");
            }
        };
        obj3.f7();

        H.I obj6 = new Assignment7();
        obj6.f9();
    }
}
