package com.casino.view;

import java.awt.GridLayout;
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

    // Costruttore privato per impedire l'istanziazione
    private MenuGiochi() {
        throw new UnsupportedOperationException("Questa classe non può essere istanziata.");
    }

    /**
     * Crea il menu con 3 bottoni che aprono i tre giochi.
     */
    public static void start() {
        JFrame frame = new JFrame("UniVegas Menù");
        frame.setSize(1100, 750);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null); // Centra la finestra
        ImageIcon fiches = new ImageIcon("src/main/resources/immagini/fiches.png");
        frame.setIconImage(fiches.getImage());
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(1, 3)); // 3 colonne, 1 riga

        // Carica le immagini per i bottoni
        ImageIcon pokerImage = new ImageIcon("src/main/resources/immagini/pokermenu.png");
        ImageIcon blackjackImage = new ImageIcon("src/main/resources/immagini/blackjackmenu.png");
        ImageIcon rouletteImage = new ImageIcon("src/main/resources/immagini/roulettemenu.png");

        // Crea i bottoni con le immagini
        JButton pokerButton = new JButton(pokerImage);
        JButton blackjackButton = new JButton(blackjackImage);
        JButton rouletteButton = new JButton(rouletteImage);

        // Aggiungi i bottoni al frame
        frame.add(pokerButton);
        frame.add(blackjackButton);
        frame.add(rouletteButton);

        // Imposta azioni per i bottoni usando lambda
        pokerButton.addActionListener(e -> 
            JOptionPane.showMessageDialog(frame, "Non disponibile")
        );

        blackjackButton.addActionListener(e -> {
            frame.dispose(); // Chiude il menu
            BlackjackModel model = new BlackjackModel();
            BlackjackView view = new BlackjackView(model);
            new BlackjackController(model, view); // Avvia il gioco Blackjack
        });

        rouletteButton.addActionListener(e -> {
            frame.dispose(); // Chiude il menu
            RouletteModel model = new RouletteModel();
            RouletteController controller = new RouletteController();
            SwingUtilities.invokeLater(() -> new RouletteView(controller, model)); // Avvia il gioco Roulette
        });

        // Mostra il frame
        frame.setVisible(true);
    }
}