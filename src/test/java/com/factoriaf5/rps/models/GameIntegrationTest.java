package com.factoriaf5.rps.models;



import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GameIntegrationTest {

    @Test
    public void testGameDeterminesWinnerCorrectly() {
        Move rock = new Rock();
        Move scissors = new Scissors();
        Move paper = new Paper();

        // Rock beats Scissors
        assertTrue(rock.beats(scissors));
        assertFalse(scissors.beats(rock));

        // Paper beats Rock
        assertTrue(paper.beats(rock));
        assertFalse(rock.beats(paper));

        // Scissors beats Paper
        assertTrue(scissors.beats(paper));
        assertFalse(paper.beats(scissors));
    }

    @Test
    public void testGameDetectsTie() {
        Move rock1 = new Rock();
        Move rock2 = new Rock();

        assertFalse(rock1.beats(rock2));
        assertFalse(rock2.beats(rock1));
    }
}