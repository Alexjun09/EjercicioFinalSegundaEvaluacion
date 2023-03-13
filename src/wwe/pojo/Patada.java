package wwe.pojo;

import java.util.Random;

/**
 * Clase patada que heredará de la clase ataque
 *
 * @author Alejandro Junyent Romani
 * @version 1
 */
public class Patada extends Ataque {
    /**
     * Constructor del objeto patada
     *
     * @param potencia la potencia maxima con la que se puede dar ete ataque
     */
    public Patada(int potencia) {
        super(potencia);
    }

    /**
     * Metodo con el que se lanza una patada a otro luchador
     *
     * @param luchador el luchador al que se está atacando
     * @return la fuerza con la que se termina dando el ataque
     */
    public int lanzarAtaque(Luchador luchador) {
        Random rand = new Random();
        int numero = rand.nextInt(getPotenciaMaxima() + 1);
        return numero;
    }

    //metodo tostring para que se imprima bien
    public String toString() {
        return "Patada";
    }
}
