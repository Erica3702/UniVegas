package com.casino.model;

import javax.swing.*;

import java.util.Map;


/**
 * Metodo che calcola il punteggio ottenuto con le scommesse vincenti (sia sui numeri che speciali)
 * Inoltre calcola le scommesse perdenti
 * Ritorna la differenza tra scommesse vincenti e perdenti
 */

public class PointsCalculator {
	
	
    public static int calculatePoints(RouletteModel model, Map<JButton, Integer> buttonTokens) {
        int points = 0;
        int totalBetLost = 0;

        for (Map.Entry<JButton, Integer> entry : buttonTokens.entrySet()) {
            JButton button = entry.getKey();
            int tokens = entry.getValue();

            if (tokens > 0) {
                String buttonText = button.getText().trim(); // Rimuove spazi extra
                int winningNumber = model.getWinningNumber();

                // Calcola i punti e le perdite
                int betMultiplier = buttonText.matches("\\d+") ? 5 : 20; // Scommessa su numero singolo o speciale
                boolean won = checkIfBetWon(buttonText, winningNumber, model);

                if (won) {
                    points += tokens * betMultiplier * getPayoutMultiplier(buttonText) + tokens * betMultiplier;
                } else {
                    totalBetLost += tokens * betMultiplier;
                }
            }
        }

        return points - totalBetLost;
    }

    /**
     * Verifica se la scommessa è vincente.
     */
    private static boolean checkIfBetWon(String buttonText, int winningNumber, RouletteModel model) {
        switch (buttonText) {
            case "RED":
                return model.isRed(winningNumber);
            case "BLACK":
                return !model.isRed(winningNumber) && winningNumber != 0;
            case "EVEN":
                return winningNumber % 2 == 0 && winningNumber != 0;
            case "ODD":
                return winningNumber % 2 != 0;
            case "1 TO 18":
                return winningNumber >= 1 && winningNumber <= 18;
            case "19 TO 36":
                return winningNumber >= 19 && winningNumber <= 36;
            case "1ST 12":
                return winningNumber >= 1 && winningNumber <= 12;
            case "2ND 12":
                return winningNumber >= 13 && winningNumber <= 24;
            case "3RD 12":
                return winningNumber >= 25 && winningNumber <= 36;
            case "2:1":
                return (winningNumber - 1) % 3 == 0;
            case " 2:1 ":
                return (winningNumber - 1) % 3 == 1;
            case "  2:1  ":
                return (winningNumber - 1) % 3 == 2;
            default:
                // Scommessa su numero singolo
                if (buttonText.matches("\\d+")) {
                    int number = Integer.parseInt(buttonText);
                    return number == winningNumber;
                }
                return false;
        }
    }

    /**
     * Restituisce il moltiplicatore di payout in base al tipo di scommessa.
     */
    private static int getPayoutMultiplier(String buttonText) {
        if (buttonText.matches("\\d+")) {
            return 35; // Payout per numero singolo
        } else if (buttonText.startsWith("2:1")) {
            return 2; // Payout per colonne
        } else {
            return 1; // Payout per scommesse speciali (rosso/nero, pari/dispari, ecc.)
        }
    }
}