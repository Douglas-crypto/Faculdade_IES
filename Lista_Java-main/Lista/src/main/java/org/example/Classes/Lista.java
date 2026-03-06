package org.example.Classes;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Lista {
    //Criar uma lista
    private List<String> lista = new ArrayList<>();
    //Criar um scanner
    private Scanner scanner = new Scanner(System.in);

    //metodo que pede o nome a ser adicionado, variavel nome armazena o nome informado, adiciona a lista nome
    public void adicionarElemento() {
        System.out.println("Informe o nome a ser adicionado: ");
        String nome = scanner.nextLine();
        lista.add(nome);
    }

    // exibir: "Tamanho da lista:" + lista.size e "Nomes da lista:" + lista
    public void exibirElemento() {
        System.out.println("Tamanho da lista: " + lista.size());
        System.out.println("Nomes da lista: " + lista);
    }

    //Remover um elemento da lista por indice da lista,
    //Não existe indices < 0 somente >= 0 e indie < lsita.size, caso fosse > lista.size erro pois
    public String removerElementoPorIndice(int indice) {
        if (indice >= 0 && indice < lista.size()) {
            return "Elemento removido: " + lista.remove(indice);
        }
        return "Índice da lista invalido, elemento não está na lista.";
    }

    //enquanto o metodo for verdadeiro sout informa elemento e na variavel elemento armazena o elemento digitado
    public void acessarElementoEspecifico() {
        while (true) {
            System.out.println("Informe o elemento a ser acessado (ou 'sair' para cancelar): ");
            String elemento = scanner.nextLine();

            if (elemento.equalsIgnoreCase("sair")) {
                System.out.println("Operação cancelada.");
                break;
            }

            //Caso o usuario digitou algo que esta na lista
            //se a lista contem o elemento informar o elemento, caso contrario uma mensagem
            if (lista.contains(elemento)) {
                System.out.println("Elemento encontrado: " + elemento);
                break;
            } else {
                System.out.println("Elemento inexistente. Tente novamente.");
            }
        }
    }
}
