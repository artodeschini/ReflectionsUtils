package org.todeschini.demo;

import org.todeschini.singleton.Singleton;

import java.lang.reflect.Field;
import java.time.LocalDate;

public class TestUse {

    public static void main(String[] args) {
        MyEntity e = MyEntityBuilder.BuilderMyEntity().id(1L).nome("A").data(LocalDate.of(2021, 11, 3)).comListaItens(new String[]{"A", "B", "C"}).build();
        System.out.println(e);

        MyEntity other = MyEntityBuilder.BuilderMyEntity().build();
        System.out.println(other);

        Singleton s1 = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();

        System.out.println(s1 == s2);

        try {
            Field instance = Singleton.class.getDeclaredField("instance");
            instance.setAccessible(true);
            instance.set(instance, new Singleton());

        } catch (NoSuchFieldException noSuchFieldException) {
            noSuchFieldException.printStackTrace();
        } catch (IllegalAccessException illegalAccessException) {
            illegalAccessException.printStackTrace();
        }

        Singleton s3 = Singleton.getInstance();

        System.out.println(s1 == s3);
    }
}
