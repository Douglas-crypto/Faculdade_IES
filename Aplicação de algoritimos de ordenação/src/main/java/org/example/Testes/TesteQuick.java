package org.example.Testes;

import org.example.Algoritimos.QuickSort;
import org.example.Classes.CarregaImagem;
import org.example.Classes.Imagem;

import java.text.SimpleDateFormat;
import java.util.List;

public class TesteQuick {

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
        QuickSort quickSort = new QuickSort();
        Imagem[] arrayImagens = quickSort.converte_array(imagens);

        // 3. Exibir antes da ordenação
        System.out.println("=== ANTES DA ORDENAÇÃO ===");
        exibirImagens(arrayImagens);

        // 4. Ordenar por data (decrescente)
        QuickSort.ordenar(arrayImagens, 0, arrayImagens.length - 1);

        // 5. Exibir após ordenação
        System.out.println("\n=== APÓS ORDENAÇÃO (Mais recente primeiro) ===");
        exibirImagens(arrayImagens);
    }

    private static void exibirImagens(Imagem[] imagens) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        System.out.println("Nome | Data (ano/mês/dia) | Tamanho (bytes)");
        System.out.println("-----------------------------");

        for (Imagem img : imagens) {
            System.out.println(img.getNome() + " | " +
                    sdf.format(img.getData()) + " | " +
                    img.getTamanho());
        }
    }
}

