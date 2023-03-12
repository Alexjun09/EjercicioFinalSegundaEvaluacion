package wwe.pojo;

import java.util.Random;

public class Punetazo extends Ataque {

    public Punetazo(int potencia) {
        super(potencia);
    }

    public int lanzarAtaque(Luchador luchador) {
        Random rand = new Random();
        int numero = rand.nextInt( getPotenciaMaxima() + 1);
        return numero;
    }
    public String toString(){
        return "Puñetazo";
    }
}
