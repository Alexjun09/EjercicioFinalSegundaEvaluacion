package wwe.pojo;

import java.util.*;

/**
 * Clase luchador que alamacenará todos los datos de los luchadores incluidos los ataques de estos
 *
 * @author Alejandro Junyent
 * @version 1
 */
public class Luchador {
    //declaramos los atributos de la clase
    private String nombre;
    private int categoria;
    private int potenciaMaxima;
    private int salud;
    private ArrayList<Ataque> ataques = new ArrayList<>();
    private boolean ko;

    //constructor vacio
    public Luchador() {

    }

    /**
     * Constructor de luchador que permitirá crear un objeto luchador con sus parametros correspondientes
     *
     * @param nom el nombre del luchador
     * @param cat la categoría a la que pertenece el luchador
     */
    public Luchador(String nom, int cat) {
        nombre = nom;
        categoria = cat;
        potenciaMaxima = categoria * 10 + 10;
        salud = 300;
        rellenarAtaques();
        ko = false;
    }

    /**
     * Metodo para rellenar los ataques aleatoriamente
     */
    public void rellenarAtaques() {
        Random rand = new Random();
        //ejecutamos el bucle tantas veces como categoría tenga el luchador, y le asignamos un ataque dependiendo del numero aleatorio
        for (int i = 0; i < categoria; i++) {
            int numero = rand.nextInt(3);
            if (numero == 0) {
                Punetazo pun = new Punetazo(potenciaMaxima);
                ataques.add(pun);
            } else if (numero == 1) {
                Patada pat = new Patada(potenciaMaxima);
                ataques.add(pat);
            } else {
                Salto salt = new Salto(potenciaMaxima);
                ataques.add(salt);
            }
        }
    }

    /**
     * Mostrará todos los datos del luchador
     */
    public void mostrarDatos() {
        System.out.println("Nombre: " + nombre + ", Categoría: " + categoria + ", Ataques: " + ataques);
    }

    /**
     * Metodo que permitirá que un luchador reciba daño
     *
     * @param cantidad la cantidad de daño que recibe
     */
    public void recibirDano(int cantidad) {
        salud = salud - cantidad;
    }

    /**
     * reiniciará la salud del luchador al valor predeterminado de 300
     */
    public void resetSalud() {
        salud = 300;
    }

    //Setters y getters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setAtaques(ArrayList<Ataque> ataques) {
        this.ataques = ataques;
    }

    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }

    public void setFuerza(int fuerza) {
        this.potenciaMaxima = fuerza;
    }

    public void setSalud(int salud) {
        this.salud = salud;
    }

    public void setKo(boolean ko) {
        this.ko = ko;
    }

    public boolean isKo() {
        return ko;
    }

    public String getNombre() {
        return nombre;
    }

    public ArrayList<Ataque> getAtaques() {
        return ataques;
    }

    public int getCategoria() {
        return categoria;
    }

    public int getFuerza() {
        return potenciaMaxima;
    }

    public int getSalud() {
        return salud;
    }
}
