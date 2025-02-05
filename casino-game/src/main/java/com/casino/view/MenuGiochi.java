package com.casino.view;
import com.casino.controller.BlackjackController;
import com.casino.controller.RouletteController;
import com.casino.model.Blackjack;
import com.casino.model.RouletteModel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class MenuGiochi {

	    public static void Start(){
	
	    	
	    	JFrame frame = new JFrame("UniVegas Menù");

	        // Imposta il frame a occupare l'intero schermo
	        frame.setExtendedState(JFrame.MAXIMIZED_BOTH); // Massimizza la finestra
	        frame.setResizable(false); // Disabilita il ridimensionamento

	        ImageIcon fiches = new ImageIcon("src/main/resources/immagini/fiches.png"); 
	        frame.setIconImage(fiches.getImage());
	        
	      
	        // Chiudi l'applicazione quando il frame viene chiuso
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	        frame.setLayout(new GridLayout(1, 3)); // 3 colonne, 1 riga

	        // Caricamento delle immagini per ogni gioco
	        ImageIcon pokerImage = new ImageIcon("src/main/resources/immagini/poker.png"); // Sostituisci con il tuo percorso immagine
	        ImageIcon blackjackImage = new ImageIcon("src/main/resources/immagini/blackjackk.png"); // Sostituisci con il tuo percorso immagine
	        ImageIcon rouletteImage = new ImageIcon("src/main/resources/immagini/roulettee.png"); // Sostituisci con il tuo percorso immagine

	        // Creazione dei bottoni con le immagini
	        JButton pokerButton = new JButton(pokerImage);
	        JButton blackjackButton = new JButton(blackjackImage);
	        JButton rouletteButton = new JButton(rouletteImage);

	        // Aggiungi i bottoni al frame
	        frame.add(pokerButton);    // Aggiungi bottone Poker
	        frame.add(blackjackButton); // Aggiungi bottone Blackjack
	        frame.add(rouletteButton);  // Aggiungi bottone Roulette

	        // Rendi il frame visibile
	        frame.setVisible(true);
	        
	        // Azioni dei bottoni, da implementare in seguito
	        pokerButton.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                JOptionPane.showMessageDialog(frame, "Momentaneamente non disponibile..");
	            }
	        });

	        blackjackButton.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                frame.dispose();
	                Blackjack model = new Blackjack();
	                BlackjackView view = new BlackjackView(model);
	                new BlackjackController(model, view);
	            }
	        });

	        rouletteButton.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                frame.dispose();
	                RouletteModel model = new RouletteModel();
	    	        RouletteController controller = new RouletteController();
	    	        RouletteView view = new RouletteView(controller, model);
	    	        controller.startGame();
	                
	            }
	        });        
	    }
}       