package com.guessingapp;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Guessing App
 * UC5 - Game Result Storage
 *
 * Persists game outcome and displays past results.
 *
 * Author: Developer
 * Version: 6.0
 */
public class GuessingApp {

    public static void main(String[] args) {

        System.out.println("Welcome to the Guessing App\n");

        GameConfig gameConfig = new GameConfig();
        gameConfig.showRules();

        Scanner scanner = new Scanner(System.in);
        HintService hintService = new HintService();
        StorageService storageService = new StorageService();

        int attemptsLeft = gameConfig.getMaxAttempts();
        int totalAttempts = attemptsLeft;
        int targetNumber = gameConfig.getTargetNumber();
        boolean isGuessed = false;

        while (attemptsLeft > 0 && !isGuessed) {

            int guess;

            try {
                System.out.print("Enter your guess: ");
                guess = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a number.\n");
                scanner.next();
                continue;
            }

            if (guess < 1 || guess > 100) {
                System.out.println("Please enter a number between 1 and 100.\n");
                continue;
            }

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

        int attemptsUsed = totalAttempts - attemptsLeft;
        storageService.saveResult(isGuessed, attemptsUsed);
        storageService.showPastResults();

        scanner.close();
    }
}
