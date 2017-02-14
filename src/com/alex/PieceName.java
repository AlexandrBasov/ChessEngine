package com.alex;

public enum PieceName {

    KING("A"),
    QUEEN("Q"),
    ROOK("R"),
    BISHOP("B"),
    KNIGHT("K"),
    PAWN("P");

    private String shortName;

    PieceName(String shortName) {
        this.shortName = shortName;
    }

    public String getShortName() {
        return shortName;
    }
}
