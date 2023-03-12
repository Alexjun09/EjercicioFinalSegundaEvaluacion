package wwe.pojo;

import wwe.exception.ContrincantesInsuficientesException;

import java.util.*;

public class Combate {
    static Random rand = new Random();


    private LinkedList<Luchador> contrincantes = new LinkedList<>();
    private String ganador;

    public Combate() {

    }

    public Combate(LinkedList<Luchador> listaLuchadores) {
        contrincantes = listaLuchadores;
    }

    public String getGanador() {
        return ganador;
    }

    public void fight() throws ContrincantesInsuficientesException {
        int ko = 0;
        for (int i = 0; i < contrincantes.size(); i++) {
            if (contrincantes.get(i).isKo()) {
                ko++;
            }
        }
        if (contrincantes.size() < 2) {
            throw new ContrincantesInsuficientesException("No hay suficientes jugadores");
        } else {
            System.out.println("Empieza el combate");
            int contrincantesKo = 0;
            do {
                int numero = rand.nextInt(contrincantes.size());
                Luchador l1 = contrincantes.get(numero);

                do {
                    if (l1.isKo()) {
                        numero = rand.nextInt(contrincantes.size());
                        l1 = contrincantes.get(numero);
                    }
                } while (l1.isKo());

                int numero2 = 0;
                Luchador l2 = contrincantes.get(numero2);

                do {
                    numero2 = rand.nextInt(contrincantes.size());
                    l2 = contrincantes.get(numero2);
                    if (l2.isKo()) {
                        numero2 = rand.nextInt(contrincantes.size());
                        l2 = contrincantes.get(numero2);
                    }
                } while (numero == numero2 || l2.isKo());

                int numeroAleatorio1 = rand.nextInt(l1.getAtaques().size());
                int numeroAleatorio2 = rand.nextInt(l2.getAtaques().size());
                System.out.println("Aleatorio: " + numeroAleatorio1);

                System.out.println(l1.getNombre() + " le lanza un(a) " + l1.getAtaques().get(numeroAleatorio1) + " a " + l2.getNombre());
                int ataque = l1.getAtaques().get(numeroAleatorio1).lanzarAtaque(l2);
                System.out.println("Ataque: " + ataque);
                boolean bloqueo = l2.getAtaques().get(numeroAleatorio2).ataqueBloqueado(ataque, l1);


                if (bloqueo) {
                    int mitadAtaque = ataque / 2;
                    int salud = l2.getSalud() - mitadAtaque;
                    l2.setSalud(salud);
                    System.out.println("Ataque bloqueado");
                } else {
                    int salud = l2.getSalud() - ataque;
                    l2.setSalud(salud);
                }
                System.out.println("Salud de " + l2.getNombre() + " a " + l2.getSalud());

                if (l2.getSalud() < 1) {
                    l2.setKo(true);
                    contrincantesKo++;
                    System.out.println(l2.getNombre() + " está ahora KO.");
                }


                int muertos = 0;
                for (int i = 0; i < contrincantes.size(); i++) {
                    if (contrincantes.get(i).isKo()) {
                        muertos++;
                    }
                }
                ko = muertos;
            } while (contrincantesKo != contrincantes.size() - 1);

            for (int i = 0; i < contrincantes.size(); i++) {
                if (!contrincantes.get(i).isKo()) {
                    ganador = contrincantes.get(i).getNombre();
                }
            }

            System.out.println(ganador + " es el ganador!");
            System.out.println();
        }
    }
}
