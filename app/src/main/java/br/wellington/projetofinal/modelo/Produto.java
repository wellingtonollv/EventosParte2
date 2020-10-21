package br.wellington.projetofinal.modelo;

import java.io.Serializable;

import br.wellington.projetofinal.MainActivity;

public class Produto implements Serializable {

    private int id;
    private String nome;
    private Float valor;

    public Produto(int id, String nome, Float valor) {
        this.id = id;
        this.nome = nome;
        this.valor = valor;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public Float getValor() {
        return valor;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setValor(Float valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return nome;

    }
}
