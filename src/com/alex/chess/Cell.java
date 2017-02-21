package com.alex.chess;

import com.alex.chess.enums.Color;
import com.alex.chess.pieces.Piece;

public class Cell {

    private Color cellColor;

    private Piece piece;

    private Coord coordinates;

    private boolean isOccupied;

    public Cell(Color color, Piece piece, Coord coordinates) {
        this.cellColor = color;
        this.piece = piece;
        this.coordinates = coordinates;
    }

    public Color getCellColor() {
        return cellColor;
    }

    public boolean isEmpty() {
        return null == piece;
    }

    public void setCellColor(Color cellColor) {
        this.cellColor = cellColor;
    }

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
        this.piece.setCoordinates(getCoordinates());
    }

    public Coord getCoordinates() {
        return coordinates;
    }

    @Override
    public String toString() {

        StringBuilder stringBuilder = new StringBuilder("");

        if (null != getPiece()) {
            stringBuilder.append(getPiece());
        } else {
            stringBuilder.append(" ");
        }
        return stringBuilder.toString();
    }
}
