package wwe.pojo;

import java.util.Random;

public abstract class Ataque {
    protected int potenciaMaxima;

    public Ataque() {

    }

    public Ataque(int potencia) {
        potencia = potenciaMaxima;
    }

    public abstract int lanzarAtaque(Luchador luchador); //heredada por las clases hijo

    public boolean ataqueBloqueado(int fuerza, Luchador luchador) {
        Random rand = new Random();
        int numero = rand.nextInt(0, luchador.getSalud() + 1);
        boolean answer = false;
        if (numero > fuerza) {
            answer = true;
        } else {
            answer = false;
        }
        return answer;
    }

    public int getPotenciaMaxima() {
        return potenciaMaxima;
    }
}
