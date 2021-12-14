package org.todeschini.demo;

public final class FinalClass {

    public static FinalClass instance;

    private FinalClass() {

    }

    public static FinalClass getInstance() {
        if (instance == null) {
            instance = new FinalClass();
        }
        return instance;
    }

    public String sample() {
        return "sample";
    }

}
