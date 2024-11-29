package com.factoriaf5.rps.application;

import com.factoriaf5.rps.models.*;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    @Test
    void testEmpate() {
        Move rock = new Rock();
        String resultado = Game.determinarGanador(rock, rock);
        assertEquals("¡Empate!", resultado);
    }

    @Test
    void testJugadorGana() {
        Move rock = new Rock();
        Move scissors = new Scissors();
        String resultado = Game.determinarGanador(rock, scissors);
        assertEquals("¡Ganaste! Rock vence a Scissors", resultado);
    }

    @Test
    void testOrdenadorGana() {
        Move paper = new Paper();
        Move rock = new Rock();
        String resultado = Game.determinarGanador(paper, rock);
        assertEquals("¡Perdiste! Paper vence a Rock", resultado);
    }

    @Test
    void testJugadaInvalida() {
        InputStream stdin = System.in;
        try {
            String input = "6\nn\n";
            System.setIn(new ByteArrayInputStream(input.getBytes()));

            // Ejecuta main con entrada inválida
            Game.main(new String[]{});
        } finally {
            System.setIn(stdin); // Restaura el System.in original
        }
    }

    @Test
    void testSimulacionJugada() {
        Move jugador = MoveFactory.getMove(1); // Piedra
        Move ordenador = MoveFactory.getMove(new Random().nextInt(5) + 1);

        assertNotNull(jugador);
        assertNotNull(ordenador);

        String resultado = Game.determinarGanador(jugador, ordenador);
        assertNotNull(resultado); // Asegúrate de que el resultado no sea nulo
    }

    @Test
    void testEntradaValida() {
        InputStream stdin = System.in;
        try {
            String input = "1\nn\n"; // Jugador elige Piedra y luego termina el juego
            System.setIn(new ByteArrayInputStream(input.getBytes()));

            // Ejecuta main con entrada válida
            Game.main(new String[]{});
        } finally {
            System.setIn(stdin); // Restaura el System.in original
        }
    }
}
