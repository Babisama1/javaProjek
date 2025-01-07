package com.genz;

import java.util.Scanner;

import com.genz.game.Game;
import com.genz.player.AIPlayer;
import com.genz.player.Player;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Selamat datang di Tic Tac Toe!");
        System.out.print("Apakah anda ingin melawan AI? (iya/tidak): ");
        String choice = scanner.next();

        Player player1 = new Player("Player 1", 'X');
        Player player2;

        if (choice.equalsIgnoreCase("iya")) {
            player2 = new AIPlayer("AI", 'O');
        } else {
            player2 = new Player("Player 2", 'O');
        }

        Game game = new Game(player1, player2, choice.equalsIgnoreCase("yes"));
        game.start();

        scanner.close();
    }
}
