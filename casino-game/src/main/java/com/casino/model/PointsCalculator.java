package com.casino.model;

import javax.swing.*;

import java.util.Map;

public class PointsCalculator {
    public static int calculatePoints(RouletteModel model, Map<JButton, Integer> buttonTokens) {
        int points = 0;
        int totalBetLost = 0;

        for (Map.Entry<JButton, Integer> entry : buttonTokens.entrySet()) {
            JButton button = entry.getKey();
            int tokens = entry.getValue();

            if (tokens > 0) {
                String buttonText = button.getText();
                boolean won = false;

                if (buttonText.matches("\\d+")) { // Scommessa su numero singolo
                    int number = Integer.parseInt(buttonText);
                    if (number == model.getWinningNumber()) {
                        points += tokens * 5 * 35 + tokens * 5;
                        won = true;
                    }
                } else { // Scommesse speciali
                    if (buttonText.equals("RED") && model.isRed(model.getWinningNumber())) {
                        points += tokens * 20 * 1 + tokens * 20;
                        won = true;
                    } else if (buttonText.equals("BLACK") && !model.isRed(model.getWinningNumber()) && model.getWinningNumber() != 0) {
                        points += tokens * 20 * 1 + tokens * 20;
                        won = true;
                    } else if (buttonText.equals("EVEN") && model.getWinningNumber() % 2 == 0 && model.getWinningNumber() != 0) {
                        points += tokens * 20 * 1 + tokens * 20;
                        won = true;
                    } else if (buttonText.equals("ODD") && model.getWinningNumber() % 2 != 0) {
                        points += tokens * 20 * 1 + tokens * 20;
                        won = true;
                    } else if (buttonText.equals("1 TO 18") && model.getWinningNumber() >= 1 && model.getWinningNumber() <= 18) {
                        points += tokens * 20 * 1 + tokens * 20;
                        won = true;
                    } else if (buttonText.equals("19 TO 36") && model.getWinningNumber() >= 19 && model.getWinningNumber() <= 36) {
                        points += tokens * 20 * 1 + tokens * 20;
                        won = true;
                    } else if (buttonText.equals("1ST 12") && model.getWinningNumber() >= 1 && model.getWinningNumber() <= 12) {
                        points += tokens * 20 * 2 + tokens * 20;
                        won = true;
                    } else if (buttonText.equals("2ND 12") && model.getWinningNumber() >= 13 && model.getWinningNumber() <= 24) {
                        points += tokens * 20 * 2 + tokens * 20;
                        won = true;
                    } else if (buttonText.equals("3RD 12") && model.getWinningNumber() >= 25 && model.getWinningNumber() <= 36) {
                        points += tokens * 20 * 2 + tokens * 20;
                        won = true;
                    } else if (buttonText.equals(" 2:1 ") && (model.getWinningNumber() - 1) % 3 == 0) {
                        points += tokens * 20 * 2 + tokens * 20;
                        won = true;
                    } else if (buttonText.equals("  2:1  ") && (model.getWinningNumber() - 1) % 3 == 1) {
                        points += tokens * 20 * 2 + tokens * 20;
                        won = true;
                    } else if (buttonText.equals("   2:1   ") && (model.getWinningNumber() - 1) % 3 == 2) {
                        points += tokens * 20 * 2 + tokens * 20;
                        won = true;
                    }
                }
                if (!won) {
                    totalBetLost += tokens * (buttonText.matches("\\d+") ? 5 : 20);
                }
            }
        }
        return points - totalBetLost;
    }
}