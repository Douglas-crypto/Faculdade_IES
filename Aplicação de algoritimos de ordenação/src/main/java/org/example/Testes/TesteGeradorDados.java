package org.example.Testes;

import org.example.Classes.GeradorDados;
import org.example.Classes.Imagem;

import java.util.List;

public class TesteGeradorDados {
    public static void main(String[] args) {
        // Gerar uma lista de 5 imagens aleatórias
        List<Imagem> imagens = GeradorDados.gerarImagensAleatorias(100000);

        // Exibir as imagens geradas
        for (Imagem imagem : imagens) {
            System.out.println(imagem);
        }
    }
}
