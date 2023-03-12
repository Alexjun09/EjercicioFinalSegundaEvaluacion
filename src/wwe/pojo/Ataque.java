package wwe.pojo;

import java.util.Random;

public abstract class Ataque {
    static Random rand = new Random();

    protected int potenciaMaxima;

    public Ataque() {

    }

    public Ataque(int potenciaMaxima) {
        this.potenciaMaxima = potenciaMaxima;
    }

    public abstract int lanzarAtaque(Luchador luchador); //heredada por las clases hijo

    public boolean ataqueBloqueado(int potenciaMaxima, Luchador luchador) {
        int numero = rand.nextInt(luchador.getSalud() + 1);
        boolean answer = false;
        if (numero > potenciaMaxima) {
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
