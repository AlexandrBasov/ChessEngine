package com.alex;

public class Cell {

    private Color cellColor;

    private Piece piece;

    public Cell(Color color, Piece piece) {
        this.cellColor = color;
        this.piece = piece;
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
    }

    @Override
    public String toString() {

        StringBuilder stringBuilder = new StringBuilder("");

        if (null != getPiece()) {
            stringBuilder.append(Color.WHITE.equals(getPiece().getPieceColor()) ? getPiece().getPieceName().getShortName().toUpperCase() :
                    getPiece().getPieceName().getShortName().toLowerCase());
        } else {
            stringBuilder.append(" ");
        }
        return stringBuilder.toString();
    }
}
