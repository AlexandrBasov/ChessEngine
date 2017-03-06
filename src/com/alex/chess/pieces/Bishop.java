package com.alex.chess.pieces;

import com.alex.chess.Board;
import com.alex.chess.Cell;
import com.alex.chess.Move;
import com.alex.chess.Player;
import com.alex.chess.enums.Color;
import com.alex.chess.enums.PieceName;
import com.alex.chess.enums.UnicodeView;

import java.util.ArrayList;
import java.util.List;

import static com.alex.chess.enums.UnicodeView.BLACK_BISHOP;
import static com.alex.chess.enums.UnicodeView.WHITE_BISHOP;
import static com.alex.chess.util.MapCoordinates.COLUMN_TO_INDEX;
import static com.alex.chess.util.MapCoordinates.ROW_TO_INDEX;

public class Bishop extends Piece {

    private UnicodeView unicodeRepresentation;

    public Bishop(Color pieceColor) {
        super(pieceColor, PieceName.BISHOP);
        if (Color.WHITE.equals(pieceColor)) {
            unicodeRepresentation = WHITE_BISHOP;
        } else {
            unicodeRepresentation = BLACK_BISHOP;
        }
    }

    @Override
    public List<Move> getPossibleMoves(Board board, Player currentPlayer) {

        List<Cell> possibleMoves = new ArrayList<>();

        int currentRow = ROW_TO_INDEX.get(getCoordinates().getRow());
        int currentCol = COLUMN_TO_INDEX.get(getCoordinates().getCol());

        for (int i = -1; i <= 1; i += 2) {
            for (int j = 1; j < 8; j++) {
                if (isValidMove(board.getState(), currentRow + (i * j), currentCol + (i * j))){
                    possibleMoves.add(board.getState()[currentRow + (i * j)][currentCol + (i * j)]);
                }
            }
        }

        return possibleMoves;
    }

    private boolean isValidMove(Cell[][] state, int row, int col) {
        try{

        }catch (ArrayIndexOutOfBoundsException e){
            return false;
        }
        return true;
    }

    private boolean isValidMove(Cell cell) {
        return false;
    }

    public UnicodeView getUnicodeRepresentation() {
        return unicodeRepresentation;
    }

    @Override
    public String toString() {
        return getUnicodeRepresentation().getUnicode();
    }
}
