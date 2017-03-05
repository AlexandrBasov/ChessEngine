package com.alex.chess.pieces;

import com.alex.chess.Board;
import com.alex.chess.Cell;
import com.alex.chess.Player;
import com.alex.chess.enums.Color;
import com.alex.chess.enums.PieceName;
import com.alex.chess.enums.UnicodeView;

import java.util.List;

import static com.alex.chess.enums.PieceName.*;
import static com.alex.chess.util.MapCoordinates.COLUMN_TO_INDEX;
import static com.alex.chess.util.MapCoordinates.ROW_TO_INDEX;

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
    public List<Cell> getPossibleMoves(Board board, Player currentPlayer) {
        return null;
    }

    public boolean isAttacked(Board board) {

        int currentRow = ROW_TO_INDEX.get(getCoordinates().getRow());
        int currentCol = COLUMN_TO_INDEX.get(getCoordinates().getCol());

        return attackedByBishopOrRookOrQueen(board, currentRow, currentCol);
    }

    private boolean attackedByBishopOrRookOrQueen(Board board, int currentRow, int currentCol) {
        int tempRow;
        int tempCol;

        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                tempRow = currentRow + i;
                tempCol = currentCol + j;
                while (tempRow >= 0 || tempRow < 8 || tempCol >= 0 || tempCol < 8) {
                    if (!board.getState()[tempRow][tempCol].isEmpty()) {
                        Piece enemy = board.getState()[tempRow][tempCol].getPiece();
                        if (getPieceColor().equals(enemy.getPieceColor())) {
                            break;
                        } else {
                            PieceName pieceName = enemy.getName();
                            if (BISHOP.equals(pieceName) || QUEEN.equals(pieceName) || ROOK.equals(pieceName)) {
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
