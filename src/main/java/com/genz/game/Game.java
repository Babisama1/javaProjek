package com.genz.game;

import java.util.Scanner;

import com.genz.board.Board;
import com.genz.player.AIPlayer;
import com.genz.player.Player;

public class Game {
    private Board board;
    private Player player1;
    private Player player2;
    private boolean againstAI;

    public Game(Player player1, Player player2, boolean againstAI) {
        this.board = new Board();
        this.player1 = player1;
        this.player2 = player2;
        this.againstAI = againstAI;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            board = new Board(); // Reset papan untuk ronde baru
            Player currentPlayer = player1;

            while (true) {
                board.displayBoard();
                if (currentPlayer instanceof AIPlayer) {
                    System.out.println(currentPlayer.getName() + "'s turn (" + currentPlayer.getSymbol() + ").");
                    int[] move = ((AIPlayer) currentPlayer).getNextMove(board);
                    board.markCell(move[0], move[1], currentPlayer.getSymbol());
                    System.out.println("AI chooses: row " + move[0] + ", column " + move[1]);
                } else {
                    System.out.println(currentPlayer.getName() + "'s turn (" + currentPlayer.getSymbol() + ").");
                    System.out.print("Enter row (0-2): ");
                    int row = scanner.nextInt();
                    System.out.print("Enter column (0-2): ");
                    int col = scanner.nextInt();

                    if (row < 0 || row > 2 || col < 0 || col > 2 || !board.isCellEmpty(row, col)) {
                        System.out.println("Gerakan invalid dipersilahkan untuk mencoba lagi.");
                        continue;
                    }
                    board.markCell(row, col, currentPlayer.getSymbol());
                }

                if (board.checkWinner(currentPlayer.getSymbol())) {
                    board.displayBoard();
                    System.out.println("Selamat untuk, " + currentPlayer.getName() + "! ");
                    currentPlayer.incrementScore(); // Tambahkan skor untuk pemenang
                    break;
                }

                if (board.isFull()) {
                    board.displayBoard();
                    System.out.println("Wah seri cuy!");
                    break;
                }

                // Ganti giliran
                currentPlayer = (currentPlayer == player1) ? player2 : player1;
            }

            // Tampilkan skor setelah ronde selesai
            System.out.println("\nCurrent Scores:");
            System.out.println(player1.getName() + ": " + player1.getScore());
            System.out.println(player2.getName() + ": " + player2.getScore());

            // Tanyakan apakah ingin bermain lagi
            System.out.print("Mau bermain lagi? (iya/tidak): ");
            String choice = scanner.next();
            if (!choice.equalsIgnoreCase("iya")) {
                System.out.println("Thank you for playing!");
                break;
            }
        }

        scanner.close();
    }
}