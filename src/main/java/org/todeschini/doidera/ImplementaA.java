package org.todeschini.doidera;

public class ImplementaA implements MyInterface {


    @Override
    public void a() {
        System.out.println("A");
    }

    @Override
    public void b() {
        System.out.println("B");
    }

    public void c(String s) {
        System.out.println("c");
        System.out.println(s);
    }

    public void d(Integer i) {
        System.out.println("d");
        System.out.println(i);
    }
}
