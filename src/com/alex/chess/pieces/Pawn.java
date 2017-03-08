package com.alex.chess.pieces;

import com.alex.chess.Board;
import com.alex.chess.Move;
import com.alex.chess.Player;
import com.alex.chess.enums.Color;
import com.alex.chess.enums.PieceName;
import com.alex.chess.enums.UnicodeView;

import java.util.ArrayList;
import java.util.List;

import static com.alex.chess.util.MapCoordinates.COLUMN_TO_INDEX;
import static com.alex.chess.util.MapCoordinates.ROW_TO_INDEX;

public class Pawn extends Piece{

    private final PieceName name = PieceName.PAWN;

    private UnicodeView unicodeRepresentation;

    public Pawn(Color pieceColor) {
        super(pieceColor, PieceName.PAWN);
        if (Color.WHITE.equals(pieceColor)) {
            unicodeRepresentation = UnicodeView.WHITE_PAWN;
        } else {
            unicodeRepresentation = UnicodeView.BLACK_PAWN;
        }
    }
    @Override
    public List<Move> getPossibleMoves(Board board, Player currentPlayer) {
        List<Move> possibleMoves = new ArrayList<>();
        Move move;
        int currentRow = ROW_TO_INDEX.get(getCoordinates().getRow());
        int currentCol = COLUMN_TO_INDEX.get(getCoordinates().getCol());
        int tempRow;
        int tempCol;

        if(Color.WHITE.equals(getPieceColor())){

        } else {

        }

        return possibleMoves;
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
