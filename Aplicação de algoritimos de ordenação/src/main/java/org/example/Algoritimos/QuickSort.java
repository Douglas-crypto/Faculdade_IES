package org.example.Algoritimos;

import org.example.Classes.Imagem;
import org.example.Interace.ConverteparaArray;

import java.util.List;

public class QuickSort implements ConverteparaArray {  // Implementando a interface

    @Override
    public Imagem[] converte_array(List<Imagem> imagens) {
        if (imagens == null) {
            throw new IllegalArgumentException("Lista de imagens não pode ser nula");
        }
        return imagens.toArray(new Imagem[0]);
    }

    public static void ordenar(Imagem[] imagens, int left, int right) {

        if (left < right) {
            int indexPivo = particionar(imagens, left, right);
            ordenar(imagens, left, indexPivo - 1);
            ordenar(imagens, indexPivo + 1, right);
        }
    }

    private static int particionar(Imagem[] imagens, int left, int right) {
        Imagem pivo = imagens[right];
        int i = left - 1;

        for (int j = left; j < right; j++) {
            if (imagens[j].getData().after(pivo.getData())) {
                i++;
                swap(imagens, i, j);
            }
        }

        swap(imagens, i + 1, right);
        return i + 1;
    }

    private static void swap(Imagem[] array, int i, int j) {
        Imagem temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}