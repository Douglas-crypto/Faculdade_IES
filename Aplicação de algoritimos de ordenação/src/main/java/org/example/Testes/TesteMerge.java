package org.example.Testes;

import org.example.Algoritimos.MergeSort;
import org.example.Classes.CarregaImagem;
import org.example.Classes.Imagem;
import java.util.List;

public class TesteMerge {
    public static void main(String[] args) {
        // Configuração do teste
        String caminhoPasta = "/home/douglas/Imagens";

        // 1. Carregar imagens
        List<Imagem> imagens = CarregaImagem.carregaImagem(caminhoPasta);

        if (imagens.isEmpty()) {
            System.out.println("Nenhuma imagem encontrada no diretório: " + caminhoPasta);
            return;
        }

        // 2. Converter para array
        MergeSort mergeSort = new MergeSort();
        Imagem[] arrayImagens = mergeSort.converte_array(imagens);

        // 3. Exibir antes da ordenação
        System.out.println("=== ANTES DA ORDENAÇÃO ===");
        exibirImagens(arrayImagens);

        // 4. Ordenar por data (decrescente)
        MergeSort.mergeSort(arrayImagens, 0, arrayImagens.length - 1);

        // 5. Exibir após ordenação
        System.out.println("\n=== APÓS ORDENAÇÃO (Mais recente primeiro) ===");
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