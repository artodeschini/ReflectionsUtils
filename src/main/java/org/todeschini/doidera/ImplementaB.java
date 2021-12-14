package org.todeschini.doidera;

public class ImplementaB implements MyInterface {
    @Override
    public void a() {
        System.out.println("A");
    }

    @Override
    public void b() {
        System.out.println("B");
    }

    public void c(Long l) {
        System.out.println("c");
        System.out.println(l);
    }

    public void d(Object o) {
        System.out.println("d");
        System.out.println(o);
    }
}
