package com.factoriaf5.rps.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MoveTest {

    @Test
    public void testRockBeatsScissorsAndLizard() {
        Move rock = new Rock();
        assertTrue(rock.beats(new Scissors()));
        assertTrue(rock.beats(new Lizard()));
        assertFalse(rock.beats(new Paper()));
        assertFalse(rock.beats(new Spock()));
    }
}