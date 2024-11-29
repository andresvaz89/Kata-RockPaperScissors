

package com.factoriaf5.rps.models;

import java.util.Arrays;
import java.util.List;

public class Rock implements Move {
    @Override
    public String getName() {
        return "Piedra";
    }

    @Override
    public boolean beats(Move other) {
        List<String> defeats = Arrays.asList("Tijera", "Lagarto");
        return defeats.contains(other.getName());
    }
}
