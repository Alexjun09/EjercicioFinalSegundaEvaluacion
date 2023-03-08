package wwe.pojo;

import java.util.ArrayList;
import java.util.Random;

public class Luchador {
    private String nombre;
    private int categoria;

    private int fuerza;
    private int salud;
    private ArrayList<Ataque> ataques = new ArrayList<>();
    private boolean ko;

    public Luchador() {

    }

    public Luchador(String nom, int cat) {
        nombre = nom;
        categoria = cat;
        fuerza = categoria * 10 + 10;
        salud = 300;
        rellenarAtaques();
        ko = false;
    }

    public void rellenarAtaques() {
        Random rand = new Random();
        for (int i = 0; i < categoria; i++) {
            int numero = rand.nextInt(0, 3);
            if (numero == 0) {
                Punetazo pun = new Punetazo(fuerza);
                ataques.add(pun);
            } else if (numero == 1) {
                Patada pat = new Patada(fuerza);
                ataques.add(pat);
            } else {
                Salto salt = new Salto(fuerza);
                ataques.add(salt);
            }
        }
    }

    public void recibirDano(int cantidad) {
        salud = salud - cantidad;
    }

    public void resetSalud() {
        salud = 300;
    }

    public void mostrarDatos() {
        System.out.println("Nombre: " + nombre + ", Categoría: " + categoria + ", Ataques: " + ataques);
    }

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
        this.fuerza = fuerza;
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
        return fuerza;
    }

    public int getSalud() {
        return salud;
    }
}
