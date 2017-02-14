package com.alex;

public class Board {

    private Cell[][] state;

    public Board() {
        this.state = new Cell[8][8];

        for (int i = 0; i < 64; i++) {
            if ((i + 1) % 2 != 0) {
                state[i / 8][i % 8] = new Cell(Color.WHITE, null);
            } else {
                state[i / 8][i % 8] = new Cell(Color.BLACK, null);
            }
        }
    }

    public Cell[][] getState() {
        return state;
    }
}
