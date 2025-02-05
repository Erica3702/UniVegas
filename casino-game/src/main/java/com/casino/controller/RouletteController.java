package com.casino.controller;


public class RouletteController {


	
	    public static boolean isSpecialBet(String text) {
	        String[] specialBets = {"RED", "BLACK", "ODD", "EVEN", "1 to 18", "19 to 36", "1st 12", "2nd 12", "3rd 12", "2:1"};
	        for (String bet : specialBets) {
	            if (text.equalsIgnoreCase(bet)) {
	                return true;
	            }
	        }
	        return false;
	    }
	    
	    
	    public static boolean isRed(int num) {
	        int[] redNumbers = {1, 3, 5, 7, 9, 12, 14, 16, 18, 19, 21, 23, 25, 27, 30, 32, 34, 36};
	        for (int red : redNumbers) {
	            if (num == red) return true;
	        }
	        return false;
	    }
		
}
