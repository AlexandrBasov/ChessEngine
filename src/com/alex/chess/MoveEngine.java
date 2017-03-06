package com.alex.chess;

public interface MoveEngine {

    void makeMove(Board board, Move move);

    void undoMove(Board board, Move move);
}
