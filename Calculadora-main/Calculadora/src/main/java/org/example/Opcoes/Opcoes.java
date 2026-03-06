package org.example.Opcoes;

public enum Opcoes {
    SOMA("+"),
    SUBTRACAO("-"),
    DIVISAO("/"),
    MULTIPLICACAO("*");

    private String simbolo;

    Opcoes(String simbolo) {
        this.simbolo = simbolo;
    }

    public String getSimbolo() {
        return simbolo;
    }

    public static Opcoes fromSimbolo(String simbolo) {
        for (Opcoes operacao : Opcoes.values()) {
            if (operacao.getSimbolo().equals(simbolo)) {
                return operacao;
            }
        }
        throw new IllegalArgumentException("Operação inválida: " + simbolo);
    }
}
