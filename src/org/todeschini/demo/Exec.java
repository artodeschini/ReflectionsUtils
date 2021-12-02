package org.todeschini.demo;

import org.todeschini.BuilderMaster;

public class Exec {

    public static void main(String[] args) {
        new BuilderMaster().gerarCodigoClasse(MyEntity.class);
    }
}
