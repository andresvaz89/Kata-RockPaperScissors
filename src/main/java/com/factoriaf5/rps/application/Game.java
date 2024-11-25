package com.factoriaf5.rps.application;
import java.util.Random;
import java.util.Scanner;

public class Game {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("¡Bienvenido a Piedra, Papel, Tijera, Lagarto o Spock!");
        System.out.println("Opciones: 1 para Piedra, 2 para Papel, 3 para Tijera, 4 para Lagarto, 5 para Spock");

        boolean seguirJugando = true;

        while (seguirJugando) {
            System.out.print("Elige tu jugada (1, 2, 3, 4, 5): ");
            int jugadorEleccion = scanner.nextInt();

            if (jugadorEleccion < 1 || jugadorEleccion > 5) {
                System.out.println("Opción inválida, intenta de nuevo.");
                continue;
            }

            String jugadorJugada = getJugada(jugadorEleccion);
            String ordenadorJugada = getJugada(new Random().nextInt(5) + 1);

            System.out.println("Tu jugada: " + jugadorJugada);
            System.out.println("Jugada del ordenador: " + ordenadorJugada);

            String resultado = determinarGanador(jugadorJugada, ordenadorJugada);
            System.out.println(resultado);

            System.out.print("¿Quieres jugar otra vez? (s/n): ");
            seguirJugando = scanner.next().equalsIgnoreCase("s");
        }

        System.out.println("¡Gracias por jugar!");
        scanner.close();
    }

    private static String getJugada(int eleccion) {
        switch (eleccion) {
            case 1: return "Piedra";
            case 2: return "Papel";
            case 3: return "Tijera";
            case 4: return "Lagarto";
            case 5: return "Spock";
            default: throw new IllegalArgumentException("Elección inválida");
        }
    }

    private static String determinarGanador(String jugador, String ordenador) {
        if (jugador.equals(ordenador)) {
            return "¡Empate!";
        }

        if (ganaSobre(jugador, ordenador)) {
            return "¡Ganaste! " + jugador + " vence a " + ordenador;
        } else {
            return "¡Perdiste! " + ordenador + " vence a " + jugador;
        }
    }

    private static boolean ganaSobre(String jugada1, String jugada2) {
        // Reglas según la versión de Sheldon
        return (jugada1.equals("Tijera") && (jugada2.equals("Papel") || jugada2.equals("Lagarto"))) ||
               (jugada1.equals("Papel") && (jugada2.equals("Piedra") || jugada2.equals("Spock"))) ||
               (jugada1.equals("Piedra") && (jugada2.equals("Tijera") || jugada2.equals("Lagarto"))) ||
               (jugada1.equals("Lagarto") && (jugada2.equals("Spock") || jugada2.equals("Papel"))) ||
               (jugada1.equals("Spock") && (jugada2.equals("Tijera") || jugada2.equals("Piedra")));
    }
}
