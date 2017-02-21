package com.alex.chess.pieces;

import com.alex.chess.Board;
import com.alex.chess.Cell;
import com.alex.chess.Coord;
import com.alex.chess.Player;
import com.alex.chess.enums.Color;
import com.alex.chess.enums.PieceName;

import java.util.List;

public abstract class Piece {

    private Color pieceColor;

    private PieceName name;

    private Coord coordinates;

    public Piece(Color pieceColor, PieceName name) {
        this.pieceColor = pieceColor;
        this.name = name;
    }

    public Color getPieceColor() {
        return pieceColor;
    }

    public abstract List<Cell> getPossibleMoves(Board board, Player currentPlayer);

    public Coord getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coord coordinates) {
        this.coordinates = coordinates;
    }

    public PieceName getName() {
        return name;
    }
}
