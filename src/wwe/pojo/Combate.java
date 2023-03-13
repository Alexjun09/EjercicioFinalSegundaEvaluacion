package wwe.pojo;

import wwe.exception.ContrincantesInsuficientesException;

import java.util.*;

/**
 * Clase Combate la cual almacenará la lista de luchadores y el ganador de la batlla, tiene el metodo fight con el cual los contrincantes luchan entre ellos hasta que solo quede uno
 *
 * @author Alejandro Junyent
 * @version 1
 */
public class Combate {
    //declaramos el metodo Random
    static Random rand = new Random();


    //Atributos de la clase combate
    private LinkedList<Luchador> contrincantes = new LinkedList<>();
    private String ganador;

    //Constructor vacío de combate
    public Combate() {

    }

    /**
     * Constructor de combate
     *
     * @param listaLuchadores la lista de luchadores disponibles para combatir
     */
    public Combate(LinkedList<Luchador> listaLuchadores) {
        contrincantes = listaLuchadores;
    }

    /**
     * Metodo fight el cual permitirá que los luchadores disponibles luchen hasta que solo quede uno
     *
     * @throws ContrincantesInsuficientesException lanza esta excepcion cuando no haya suficientes luchadores disponibles
     */
    public void fight() throws ContrincantesInsuficientesException {
        //Si no hay suficientes contrincantes lanza la excepcion
        if (contrincantes.size() < 2) {
            throw new ContrincantesInsuficientesException("No hay suficientes jugadores");
        } else {
            //Si hay suficientes contrincantes empieza el combate
            System.out.println("Empieza el combate");
            //Declaramos una variable que contará a medida que vayan mueriendo los luchadores durante la batalla
            int contrincantesKo = 0;
            //Empezamos un bucle while que se ejecutará hasta que solo quede un luchador vivo
            do {
                //generamos un numero random y llamamos al constructor
                int numero = rand.nextInt(contrincantes.size());
                Luchador l1 = contrincantes.get(numero);

                //verificamos que el luchador escogido no está KO
                do {
                    if (l1.isKo()) {
                        numero = rand.nextInt(contrincantes.size());
                        l1 = contrincantes.get(numero);
                    }
                } while (l1.isKo());

                //generamos otro numero random y llamamos al constructor
                int numero2 = 0;
                Luchador l2 = contrincantes.get(numero2);

                //verificamos que no es el mismo luchador que el primero y que no está KO
                do {
                    numero2 = rand.nextInt(contrincantes.size());
                    l2 = contrincantes.get(numero2);
                    if (l2.isKo()) {
                        numero2 = rand.nextInt(contrincantes.size());
                        l2 = contrincantes.get(numero2);
                    }
                } while (numero == numero2 || l2.isKo());

                //generamos dos numeros aleatorios para escoger los ataques
                int numeroAleatorio1 = rand.nextInt(l1.getAtaques().size());

                //imprimimos por pantalla el eataque
                System.out.println(l1.getNombre() + " le lanza un(a) " + l1.getAtaques().get(numeroAleatorio1) + " a " + l2.getNombre());
                //ejecutamos el ataque
                int ataque = l1.getAtaques().get(numeroAleatorio1).lanzarAtaque(l2);
                //ejecutamos el bloqueo
                boolean bloqueo = l1.getAtaques().get(numeroAleatorio1).ataqueBloqueado(ataque, l1);

                //si se bloquea quitará menos vida que si no se bloquea
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

                //comprobamos si el luchador que ha sido atatcado tiene vida, de lo contrario lo sumamos al contador
                if (l2.getSalud() < 1) {
                    l2.setKo(true);
                    contrincantesKo++;
                    System.out.println(l2.getNombre() + " está ahora KO.");
                }
            } while (contrincantesKo != contrincantes.size() - 1);

            //comprobamos cual es el ganador, descartando todos los otros jugadores que están KO
            for (int i = 0; i < contrincantes.size(); i++) {
                if (!contrincantes.get(i).isKo()) {
                    ganador = contrincantes.get(i).getNombre();
                }
            }

            System.out.println(ganador + " es el ganador!");
            System.out.println();
        }
    }

    //Setters y getters
    public String getGanador() {
        return ganador;
    }
}
