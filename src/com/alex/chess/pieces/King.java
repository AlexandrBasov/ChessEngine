package com.alex.chess.pieces;

import com.alex.chess.*;
import com.alex.chess.enums.Color;
import com.alex.chess.enums.PieceName;
import com.alex.chess.enums.UnicodeView;

import java.util.ArrayList;
import java.util.List;

import static com.alex.chess.enums.PieceName.*;
import static com.alex.chess.util.MapCoordinates.*;

public class King extends Piece {

    private UnicodeView unicodeRepresentation;

    public King(Color pieceColor) {
        super(pieceColor, PieceName.KING);
        if (Color.WHITE.equals(pieceColor)) {
            unicodeRepresentation = UnicodeView.WHITE_KING;
        } else {
            unicodeRepresentation = UnicodeView.BLACK_KING;
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
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                tempRow = currentRow + i;
                tempCol = currentCol + j;
                if (tempRow >= 0 && tempRow < 8 && tempCol >= 0 && tempCol < 8) {
                    Cell cell = board.getState()[tempRow][tempCol];
                    if (cell.isEmpty()) {
                        move = new Move(this, getCoordinates(),
                                new Coord(INDEX_TO_ROW.get(tempRow), INDEX_TO_COLUMN.get(tempCol)));
                        currentPlayer.makeMove(board, move);
                        if (!this.isAttacked(board)) {
                            possibleMoves.add(move);
                        }
                        currentPlayer.undoMove(board, move);
                    } else {
                        Piece enemy = board.getState()[tempRow][tempCol].getPiece();
                        if (!getPieceColor().equals(enemy.getPieceColor())) {

                            move = new Move(this, getCoordinates(),
                                    new Coord(INDEX_TO_ROW.get(tempRow), INDEX_TO_COLUMN.get(tempCol)));
                            currentPlayer.makeMove(board, move);
                            if (!this.isAttacked(board)) {
                                possibleMoves.add(move);
                            }
                            currentPlayer.undoMove(board, move);
                        }
                    }
                }
            }
        }
        return possibleMoves;
    }

    public boolean isAttacked(Board board) {

        int currentRow = ROW_TO_INDEX.get(getCoordinates().getRow());
        int currentCol = COLUMN_TO_INDEX.get(getCoordinates().getCol());

        return
                attackedByRookOrQueen(board, currentRow, currentCol) ||
                        attackedByBishopOrQueen(board, currentRow, currentCol) ||
                        attackedByPawn(board, currentRow, currentCol) ||
                        attackedByKnight(board, currentRow, currentCol) ||
                        attackedByKing(board, currentRow, currentCol);
    }

    private boolean attackedByKing(Board board, int currentRow, int currentCol) {
        int tempRow;
        int tempCol;

        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                tempRow = currentRow + i;
                tempCol = currentCol + j;
                if ((tempRow >= 0 && tempRow < 8 && tempCol >= 0 && tempCol < 8)
                        && !board.getState()[tempRow][tempCol].isEmpty()) {
                    Piece enemy = board.getState()[tempRow][tempCol].getPiece();
                    if (!getPieceColor().equals(enemy.getPieceColor())) {
                        PieceName pieceName = enemy.getName();
                        if (KING.equals(pieceName)) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    private boolean attackedByKnight(Board board, int currentRow, int currentCol) {

        int[][] offsets = {
                {-2, 1},
                {-1, 2},
                {1, 2},
                {2, 1},
                {2, -1},
                {1, -2},
                {-1, -2},
                {-2, -1}
        };

        int tempRow;
        int tempCol;

        for (int[] offset : offsets) {
            tempRow = currentRow + offset[0];
            tempCol = currentCol + offset[1];
            if ((tempRow >= 0 && tempRow < 8 && tempCol >= 0 && tempCol < 8)
                    && !board.getState()[tempRow][tempCol].isEmpty()) {
                Piece enemy = board.getState()[tempRow][tempCol].getPiece();
                if (!getPieceColor().equals(enemy.getPieceColor())) {
                    PieceName pieceName = enemy.getName();
                    if (KNIGHT.equals(pieceName)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    private boolean attackedByPawn(Board board, int currentRow, int currentCol) {
        int tempRow;
        int tempCol;

        for (int i = -1; i <= 1; i += 2) {
            tempRow = currentRow - 1;
            tempCol = currentCol + i;
            if ((tempRow >= 0 && tempRow < 8 && tempCol >= 0 && tempCol < 8)
                    && !board.getState()[tempRow][tempCol].isEmpty()) {
                Piece enemy = board.getState()[tempRow][tempCol].getPiece();
                if (!getPieceColor().equals(enemy.getPieceColor())) {
                    PieceName pieceName = enemy.getName();
                    if (PAWN.equals(pieceName)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean attackedByRookOrQueen(Board board, int currentRow, int currentCol) {
        int tempRow;
        int tempCol;

        for (int i = -1; i <= 1; i++) {
            tempRow = currentRow + i;
            tempCol = currentCol;
            while (tempRow >= 0 && tempRow < 8) {
                if (!board.getState()[tempRow][tempCol].isEmpty()) {
                    Piece enemy = board.getState()[tempRow][tempCol].getPiece();
                    if (getPieceColor().equals(enemy.getPieceColor())) {
                        break;
                    } else {
                        PieceName pieceName = enemy.getName();
                        if (QUEEN.equals(pieceName) || ROOK.equals(pieceName)) {
                            return true;
                        }
                    }
                }
                tempRow++;
            }
        }
        for (int j = -1; j <= 1; j++) {
            tempRow = currentRow;
            tempCol = currentCol + j;
            while (tempCol >= 0 && tempCol < 8) {
                if (!board.getState()[tempRow][tempCol].isEmpty()) {
                    Piece enemy = board.getState()[tempRow][tempCol].getPiece();
                    if (getPieceColor().equals(enemy.getPieceColor())) {
                        break;
                    } else {
                        PieceName pieceName = enemy.getName();
                        if (QUEEN.equals(pieceName) || ROOK.equals(pieceName)) {
                            return true;
                        }
                    }
                }
                tempCol++;
            }
        }
        return false;
    }

    private boolean attackedByBishopOrQueen(Board board, int currentRow, int currentCol) {
        int tempRow;
        int tempCol;

        for (int i = -1; i <= 1; i += 2) {
            for (int j = -1; j <= 1; j += 2) {
                tempRow = currentRow + i;
                tempCol = currentCol + j;
                while (tempRow >= 0 && tempRow < 8 && tempCol >= 0 && tempCol < 8) {
                    if (!board.getState()[tempRow][tempCol].isEmpty()) {
                        Piece enemy = board.getState()[tempRow][tempCol].getPiece();
                        if (getPieceColor().equals(enemy.getPieceColor())) {
                            break;
                        } else {
                            PieceName pieceName = enemy.getName();
                            if (BISHOP.equals(pieceName) || QUEEN.equals(pieceName)) {
                                return true;
                            }
                        }
                    }
                    tempRow++;
                    tempCol++;
                }
            }
        }

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
