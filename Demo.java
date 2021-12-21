class A {
    void show() {
        System.out.println("Inside show of A");
    }
}

class B extends A {
    void show() {
        super.show();
        System.out.println("Inside show of B");
    }
}

class Demo {
    public static void main(String args[]) {
        A a1 = new B();
        a1.show();
    }
}