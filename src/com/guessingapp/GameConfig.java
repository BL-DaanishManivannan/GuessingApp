package com.guessingapp;

import java.util.Random;

/**
 * GameConfig
 * UC1 - Game Initialization
 *
 * Handles game setup and configuration.
 *
 * @author Developer
 * @version 1.0
 */
public class GameConfig {

    private final int MIN = 1;
    private final int MAX = 100;
    private final int MAX_ATTEMPTS = 7;

    private int targetNumber;

    public GameConfig() {
        Random random = new Random();
        this.targetNumber = random.nextInt(MAX - MIN + 1) + MIN;
    }

    public int getTargetNumber() {
        return targetNumber;
    }

    public int getMaxAttempts() {
        return MAX_ATTEMPTS;
    }

    public void showRules() {
        System.out.println("Guess a number between " + MIN + " and " + MAX);
        System.out.println("You have " + MAX_ATTEMPTS + " attempts.");
    }
}
