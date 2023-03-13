package wwe.pojo;

import java.util.Random;

/**
 * Clase abstracta ataque la cual será heredada por los 3 tipos de ataque
 * @version 1
 * @author Alejandro Junyent
 */
public abstract class Ataque {
    static Random rand = new Random();

    //declaramos los atributos
    protected int potenciaMaxima;
    //constructor vacío de ataque
    public Ataque() {

    }

    /**
     * Constructor de ataque con el que se podrá crear un objeto Ataque, será heredado por las clases hijo
     * @param potenciaMaxima la maxima potencia con la que se puede lanzar un ataque (categoría * 10 +10)
     */
    public Ataque(int potenciaMaxima) {
        this.potenciaMaxima = potenciaMaxima;
    }

    /**
     * Metodo lanzarAtaque el cual permitirá que se ejecuten ataques desde las clases hijo
     * @param luchador el luchador al que se está atacando
     * @return devolverá la fuerza con la que se ha ejecutado el ataque, la cual mas alante podrá ser bloqueada o no con el metodo ataqueBloqueado
     */
    public abstract int lanzarAtaque(Luchador luchador); //heredada por las clases hijo

    /**
     * Metodo que permite bloquear un ataque previamente ejecutadp
     * @param potenciaMaxima la potencia maxima con la cual se ha ejecutado el ataque
     * @param luchador el luchador al cual se ejecuta el bloqueo
     * @return devuelve si se ha bloqueado (true) o no (false)
     */
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

    //setters y getters
    public int getPotenciaMaxima() {
        return potenciaMaxima;
    }
}
