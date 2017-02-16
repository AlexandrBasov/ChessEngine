package com.alex.chess.enums;

import static com.alex.chess.enums.CharColors.*;

public enum UnicodeView {

    WHITE_KING(YELLOW.getUnicodeColor() + "\u2654" + RESET.getUnicodeColor()),
    WHITE_QUEEN(YELLOW.getUnicodeColor() + "\u2655" + RESET.getUnicodeColor()),
    WHITE_ROOK(YELLOW.getUnicodeColor() + "\u2656" + RESET.getUnicodeColor()),
    WHITE_BISHOP(YELLOW.getUnicodeColor() + "\u2657" + RESET.getUnicodeColor()),
    WHITE_KNIGHT(YELLOW.getUnicodeColor() + "\u2658" + RESET.getUnicodeColor()),
    WHITE_PAWN(YELLOW.getUnicodeColor() + "\u2659" + RESET.getUnicodeColor()),

    BLACK_KING(BLUE.getUnicodeColor() + "\u265A" + RESET.getUnicodeColor()),
    BLACK_QUEEN(BLUE.getUnicodeColor() + "\u265B" + RESET.getUnicodeColor()),
    BLACK_ROOK(BLUE.getUnicodeColor() + "\u265C" + RESET.getUnicodeColor()),
    BLACK_BISHOP(BLUE.getUnicodeColor() + "\u265D" + RESET.getUnicodeColor()),
    BLACK_KNIGHT(BLUE.getUnicodeColor() + "\u265E" + RESET.getUnicodeColor()),
    BLACK_PAWN(BLUE.getUnicodeColor() + "\u265F" + RESET.getUnicodeColor());

    private String unicode;

    UnicodeView(String unicode) {
        this.unicode = unicode;
    }

    public String getUnicode() {
        return unicode;
    }
}
