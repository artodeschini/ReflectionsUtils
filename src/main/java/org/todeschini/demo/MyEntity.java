package org.todeschini.demo;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MyEntity implements Serializable {

    private Long id;
    private String nome;
    private LocalDate data;
    private List<String> itens = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public List<String> getItens() {
        return itens;
    }

    public void setItens(List<String> itens) {
        this.itens = itens;
    }

    @Override
    public String toString() {
        return "MyEntity{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", data=" + data +
                ", itens=" + itens +
                '}';
    }
}
