package wwe.pojo;

import java.util.ArrayList;
import java.util.Random;

public class Luchador {
    private String nombre;
    private int categoria;

    private int fuerzaMinima;
    private int salud;
    private ArrayList<Ataque> ataques = new ArrayList<>();
    private boolean ko;

    public Luchador() {

    }

    public Luchador(String nom, int cat) {
        nombre = nom;
        categoria = cat;
        fuerzaMinima = categoria * 10 + 10;
        salud = 300;
        rellenarAtaques();
        ko = false;
    }

    public void rellenarAtaques() {
        Random rand = new Random();
        for (int i = 0; i < categoria; i++) {
            int numero = rand.nextInt(0, 3);
            if (numero == 0) {
                Punetazo pun = new Punetazo();
                ataques.add(pun);
            } else if (numero == 1) {
                Patada pat = new Patada();
                ataques.add(pat);
            } else {
                Salto salt = new Salto();
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

    public void setFuerzaMinima(int fuerzaMinima) {
        this.fuerzaMinima = fuerzaMinima;
    }

    public void setSalud(int salud) {
        this.salud = salud;
    }

    public void setKo(boolean ko) {
        this.ko = ko;
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

    public int getFuerzaMinima() {
        return fuerzaMinima;
    }

    public int getSalud() {
        return salud;
    }
}
