package org.example.Algoritimos;

import org.example.Interace.ConverteparaArray;
import org.example.Classes.Imagem;
import java.util.List;

public class BubbleSort implements ConverteparaArray {

    @Override
    public Imagem[] converte_array(List<Imagem> imagens) {
        if (imagens == null) {
            throw new IllegalArgumentException("Lista de imagens não pode ser nula");
        }
        return imagens.toArray(new Imagem[0]);
    }

    public static void bubbleSort(Imagem[] array) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("Array não pode ser nulo ou vazio");
        }

        int n = array.length;
        boolean trocou;

        for (int i = 0; i < n - 1; i++) {
            trocou = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j].getData().before(array[j + 1].getData())) {
                    // Troca os elementos se estiverem na ordem errada (decrescente)
                    swap(array, j, j + 1);
                    trocou = true;
                }
            }
            // Se não houve trocas na iteração, o array está ordenado
            if (!trocou) break;
        }
    }

    private static void swap(Imagem[] array, int i, int j) {
        Imagem temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}