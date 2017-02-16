package com.alex.chess.enums;

public enum Color {

    WHITE, BLACK;

    public Color opposite() {
        return this == WHITE ? BLACK : WHITE;
    }
}
