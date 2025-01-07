package com.genz.player;

import java.util.Random;

import com.genz.board.Board;

public class AIPlayer extends Player {
    private Random random;

    public AIPlayer(String name, char symbol) {
        super(name, symbol);
        this.random = new Random();
    }

    public int[] getNextMove(Board board) {
        int row, col;
        do {
            row = random.nextInt(3); // Pilih baris secara acak (0-2)
            col = random.nextInt(3); // Pilih kolom secara acak (0-2)
        } while (!board.isCellEmpty(row, col)); // Pastikan sel kosong
        return new int[]{row, col};
    }
}