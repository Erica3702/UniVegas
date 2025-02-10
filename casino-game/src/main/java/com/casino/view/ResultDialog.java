package com.casino.view;

import javax.swing.*;
import com.casino.model.RouletteModel;

public class ResultDialog {
	
	public static void showResultDialog(int winningNumber, RouletteModel model) {
	    SwingUtilities.invokeLater(() -> {
	        int punti = model.calculatePoints(model); // Ora chiama il metodo sull'istanza

	        String messageWin = "Il numero vincente è: " + winningNumber + "\nHai vinto: " + punti + " token!";
	        String messageLose = "Il numero vincente è: " + winningNumber + "\nHai perso ";

	        if (punti > 0) {
	            JOptionPane.showMessageDialog(null, messageWin, "Risultato Roulette", JOptionPane.INFORMATION_MESSAGE);
	        } else {
	            JOptionPane.showMessageDialog(null, messageLose, "Risultato Roulette", JOptionPane.INFORMATION_MESSAGE);
	        }
	        BettingPanel.clearBets();
	    });
	}

}