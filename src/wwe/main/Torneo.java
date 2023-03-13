package wwe.main;

import wwe.exception.ContrincantesInsuficientesException;
import wwe.pojo.*;

import java.util.*;

public class Torneo {
    static Scanner sc = new Scanner(System.in);
    static HashMap<String, Integer> hallOfFame = new HashMap<>();
    static LinkedList<Luchador> listaLuchadores = new LinkedList<>();
    static Combate combate = new Combate();


    public static void menu() {
        System.out.println("**Menu principal**");
        System.out.println("1- Mostrar Luchadores");
        System.out.println("2- Añadir Luchador");
        System.out.println("3- Ready? Fight!");
        System.out.println("4- Mostrar Hall of Fame");
        System.out.println("0- Salir");
        System.out.println();
    }

    public static void mostrarLuchadores() {
        System.out.println("**Mostrando Luchadores**");
        if (listaLuchadores.size() == 0) {
            System.out.println("No hay luchadores actualmente, añade uno para que aparezca aqui.");
        } else {
            for (Luchador i : listaLuchadores) {
                i.mostrarDatos();
            }
        }
        System.out.println();
    }

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
        do {
            try {
                input = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException ex) {
                System.out.println("Valor introducido no valido. Tiene que ser un numero positivo.");
            }
        } while (input < 0);

        Luchador l1 = new Luchador(nombre, input);
        listaLuchadores.add(l1);
        System.out.println("Luchador añadido correctamente");
        System.out.println();
    }

    public static void luchar() {
        for (Luchador i : listaLuchadores) {
            i.resetSalud();
            i.setKo(false);
        }
        combate = new Combate(listaLuchadores);
        try {
            combate.fight();
        } catch (ContrincantesInsuficientesException ex) {
            System.out.println(ex.getMessage());
            System.out.println();
        }

        String ganador = combate.getGanador();

        if (hallOfFame.containsKey(ganador)) {
            int sum = hallOfFame.get(ganador) + 1;
            hallOfFame.put(ganador, sum);
        } else {
            hallOfFame.put(ganador, 1);
        }
    }

    public static void mostrarHallOfFame() {
        int contador = 1;
        if (hallOfFame.size() == 0) {
            System.out.println("El Hall of Fame está vacio, juega una partida para poder ver a los ganadores.");
        } else {
            for (String i : hallOfFame.keySet()) {
                System.out.println(contador + ". " + i + " con " + hallOfFame.get(i) + " puntos");
                contador++;
            }
        }
        System.out.println();
    }

    public static void salir() {
        System.out.println("Apagando programa");
    }

    public static void main(String[] args) {
        int input = -1;
        do {
            input = -1;
            System.out.println("Introduce un numero de las opciones listadas:");
            menu();
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
