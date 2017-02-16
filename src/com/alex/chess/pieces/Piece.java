package com.alex.chess.pieces;

import com.alex.chess.Board;
import com.alex.chess.Coord;
import com.alex.chess.enums.Color;

public abstract class Piece {

    private Color pieceColor;

    private Coord coordinates;

    public Piece(Color pieceColor) {
        this.pieceColor = pieceColor;
    }

    public Color getPieceColor() {
        return pieceColor;
    }

    public abstract String getPossibleMoves(Board board);

    public Coord getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coord coordinates) {
        this.coordinates = coordinates;
    }
}
