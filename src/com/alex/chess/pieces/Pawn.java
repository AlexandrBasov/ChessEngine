package com.alex.chess.pieces;

import com.alex.chess.Board;
import com.alex.chess.enums.Color;
import com.alex.chess.enums.PieceName;
import com.alex.chess.enums.UnicodeView;

public class Pawn extends Piece{

    private final PieceName name = PieceName.PAWN;

    private UnicodeView unicodeRepresentation;

    public Pawn(Color pieceColor) {
        super(pieceColor);
        if (Color.WHITE.equals(pieceColor)) {
            unicodeRepresentation = UnicodeView.WHITE_PAWN;
        } else {
            unicodeRepresentation = UnicodeView.BLACK_PAWN;
        }
    }

    @Override
    public String getPossibleMoves(Board board) {
        return "";
    }

    public PieceName getName() {
        return name;
    }

    public UnicodeView getUnicodeRepresentation() {
        return unicodeRepresentation;
    }

    @Override
    public String toString() {
        return getUnicodeRepresentation().getUnicode();
    }
}
