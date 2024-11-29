package com.factoriaf5.rps.models;



import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GameFlowTest {

    @Test
    public void testGameFlowPlayerWins() {
        Move playerMove = new Spock();
        Move computerMove = new Scissors();

        String result = determinarGanador(playerMove, computerMove);
        assertEquals("¡Ganaste! Spock vence a Tijera", result);
    }

    @Test
    public void testGameFlowComputerWins() {
        Move playerMove = new Lizard();
        Move computerMove = new Rock();

        String result = determinarGanador(playerMove, computerMove);
        assertEquals("¡Perdiste! Piedra vence a Lagarto", result);
    }

    @Test
    public void testGameFlowTie() {
        Move playerMove = new Paper();
        Move computerMove = new Paper();

        String result = determinarGanador(playerMove, computerMove);
        assertEquals("¡Empate!", result);
    }

    // Helper function
    private String determinarGanador(Move jugador, Move ordenador) {
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