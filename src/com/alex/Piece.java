package com.alex;

public class Piece {

    private Color pieceColor;

    private PieceName pieceName;

    public Piece(PieceName pieceName, Color pieceColor) {
        this.pieceColor = pieceColor;
        this.pieceName = pieceName;
    }

    public Color getPieceColor() {
        return pieceColor;
    }

    public PieceName getPieceName() {
        return pieceName;
    }
}
