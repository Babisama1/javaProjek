package com.genz.board;

public class Board {
    private char[][] board;
    private final int size = 3;

    public Board() {
        board = new char[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                board[i][j] = ' '; // Kosongkan papan
            }
        }
    }

    public void displayBoard() {
        System.out.println("  0 1 2");
        for (int i = 0; i < size; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < size; j++) {
                System.out.print(board[i][j]);
                if (j < size - 1) System.out.print("|");
            }
            System.out.println();
            if (i < size - 1) System.out.println("  -----");
        }
    }

    public boolean isCellEmpty(int row, int col) {
        return board[row][col] == ' ';
    }

    public void markCell(int row, int col, char symbol) {
        board[row][col] = symbol;
    }

    public boolean checkWinner(char symbol) {
        // Cek baris dan kolom
        for (int i = 0; i < size; i++) {
            if ((board[i][0] == symbol && board[i][1] == symbol && board[i][2] == symbol) ||
                (board[0][i] == symbol && board[1][i] == symbol && board[2][i] == symbol)) {
                return true;
            }
        }
        // Cek diagonal
        return (board[0][0] == symbol && board[1][1] == symbol && board[2][2] == symbol) ||
               (board[0][2] == symbol && board[1][1] == symbol && board[2][0] == symbol);
    }

    public boolean isFull() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board[i][j] == ' ') return false;
            }
        }
        return true;
    }
}   