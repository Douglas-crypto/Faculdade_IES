package org.example.Testes;

import org.example.Classes.CarregaImagem;
import org.example.Classes.ComparaAlgoritmos;
import org.example.Classes.Imagem;

import java.util.List;

public class TesteComparaAlgoritmo {

    public static void main(String[] args) {
        String caminhoPasta = "/home/douglas/Imagens";

        List<Imagem> imagens = CarregaImagem.carregaImagem(caminhoPasta);

        if (imagens == null || imagens.isEmpty()) {
            System.out.println("Nenhuma imagem carregada. Verifique o caminho: " + caminhoPasta);
            return;
        }

        // MENSAGEM "ANTES"
        System.out.println("Imagens carregadas com sucesso. Iniciando comparação dos algoritmos de ordenação...\n");

        ComparaAlgoritmos comparador = new ComparaAlgoritmos();
        comparador.executarComparacao(imagens);

        // MENSAGEM "DEPOIS"
        System.out.println("\nComparação finalizada.");
    }
}
