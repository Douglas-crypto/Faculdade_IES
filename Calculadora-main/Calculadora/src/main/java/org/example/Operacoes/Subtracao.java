package org.example.Operacoes;

import org.example.Interface.Operacao;

public class Subtracao implements Operacao {
    @Override
    public double calcular(double a, double b) {
        return a - b;
    }
}
