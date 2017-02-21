package com.alex.chess.pieces;

import com.alex.chess.Board;
import com.alex.chess.Cell;
import com.alex.chess.enums.Color;
import com.alex.chess.enums.PieceName;
import com.alex.chess.enums.UnicodeView;

import java.util.List;

public class Knight extends Piece{

    private final PieceName name = PieceName.KNIGHT;

    private UnicodeView unicodeRepresentation;

    public Knight(Color pieceColor) {
        super(pieceColor, PieceName.KNIGHT);
        if (Color.WHITE.equals(pieceColor)) {
            unicodeRepresentation = UnicodeView.WHITE_KNIGHT;
        } else {
            unicodeRepresentation = UnicodeView.BLACK_KNIGHT;
        }
    }

    @Override
    public List<Cell> getPossibleMoves(Board board) {
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
