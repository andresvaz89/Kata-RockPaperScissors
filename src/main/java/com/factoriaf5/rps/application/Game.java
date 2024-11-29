package com.factoriaf5.rps.application;



import com.factoriaf5.rps.models.Move;
import com.factoriaf5.rps.models.MoveFactory;

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

            Move jugadorJugada = MoveFactory.getMove(jugadorEleccion);
            Move ordenadorJugada = MoveFactory.getMove(new Random().nextInt(5) + 1);

            System.out.println("Tu jugada: " + jugadorJugada.getName());
            System.out.println("Jugada del ordenador: " + ordenadorJugada.getName());

            String resultado = determinarGanador(jugadorJugada, ordenadorJugada);
            System.out.println(resultado);

            System.out.print("¿Quieres jugar otra vez? (s/n): ");
            seguirJugando = scanner.next().equalsIgnoreCase("s");
        }

        System.out.println("¡Gracias por jugar!");
        scanner.close();
    }

    public static String determinarGanador(Move jugador, Move ordenador) {
        if (jugador.getName().equals(ordenador.getName())) {
            return "¡Empate!";
        }

        if (jugador.beats(ordenador)) {
            return "¡Ganaste! " + jugador.getName() + " vence a " + ordenador.getName();
        } else {
            return "¡Perdiste! " + ordenador.getName() + " vence a " + jugador.getName();
        }
    }
}
