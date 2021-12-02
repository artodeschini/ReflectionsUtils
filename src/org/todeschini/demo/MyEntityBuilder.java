package org.todeschini.demo;

import java.lang.Long;
import java.util.Arrays;
import java.time.LocalDate;
import java.lang.String;

import org.todeschini.demo.MyEntity;


public class MyEntityBuilder {
    private MyEntity element;

    private MyEntityBuilder() {
    }

    public static MyEntityBuilder BuilderMyEntity() {
        MyEntityBuilder builder = new MyEntityBuilder();
        initObject(builder);
        return builder;
    }

    public static void initObject(MyEntityBuilder builder) {
        builder.element = new MyEntity();
        MyEntity element = builder.element;


        element.setId(0L);
        element.setNome("");
        element.setData(null);
        element.setItens(null);
    }

    public MyEntityBuilder id(Long param) {
        element.setId(param);
        return this;
    }

    public MyEntityBuilder nome(String param) {
        element.setNome(param);
        return this;
    }

    public MyEntityBuilder data(LocalDate param) {
        element.setData(param);
        return this;
    }

    public MyEntityBuilder comListaItens(String... params) {
        element.setItens(Arrays.asList(params));
        return this;
    }

    public MyEntity build() {
        return element;
    }
}
