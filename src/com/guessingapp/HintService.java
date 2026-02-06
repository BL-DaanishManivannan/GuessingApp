package com.guessingapp;

/**
 * HintService
 * UC3 - Hint Generation
 *
 * Generates limited, non-revealing hints
 * to guide the player after incorrect guesses.
 *
 * Author: Developer
 * Version: 1.0
 */
public class HintService {

    private int hintCount = 0;
    private final int MAX_HINTS = 3;

    public boolean canGiveHint() {
        return hintCount < MAX_HINTS;
    }

    public void showHint(int targetNumber) {
        hintCount++;

        switch (hintCount) {
            case 1:
                System.out.println(
                        targetNumber % 2 == 0
                                ? "Hint: The number is even."
                                : "Hint: The number is odd."
                );
                break;

            case 2:
                if (targetNumber <= 50) {
                    System.out.println("Hint: The number is between 1 and 50.");
                } else {
                    System.out.println("Hint: The number is between 51 and 100.");
                }
                break;

            case 3:
                if (targetNumber % 3 == 0) {
                    System.out.println("Hint: The number is divisible by 3.");
                } else {
                    System.out.println("Hint: The number is not divisible by 3.");
                }
                break;

            default:
                // No more hints
                break;
        }
    }
}
