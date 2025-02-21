package com.casino.view;

import com.casino.controller.RouletteController;
import com.casino.model.RouletteModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class RouletteView extends JFrame {
    private final ImageIcon chipIcon;
    private final JPanel bettingPanel;
    public static JButton[][] buttons;
    public static Map<JButton, Integer> buttonTokens;
    static int totalBet = 0;
    private static JLabel totalBetLabel;
    private final RoulettePanel roulettePanel;
    private final RouletteController controller;
    private final RouletteModel model;
    int buttonWidth = 120;  // Larghezza fissa del bottone
    int buttonHeight = 35; // Altezza fissa del bottone
    Dimension buttonSize = new Dimension(buttonWidth, buttonHeight);
    

    

    public RouletteView(RouletteController controller, RouletteModel model) {
        this.controller = controller;
        this.model = model;

        setTitle("Roulette Game");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        //immagine fiches
        ImageIcon fiches = new ImageIcon("src/main/resources/immagini/fiches.png");
        Image scaledImage = fiches.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        chipIcon = new ImageIcon(scaledImage);

        //creazione pannello roulette(sx)
        roulettePanel = new RoulettePanel(model);
        roulettePanel.setPreferredSize(new Dimension(Toolkit.getDefaultToolkit().getScreenSize().width / 2, getHeight()));
        roulettePanel.setBackground(new Color(0, 100, 0));

        //creazione pannello puntate(dx)
        bettingPanel = new JPanel();
        bettingPanel.setLayout(new GridBagLayout());
        bettingPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 10));
        bettingPanel.setBackground(new Color(0, 100, 0));

        
        //tasto per tornare al menu e lo aggiungo
        JButton backToMenuButton = new JButton("Torna al menu");
        backToMenuButton.setFont(new Font("Arial", Font.BOLD, 18));
        backToMenuButton.setBackground(Color.DARK_GRAY);
        backToMenuButton.setForeground(Color.WHITE);
        backToMenuButton.addActionListener(e -> MenuGiochi.Start());
        roulettePanel.setLayout(new BorderLayout());
        roulettePanel.add(backToMenuButton, BorderLayout.SOUTH);

        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.NONE; // Non lasciare che si espandano
        gbc.anchor = GridBagConstraints.CENTER; // Mantieni i bottoni centrati
        gbc.insets = new Insets(2, 2, 2, 2); // Spazio tra i bottoni

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
            {" 2:1 ", "  2:1  ", "   2:1   "},
            {"1ST 12", "2ND 12", "3RD 12"},
            {"RED", "1 TO 18", "EVEN"},
            {"BLACK", "19 TO 36", "ODD"},
            {"", "", ""}
        };

        buttonTokens = new HashMap<>();
        buttons = new JButton[layout.length][];


        for (int row = 0; row < layout.length; row++) {
            buttons[row] = new JButton[layout[row].length];
            for (int col = 0; col < layout[row].length; col++) {
                if (!layout[row][col].isEmpty()) {
                    JButton button = new JButton(layout[row][col]);
                    button.setFont(new Font("Arial", Font.BOLD, 18));
                    button.setFocusPainted(false);

                    button.setPreferredSize(buttonSize);
                    button.setMinimumSize(buttonSize);
                    button.setMaximumSize(buttonSize);

                    if (row == 0) {
                    	Dimension buttonZeroSize = new Dimension(370, 35);
                    	button.setPreferredSize(buttonZeroSize);
                    	gbc.gridwidth = 3;
                    	
                    } else {
                        gbc.gridwidth = 1;
                    }

                    if (layout[row][col].matches("\\d+")) {
                        int num = Integer.parseInt(layout[row][col]);
                        if (num == 0) {
                            button.setBackground(Color.GREEN);
                        } else {
                            button.setBackground(model.isRed(num) ? Color.RED : Color.BLACK);
                        }
                        button.setForeground(Color.WHITE);
                    } else if (model.isSpecialBet(layout[row][col])) {
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


        
        //aggiungo bottone per girare ruota
        JButton spinButton = new JButton("SPIN");
        spinButton.setPreferredSize(buttonSize);
        spinButton.addActionListener(e -> roulettePanel.startBallAnimation());
        spinButton.setFont(new Font("Arial", Font.BOLD, 18));
        spinButton.setBackground(Color.BLUE);
        spinButton.setForeground(Color.WHITE);
        
        gbc.gridx = 0;
        gbc.gridy = layout.length ;															
        gbc.gridwidth = 1;
        bettingPanel.add(spinButton, gbc);

        
        //aggiungo bottone per pulire griglia
        JButton clearButton = new JButton("CLEAR");
        clearButton.setPreferredSize(buttonSize);
        clearButton.addActionListener(e -> clearBets());
        clearButton.setFont(new Font("Arial", Font.BOLD, 18));
        clearButton.setBackground(Color.BLUE);
        clearButton.setForeground(Color.WHITE);
        
        gbc.gridx = 1;
        gbc.gridy = layout.length;
        gbc.gridwidth = 1;
        bettingPanel.add(clearButton, gbc);

        
        //creo etichetta che monitora puntata e la aggiungo
        totalBetLabel = new JLabel("BET: 0");
        totalBetLabel.setPreferredSize(buttonSize);
        totalBetLabel.setFont(new Font("Arial", Font.BOLD, 18));
        totalBetLabel.setOpaque(true);
        totalBetLabel.setHorizontalAlignment(SwingConstants.CENTER); // Centra orizzontalmente
        totalBetLabel.setBackground(Color.BLUE);
        totalBetLabel.setForeground(Color.WHITE);
     
        gbc.gridx = 2;
        gbc.gridy = layout.length;
        gbc.gridwidth = 1;
        bettingPanel.add(totalBetLabel, gbc);

        setLayout(new BorderLayout());
        add(roulettePanel, BorderLayout.WEST);
        add(bettingPanel, BorderLayout.CENTER);
        setVisible(true);
    }

    static void clearBets() {
        totalBet = 0;

        for (JButton[] row : buttons) {
            for (JButton button : row) {
                if (button != null) {
                    if (button.getComponentCount() > 0) {
                        button.removeAll();
                        button.repaint();
                        button.revalidate();
                    }
                    button.setEnabled(true); // Riabilita tutti i pulsanti
                    buttonTokens.put(button, 0);
                }
            }
        }
        updateTotalBetLabel();
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
            String buttonText = button.getText();

            
            // Controlla se l'utente sta puntando su ROSSO o NERO
            if (buttonText.equals("RED")) {
                disableButton("BLACK"); // Disabilita il pulsante NERO
            } else if (buttonText.equals("BLACK")) {
                disableButton("RED"); // Disabilita il pulsante ROSSO
            }
            
            
            // Controlla se l'utente sta puntando su EVEN o ODD
            if (buttonText.equals("EVEN")) {
                disableButton("ODD"); // Disabilita il pulsante ODD
            } else if (buttonText.equals("ODD")) {              
                disableButton("EVEN"); // Disabilita il pulsante ROSSO
            }
            
           
            // Controlla se l'utente sta puntando su 1-18 o 18-36
            if (buttonText.equals("1 TO 18")) {
                disableButton("19 TO 36"); // Disabilita il pulsante ODD
            } else if (buttonText.equals("19 TO 36")) {             
                disableButton("1 TO 18"); // Disabilita il pulsante ROSSO
            }

            
            //  Controlla se l'utente sta puntando le terzine
            if (buttonText.equals("1ST 12") || buttonText.equals("2ND 12") || buttonText.equals("3RD 12")) {
                checkAndDisableThird12Button(buttonText);
            } 
            
            
            if(buttonText.equals(" 2:1 ") || buttonText.equals("  2:1  ") || buttonText.equals("   2:1   ") ) {
            	checkAndDisableThird21Button(buttonText);
            }
           
            
            
            // Aggiungi la fiche al bottone
            button.add(chipLabel, BorderLayout.CENTER);
            button.repaint();
            button.revalidate();

            int tokens = model.isSpecialBet(button.getText()) ? 20 : 5;
            buttonTokens.put(button, buttonTokens.get(button) + 1);
            totalBet += tokens;
            updateTotalBetLabel();
        }
        
        

        private void checkAndDisableThird12Button(String clickedButtonText) {
            boolean is1st12Selected = isButtonSelected("1ST 12") || clickedButtonText.equals("1ST 12");
            boolean is2nd12Selected = isButtonSelected("2ND 12") || clickedButtonText.equals("2ND 12");
            boolean is3rd12Selected = isButtonSelected("3RD 12") || clickedButtonText.equals("3RD 12");

            if (is1st12Selected && is2nd12Selected) {
                disableButton("3RD 12");
            } else if (is1st12Selected && is3rd12Selected) {
                disableButton("2ND 12");
            } else if (is2nd12Selected && is3rd12Selected) {
                disableButton("1ST 12");
            }
        }
        
        
        private void checkAndDisableThird21Button(String clickedButtonText) {
            boolean isFirst21Selected = isButtonSelected(" 2:1 ") || clickedButtonText.equals(" 2:1 ");
            boolean isSecond21Selected = isButtonSelected("  2:1  ") || clickedButtonText.equals("  2:1  ");
            boolean isThird21Selected = isButtonSelected("   2:1   ") || clickedButtonText.equals("   2:1   ");

            if (isFirst21Selected && isSecond21Selected) {
                disableButton("   2:1   ");
            } else if (isFirst21Selected && isThird21Selected) {
                disableButton("  2:1  ");
            } else if (isSecond21Selected && isThird21Selected) {
                disableButton(" 2:1 ");
            }
        }
    
    
    private boolean isButtonSelected(String buttonText) {
        for (JButton[] row : buttons) {
            for (JButton button : row) {
                if (button != null && button.getText().equals(buttonText)) {
                    // Controlla se il bottone ha fiches sopra
                    if (button.getComponentCount() > 0) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    
    private void disableButton(String buttonText) {
        for (JButton[] row : buttons) {
            for (JButton button : row) {
                if (button != null && button.getText().equals(buttonText)) {
                    button.setEnabled(false); // Disabilita il pulsante
                }
            }
        }
    }
        
        
    }

    public static int calculatePoints(RouletteModel model) {
        int points = 0;
        int totalBetLost = 0;

        for (Map.Entry<JButton, Integer> entry : buttonTokens.entrySet()) {
            JButton button = entry.getKey();
            int tokens = entry.getValue();

            if (tokens > 0) {
                String buttonText = button.getText();
                boolean won = false;

                if (buttonText.matches("\\d+")) {
                    int number = Integer.parseInt(buttonText);
                    if (number == model.getWinningNumber()) {
                        points += tokens * 5 * 35 + tokens * 5;
                        won = true;
                    }
                    if (!won) {
                        totalBetLost += tokens * 5;
                    }
                } else {
                    if (buttonText.equals("RED") && model.isRed(model.getWinningNumber())) {
                        points += tokens * 20 * 1 + tokens * 20;
                        won = true;
                    } else if (buttonText.equals("BLACK") && !model.isRed(model.getWinningNumber()) && model.getWinningNumber() != 0) {
                        points += tokens * 20 * 1 + tokens * 20;
                        won = true;
                    } else if (buttonText.equals("EVEN") && model.getWinningNumber() % 2 == 0 && model.getWinningNumber() != 0) {
                        points += tokens * 20 * 1 + tokens * 20;
                        won = true;
                    } else if (buttonText.equals("ODD") && model.getWinningNumber() % 2 != 0) {
                        points += tokens * 20 * 1 + tokens * 20;
                        won = true;
                    } else if (buttonText.equals("1 TO 18") && model.getWinningNumber() >= 1 && model.getWinningNumber() <= 18) {
                        points += tokens * 20 * 1 + tokens * 20;
                        won = true;
                    } else if (buttonText.equals("19 TO 36") && model.getWinningNumber() >= 19 && model.getWinningNumber() <= 36) {
                        points += tokens * 20 * 1 + tokens * 20;
                        won = true;
                    } else if (buttonText.equals("1ST 12") && model.getWinningNumber() >= 1 && model.getWinningNumber() <= 12) {
                        points += tokens * 20 * 2 + tokens * 20;
                        won = true;
                    } else if (buttonText.equals("2ND 12") && model.getWinningNumber() >= 13 && model.getWinningNumber() <= 24) {
                        points += tokens * 20 * 2 + tokens * 20;
                        won = true;
                    } else if (buttonText.equals("3RD 12") && model.getWinningNumber() >= 25 && model.getWinningNumber() <= 36) {
                        points += tokens * 20 * 2 + tokens * 20;
                        won = true;
                    } else if (buttonText.equals(" 2:1 ") && (model.getWinningNumber()-1) % 3 + 1 == 1) {
                        points += tokens * 20 * 2 + tokens * 20;
                        won = true;
                    }else if (buttonText.equals("  2:1  ") && (model.getWinningNumber()-1) % 3 + 1 == 2) {
                        points += tokens * 20 * 2 + tokens * 20;
                        won = true;
                    }else if (buttonText.equals("   2:1   ") && (model.getWinningNumber()-1) % 3 + 1 == 3) {
                        points += tokens * 20 * 2 + tokens * 20;
                        won = true;
                    }

                    if (!won) {
                        totalBetLost += tokens * 20;
                    }
                }
            }
        }

        return points - totalBetLost;
    }

    public static void showResultDialog(int winningNumber, RouletteModel model) {
        SwingUtilities.invokeLater(() -> {
            String messageWin = "Il numero vincente è: " + winningNumber + "\nHai vinto: " + calculatePoints(model) + " token!";
            String messageLose = "Il numero vincente è: " + winningNumber + "\nHai perso ";

            if (calculatePoints(model) > 0) {
                JOptionPane.showMessageDialog(null, messageWin, "Risultato Roulette", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, messageLose, "Risultato Roulette", JOptionPane.INFORMATION_MESSAGE);
            }
            clearBets();
        });
    }

    private static void updateTotalBetLabel() {
        SwingUtilities.invokeLater(() -> totalBetLabel.setText(" BET: " + totalBet));
    }
    
   
    
    
  /*  public static void main(String[] args) {
    	RouletteModel model = new RouletteModel();
        RouletteController controller = new RouletteController();
        SwingUtilities.invokeLater(() -> new RouletteView(controller, model));
    }*/
    
}