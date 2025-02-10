package com.casino.model;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;

public class RouletteModel {
    private static final int[] ROULETTE_NUMBERS = {
        0, 32, 15, 4, 19, 21, 2, 25, 17, 34, 6, 27, 13, 36, 11, 30, 8, 23,
        10, 5, 24, 16, 33, 1, 20, 14, 31, 9, 22, 18, 29, 7, 28, 12, 35, 3, 26
    };

    private int winningNumber;
    public Map<JButton, Integer> buttonTokens;
    
    public RouletteModel() {
        this.buttonTokens = new HashMap<>();
    }

    public int getWinningNumber(double finalAngle) {
        double normalizedAngle = (finalAngle % 360 + 360) % 360;
        double sectorSize = 360.0 / 37;
        double adjustedAngle = (normalizedAngle + 90) % 360;
        int index = (int) (adjustedAngle / sectorSize);

        if (index >= ROULETTE_NUMBERS.length) {
            index = ROULETTE_NUMBERS.length - 1;
        }

        winningNumber = ROULETTE_NUMBERS[index];
        return winningNumber;
    }

    public boolean isRed(int num) {
        int[] redNumbers = {1, 3, 5, 7, 9, 12, 14, 16, 18, 19, 21, 23, 25, 27, 30, 32, 34, 36};
        return Arrays.stream(redNumbers).anyMatch(red -> red == num);
    }

    public boolean isSpecialBet(String text) {
        String[] specialBets = {"RED", "BLACK", "ODD", "EVEN", "1 to 18", "19 to 36", "1st 12", "2nd 12", "3rd 12", "2:1"};
        return Arrays.stream(specialBets).anyMatch(bet -> bet.equalsIgnoreCase(text));
    }

    public int getWinningNumber() {
        return winningNumber;
    }

    //per i test
	public void setWinningNumber(int i) {
		winningNumber = i;
	}
	
	 public int calculatePoints(RouletteModel model) {
	        int points = 0;
	        int totalBetLost = 0;

	        for (Map.Entry<JButton, Integer> entry : buttonTokens.entrySet()) {
	            JButton button = entry.getKey();
	            int tokens = entry.getValue();

	            if (tokens > 0) {
	                String buttonText = button.getText();
	                boolean won = false;

	                if (buttonText.matches("\\d+")) {
	                    int number = Integer.parseInt(buttonText);
	                    if (number == model.getWinningNumber()) {
	                        points += tokens * 5 * 35 + tokens * 5;
	                        won = true;
	                    }
	                    if (!won) {
	                        totalBetLost += tokens * 5;
	                    }
	                } else {
	                    if (buttonText.equals("RED") && model.isRed(model.getWinningNumber()) && model.getWinningNumber() != 0) {
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
	                    } else if (buttonText.equals("2:1") && model.getWinningNumber() % 3 == 0) {
	                        points += tokens * 20 * 2 + tokens * 20;
	                        won = true;
	                    }
	                    if (!won) {
	                        totalBetLost += tokens * 20;
	                    }
	                }
	            }
	        }
	        return points - totalBetLost;
	    }
}