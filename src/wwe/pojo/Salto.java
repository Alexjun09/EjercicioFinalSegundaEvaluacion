package wwe.pojo;

import java.util.Random;

public class Salto extends Ataque{
    public Salto(int potencia) {
        super(potencia);
    }

    public int lanzarAtaque(Luchador luchador) {
        Random rand = new Random();
        int numero = rand.nextInt(0, getPotenciaMaxima() + 1);
        System.out.println("Salto lanzado a " + luchador.getNombre());

        return numero;
    }
}
