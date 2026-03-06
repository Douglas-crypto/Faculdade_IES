package org.example.Main;

import org.example.Classes.Lista;

public class Main {
    public static void main(String[] args) {

        Lista lista1 = new Lista();

        lista1.adicionarElemento();
        lista1.adicionarElemento();

        lista1.exibirElemento();

        lista1.removerElementoPorIndice(1);

        lista1.exibirElemento();

        lista1.acessarElementoEspecifico();
    }
}