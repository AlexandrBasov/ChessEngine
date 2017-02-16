package com.alex.chess;

import com.alex.chess.enums.Color;
import com.alex.chess.pieces.*;

import java.util.ArrayList;
import java.util.List;

public abstract class Player implements MoveEngine {

    protected boolean canPlay;

    protected List<Piece> pieces;

    protected List<Piece> brokePieces;

    public Player(Color color) {
        this.pieces = new ArrayList<>();

        for (int i = 0; i < 8; i++) {
            pieces.add(new Pawn(color));
        }
        pieces.add(new King(color));
        pieces.add(new Queen(color));
        pieces.add(new Bishop(color));
        pieces.add(new Bishop(color));
        pieces.add(new King(color));
        pieces.add(new King(color));
        pieces.add(new Rook(color));
        pieces.add(new Rook(color));
    }

    public void putPiecesOnTheBoard(Board board) {

        assert board.getState() != null;
        Cell[][] state = board.getState();
        if (state[1][0].isEmpty()) {
            putPawns(state, 8, 16);
            putKing(state, 4);
            putQueen(state, 3);
            putBishops(state, 2, 5);
            putKnights(state, 1, 6);
            putRooks(state, 0, 7);
        } else {
            putPawns(state, 48, 56);
            putKing(state, 60);
            putQueen(state, 59);
            putBishops(state, 58, 61);
            putKnights(state, 57, 62);
            putRooks(state, 56, 63);
        }
    }

    private void putPawns(Cell[][] state, int from, int to) {
        for (int i = from; i < to; i++) {
            Piece piece = getPieces().get(i > 16 ? i - 48 : i - 8);
            state[i / 8][i % 8].setPiece(piece);
        }
    }

    private void putKing(Cell[][] state, int cell) {
        Piece king = getPieces().get(8);
        state[cell / 8][cell % 8].setPiece(king);
    }

    private void putQueen(Cell[][] state, int cell) {
        Piece queen = getPieces().get(9);
        state[cell / 8][cell % 8].setPiece(queen);
    }

    private void putBishops(Cell[][] state, int cell_one, int cell_two) {
        Piece bishopOne = getPieces().get(10);
        Piece bishopTwo = getPieces().get(11);

        state[cell_one / 8][cell_one % 8].setPiece(bishopOne);
        state[cell_two / 8][cell_two % 8].setPiece(bishopTwo);
    }

    private void putKnights(Cell[][] state, int cell_one, int cell_two) {
        Piece knightOne = getPieces().get(12);
        Piece knightTwo = getPieces().get(13);

        state[cell_one / 8][cell_one % 8].setPiece(knightOne);
        state[cell_two / 8][cell_two % 8].setPiece(knightTwo);
    }

    private void putRooks(Cell[][] state, int cell_one, int cell_two) {
        Piece rookOne = getPieces().get(14);
        Piece rookTwo = getPieces().get(15);

        state[cell_one / 8][cell_one % 8].setPiece(rookOne);
        state[cell_two / 8][cell_two % 8].setPiece(rookTwo);
    }

    public List<Piece> getPieces() {
        return pieces;
    }

    public List<Piece> getBrokePieces() {
        return brokePieces;
    }

    public boolean isCanPlay() {
        return canPlay;
    }

    public void setCanPlay(boolean canPlay) {
        this.canPlay = canPlay;
    }
}
