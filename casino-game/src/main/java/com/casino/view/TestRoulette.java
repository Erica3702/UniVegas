package com.casino.view;

import com.casino.model.*;
import com.casino.controller.*;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class TestRoulette extends JFrame {
    private final ImageIcon chipIcon;
    private final JPanel bettingPanel;
    private static JButton[][] buttons;
    public static Map<JButton, Integer> buttonTokens;
    private static int totalBet = 0;
    private static JLabel totalBetLabel;
    private final RoulettePanel roulettePanel; // Cambiato da JPanel a RoulettePanel
    private JLayeredPane layeredPane;
    private JButton menuButton;
    

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
        roulettePanel.setBackground(new Color(0, 100, 0));  
        

        // Creazione del pannello delle scommesse
        bettingPanel = new JPanel();
        bettingPanel.setLayout(new GridBagLayout());
        bettingPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 10));
        bettingPanel.setBackground(new Color(0, 100, 0));
               
        
     // Creazione del bottone per tornare al menu principale
        JButton backToMenuButton = new JButton("Torna al menu");
        backToMenuButton.setFont(new Font("Arial", Font.BOLD, 14));
        backToMenuButton.setBackground(Color.DARK_GRAY);
        backToMenuButton.setForeground(Color.WHITE);

        // Aggiungi un ActionListener per gestire l'evento
        backToMenuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Aggiungi qui la logica per tornare al menu principale
                // Per esempio, se hai un pannello del menu principale, puoi farlo visibile e nascondere il pannello delle scommesse
                // Esempio: 
                // mainMenuPanel.setVisible(true);
                // bettingPanel.setVisible(false);
                JOptionPane.showMessageDialog(TestRoulette.this, "Torna al menu principale", "Menu", JOptionPane.INFORMATION_MESSAGE);
            }
        }); 
        
        roulettePanel.setLayout(new BorderLayout());
        roulettePanel.add(backToMenuButton, BorderLayout.SOUTH);

        // Impostiamo un pannello con allineamento a sinistra
        ((JPanel) roulettePanel).setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);        
        
       
 
   
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
                            button.setBackground(RouletteController.isRed(num) ? Color.RED : Color.BLACK);
                        }
                        button.setForeground(Color.WHITE);
                    } else if (RouletteController.isSpecialBet(layout[row][col])) {
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
        gbc.gridwidth = 3;//GridBagConstraints.REMAINDER;
        bettingPanel.add(spinButton, gbc);
        
        
        
        // Creazione del bottone 
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


    private static void clearBets() {
        // Pulisci tutte le fiches dai bottoni e azzera i token
        totalBet = 0;  // Reset il totale delle puntate
        for (JButton[] row : buttons) {
            for (JButton button : row) {
                if (button != null && button.getComponentCount() > 0) {
                    button.removeAll(); // Rimuove tutte le componenti (fiches)
                    button.repaint(); // Renderizza il cambiamento
                    button.revalidate(); // Rende effettivo l'aggiornamento
                }
                // Azzeriamo i token per ciascun bottone
                if (button != null) {
                    buttonTokens.put(button, 0);
                }
            }
        }
        updateTotalBetLabel();  // Questo aggiorna la label con il totale azzerato 
    }
    
    
   

 // Classe ChipPlacer per gestire le puntate
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

            int tokens = RouletteController.isSpecialBet(button.getText()) ? 20 : 5;
            buttonTokens.put(button, buttonTokens.get(button) + 1);
            totalBet += tokens; // Aggiorna il totale delle scommesse
            updateTotalBetLabel(); // Aggiorna la label
        }
    }
    
    public static int calculatePoints() {
        int points = 0;
        int totalBetLost = 0; // Tiene traccia delle puntate perse

        for (Map.Entry<JButton, Integer> entry : buttonTokens.entrySet()) {
            JButton button = entry.getKey();
            int tokens = entry.getValue(); // Ottiene il valore scommesso su un bottone

            if (tokens > 0) {
                String buttonText = button.getText();
                boolean won = false; // Flag per sapere se la scommessa ha vinto

                if (buttonText.matches("\\d+")) {
                    // Scommessa su un numero specifico (5 token per unità)
                    int number = Integer.parseInt(buttonText);
                    if (number == RoulettePanel.winningNumber) {
                        // Vincita 35:1 per il numero
                        points += tokens * 5 * 35 + tokens * 5;
                        won = true;
                    }
                    // Se non ha vinto, sottrai i 5 token della scommessa sul numero
                    if (!won) {
                        totalBetLost += tokens * 5;
                    }
                } else {
                    // Scommesse speciali (20 token per unità)
                    if (buttonText.equals("RED") && RouletteController.isRed(RoulettePanel.winningNumber)) {
                        // Vincita 1:1 per il rosso
                        points += tokens * 20 * 1 + tokens * 20;
                        won = true;
                    } else if (buttonText.equals("BLACK") && !RouletteController.isRed(RoulettePanel.winningNumber) && RoulettePanel.winningNumber != 0) {
                        // Vincita 1:1 per il nero
                        points += tokens * 20 * 1 + tokens * 20;
                        won = true;
                    } else if (buttonText.equals("EVEN") && RoulettePanel.winningNumber % 2 == 0 && RoulettePanel.winningNumber != 0) {
                        // Vincita 1:1 per il pari
                        points += tokens * 20 * 1 + tokens * 20;
                        won = true;
                    } else if (buttonText.equals("ODD") && RoulettePanel.winningNumber % 2 != 0) {
                        // Vincita 1:1 per il dispari
                        points += tokens * 20 * 1 + tokens * 20;
                        won = true;
                    } else if (buttonText.equals("1 to 18") && RoulettePanel.winningNumber >= 1 && RoulettePanel.winningNumber <= 18) {
                        // Vincita 1:1 per 1-18
                        points += tokens * 20 * 1 + tokens * 20;
                        won = true;
                    } else if (buttonText.equals("19 to 36") && RoulettePanel.winningNumber >= 19 && RoulettePanel.winningNumber <= 36) {
                        // Vincita 1:1 per 19-36
                        points += tokens * 20 * 1 + tokens * 20;
                        won = true;
                    } else if (buttonText.equals("1st 12") && RoulettePanel.winningNumber >= 1 && RoulettePanel.winningNumber <= 12) {
                        // Vincita 2:1 per il primo 12
                        points += tokens * 20 * 2 + tokens * 20;
                        won = true;
                    } else if (buttonText.equals("2nd 12") && RoulettePanel.winningNumber >= 13 && RoulettePanel.winningNumber <= 24) {
                        // Vincita 2:1 per il secondo 12
                        points += tokens * 20 * 2 + tokens * 20;
                        won = true;
                    } else if (buttonText.equals("3rd 12") && RoulettePanel.winningNumber >= 25 && RoulettePanel.winningNumber <= 36) {
                        // Vincita 2:1 per il terzo 12
                        points += tokens * 20 * 2 + tokens * 20;
                        won = true;
                    } else if (buttonText.equals("2:1") && RoulettePanel.winningNumber % 3 == 0) {
                        // Vincita 2:1 per la colonna
                        points += tokens * 20 * 2 + tokens * 20;
                        won = true;
                    }

                    // Se la scommessa speciale non ha vinto, sottrai i 20 token della scommessa speciale
                    if (!won) {
                        totalBetLost += tokens * 20;
                    }
                }
            }
        }

        // Ritorna il saldo finale
        return points - totalBetLost; // Saldo finale = punti vinti - puntate perse
    }



    
    
    public static void showResultDialog(int winningNumber) {
    	
    	SwingUtilities.invokeLater(() -> {
        	String messageWin = "Il numero vincente è: " + winningNumber + "\nHai vinto: " + TestRoulette.calculatePoints() + " token!";
        	String messageLose = "Il numero vincente è: " + winningNumber + "\nHai perso ";
        	
        if(calculatePoints()>0) {
        	JOptionPane.showMessageDialog(null, messageWin, "Risultato Roulette", JOptionPane.INFORMATION_MESSAGE);
        }else {
        	JOptionPane.showMessageDialog(null, messageLose, "Risultato Roulette", JOptionPane.INFORMATION_MESSAGE);
        }   
       clearBets();
        });
    }
    
  
    private static void updateTotalBetLabel() {
        SwingUtilities.invokeLater(() -> totalBetLabel.setText("TOTAL BET: " + totalBet));
    }
 

    public static void main(String[] args) {
        SwingUtilities.invokeLater(TestRoulette::new);
    }
        
}