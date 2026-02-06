package com.guessingapp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * StorageService
 * UC5 - Game Result Storage
 *
 * Handles saving and reading game results
 * using file-based persistence.
 *
 * Author: Developer
 * Version: 1.0
 */
public class StorageService {

    private static final String FILE_NAME = "game_results.txt";

    public void saveResult(boolean isWin, int attemptsUsed) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            writer.write(
                    "RESULT=" + (isWin ? "WIN" : "LOSS") +
                            ", ATTEMPTS_USED=" + attemptsUsed
            );
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Error saving game result.");
        }
    }

    public void showPastResults() {
        System.out.println("\nPrevious Game Results:");
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("No previous game records found.");
        }
    }
}
