package com.alex.chess.pieces;

import com.alex.chess.Board;
import com.alex.chess.enums.Color;
import com.alex.chess.enums.PieceName;
import com.alex.chess.enums.UnicodeView;

public class Rook extends Piece{

    private final PieceName name = PieceName.ROOK;

    private UnicodeView unicodeRepresentation;

    public Rook(Color pieceColor) {
        super(pieceColor);
        if (Color.WHITE.equals(pieceColor)) {
            unicodeRepresentation = UnicodeView.WHITE_ROOK;
        } else {
            unicodeRepresentation = UnicodeView.BLACK_ROOK;
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