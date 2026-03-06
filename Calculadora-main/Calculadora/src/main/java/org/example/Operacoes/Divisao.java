package org.example.Operacoes;

import org.example.Interface.Operacao;

public class Divisao implements Operacao {
    @Override
    public double calcular(double a, double b) {
        return a / b;
    }
}

