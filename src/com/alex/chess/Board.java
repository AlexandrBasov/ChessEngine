package com.alex.chess;

import com.alex.chess.enums.Color;

import static com.alex.chess.util.MapCoordinates.*;

public class Board {

    private Cell[][] state;

    public Board() {

        this.state = new Cell[8][8];

        for (int i = 0; i < 64; i++) {
            if ((i + 1) % 2 != 0) {
                state[i / 8][i % 8] = new Cell(Color.WHITE, null, new Coord(INDEX_TO_ROW.get(i/8), INDEX_TO_COLUMN.get(i%8)));
            } else {
                state[i / 8][i % 8] = new Cell(Color.BLACK, null, new Coord(INDEX_TO_ROW.get(i/8), INDEX_TO_COLUMN.get(i%8)));
            }
        }
    }

    public Cell[][] getState() {
        return state;
    }
}
