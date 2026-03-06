package org.example.Testes;

import org.example.Classes.Imagem;
import org.example.Classes.CarregaImagem;
import java.util.List;
import java.text.SimpleDateFormat;

public class TesteCarregaImagem {
    public static void main(String[] args) {
        List<Imagem> imagens = CarregaImagem.carregaImagem("/home/douglas/Imagens");

        // Definindo o formato desejado para a data
        SimpleDateFormat formatoData = new SimpleDateFormat("yyyy/MM/dd");

        if (imagens.isEmpty()) {
            System.out.println("Nenhuma imagem carregada.");
        } else {
            System.out.println("Imagens carregadas:");
            for (Imagem img : imagens) {
                // Formatando a data antes de exibir
                String dataFormatada = formatoData.format(img.getData());

                System.out.println("Nome: " + img.getNome() +
                        ", Data: " + dataFormatada);  // Usando a data formatada
            }
        }
    }
}