package com.alex.chess.pieces;

import com.alex.chess.*;
import com.alex.chess.enums.Color;
import com.alex.chess.enums.PieceName;

import java.util.List;

import static com.alex.chess.util.MapCoordinates.INDEX_TO_COLUMN;
import static com.alex.chess.util.MapCoordinates.INDEX_TO_ROW;

public abstract class Piece {

    private Color pieceColor;

    private PieceName name;

    private Coord coordinates;

    public Piece(Color pieceColor, PieceName name) {
        this.pieceColor = pieceColor;
        this.name = name;
    }
    public Color getPieceColor() {
        return pieceColor;
    }

    public abstract List<Move> getPossibleMoves(Board board, Player currentPlayer);

    protected boolean checkMove(Player currentPlayer, List<Move> possibleMoves, Board board,
                                King king, int tempRow, int tempCol) {
        Cell cell = board.getState()[tempRow][tempCol];
        if (cell.isEmpty()) {
            doAndUndoMove(currentPlayer, possibleMoves, board, king, tempRow, tempCol);
            return false;
        } else {
            Piece enemy = board.getState()[tempRow][tempCol].getPiece();
            if (getPieceColor().equals(enemy.getPieceColor())) {
                return true;
            } else {
                doAndUndoMove(currentPlayer, possibleMoves, board, king, tempRow, tempCol);
                return false;
            }
        }
    }

    private void doAndUndoMove(Player currentPlayer, List<Move> possibleMoves, Board board,
                               King king, int tempRow, int tempCol){
        Move move;
        move = new Move(this, getCoordinates(),
                new Coord(INDEX_TO_ROW.get(tempRow), INDEX_TO_COLUMN.get(tempCol)));
        currentPlayer.makeMove(board, move);
        if (!king.isAttacked(board)) {
            possibleMoves.add(move);
        }
        currentPlayer.undoMove(board, move);
    }

    public Coord getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coord coordinates) {
        this.coordinates = coordinates;
    }

    public PieceName getName() {
        return name;
    }
}
