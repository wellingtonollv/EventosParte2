package br.wellington.projetofinal.modelo;

import java.io.Serializable;

import br.wellington.projetofinal.MainActivity;

public class Produto implements Serializable {
    private String nome;
    private Float valor;

    public Produto(String nome, Float valor) {
        this.nome = nome;
        this.valor = valor;
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
