package com.alex.chess.pieces;

import com.alex.chess.*;
import com.alex.chess.enums.Color;
import com.alex.chess.enums.PieceName;
import com.alex.chess.enums.UnicodeView;

import java.util.ArrayList;
import java.util.List;

import static com.alex.chess.enums.UnicodeView.BLACK_BISHOP;
import static com.alex.chess.enums.UnicodeView.WHITE_BISHOP;
import static com.alex.chess.util.MapCoordinates.*;
import static com.alex.chess.util.MapCoordinates.INDEX_TO_COLUMN;
import static com.alex.chess.util.MapCoordinates.INDEX_TO_ROW;

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

        List<Move> possibleMoves = new ArrayList<>();
        Move move;
        King king = (King) currentPlayer.getPieces().get(8);
        int currentRow = ROW_TO_INDEX.get(getCoordinates().getRow());
        int currentCol = COLUMN_TO_INDEX.get(getCoordinates().getCol());
        int tempRow;
        int tempCol;

        for (int i = -1; i <= 1; i+=2) {
            for (int j = -1; j <= 1; j+=2) {
                tempRow = currentRow + i;
                tempCol = currentCol + j;
                while (tempRow >= 0 && tempRow < 8 && tempCol >= 0 && tempCol < 8) {
                    Cell cell = board.getState()[tempRow][tempCol];
                    if (cell.isEmpty()) {
                        move = new Move(this, getCoordinates(),
                                new Coord(INDEX_TO_ROW.get(tempRow), INDEX_TO_COLUMN.get(tempCol)), null);
                        currentPlayer.makeMove(board, move);
                        if (!king.isAttacked(board)) {
                            possibleMoves.add(move);
                        }
                        currentPlayer.undoMove(board, move);
                    } else {
                        Piece enemy = board.getState()[tempRow][tempCol].getPiece();
                        if (getPieceColor().equals(enemy.getPieceColor())) {
                            break;
                        } else {
                            move = new Move(this, getCoordinates(),
                                    new Coord(INDEX_TO_ROW.get(tempRow), INDEX_TO_COLUMN.get(tempCol)), enemy);
                            currentPlayer.makeMove(board, move);
                            if (!king.isAttacked(board)) {
                                possibleMoves.add(move);
                            }
                            currentPlayer.undoMove(board, move);
                        }
                    }
                    tempRow++;
                    tempCol++;
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
