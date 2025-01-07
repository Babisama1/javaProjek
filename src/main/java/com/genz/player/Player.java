package com.genz.player;

public class Player {
    private String name;
    private char symbol;
    private int score; // Tambahkan atribut skor

    public Player(String name, char symbol) {
        this.name = name;
        this.symbol = symbol;
        this.score = 0; // Skor awal adalah 0
    }

    public String getName() {
        return name;
    }

    public char getSymbol() {
        return symbol;
    }

    public int getScore() {
        return score;
    }

    public void incrementScore() {
        score++; // Tambahkan 1 ke skor
    }
}