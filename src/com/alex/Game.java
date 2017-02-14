package com.alex;

import java.util.Arrays;
import java.util.Scanner;

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

        System.out.println("Choose the piece: ");

        Piece piece;
        if (scanner.hasNext()){
            String cellCoords = scanner.nextLine();
            piece = getBoard().getState()[cellCoords.charAt(0)][cellCoords.charAt(1)].getPiece();
        }
    }

    private void render(Cell[][] state) {
        for (int i=0; i<state.length; i++){
            System.out.println(Arrays.asList(state[i]));
        }
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
