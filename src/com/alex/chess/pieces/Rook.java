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

public class Rook extends Piece{

    private final PieceName name = PieceName.ROOK;

    private UnicodeView unicodeRepresentation;

    public Rook(Color pieceColor) {
        super(pieceColor, PieceName.ROOK);
        if (Color.WHITE.equals(pieceColor)) {
            unicodeRepresentation = UnicodeView.WHITE_ROOK;
        } else {
            unicodeRepresentation = UnicodeView.BLACK_ROOK;
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

        for (int i = -1; i <= 1; i++) {
            tempRow = currentRow + i;
            tempCol = currentCol;
            while (tempRow >= 0 && tempRow < 8) {
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
            }
        }
        for (int j = -1; j <= 1; j++) {
            tempRow = currentRow;
            tempCol = currentCol + j;
            while (tempCol >= 0 && tempCol < 8) {
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
                tempCol++;
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
}
