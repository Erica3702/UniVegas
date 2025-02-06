package com.casino.model;

import java.util.Arrays;

public class RouletteModel {
    private static final int[] ROULETTE_NUMBERS = {
        0, 32, 15, 4, 19, 21, 2, 25, 17, 34, 6, 27, 13, 36, 11, 30, 8, 23,
        10, 5, 24, 16, 33, 1, 20, 14, 31, 9, 22, 18, 29, 7, 28, 12, 35, 3, 26
    };

    private int winningNumber;

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
}
