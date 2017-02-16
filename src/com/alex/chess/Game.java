package com.alex.chess;

import com.alex.chess.enums.Color;
import com.alex.chess.pieces.Piece;

import java.util.Scanner;

import static com.alex.chess.enums.CharColors.*;

public class Game {
    private Player player_1;
    private Player player_2;

    private Board board;

    public Game(boolean multiplayer, Color color) {

        this.player_1 = new HumanPlayer(color);

        if (multiplayer) {
            player_2 = new HumanPlayer(color.opposite());
        } else {
            player_2 = new ComputerPlayer(color.opposite());
        }

        this.board = new Board();

        player_1.putPiecesOnTheBoard(this.board);
        player_2.putPiecesOnTheBoard(this.board);
    }

    public void run() {

        render(getBoard().getState());

        Scanner scanner = new Scanner(System.in);

        System.out.println("\nChoose the piece: ");

        Piece piece;
        if (scanner.hasNext()) {
            String cellCoords = scanner.nextLine();
            piece = getBoard().getState()[cellCoords.charAt(0)][cellCoords.charAt(1)].getPiece();
        }
    }

    private void render(Cell[][] state) {
        System.out.println();
        for (int i = 0; i < state.length; i++) {
            printRow(state[i], state.length - i);
        }
    }

    private void printRow(Cell[] row, int rowNumber) {
        printUpLine();
        printMiddleLine(row, rowNumber);
        if (rowNumber == 1) {
            printUpLine();
            System.out.println(RED.getUnicodeColor() + "\t\t\t\t\t\t  a   b   c   d   e   f   g   h  " + RESET.getUnicodeColor());
        }
    }

    public void printUpLine() {
        System.out.print("\t\t\t\t\t\t");
        for (int i = 0; i < 33; i++) {
            if (i == 0 || i % 4 == 0) {
                System.out.print(WHITE.getUnicodeColor() + "+" + RESET.getUnicodeColor());
            } else {
                System.out.print(WHITE.getUnicodeColor() + "-" + RESET.getUnicodeColor());
            }
        }
        System.out.println();
    }

    public void printMiddleLine(Cell[] cells, int rowNumber) {
        System.out.print(RED.getUnicodeColor() + "\t\t\t\t\t  " + rowNumber + " " + RESET.getUnicodeColor());

        for (int i = 0; i < cells.length; i++) {
            System.out.print(WHITE.getUnicodeColor() + "| " + cells[i] + " " + RESET.getUnicodeColor());
        }
        System.out.println("|");
    }

    public MoveEngine getPlayer_1() {
        return player_1;
    }

    public MoveEngine getPlayer_2() {
        return player_2;
    }

    public Board getBoard() {
        return board;
    }
}
