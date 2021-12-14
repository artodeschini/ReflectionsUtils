package org.todeschini.singleton;

public class Singleton {

    private static volatile Singleton instance;

    public static synchronized Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                instance = new Singleton();
            }
        }
        return instance;
    }
}
