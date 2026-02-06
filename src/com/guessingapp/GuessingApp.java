package com.guessingapp;

import java.util.Scanner;

/**
 * Guessing App
 * UC2 - User Guess Submission
 *
 * Allows the player to submit guesses,
 * tracks attempts, and provides feedback.
 *
 * Author: Developer
 * Version: 3.0
 */
public class GuessingApp {

    public static void main(String[] args) {

        System.out.println("Welcome to the Guessing App\n");

        GameConfig gameConfig = new GameConfig();
        gameConfig.showRules();

        Scanner scanner = new Scanner(System.in);

        int attemptsLeft = gameConfig.getMaxAttempts();
        int targetNumber = gameConfig.getTargetNumber();
        boolean isGuessed = false;

        while (attemptsLeft > 0 && !isGuessed) {

            System.out.print("Enter your guess: ");
            int guess = scanner.nextInt();

            attemptsLeft--;

            if (guess == targetNumber) {
                System.out.println("Correct! You guessed the number.");
                isGuessed = true;
            } else if (guess < targetNumber) {
                System.out.println("Higher!");
            } else {
                System.out.println("Lower!");
            }

            if (!isGuessed) {
                System.out.println("Attempts left: " + attemptsLeft + "\n");
            }
        }

        if (!isGuessed) {
            System.out.println("Game Over! The number was: " + targetNumber);
        }

        scanner.close();
    }
}
