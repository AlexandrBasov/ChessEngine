package com.alex.chess;

import com.alex.chess.pieces.Piece;

public class Move {

    private Piece piece;

    private Coord from;

    private Coord to;

    public Move(Piece piece, Coord from, Coord to) {
        this.piece = piece;
        this.from = from;
        this.to = to;
    }

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public Coord getFrom() {
        return from;
    }

    public void setFrom(Coord from) {
        this.from = from;
    }

    public Coord getTo() {
        return to;
    }

    public void setTo(Coord to) {
        this.to = to;
    }
}
