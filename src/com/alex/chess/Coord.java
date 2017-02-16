package com.alex.chess;

public class Coord {

    private String row;

    private String col;

    private int dimension;

    public Coord (String row, String column){
        this.row = row;
        this.col = column;
    }

    public String getRow() {
        return row;
    }

    public void setRow(String row) {
        this.row = row;
    }

    public String getCol() {
        return col;
    }

    public void setCol(String col) {
        this.col = col;
    }

    @Override
    public String toString() {
        return col + row;
    }
}
