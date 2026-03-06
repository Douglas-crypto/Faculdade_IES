package org.example;

public class Main {
    public static void main(String[] args) {
        
        Jogador jogador1 = new Jogador();
        Jogador jogador2 = new Jogador();

        System.out.println("Informe os dados do Jogador 1:");
        jogador1.atribuiDados();

        System.out.println("Informe os dados do Jogador 2:");
        jogador2.atribuiDados();

        System.out.println("\nInformações do Jogador 1:");
        jogador1.exibirDados();

        System.out.println("\nInformações do Jogador 2:");
        jogador2.exibirDados();

        int[] somas = jogador1.somaAtributos(jogador2);

        System.out.println("\nSoma dos atributos dos jogadores:");
        System.out.println("Jogadores: " + jogador1.nome + " e " + jogador2.nome);
        jogador1.exibirSomaAtributos(somas);

        System.out.println("\nAvaliação do Jogador 1:");
        boolean jogador1Bom = jogador1.eBom(); // Exibe a mensagem e armazena o resultado

        System.out.println("\nAvaliação do Jogador 2:");
        boolean jogador2Bom = jogador2.eBom(); // Exibe a mensagem e armazena o resultado

        if (jogador1Bom && jogador2Bom) {
            System.out.println("\nAmbos os jogadores são bons!");
        } else if (jogador1Bom || jogador2Bom) {
            System.out.println("\nApenas um dos jogadores é bom.");
        } else {
            System.out.println("\nNenhum dos jogadores é bom.");
        }
    }
}
