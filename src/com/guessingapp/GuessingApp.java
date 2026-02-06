package com.guessingapp;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Guessing App
 * UC4 - Error Handling & Validation
 *
 * Adds safe input handling to prevent crashes
 * and validates guess range without consuming attempts.
 *
 * Author: Developer
 * Version: 5.0
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

            int guess;

            try {
                System.out.print("Enter your guess: ");
                guess = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a number.\n");
                scanner.next(); // clear invalid token
                continue;       // do NOT consume attempt
            }

            // Range validation
            if (guess < 1 || guess > 100) {
                System.out.println("Please enter a number between 1 and 100.\n");
                continue; // do NOT consume attempt
            }

            // Valid guess → consume attempt
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
