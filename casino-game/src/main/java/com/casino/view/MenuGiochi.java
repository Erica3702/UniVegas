package com.casino.view;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

import com.casino.controller.BlackjackController;
import com.casino.controller.RouletteController;
import com.casino.model.BlackjackModel;
import com.casino.model.RouletteModel;

public class MenuGiochi {

	    public static void Start(){

	    	JFrame frame = new JFrame("UniVegas Menù");

	        frame.setSize(1100,750);
	        frame.setResizable(false); // Disabilita il ridimensionamento
	        frame.setLocationRelativeTo(null); //centra la finestra
	        ImageIcon fiches = new ImageIcon("src/main/resources/immagini/fiches.png");
	        frame.setIconImage(fiches.getImage());


	        // Chiudi l'applicazione quando il frame viene chiuso
	        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

	        frame.setLayout(new GridLayout(1, 3)); // 3 colonne, 1 riga

	        // Caricamento delle immagini per ogni gioco
	        ImageIcon pokerImage = new ImageIcon("src/main/resources/immagini/pokermenu.png"); // Sostituisci con il tuo percorso immagine
	        ImageIcon blackjackImage = new ImageIcon("src/main/resources/immagini/blackjackmenu.png"); // Sostituisci con il tuo percorso immagine
	        ImageIcon rouletteImage = new ImageIcon("src/main/resources/immagini/roulettemenu.png"); // Sostituisci con il tuo percorso immagine

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

	        // Azioni dei bottoni
	        pokerButton.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                JOptionPane.showMessageDialog(frame, "Non disponibile");
	            }
	        });

	        blackjackButton.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                frame.dispose();
	                BlackjackModel model = new BlackjackModel();
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
	                SwingUtilities.invokeLater(() -> new RouletteView(controller, model));
	            }
	        });
	    }
}