package com.alex.chess;

import com.alex.chess.pieces.Piece;

public class Move {

    private Piece piece;

    private Piece taken;

    private Coord from;

    private Coord to;

    public Move(Piece piece, Coord from, Coord to, Piece taken) {
        this.piece = piece;
        this.from = from;
        this.to = to;
        this.taken = taken;
    }

    public Piece getTaken() {
        return taken;
    }

    public void setTaken(Piece taken) {
        this.taken = taken;
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
