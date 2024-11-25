package com.factoriaf5.rps.application;
import java.util.Random;
import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("¡Hola, elige tu tirada!");
        System.out.println("Opciones: 1 para Piedra, 2 para Papel, 3 para Tijera");
        
        boolean seguirJugando = true;

        while (seguirJugando) {
            System.out.print("Elige tu jugada (1, 2, 3): ");
            int jugadorEleccion = scanner.nextInt();

            if (jugadorEleccion < 1 || jugadorEleccion > 3) {
                System.out.println("No vale, prueba otra vez.");
                continue;
            }

            String jugadorJugada = getJugada(jugadorEleccion);
            String ordenadorJugada = getJugada(new Random().nextInt(3) + 1);

            System.out.println("Has elegido: " + jugadorJugada+" y el ordenador ha elegido: " + ordenadorJugada);
          

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
            default: throw new IllegalArgumentException("Elección inválida");
        }
    }

    private static String determinarGanador(String jugador, String ordenador) {
        if (jugador.equals(ordenador)) {
            return "¡Empate!";
        } else if (
            (jugador.equals("Piedra") && ordenador.equals("Tijera")) ||
            (jugador.equals("Papel") && ordenador.equals("Piedra")) ||
            (jugador.equals("Tijera") && ordenador.equals("Papel"))
        ) {
            return "¡Ganaste!";
        } else {
            return "¡Perdiste!";
        }
    }
}
