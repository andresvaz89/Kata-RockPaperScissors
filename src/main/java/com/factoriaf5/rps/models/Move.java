package com.factoriaf5.rps.models;



public interface Move {
    String getName();
    boolean beats(Move other);
}
