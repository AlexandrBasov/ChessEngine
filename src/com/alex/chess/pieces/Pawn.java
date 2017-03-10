package com.alex.chess.pieces;

import com.alex.chess.*;
import com.alex.chess.enums.Color;
import com.alex.chess.enums.PieceName;
import com.alex.chess.enums.UnicodeView;

import java.util.ArrayList;
import java.util.List;

import static com.alex.chess.util.MapCoordinates.*;
import static com.alex.chess.util.MapCoordinates.INDEX_TO_COLUMN;
import static com.alex.chess.util.MapCoordinates.INDEX_TO_ROW;

public class Pawn extends Piece {

    private final PieceName name = PieceName.PAWN;

    private UnicodeView unicodeRepresentation;

    private boolean enPassat;

    public Pawn(Color pieceColor) {
        super(pieceColor, PieceName.PAWN);
        this.enPassat = true;
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
        King king = (King) currentPlayer.getPieces().get(8);
        int currentRow = ROW_TO_INDEX.get(getCoordinates().getRow());
        int currentCol = COLUMN_TO_INDEX.get(getCoordinates().getCol());
        int tempRow = 0;
        int tempCol;

        if (Color.WHITE.equals(getPieceColor())) {
            if (currentRow == 6) {
                for (int i = 1; i <= 2; i++) {
                    tempRow -= i;
                    tempCol = currentCol;
                    Cell cell = board.getState()[tempRow][tempCol];
                    if (cell.isEmpty()) {
                        move = new Move(this, getCoordinates(),
                                new Coord(INDEX_TO_ROW.get(tempRow), INDEX_TO_COLUMN.get(tempCol)), null);
                        currentPlayer.makeMove(board, move);
                        if (!king.isAttacked(board)) {
                            possibleMoves.add(move);
                        }
                        currentPlayer.undoMove(board, move);
                    }
                    if((tempCol >= 0 && tempCol < 8) && !board.getState()[tempRow][tempCol + 1].isEmpty()) {
                        Piece enemy = board.getState()[tempRow][tempCol].getPiece();
                        if (!getPieceColor().equals(enemy.getPieceColor())) {

                            move = new Move(this, getCoordinates(),
                                    new Coord(INDEX_TO_ROW.get(tempRow), INDEX_TO_COLUMN.get(tempCol)), enemy);
                            currentPlayer.makeMove(board, move);
                            if (!king.isAttacked(board)) {
                                possibleMoves.add(move);
                            }
                            currentPlayer.undoMove(board, move);
                        }
                    }
                    if((tempCol >= 0 && tempCol < 8) && !board.getState()[tempRow][tempCol - 1].isEmpty()) {
                        Piece enemy = board.getState()[tempRow][tempCol].getPiece();
                        if (!getPieceColor().equals(enemy.getPieceColor())) {

                            move = new Move(this, getCoordinates(),
                                    new Coord(INDEX_TO_ROW.get(tempRow), INDEX_TO_COLUMN.get(tempCol)), enemy);
                            currentPlayer.makeMove(board, move);
                            if (!king.isAttacked(board)) {
                                possibleMoves.add(move);
                            }
                            currentPlayer.undoMove(board, move);
                        }
                    }
                }
            } else if(currentRow < 6 && currentRow > 0){
                tempRow -= 1;
                tempCol = currentCol;
                Cell cell = board.getState()[tempRow][tempCol];
                if (cell.isEmpty()) {
                    move = new Move(this, getCoordinates(),
                            new Coord(INDEX_TO_ROW.get(tempRow), INDEX_TO_COLUMN.get(tempCol)), null);
                    currentPlayer.makeMove(board, move);
                    if (!king.isAttacked(board)) {
                        possibleMoves.add(move);
                    }
                    currentPlayer.undoMove(board, move);
                }
                if((tempCol >= 0 && tempCol < 8) && !board.getState()[tempRow][tempCol + 1].isEmpty()) {
                    Piece enemy = board.getState()[tempRow][tempCol].getPiece();
                    if (!getPieceColor().equals(enemy.getPieceColor())) {

                        move = new Move(this, getCoordinates(),
                                new Coord(INDEX_TO_ROW.get(tempRow), INDEX_TO_COLUMN.get(tempCol)), enemy);
                        currentPlayer.makeMove(board, move);
                        if (!king.isAttacked(board)) {
                            possibleMoves.add(move);
                        }
                        currentPlayer.undoMove(board, move);
                    }
                }
                if((tempCol >= 0 && tempCol < 8) && !board.getState()[tempRow][tempCol - 1].isEmpty()) {
                    Piece enemy = board.getState()[tempRow][tempCol].getPiece();
                    if (!getPieceColor().equals(enemy.getPieceColor())) {

                        move = new Move(this, getCoordinates(),
                                new Coord(INDEX_TO_ROW.get(tempRow), INDEX_TO_COLUMN.get(tempCol)), enemy);
                        currentPlayer.makeMove(board, move);
                        if (!king.isAttacked(board)) {
                            possibleMoves.add(move);
                        }
                        currentPlayer.undoMove(board, move);
                    }
                }
                if(isEnPassat()){

                }
            }
        } else {
            if (currentRow == 1) {

            }
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

    public boolean isEnPassat() {
        return enPassat;
    }

    public void setEnPassat(boolean enPassat) {
        this.enPassat = enPassat;
    }
}
