package wwe.main;

import wwe.exception.ContrincantesInsuficientesException;
import wwe.pojo.*;

import java.util.*;

/**
 * Clase Torneo en la cual tiene todos los metodos del main y el codigo que se ejecutará
 *
 * @author Alejandro Junyent
 * @version 1
 */
public class Torneo {
    //declaramos nuestros atributos comunes
    static Scanner sc = new Scanner(System.in);
    static HashMap<String, Integer> hallOfFame = new HashMap<>();
    static LinkedList<Luchador> listaLuchadores = new LinkedList<>();
    static Combate combate = new Combate();


    /**
     * Metodo que imprimirá el menu de opciones para el switch
     */
    public static void menu() {
        System.out.println("**Menu principal**");
        System.out.println("1- Mostrar Luchadores");
        System.out.println("2- Añadir Luchador");
        System.out.println("3- Ready? Fight!");
        System.out.println("4- Mostrar Hall of Fame");
        System.out.println("0- Salir");
        System.out.println();
    }

    /**
     * Metodo que mostrará todos los datos de los lucadores actualemente añadidos a la lista
     */
    public static void mostrarLuchadores() {
        System.out.println("**Mostrando Luchadores**");
        //si no hay jugadores
        if (listaLuchadores.size() == 0) {
            System.out.println("No hay luchadores actualmente, añade uno para que aparezca aqui.");
        } else {
            //Si hay jugadores
            for (Luchador i : listaLuchadores) {
                i.mostrarDatos();
            }
        }
        System.out.println();
    }

    /**
     * Metodo para añadir luchadores a la lista
     */
    public static void anadirLuchador() {
        System.out.println("**Añadiendo un luchador**");
        System.out.println("Que nombre tendrá este luchador?");
        String nombre = sc.nextLine();
        System.out.println("Nombre: " + nombre);
        System.out.println("Que categoría tiene?");
        System.out.println("1: Peso mosca");
        System.out.println("2: Peso pluma");
        System.out.println("3: Peso ligero");
        System.out.println("4: Peso medio");
        System.out.println("5: Peso pesado");

        int input = -1;
        //comprueba que el dato es valido
        do {
            try {
                input = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException ex) {
                System.out.println("Valor introducido no valido. Tiene que ser un numero positivo.");
            }
        } while (input < 0);

        //crea y añade los luchadores creados
        Luchador l1 = new Luchador(nombre, input);
        listaLuchadores.add(l1);
        System.out.println("Luchador añadido correctamente");
        System.out.println();
    }

    /**
     * Metodo que empezará la battalla entre los jugadores
     */
    public static void luchar() {
        //resetea la vida y los KO antes de empezar
        for (Luchador i : listaLuchadores) {
            i.resetSalud();
            i.setKo(false);
        }
        //llama al constructor
        combate = new Combate(listaLuchadores);
        //maneja la excepcion
        try {
            combate.fight();
        } catch (ContrincantesInsuficientesException ex) {
            System.out.println(ex.getMessage());
            System.out.println();
        }

        //asigna el ganador
        String ganador = combate.getGanador();

        //asigna el ganador al hall of fame
        if (hallOfFame.containsKey(ganador)) {
            int sum = hallOfFame.get(ganador) + 1;
            hallOfFame.put(ganador, sum);
        } else {
            hallOfFame.put(ganador, 1);
        }
    }

    /**
     * metodo que mostrará el hall of fame con los ganadores previos y sus puntos
     */
    public static void mostrarHallOfFame() {
        int contador = 1;
        //si no hay hall of fame
        if (hallOfFame.size() == 0) {
            System.out.println("El Hall of Fame está vacio, juega una partida para poder ver a los ganadores.");
        } else {
            //si hay hall of fame se ejecuta
            for (String i : hallOfFame.keySet()) {
                System.out.println(contador + ". " + i + " con " + hallOfFame.get(i) + " puntos");
                contador++;
            }
        }
        System.out.println();
    }

    /**
     * metodo para salir del programa
     */
    public static void salir() {
        System.out.println("Apagando programa");
    }

    //Metodo main
    public static void main(String[] args) {
        int input = 0;
        //se ejecutará hasta que el usuario introduzca un 0
        do {
            input = -1;
            System.out.println("Introduce un numero de las opciones listadas:");
            //imprime el menu
            menu();
            //verificamos que el dato introducido es un numero entro el 0 y el 4 (incluido)
            do {

                try {
                    input = Integer.parseInt(sc.nextLine());
                    if (input < 0 || input > 4) {
                        System.out.println("Valor introducido no valido. Tiene que ser un numero positivo.");
                    }
                } catch (NumberFormatException ex) {
                    System.out.println("Valor introducido no valido. Tiene que ser un numero positivo.");
                }


            } while (input < 0 || input > 4);

            //Switch para el menu de opciones el cual llama a los metodos correspondientes
            switch (input) {
                case 0:
                    salir();
                    break;
                case 1:
                    mostrarLuchadores();
                    break;
                case 2:
                    anadirLuchador();
                    break;
                case 3:
                    luchar();
                    break;
                case 4:
                    mostrarHallOfFame();
                    break;
                default:
                    System.out.println("Opcion no valida, introducir un numero entre el 0 y el 4");
            }
        } while (input != 0);
    }
}
