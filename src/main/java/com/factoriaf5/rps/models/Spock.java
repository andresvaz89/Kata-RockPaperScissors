package com.factoriaf5.rps.models;

import java.util.Arrays;
import java.util.List;

public class Spock implements Move {
    @Override
    public String getName() {
        return "Spock";
    }

    @Override
    public boolean beats(Move other) {
        List<String> defeats = Arrays.asList("Tijera", "Piedra");
        return defeats.contains(other.getName());
    }
}
