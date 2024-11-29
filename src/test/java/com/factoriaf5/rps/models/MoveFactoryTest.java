package com.factoriaf5.rps.models;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MoveFactoryTest {

    @Test
    public void testMoveFactoryReturnsCorrectInstance() {
        assertTrue(MoveFactory.getMove(1) instanceof Rock);
        assertTrue(MoveFactory.getMove(2) instanceof Paper);
        assertTrue(MoveFactory.getMove(3) instanceof Scissors);
        assertTrue(MoveFactory.getMove(4) instanceof Lizard);
        assertTrue(MoveFactory.getMove(5) instanceof Spock);
    }

    @Test
    public void testMoveFactoryThrowsExceptionForInvalidInput() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            MoveFactory.getMove(6);
        });
        assertEquals("Elección inválida", exception.getMessage());
    }
}