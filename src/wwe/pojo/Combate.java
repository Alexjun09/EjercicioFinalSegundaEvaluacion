package wwe.pojo;

import wwe.exception.ContrincantesInsuficientesException;

import java.util.LinkedList;
import java.util.Random;

public class Combate {

    private LinkedList<Luchador> contrincantes = new LinkedList<>();
    private String ganador;

    public String getGanador() {
        return ganador;
    }

    public void fight() throws ContrincantesInsuficientesException {
        System.out.println("Empieza el combate");
        if (contrincantes.size() < 2) {
            throw new ContrincantesInsuficientesException("No hay suficientes jugadores");
        } else {
            int ko = 0;
            do {
                Random rand = new Random();

                int numero = rand.nextInt(0, contrincantes.size() + 1);
                Luchador l1 = contrincantes.get(numero);

                do {
                    if (l1.isKo()) {
                        numero = rand.nextInt(0, contrincantes.size() + 1);
                        l1 = contrincantes.get(numero);
                    }
                } while (l1.isKo());

                int numero2 = rand.nextInt(0, contrincantes.size() + 1);

                do {
                    if (numero == numero2) {
                        numero2 = rand.nextInt(0, contrincantes.size() + 1);
                    }
                } while (numero == numero2);

                Luchador l2 = contrincantes.get(numero2);

                do {
                    if (l2.isKo()) {
                        numero2 = rand.nextInt(0, contrincantes.size() + 1);
                        l2 = contrincantes.get(numero2);
                    }
                } while (l2.isKo());

                int numeroAleatorio = rand.nextInt(0, l1.getAtaques().size() + 1);

                System.out.println(l1.getNombre() + " le lanza un(a) " + l1.getAtaques().get(numeroAleatorio) + " a " + l2.getNombre());
                int ataque = l1.getAtaques().get(numeroAleatorio).lanzarAtaque(l2);
                boolean bloqueo = l2.getAtaques().get(numeroAleatorio).ataqueBloqueado(ataque, l1);


                if (bloqueo) {
                    int salud = l2.getSalud() - (ataque / 2);
                    l2.setSalud(salud);
                    System.out.println("Ataque bloqueado");
                } else {
                    int salud = l2.getSalud() - ataque;
                    l2.setSalud(salud);
                }
                System.out.println("Salud de " + l2.getNombre() + " a " + l2.getSalud());

                if (l2.getSalud() < 1) {
                    l2.setKo(true);
                }


                int muertos = 0;
                for (int i = 0; i < contrincantes.size(); i++) {
                    if (contrincantes.get(i).isKo()) {
                        muertos++;
                    }
                }
                ko = muertos;
            } while (ko == contrincantes.size() - 1);


            for (int i = 0; i < contrincantes.size(); i++) {
                if (!contrincantes.get(i).isKo()) {
                    ganador = contrincantes.get(i).getNombre();
                }
            }

            System.out.println(ganador + " es el ganador!");

        }
    }
}
