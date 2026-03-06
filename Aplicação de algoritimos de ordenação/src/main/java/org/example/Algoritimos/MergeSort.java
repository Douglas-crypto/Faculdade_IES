package org.example.Algoritimos;

import org.example.Interace.ConverteparaArray;
import org.example.Classes.Imagem;
import java.util.List;

public class MergeSort implements ConverteparaArray {

    @Override
    public Imagem[] converte_array(List<Imagem> imagens) {
        if (imagens == null) {
            throw new IllegalArgumentException("Lista de imagens não pode ser nula");
        }
        return imagens.toArray(new Imagem[0]);
    }

    // Métodos originais mantidos exatamente como estão
    public static void mergeSort(Imagem[] array, int left, int right) {
        if (left < right) {
            int middle = (left + right) / 2;
            mergeSort(array, left, middle);
            mergeSort(array, middle + 1, right);
            merge(array, left, middle, right);
        }
    }

    private static void merge(Imagem[] v, int left, int middle, int right) {
        Imagem[] helper = new Imagem[v.length];
        for (int i = left; i <= right; i++) {
            helper[i] = v[i];
        }

        int i = left;
        int j = middle + 1;
        int k = left;

        while (i <= middle && j <= right) {
            if (helper[i].getData().after(helper[j].getData())) {
                v[k] = helper[i];
                i++;
            } else {
                v[k] = helper[j];
                j++;
            }
            k++;
        }

        while (i <= middle) {
            v[k] = helper[i];
            i++;
            k++;
        }
    }
}