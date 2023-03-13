package wwe.pojo;

import java.util.Random;

/**
 * Clase Punetazo que hereda de la clase ataque
 *
 * @author Alejandro Junyent
 * @version 1
 */
public class Punetazo extends Ataque {

    /**
     * Constructor del objeto potencia
     *
     * @param potencia la potencia maxima con la que se puede dar ete ataque
     */
    public Punetazo(int potencia) {
        super(potencia);
    }

    /**
     * Metodo con el que se lanza el puñetazo a otro luchador
     *
     * @param luchador el luchador al que se está atacando
     * @return la fuerza con la que se termina dando el ataque
     */
    public int lanzarAtaque(Luchador luchador) {
        Random rand = new Random();
        int numero = rand.nextInt(getPotenciaMaxima() + 1);
        return numero;
    }

    //metodo to string para que imprima bien los ataques
    public String toString() {
        return "Puñetazo";
    }
}
