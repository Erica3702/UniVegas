package com.casino.view;

import javax.swing.*;
import com.casino.model.RouletteModel;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class BettingPanel extends JPanel {
    private static JButton[][] buttons;
    public static Map<JButton, Integer> buttonTokens;
    static int totalBet = 0;
    private static JLabel totalBetLabel;
    private final RouletteModel model;
    private final ImageIcon chipIcon;
    private final RoulettePanel roulettePanel;

    private static final String[][] layout = {
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
            {"1ST 12", "2ND 12", "3RD 12"},
            {"RED", "1 TO 18", "EVEN"},
            {"BLACK", "19 TO 36", "ODD"},
            {"", "", ""}
    };

    public BettingPanel(RouletteModel model, RoulettePanel roulettePanel) {
        this.model = model;
        this.roulettePanel = roulettePanel;

        // Carica l'icona della fiche e ridimensionala
        ImageIcon fiches = new ImageIcon("src/main/resources/immagini/fiches.png");
        Image scaledImage = fiches.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        this.chipIcon = new ImageIcon(scaledImage);

        setLayout(new GridBagLayout());
        setBorder(BorderFactory.createLineBorder(Color.BLACK, 10));
        setBackground(new Color(0, 100, 0));

        buttonTokens = new HashMap<>();
        buttons = new JButton[layout.length][];

        initializeButtons();
        initializeSpinButton();
        initializeClearButton();
        initializeTotalBetLabel();
    }

    private void initializeButtons() {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(2, 2, 2, 2);

        for (int row = 0; row < layout.length; row++) {
            buttons[row] = new JButton[layout[row].length];
            for (int col = 0; col < layout[row].length; col++) {
                if (!layout[row][col].isEmpty()) {
                    JButton button = new JButton(layout[row][col]) {
						private static final long serialVersionUID = 1L;

						@Override
                        protected void paintComponent(Graphics g) {
                            super.paintComponent(g);
                            int tokens = buttonTokens.getOrDefault(this, 0);
                            if (tokens > 0) {
                                int x = (getWidth() - chipIcon.getIconWidth()) / 2;
                                int y = (getHeight() - chipIcon.getIconHeight()) / 2;
                                for (int i = 0; i < tokens; i++) {
                                    chipIcon.paintIcon(this, g, x, y - i * 2); // Sovrappone le fiches
                                }
                            }
                        }
                    };

                    button.setFont(new Font("Arial", Font.BOLD, 15));
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
                            button.setBackground(model.isRed(num) ? Color.RED : Color.BLACK);
                        }
                        button.setForeground(Color.WHITE);
                    } else if (model.isSpecialBet(layout[row][col])) {
                        button.setBackground(Color.GRAY);
                        button.setForeground(Color.WHITE);
                    } else {
                        button.setBackground(Color.LIGHT_GRAY);
                    }

                    button.addActionListener(e -> {
                        int tokens = buttonTokens.getOrDefault(button, 0) + 1;
                        buttonTokens.put(button, tokens);
                        totalBet += model.isSpecialBet(button.getText()) ? 20 : 5;
                        updateTotalBetLabel();
                        button.repaint(); // Ridisegna il pulsante per mostrare le fiches
                    });

                    gbc.gridx = col;
                    gbc.gridy = row;
                    buttons[row][col] = button;
                    add(button, gbc);

                    buttonTokens.put(button, 0);
                }
            }
        }
    }

    private void initializeSpinButton() {
        JButton spinButton = new JButton(" SPIN ");
        spinButton.addActionListener(e -> roulettePanel.startBallAnimation());
        spinButton.setFont(new Font("Arial", Font.BOLD, 18));
        spinButton.setBackground(Color.BLUE);
        spinButton.setForeground(Color.WHITE);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = layout.length;
        gbc.gridwidth = 2;
        add(spinButton, gbc);
    }

    private void initializeClearButton() {
        JButton clearButton = new JButton("CLEAR");
        clearButton.addActionListener(e -> clearBets());
        clearButton.setFont(new Font("Arial", Font.BOLD, 18));
        clearButton.setBackground(Color.RED);
        clearButton.setForeground(Color.WHITE);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = layout.length;
        gbc.gridwidth = 2;
        add(clearButton, gbc);
    }

    private void initializeTotalBetLabel() {
        totalBetLabel = new JLabel("TOTAL BET: 0");
        totalBetLabel.setFont(new Font("Arial", Font.BOLD, 16));
        totalBetLabel.setForeground(Color.WHITE);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = layout.length+1;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        add(totalBetLabel, gbc);
    }

    public static void clearBets() {
        totalBet = 0;
        for (JButton[] row : buttons) {
            for (JButton button : row) {
                if (button != null) {
                    buttonTokens.put(button, 0);
                    button.repaint(); // Ridisegna il pulsante per rimuovere le fiches
                }
            }
        }
        updateTotalBetLabel();
    }

    static void updateTotalBetLabel() {
        SwingUtilities.invokeLater(() -> totalBetLabel.setText("TOTAL BET: " + totalBet));
    }
}