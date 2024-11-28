package com.factoriaf5.rps.models;

import java.util.Arrays;
import java.util.List;

public class Scissors implements Move {
    @Override
    public String getName() {
        return "Tijera";
    }

    @Override
    public boolean beats(Move other) {
        List<String> defeats = Arrays.asList("Papel", "Lagarto");
        return defeats.contains(other.getName());
    }
}
