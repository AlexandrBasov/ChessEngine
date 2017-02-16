package com.alex.chess.pieces;

import com.alex.chess.Board;
import com.alex.chess.enums.Color;
import com.alex.chess.enums.PieceName;
import com.alex.chess.enums.UnicodeView;
import com.alex.chess.util.MapCoordinates;

import static com.alex.chess.util.MapCoordinates.*;

import static com.alex.chess.enums.PieceName.BISHOP;
import static com.alex.chess.enums.UnicodeView.*;

public class Bishop extends Piece {

    private final PieceName name = BISHOP;

    private UnicodeView unicodeRepresentation;

    public Bishop(Color pieceColor) {
        super(pieceColor);
        if (Color.WHITE.equals(pieceColor)) {
            unicodeRepresentation = WHITE_BISHOP;
        } else {
            unicodeRepresentation = BLACK_BISHOP;
        }
    }

    @Override
    public String getPossibleMoves(Board board) {

        int row = ROW_TO_INDEX.get(getCoordinates().getRow());
        int col = COLUMN_TO_INDEX.get(getCoordinates().getCol());

        int shift = 1;
        for (int r=row-shift; ) ;

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
