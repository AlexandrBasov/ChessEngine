package com.alex.chess;

import com.alex.chess.enums.Color;

public class Main {

    public static void main(String[] args) {

        Game chessGame = new Game(true, Color.WHITE);

        chessGame.run();
    }
}
