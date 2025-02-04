package com.casino.view;

import com.casino.model.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class TestRoulette extends JFrame {
    private final ImageIcon chipIcon;
    private final JPanel bettingPanel;
    private final JButton[][] buttons;
    public final Map<JButton, Integer> buttonTokens;
    private int totalBet;
    private final JLabel totalBetLabel;
    private final RoulettePanel roulettePanel; // Cambiato da JPanel a RoulettePanel

    public TestRoulette() {
        setTitle("Roulette Game");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Carica e ridimensiona l'icona della fiches
        ImageIcon fiches = new ImageIcon("src/main/resources/numeri roulette/Logodef.png");
        Image scaledImage = fiches.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        chipIcon = new ImageIcon(scaledImage);

        // Creazione del pannello della roulette con animazione
        roulettePanel = new RoulettePanel();
        roulettePanel.setPreferredSize(new Dimension(Toolkit.getDefaultToolkit().getScreenSize().width / 2, getHeight()));

        // Creazione del pannello delle scommesse
        bettingPanel = new JPanel();
        bettingPanel.setLayout(new GridBagLayout());
        bettingPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 10));
        bettingPanel.setBackground(new Color(0, 100, 0));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(2, 2, 2, 2);

        String[][] layout = {
            {"0"},
            {"1", "2", "3"},
            {"4", "5", "6"},
            {"7", "8", "9"},
            {"10", "11", "12"},
            {"13", "14", "15"},
            {"16", "17", "18"},
            {"19", "20", "21"},
            {"22", "23", "24"},
            {"25", "26", "27"},
            {"28", "29", "30"},
            {"31", "32", "33"},
            {"34", "35", "36"},
            {"2:1", "2:1", "2:1"},
            {"1st 12", "2nd 12", "3rd 12"},
            {"RED", "1 to 18", "EVEN"},
            {"BLACK", "19 to 36", "ODD"},
            {"","",""}
        };

        buttonTokens = new HashMap<>();
        buttons = new JButton[layout.length][];

        for (int row = 0; row < layout.length; row++) {
            buttons[row] = new JButton[layout[row].length];
            for (int col = 0; col < layout[row].length; col++) {
                if (!layout[row][col].isEmpty()) {
                    JButton button = new JButton(layout[row][col]);
                    button.setFont(new Font("Arial", Font.BOLD, 14));
                    button.setFocusPainted(false);

                    if (row == 0) {
                        gbc.gridwidth = 3;
                    } else {
                        gbc.gridwidth = 1;
                    }

                    if (layout[row][col].matches("\\d+")) {
                        int num = Integer.parseInt(layout[row][col]);
                        if (num == 0) {
                            button.setBackground(Color.GREEN);
                        } else {
                            button.setBackground(isRed(num) ? Color.RED : Color.BLACK);
                        }
                        button.setForeground(Color.WHITE);
                    } else if (isSpecialBet(layout[row][col])) {
                        button.setBackground(Color.GRAY);
                        button.setForeground(Color.WHITE);
                    } else {
                        button.setBackground(Color.LIGHT_GRAY);
                    }

                    button.addActionListener(new ChipPlacer(button));

                    gbc.gridx = col;
                    gbc.gridy = row;
                    buttons[row][col] = button;
                    bettingPanel.add(button, gbc);

                    buttonTokens.put(button, 0);
                }
            }
        }

        // Bottone per avviare l'animazione della pallina
        JButton spinButton = new JButton("SPIN");
        spinButton.addActionListener(e -> roulettePanel.startBallAnimation()); // Chiamata all'animazione
  
        spinButton.setFont(new Font("Arial", Font.BOLD, 16));
        spinButton.setBackground(Color.BLUE);
        spinButton.setForeground(Color.WHITE);

        gbc.gridx = 0;
        gbc.gridy = layout.length + 2;		//spin
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        bettingPanel.add(spinButton, gbc);
        
        
        
        // Creazione del bottone Clear
        JButton clearButton = new JButton("CLEAR");
        clearButton.addActionListener(e -> clearBets());
        clearButton.setFont(new Font("Arial", Font.BOLD, 14));
        clearButton.setBackground(Color.RED);
        clearButton.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = layout.length;		//clear
        gbc.gridwidth = 3;
        bettingPanel.add(clearButton, gbc);

        totalBetLabel = new JLabel("TOTAL BET: 0");
        totalBetLabel.setFont(new Font("Arial", Font.BOLD, 16));
        totalBetLabel.setForeground(Color.WHITE);

        gbc.gridx = 0;
        gbc.gridy = layout.length+1;	//tot bet
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        bettingPanel.add(totalBetLabel, gbc);

        setLayout(new BorderLayout());
        add(roulettePanel, BorderLayout.WEST);
        add(bettingPanel, BorderLayout.CENTER);

        setVisible(true);
    }

    private void clearBets() {
        // Pulisci tutte le fiches dai bottoni e azzera i token
        totalBet = 0;  // Reset il totale delle puntate
        for (JButton[] row : buttons) {
            for (JButton button : row) {
                if (button.getComponentCount() > 0) {
                    button.removeAll(); // Rimuove tutte le componenti (fiches)
                    button.repaint(); // Renderizza il cambiamento
                    button.revalidate(); // Rende effettivo l'aggiornamento
                }
                // Azzeriamo i token per ciascun bottone
                buttonTokens.put(button, 0);
            }
        }
        updateTotalBetLabel();  // Questo aggiorna la label con il totale azzerato
        
    }
    
    
    

    private boolean isRed(int num) {
        int[] redNumbers = {1, 3, 5, 7, 9, 12, 14, 16, 18, 19, 21, 23, 25, 27, 30, 32, 34, 36};
        for (int red : redNumbers) {
            if (num == red) return true;
        }
        return false;
    }

    private boolean isSpecialBet(String text) {
        String[] specialBets = {"RED", "BLACK", "ODD", "EVEN", "1 to 18", "19 to 36", "1st 12", "2nd 12", "3rd 12", "2:1"};
        for (String bet : specialBets) {
            if (text.equalsIgnoreCase(bet)) {
                return true;
            }
        }
        return false;
    }

    private class ChipPlacer implements ActionListener {
        private final JButton button;
        private JLabel chipLabel;

        public ChipPlacer(JButton button) {
            this.button = button;
            this.chipLabel = new JLabel(chipIcon);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            button.add(chipLabel, BorderLayout.CENTER);
            button.repaint();
            button.revalidate();

            int tokens = isSpecialBet(button.getText()) ? 20 : 5;
            buttonTokens.put(button, buttonTokens.get(button) + 1);
            totalBet += tokens;
            updateTotalBetLabel();
        }
    }

    private void updateTotalBetLabel() {
    	totalBetLabel.setText("TOTAL BET: " + totalBet);
    } 

    public static void main(String[] args) {
        SwingUtilities.invokeLater(TestRoulette::new);
    }
}