package com.guessingapp;

/**
 * Guessing App
 * UC1 - Game Initialization
 *
 * Initializes the game configuration
 * and displays game rules.
 *
 * Author: Developer
 * Version: 2.0
 */
public class GuessingApp {

    public static void main(String[] args) {
        System.out.println("Welcome to the Guessing App\n");

        GameConfig gameConfig = new GameConfig();
        gameConfig.showRules();
    }
}
