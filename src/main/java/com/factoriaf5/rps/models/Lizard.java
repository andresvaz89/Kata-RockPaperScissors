package com.factoriaf5.rps.models;

import java.util.Arrays;
import java.util.List;

public class Lizard implements Move {
    @Override
    public String getName() {
        return "Lagarto";
    }

    @Override
    public boolean beats(Move other) {
        List<String> defeats = Arrays.asList("Spock", "Papel");
        return defeats.contains(other.getName());
    }
}
