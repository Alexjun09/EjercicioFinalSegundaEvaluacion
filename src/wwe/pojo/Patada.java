package wwe.pojo;

import java.util.Random;

public class Patada extends Ataque {
    public Patada(int potencia) {
        super(potencia);
    }

    public int lanzarAtaque(Luchador luchador) {
        Random rand = new Random();
        int numero = rand.nextInt(0, getPotenciaMaxima() + 1);
        System.out.println("Patada lanzado a " + luchador.getNombre());

        return numero;
    }
    public String toString(){
        return "Patada";
    }
}
