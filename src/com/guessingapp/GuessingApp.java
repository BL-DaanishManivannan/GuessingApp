package com.guessingapp;

import java.util.Scanner;

/**
 * Guessing App
 * UC3 - Hint Generation
 *
 * Adds limited hints after incorrect guesses.
 *
 * Author: Developer
 * Version: 4.0
 */
public class GuessingApp {

    public static void main(String[] args) {

        System.out.println("Welcome to the Guessing App\n");

        GameConfig gameConfig = new GameConfig();
        gameConfig.showRules();

        Scanner scanner = new Scanner(System.in);
        HintService hintService = new HintService();

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
            } else {
                System.out.println(guess < targetNumber ? "Higher!" : "Lower!");

                if (hintService.canGiveHint()) {
                    hintService.showHint(targetNumber);
                }

                System.out.println("Attempts left: " + attemptsLeft + "\n");
            }
        }

        if (!isGuessed) {
            System.out.println("Game Over! The number was: " + targetNumber);
        }

        scanner.close();
    }
}
