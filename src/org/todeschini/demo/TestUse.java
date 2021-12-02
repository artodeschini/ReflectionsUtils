package org.todeschini.demo;

import java.time.LocalDate;

public class TestUse {

    public static void main(String[] args) {
        MyEntity e = MyEntityBuilder.BuilderMyEntity().id(1L).nome("A").data(LocalDate.of(2021, 11, 3)).comListaItens(new String[]{"A", "B", "C"}).build();
        System.out.println(e);

        MyEntity other = MyEntityBuilder.BuilderMyEntity().build();
        System.out.println(other);
    }
}
