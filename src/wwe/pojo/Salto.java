package wwe.pojo;

import java.util.Random;

/**
 * Clase salto que heredará de la clase ataque
 *
 * @author Alejandro Junyent Romani
 * @version 1
 */
public class Salto extends Ataque {
    /**
     * Constructor del objeto Salto
     *
     * @param potencia la potencia maxima con la que se puede dar ete ataque
     */
    public Salto(int potencia) {
        super(potencia);
    }

    /**
     * Metodo con el que se lanza el salto a otro luchador
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
        return "Salto";
    }
}
