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

    public RouletteView(RouletteController controller, RouletteModel model) {
        this.controller = controller;
        this.model = model;

        setTitle("Roulette Game");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        ImageIcon fiches = new ImageIcon("src/main/resources/immagini/fiches.png");
        Image scaledImage = fiches.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        chipIcon = new ImageIcon(scaledImage);

        roulettePanel = new RoulettePanel(model);
        roulettePanel.setPreferredSize(new Dimension(Toolkit.getDefaultToolkit().getScreenSize().width / 2, getHeight()));
        roulettePanel.setBackground(new Color(0, 100, 0));

        bettingPanel = new JPanel();
        bettingPanel.setLayout(new GridBagLayout());
        bettingPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 10));
        bettingPanel.setBackground(new Color(0, 100, 0));

        JButton backToMenuButton = new JButton("Torna al menu");
        backToMenuButton.setFont(new Font("Arial", Font.BOLD, 14));
        backToMenuButton.setBackground(Color.DARK_GRAY);
        backToMenuButton.setForeground(Color.WHITE);
        backToMenuButton.addActionListener(e -> MenuGiochi.Start());
        
        
        
        roulettePanel.setLayout(new BorderLayout());
        roulettePanel.add(backToMenuButton, BorderLayout.SOUTH);
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

        JButton spinButton = new JButton("SPIN");
        spinButton.addActionListener(e -> roulettePanel.startBallAnimation());
        spinButton.setFont(new Font("Arial", Font.BOLD, 16));
        spinButton.setBackground(Color.BLUE);
        spinButton.setForeground(Color.WHITE);

        gbc.gridx = 0;
        gbc.gridy = layout.length + 2;
        gbc.gridwidth = 3;
        bettingPanel.add(spinButton, gbc);

        JButton clearButton = new JButton("CLEAR");
        clearButton.addActionListener(e -> clearBets());
        clearButton.setFont(new Font("Arial", Font.BOLD, 14));
        clearButton.setBackground(Color.RED);
        clearButton.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = layout.length;
        gbc.gridwidth = 3;
        bettingPanel.add(clearButton, gbc);

        totalBetLabel = new JLabel("TOTAL BET: 0");
        totalBetLabel.setFont(new Font("Arial", Font.BOLD, 16));
        totalBetLabel.setForeground(Color.WHITE);

        gbc.gridx = 0;
        gbc.gridy = layout.length + 1;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
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
                if (button != null && button.getComponentCount() > 0) {
                    button.removeAll();
                    button.repaint();
                    button.revalidate();
                }
                if (button != null) {
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
            button.add(chipLabel, BorderLayout.CENTER);
            button.repaint();
            button.revalidate();

            int tokens = model.isSpecialBet(button.getText()) ? 20 : 5;
            buttonTokens.put(button, buttonTokens.get(button) + 1);
            totalBet += tokens;
            updateTotalBetLabel();
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
                    } else if (buttonText.equals("1 to 18") && model.getWinningNumber() >= 1 && model.getWinningNumber() <= 18) {
                        points += tokens * 20 * 1 + tokens * 20;
                        won = true;
                    } else if (buttonText.equals("19 to 36") && model.getWinningNumber() >= 19 && model.getWinningNumber() <= 36) {
                        points += tokens * 20 * 1 + tokens * 20;
                        won = true;
                    } else if (buttonText.equals("1st 12") && model.getWinningNumber() >= 1 && model.getWinningNumber() <= 12) {
                        points += tokens * 20 * 2 + tokens * 20;
                        won = true;
                    } else if (buttonText.equals("2nd 12") && model.getWinningNumber() >= 13 && model.getWinningNumber() <= 24) {
                        points += tokens * 20 * 2 + tokens * 20;
                        won = true;
                    } else if (buttonText.equals("3rd 12") && model.getWinningNumber() >= 25 && model.getWinningNumber() <= 36) {
                        points += tokens * 20 * 2 + tokens * 20;
                        won = true;
                    } else if (buttonText.equals("2:1") && model.getWinningNumber() % 3 == 0) {
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
        SwingUtilities.invokeLater(() -> totalBetLabel.setText("TOTAL BET: " + totalBet));
    }
}