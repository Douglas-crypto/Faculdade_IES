package org.example.Classes;

// Vai armazenar os dados das imagens

import java.util.Date;

public class Imagem {

    private final String nome;
    private final long tamanho;
    private final Date data;

    public Imagem(String nome, long tamanho,Date data){
        this.nome = nome;
        this.tamanho = tamanho;
        this.data = data;
    }

    public long getTamanho() {
        return tamanho;
    }

    public String getNome() {
        return nome;
    }

    public Date getData() {
        return data;
    }
}