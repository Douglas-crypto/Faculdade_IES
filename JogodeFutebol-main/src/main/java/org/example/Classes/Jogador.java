package org.example;

import java.util.Scanner;

public class Jogador {

    String nome;
    int jogos;
    int gols;
    int assistencias;

    public void atribuiDados() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Informe o nome do jogador: ");
        this.nome = scanner.next();

        System.out.println("Informe a quantidade de jogos: ");
        this.jogos = scanner.nextInt();

        System.out.println("Informe a quantidade de gols feita: ");
        this.gols = scanner.nextInt();

        System.out.println("Informe a quantidade de assistências: ");
        this.assistencias = scanner.nextInt();
    }

    public void exibirDados() {
        System.out.println("Nome do jogador: " + nome);
        System.out.println("Quantidade de jogos: " + jogos);
        System.out.println("Quantidade de gols: " + gols);
        System.out.println("Quantidade de assistências: " + assistencias);
    }

    public int[] somaAtributos(Jogador outro) {
        int somaJogos = this.jogos + outro.jogos;
        int somaGols = this.gols + outro.gols;
        int somaAssistencias = this.assistencias + outro.assistencias;
        return new int[]{somaJogos, somaGols, somaAssistencias};
    }

    public void exibirSomaAtributos(int[] somas) {
        System.out.println("Soma dos jogos: " + somas[0]);
        System.out.println("Soma dos gols: " + somas[1]);
        System.out.println("Soma das assistências: " + somas[2]);
    }

    public boolean eBom() {
        if (jogos > 5 && gols > 5 && assistencias > 5) {
            System.out.println("É um bom jogador");
            return true;
        } else {
            System.out.println("É um mal jogador");
            return false;
        }
    }
}
