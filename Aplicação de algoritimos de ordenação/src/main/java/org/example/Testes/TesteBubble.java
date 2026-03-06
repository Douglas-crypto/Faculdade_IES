package org.example.Testes;

import org.example.Algoritimos.BubbleSort;
import org.example.Classes.CarregaImagem;
import org.example.Classes.Imagem;
import java.util.List;


public class TesteBubble {


    public static void main(String[] args) {
        String caminhoPasta = "/home/douglas/Imagens";
        List<Imagem> imagens = CarregaImagem.carregaImagem(caminhoPasta);

        BubbleSort bubbleSort = new BubbleSort();
        Imagem[] arrayImagens = bubbleSort.converte_array(imagens);

        System.out.println("=== ANTES DA ORDENAÇÃO ===");
        exibirImagens(arrayImagens);

        BubbleSort.bubbleSort(arrayImagens);

        System.out.println("\n=== APÓS ORDENAÇÃO ===");
        exibirImagens(arrayImagens);
    }

    private static void exibirImagens(Imagem[] imagens) {
        System.out.println("Nome | Data (ano/mês/dia) | Tamanho");
        System.out.println("-----------------------------------");

        for (Imagem img : imagens) {
            String dataFormatada = String.format("%tY/%tm/%td", img.getData(), img.getData(), img.getData());
            System.out.println(img.getNome() + " | " + dataFormatada + " | " + img.getTamanho() + " bytes");
        }
    }
}

