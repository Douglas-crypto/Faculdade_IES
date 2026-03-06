package org.example.Classes;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class GeradorDados {
  
   public static List<Imagem> gerarImagensAleatorias(int quantidade) {
        List<Imagem> imagens = new ArrayList<>();
        Random random = new Random();
        long agora = System.currentTimeMillis();
        long intervalo = 1000L * 60 * 60 * 24 * 365;

        for (int i = 0; i < quantidade; i++) {
            long dataAleatoria = agora - (Math.abs(random.nextLong()) % intervalo);
            Date data = new Date(dataAleatoria);
            imagens.add(new Imagem("Imagem_" + i, i, data));
        }
        return imagens;
    }
}
