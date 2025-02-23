package com.casino.model;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class RouletteModelTest {

	@Test
	public void testIsRed() {
        RouletteModel model = new RouletteModel();
        assertTrue(model.isRed(1));  // 1 è un numero rosso
        assertFalse(model.isRed(2)); // 2 è un numero nero
        assertFalse(model.isRed(0)); // 0 non è né rosso né nero
    }

	@Test
    public void testIsSpecialBet() {
        RouletteModel model = new RouletteModel();
        assertTrue(model.isSpecialBet("RED"));    // "RED" è una scommessa speciale
        assertTrue(model.isSpecialBet("BLACK"));  // "BLACK" è una scommessa speciale
        assertFalse(model.isSpecialBet("37"));    // "37" non è una scommessa speciale
    }

	 @Test
	 public void testGetWinningNumber() {
	        RouletteModel model = new RouletteModel();
	        int winningNumber = model.getWinningNumber(270); // Angolo che corrisponde a un numero specifico
	        assertTrue(winningNumber ==0); // Verifica che il numero sia valido
	    }
}