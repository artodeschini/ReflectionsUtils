package org.todeschini.doidera;

import java.lang.reflect.Method;
import java.util.concurrent.atomic.AtomicInteger;

public class Test {

    public static AtomicInteger C = new AtomicInteger();

    public static void main(String[] args) throws Exception {
        MyInterface a = new ImplementaA();
        MyInterface b = new ImplementaB();

        System.out.println(a.getClass());
        System.out.println(b.getClass());


        try {
            callMethod(a, "c", new Class[] {String.class}, new Object[] {"um teste"});
        } catch (Exception e) {
            e.printStackTrace();
        }
        C.incrementAndGet();

        System.out.println(C.get());
        try {
            Object o = callStaticMethod( Test.class, "callStaticMethod", new Class[] {String.class, String.class}, new Object[]{"1", "foi"});
            System.out.println(o);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public static void  callMethod(MyInterface i, String name, Class[] parameterTypes, Object[] params) throws Exception {
        Class<?> c = i.getClass();
        Method method = c.getDeclaredMethod(name, parameterTypes);
        method.invoke(i, params);
    }

    public static Object callStaticMethod(Class clazz, String name, Class[] parameterTypes, Object[] params) throws Exception {
        Class<?> c = clazz;
        Method method = c.getDeclaredMethod(name, parameterTypes);
        Object o = method.invoke(c, params);
        return o;
    }

    //FIXME ajustar para funcionar de maneira adequada
    public static int myStaticMethod(String s1, String s2) {
        int i = Integer.parseInt(s1);
        System.out.println(s2);
        System.out.println(i);
        return i;
    }
}
