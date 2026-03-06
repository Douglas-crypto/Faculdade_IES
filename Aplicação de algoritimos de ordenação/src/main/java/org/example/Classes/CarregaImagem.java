package org.example.Classes;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CarregaImagem {

    public static List<Imagem> carregaImagem(String caminhoPasta) {
        List<Imagem> imagens = new ArrayList<>();
        File file = new File(caminhoPasta);

        // Verifica se o caminho é um diretório válido
        if (file.isDirectory()) {
            File[] files = file.listFiles(); // Lista todos os arquivos

            if (files != null) {
                for (File arquivo : files) {
                    // Verifica se é arquivo e tem extensão de imagem
                    if (arquivo.isFile() && isImagem(arquivo.getName())) {
                        Imagem imagem = new Imagem(
                                arquivo.getName(),
                                arquivo.length(),
                                new Date(arquivo.lastModified())
                        );
                        imagens.add(imagem);
                    }
                }
            }
        }

        return imagens;
    }

    // Método auxiliar para verificar se o arquivo é uma imagem
    private static boolean isImagem(String nomeArquivo) {
        String[] extensoes = {".jpg", ".jpeg", ".png"};

        for (String extensao : extensoes) {
            if (nomeArquivo.toLowerCase().endsWith(extensao)) {
                return true;
            }
        }
        return false;
    }
}
