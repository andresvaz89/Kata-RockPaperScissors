package com.factoriaf5.rps.models;

import java.util.Arrays;
import java.util.List;

public class Paper implements Move {
    @Override
    public String getName() {
        return "Papel";
    }

    @Override
    public boolean beats(Move other) {
        List<String> defeats = Arrays.asList("Piedra", "Spock");
        return defeats.contains(other.getName());
    }
}
