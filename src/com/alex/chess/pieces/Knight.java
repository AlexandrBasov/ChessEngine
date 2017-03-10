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

public class Knight extends Piece {

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
    public List<Move> getPossibleMoves(Board board, Player currentPlayer) {

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

        List<Move> possibleMoves = new ArrayList<>();
        Move move;
        King king = (King) currentPlayer.getPieces().get(8);
        int currentRow = ROW_TO_INDEX.get(getCoordinates().getRow());
        int currentCol = COLUMN_TO_INDEX.get(getCoordinates().getCol());
        int tempRow;
        int tempCol;

        for (int[] offset : offsets) {
            tempRow = currentRow + offset[0];
            tempCol = currentCol + offset[1];
            if ((tempRow >= 0 && tempRow < 8 && tempCol >= 0 && tempCol < 8)
                    && !board.getState()[tempRow][tempCol].isEmpty()) {
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
