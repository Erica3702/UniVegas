package com.casino.model;

public class RouletteModel {
	
	/**
	 * Array dei numeri ordinati come sulla roulette
	 */
    private static final int[] ROULETTE_NUMBERS = {
        0, 32, 15, 4, 19, 21, 2, 25, 17, 34, 6, 27, 13, 36, 11, 30, 8, 23,
        10, 5, 24, 16, 33, 1, 20, 14, 31, 9, 22, 18, 29, 7, 28, 12, 35, 3, 26
    };

    private int winningNumber;

    
    /**
     * Metodo che ricava il numero vincente partendo dall'angolo in cui si trova la pallina alla fine della rotazione
     * @param Angolo a fine rotazione
     * @return Numero vincente
     */
    public int getWinningNumber(double finalAngle) {
        double normalizedAngle = (finalAngle % 360 + 360) % 360;
        double sectorSize = 360.0 / 37; 
        double adjustedAngle = (normalizedAngle + 90 + 4.5) % 360; //tiene conto della posizione iniziale
        int index = (int) (adjustedAngle  / sectorSize); // Calcola l'indice del numero vincente

        if (index >= ROULETTE_NUMBERS.length) {	 // deve essere <= di 36
            index = ROULETTE_NUMBERS.length - 1;
        }

        winningNumber = ROULETTE_NUMBERS[index];
        return winningNumber;
    }
    
    /**
     * Dato un numero, restuisce true se è presente nell'array dei numeri rossi, false negli altri casi
     * @param numero estratto
     */
    public boolean isRed(int num) {
        int[] redNumbers = {1, 3, 5, 7, 9, 12, 14, 16, 18, 19, 21, 23, 25, 27, 30, 32, 34, 36};
        for(int i=0;i<redNumbers.length;i++) {
        	if(num == redNumbers[i]) {
        		return true;
        	}
        }
        return false;
    }

    /**
     * Data una scritta, restituisce true se coincide con una delle puntate speciali, false negli altri casi
     * @param la scritta sul bottone
     */
    public boolean isSpecialBet(String text) {
        String[] specialBets = {"RED", "BLACK", "ODD", "EVEN", "1 TO 18", "19 TO 36", "1ST 12", "2ND 12", "3RD 12", " 2:1 ", "  2:1  ", "   2:1   "};
        for (int i = 0; i < specialBets.length; i++) {
            if (text.equals(specialBets[i])) { // Usa equals() per confrontare le stringhe
                return true;
            }
        }
        return false;
    }
    
    
    public int getWinningNumber() {
        return winningNumber;
    }

    //per i test
	public void setWinningNumber(int i) {
		winningNumber = i;
	}
}