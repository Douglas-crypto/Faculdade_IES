package org.example.Resultados;

import org.example.Classes.ComparaAlgoritmos;
import org.example.Classes.GeradorDados;
import org.example.Classes.Imagem;

import java.util.List;

public class Resultados {
    public static void main(String[] args) {
        List<Imagem> imagens = GeradorDados.gerarImagensAleatorias(100);

        // Exibir as imagens geradas (opcional)
        System.out.println("Imagens geradas:");
        for (Imagem imagem : imagens) {
            System.out.println(imagem);
        }
        // Comparar algoritmos com as imagens geradas
        ComparaAlgoritmos comparador = new ComparaAlgoritmos();
        comparador.executarComparacao(imagens);

        System.out.println("Dados já ordenados");
        comparador.executarComparacao(imagens);

    }
}
