package com.alex.chess.pieces;

import com.alex.chess.Board;
import com.alex.chess.enums.Color;
import com.alex.chess.enums.PieceName;
import com.alex.chess.enums.UnicodeView;

public class King extends Piece {

    private final PieceName name = PieceName.KING;

    private UnicodeView unicodeRepresentation;

    public King(Color pieceColor) {
        super(pieceColor);
        if (Color.WHITE.equals(pieceColor)) {
            unicodeRepresentation = UnicodeView.WHITE_KING;
        } else {
            unicodeRepresentation = UnicodeView.BLACK_KING;
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
