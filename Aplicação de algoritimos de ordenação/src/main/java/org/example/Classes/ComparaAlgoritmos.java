package org.example.Classes;

import org.example.Algoritimos.BubbleSort;
import org.example.Algoritimos.MergeSort;
import org.example.Algoritimos.QuickSort;

import java.util.List;

public class ComparaAlgoritmos {

    public void executarComparacao(List list) {
        List<Imagem> listaImagens = GeradorDados.gerarImagensAleatorias(1000);

        // ---------- BubbleSort ----------
        Imagem[] bubbleArray = new BubbleSort().converte_array(listaImagens);
        int comparacoesBubble = 0, trocasBubble = 0, passosExtBubble = 0, passosIntBubble = 0;

        long inicioBubble = System.nanoTime();
        int n = bubbleArray.length;
        boolean trocou;

        for (int i = 0; i < n - 1; i++) {
            passosExtBubble++;
            trocou = false;
            for (int j = 0; j < n - i - 1; j++) {
                passosIntBubble++;
                comparacoesBubble++;
                if (bubbleArray[j].getData().before(bubbleArray[j + 1].getData())) {
                    Imagem temp = bubbleArray[j];
                    bubbleArray[j] = bubbleArray[j + 1];
                    bubbleArray[j + 1] = temp;
                    trocou = true;
                    trocasBubble++;
                }
            }
            if (!trocou) break;
        }

        long fimBubble = System.nanoTime();

        // ---------- MergeSort ----------
        Imagem[] mergeArray = new MergeSort().converte_array(listaImagens);
        int[] comparacoesMerge = {0}, copiasMerge = {0}, chamadasMerge = {0}, mergesCont = {0}, profundidadeMerge = {0};

        long inicioMerge = System.nanoTime();
        mergeSortInstrumentado(mergeArray, 0, mergeArray.length - 1, comparacoesMerge, copiasMerge, chamadasMerge, mergesCont, 1, profundidadeMerge);
        long fimMerge = System.nanoTime();

        // ---------- QuickSort ----------
        Imagem[] quickArray = new QuickSort().converte_array(listaImagens);
        int[] comparacoesQuick = {0}, trocasQuick = {0}, chamadasQuick = {0}, particoes = {0}, profundidadeQuick = {0};

        long inicioQuick = System.nanoTime();
        quickSortInstrumentado(quickArray, 0, quickArray.length - 1, comparacoesQuick, trocasQuick, chamadasQuick, particoes, 1, profundidadeQuick);
        long fimQuick = System.nanoTime();

        // ---------- Resultados ----------
        exibirResultados(
                fimBubble - inicioBubble, comparacoesBubble, trocasBubble, passosExtBubble, passosIntBubble,
                fimMerge - inicioMerge, comparacoesMerge, copiasMerge, chamadasMerge, mergesCont, profundidadeMerge,
                fimQuick - inicioQuick, comparacoesQuick, trocasQuick, chamadasQuick, particoes, profundidadeQuick
        );
    }

    public void exibirResultados(
            long tempoBubble, int comparacoesBubble, int trocasBubble, int passosExtBubble, int passosIntBubble,
            long tempoMerge, int[] comparacoesMerge, int[] copiasMerge, int[] chamadasMerge, int[] mergesCont, int[] profundidadeMerge,
            long tempoQuick, int[] comparacoesQuick, int[] trocasQuick, int[] chamadasQuick, int[] particoes, int[] profundidadeQuick
    ) {
        System.out.println("===== RESULTADOS DA COMPARAÇÃO =====");

        System.out.println("\n--- BubbleSort ---");
        System.out.println("Tempo: " + (tempoBubble / 1_000_000.0) + " ms");
        System.out.println("Comparações: " + comparacoesBubble);
        System.out.println("Trocas: " + trocasBubble);
        System.out.println("Laços Externos: " + passosExtBubble);
        System.out.println("Laços Internos: " + passosIntBubble);

        System.out.println("\n--- MergeSort ---");
        System.out.println("Tempo: " + (tempoMerge / 1_000_000.0) + " ms");
        System.out.println("Comparações: " + comparacoesMerge[0]);
        System.out.println("Cópias: " + copiasMerge[0]);
        System.out.println("Chamadas recursivas: " + chamadasMerge[0]);
        System.out.println("Merges realizados: " + mergesCont[0]);
        System.out.println("Profundidade máxima: " + profundidadeMerge[0]);

        System.out.println("\n--- QuickSort ---");
        System.out.println("Tempo: " + (tempoQuick / 1_000_000.0) + " ms");
        System.out.println("Comparações: " + comparacoesQuick[0]);
        System.out.println("Trocas: " + trocasQuick[0]);
        System.out.println("Chamadas recursivas: " + chamadasQuick[0]);
        System.out.println("Partições realizadas: " + particoes[0]);
        System.out.println("Profundidade máxima: " + profundidadeQuick[0]);
    }

    public void mergeSortInstrumentado(Imagem[] v, int left, int right,
                                       int[] comparacoes, int[] copias, int[] chamadas, int[] merges,
                                       int profundidadeAtual, int[] profundidadeMaxima) {
        chamadas[0]++;
        profundidadeMaxima[0] = Math.max(profundidadeMaxima[0], profundidadeAtual);
        if (left < right) {
            int middle = (left + right) / 2;
            mergeSortInstrumentado(v, left, middle, comparacoes, copias, chamadas, merges, profundidadeAtual + 1, profundidadeMaxima);
            mergeSortInstrumentado(v, middle + 1, right, comparacoes, copias, chamadas, merges, profundidadeAtual + 1, profundidadeMaxima);
            mergeInstrumentado(v, left, middle, right, comparacoes, copias);
            merges[0]++;
        }
    }

    public void mergeInstrumentado(Imagem[] v, int left, int middle, int right,
                                   int[] comparacoes, int[] copias) {
        Imagem[] helper = new Imagem[v.length];
        for (int i = left; i <= right; i++) {
            helper[i] = v[i];
            copias[0]++;
        }

        int i = left;
        int j = middle + 1;
        int k = left;

        while (i <= middle && j <= right) {
            comparacoes[0]++;
            if (helper[i].getData().after(helper[j].getData())) {
                v[k++] = helper[i++];
            } else {
                v[k++] = helper[j++];
            }
        }

        while (i <= middle) {
            v[k++] = helper[i++];
            copias[0]++;
        }
    }

    public void quickSortInstrumentado(Imagem[] imagens, int left, int right,
                                       int[] comparacoes, int[] trocas, int[] chamadas, int[] particoes,
                                       int profundidadeAtual, int[] profundidadeMaxima) {
        if (left < right) {
            chamadas[0]++;
            profundidadeMaxima[0] = Math.max(profundidadeMaxima[0], profundidadeAtual);

            int pi = particionarInstrumentado(imagens, left, right, comparacoes, trocas);
            particoes[0]++;

            quickSortInstrumentado(imagens, left, pi - 1, comparacoes, trocas, chamadas, particoes, profundidadeAtual + 1, profundidadeMaxima);
            quickSortInstrumentado(imagens, pi + 1, right, comparacoes, trocas, chamadas, particoes, profundidadeAtual + 1, profundidadeMaxima);
        }
    }

    public int particionarInstrumentado(Imagem[] imagens, int left, int right, int[] comparacoes, int[] trocas) {
        Imagem pivo = imagens[right];
        int i = left - 1;

        for (int j = left; j < right; j++) {
            comparacoes[0]++;
            if (imagens[j].getData().after(pivo.getData())) {
                i++;
                swap(imagens, i, j);
                trocas[0]++;
            }
        }

        swap(imagens, i + 1, right);
        trocas[0]++;
        return i + 1;
    }

    public void swap(Imagem[] v, int i, int j) {
        Imagem temp = v[i];
        v[i] = v[j];
        v[j] = temp;
    }

    public void bubbleSortInstrumentado(Imagem[] v, int[] comparacoes, int[] trocas, int[] passosExt, int[] passosInt) {
        int n = v.length;
        boolean trocou;
        for (int i = 0; i < n - 1; i++) {
            passosExt[0]++;
            trocou = false;
            for (int j = 0; j < n - i - 1; j++) {
                passosInt[0]++;
                comparacoes[0]++;
                if (v[j].getData().before(v[j + 1].getData())) {
                    Imagem temp = v[j];
                    v[j] = v[j + 1];
                    v[j + 1] = temp;
                    trocou = true;
                    trocas[0]++;
                }
            }
            if (!trocou) break;
        }
    }
}

