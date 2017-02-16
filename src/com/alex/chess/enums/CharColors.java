package com.alex.chess.enums;

public enum CharColors {

    RESET("\u001B[0m"),
    BLACK("\u001B[30;1m"),
    RED("\u001B[31;1m"),
    GREEN("\u001B[32;1m"),
    YELLOW("\u001B[33;1m"),
    BLUE("\u001B[34;1m"),
    PURPLE("\u001B[35;1m"),
    CYAN("\u001B[36;1m"),
    WHITE("\u001B[37;1m");

    String unicodeColor;

    CharColors(String unicodeColor) {

        this.unicodeColor = unicodeColor;
    }

    public String getUnicodeColor() {
        return unicodeColor;
    }
}
