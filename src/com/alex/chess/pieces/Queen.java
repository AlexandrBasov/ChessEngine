package com.alex.chess.pieces;

import com.alex.chess.Board;
import com.alex.chess.Cell;
import com.alex.chess.enums.Color;
import com.alex.chess.enums.PieceName;
import com.alex.chess.enums.UnicodeView;

import java.util.List;

public class Queen extends Piece{

    private final PieceName name = PieceName.QUEEN;

    private UnicodeView unicodeRepresentation;

    public Queen(Color pieceColor) {
        super(pieceColor, PieceName.QUEEN);
        if (Color.WHITE.equals(pieceColor)) {
            unicodeRepresentation = UnicodeView.WHITE_QUEEN;
        } else {
            unicodeRepresentation = UnicodeView.BLACK_QUEEN;
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
