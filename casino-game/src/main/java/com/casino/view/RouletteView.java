package com.casino.view;

import java.awt.*;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.*;

import com.casino.controller.RouletteController;
import com.casino.model.RouletteModel;

public class RouletteView extends JFrame {
    // Costanti
    private static final int BUTTON_WIDTH = 120;
    private static final int BUTTON_HEIGHT = 35;
    private static final Dimension BUTTON_SIZE = new Dimension(BUTTON_WIDTH, BUTTON_HEIGHT);
    private static final Color BACKGROUND_COLOR = new Color(53, 101, 77);
    private static final Color BUTTON_COLOR = Color.BLUE;
    private static final Color TEXT_COLOR = Color.WHITE;

    // Componenti UI
    private final ImageIcon chipIcon;
    private final JPanel bettingPanel;
    private final RoulettePanel roulettePanel;
    private static JButton[][] buttons;

    private static Map<JButton, Integer> buttonTokens; 
    private static int totalBet = 0;
    private static JLabel totalBetLabel;
    // Audio
    private final SoundManager soundManager;

    // Modello e controller
    private final RouletteController controller;
    private final RouletteModel model;

    public RouletteView(RouletteController controller, RouletteModel model) {
        // Inizializzazione dei campi final
        this.chipIcon = initializeChipIcon();
        this.bettingPanel = new JPanel();
        this.roulettePanel = new RoulettePanel(model);
        this.controller = controller;
        this.model = model;
        this.soundManager = new SoundManager();
        this.soundManager.loadSound("src/main/resources/audio/ruota.wav", "spin");
        this.soundManager.loadSound("src/main/resources/audio/fiches.wav", "fiches"); 

        initializeFrame();
        initializeRoulettePanel();
        initializeBettingPanel();
        setupSpinAndClearButtons(); // Configurazione dei pulsanti SPIN e CLEAR  
        setupTotalBetLabel(); // Configurazione dell'etichetta della puntata totale
        setupLayout();
    }

    
    private void initializeFrame() {
        setTitle("Roulette Game");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private ImageIcon initializeChipIcon() {
        ImageIcon fiches = new ImageIcon("src/main/resources/immagini/fiches.png");
        Image scaledImage = fiches.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        return new ImageIcon(scaledImage);
    }

    private void initializeRoulettePanel() {
    	roulettePanel.setPreferredSize(new Dimension(Toolkit.getDefaultToolkit().getScreenSize().width / 2, Toolkit.getDefaultToolkit().getScreenSize().height));
    	roulettePanel.setBackground(BACKGROUND_COLOR);
        JButton backToMenuButton = createButton("Torna al menu", Color.DARK_GRAY, TEXT_COLOR, e -> MenuGiochi.Start());
        roulettePanel.setLayout(new BorderLayout());
        roulettePanel.add(backToMenuButton, BorderLayout.SOUTH);
    }


    private void initializeBettingPanel() {
        bettingPanel.setLayout(new GridBagLayout());
        bettingPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 10));
        bettingPanel.setBackground(BACKGROUND_COLOR);
        buttonTokens = new HashMap<>();
        buttons = new JButton[getButtonLayout().length][];
      
        setupBettingButtons();
    }

    private String[][] getButtonLayout() {
        return new String[][]{
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
        };
    }

    private void setupBettingButtons() {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(2, 2, 2, 2);

        String[][] layout = getButtonLayout();

        for (int row = 0; row < layout.length; row++) {
            buttons[row] = new JButton[layout[row].length];
            for (int col = 0; col < layout[row].length; col++) {
                if (!layout[row][col].isEmpty()) {
                    JButton button = createBettingButton(layout[row][col], row, col, gbc);
                    buttons[row][col] = button;
                    bettingPanel.add(button, gbc);
                    buttonTokens.put(button, 0);
                }
            }
        }
    }

    private JButton createBettingButton(String text, int row, int col, GridBagConstraints gbc) {
        JButton button = createButton(text, getButtonBackground(text), TEXT_COLOR, new ChipPlacer(this, text)); // Passa this e text
        button.setPreferredSize(row == 0 ? new Dimension(370, 35) : BUTTON_SIZE);
        gbc.gridx = col;
        gbc.gridy = row;
        gbc.gridwidth = row == 0 ? 3 : 1;
        return button;
    }

    private Color getButtonBackground(String text) {
        if (text.matches("\\d+")) {
            int num = Integer.parseInt(text);
            return num == 0 ? Color.GREEN : model.isRed(num) ? Color.RED : Color.BLACK;
        } else if (model.isSpecialBet(text)) {
            return Color.GRAY;
        } else {
            return Color.LIGHT_GRAY;
        }
    }

    private JButton createButton(String text, Color background, Color foreground, ActionListener listener) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.BOLD, 18));
        button.setFocusPainted(false);
        button.setBackground(background);
        button.setForeground(foreground);
        button.addActionListener(listener);
        return button;
    }




    private void setupSpinAndClearButtons() {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = getButtonLayout().length;
        gbc.gridwidth = 1;

        // Creazione del pulsante SPIN 
        JButton spinButton = createButton("SPIN", BUTTON_COLOR, TEXT_COLOR, e -> {
        	disableAllBettingButtons();
        	soundManager.playSound("spin");
            roulettePanel.startBallAnimation();
        });
        spinButton.setPreferredSize(BUTTON_SIZE); // Imposta la dimensione
        bettingPanel.add(spinButton, gbc);

        gbc.gridx = 1;
        JButton clearButton = createButton("CLEAR", BUTTON_COLOR, TEXT_COLOR, e -> clearBets());
        clearButton.setPreferredSize(BUTTON_SIZE); // Imposta la dimensione
        bettingPanel.add(clearButton, gbc);
    }

    private void setupTotalBetLabel() {
        totalBetLabel = new JLabel("BET: 0");
        totalBetLabel.setPreferredSize(BUTTON_SIZE);
        totalBetLabel.setFont(new Font("Arial", Font.BOLD, 18));
        totalBetLabel.setOpaque(true);
        totalBetLabel.setHorizontalAlignment(SwingConstants.CENTER);
        totalBetLabel.setBackground(BUTTON_COLOR);
        totalBetLabel.setForeground(TEXT_COLOR);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = getButtonLayout().length;
        gbc.gridwidth = 1;
        bettingPanel.add(totalBetLabel, gbc);
    }

    private void setupLayout() {
        setLayout(new BorderLayout());
        add(roulettePanel, BorderLayout.WEST);
        add(bettingPanel, BorderLayout.CENTER);
        setVisible(true);
    }

    
    
    // Metodi per gestire le puntate
    public static void clearBets() {
        totalBet = 0;
        for (JButton[] row : buttons) {
            for (JButton button : row) {
                if (button != null) {
                    if (button.getComponentCount() > 0) {
                        button.removeAll();
                        button.repaint();
                        button.revalidate();
                    }
                    button.setEnabled(true);
                    buttonTokens.put(button, 0);
                }
            }
        }
        updateTotalBetLabel();
    }
    
    //per i test
    public static void clearButtonTokens() {
        buttonTokens.clear();
    }
    //per i test
    public static void addButtonToken(JButton button, int tokens) {
        buttonTokens.put(button, tokens);
    }

    private void disableAllBettingButtons() {
        for (JButton[] row : buttons) {
            for (JButton button : row) {
                if (button != null) {
                    button.setEnabled(false);
                }
            }
        }
    }


    
    private static void updateTotalBetLabel() {
        SwingUtilities.invokeLater(() -> totalBetLabel.setText(" BET: " + totalBet));
    }

    protected void handleButtonClick(String buttonText) {
        disableOppositeButtons(buttonText);
        placeChip(buttonText);
        updateTotalBet();
    }

    private void disableOppositeButtons(String buttonText) {
        switch (buttonText) {
            case "RED":
                disableButton("BLACK");
                break;
            case "BLACK":
                disableButton("RED");
                break;
            case "EVEN":
                disableButton("ODD");
                break;
            case "ODD":
                disableButton("EVEN");
                break;
            case "1 TO 18":
                disableButton("19 TO 36");
                break;
            case "19 TO 36":
                disableButton("1 TO 18");
                break;
            case "1ST 12":
            case "2ND 12":
            case "3RD 12":
                checkAndDisableThird12Button(buttonText);
                break;
            case " 2:1 ":
            case "  2:1  ":
            case "   2:1   ":
                checkAndDisableThird21Button(buttonText);
                break;
        }
    }

    private void placeChip(String buttonText) {
         JButton button = findButtonByText(buttonText);
        if (button != null) {
        	soundManager.playSound("fiches");
        	JLabel chipLabel = new JLabel(chipIcon);
        	button.setLayout(new ChipLayout()); 
            button.add(chipLabel, BorderLayout.CENTER);
            button.repaint();
            button.revalidate();

            int tokens = model.isSpecialBet(buttonText) ? 20 : 5;
            buttonTokens.put(button, buttonTokens.get(button) + 1);
            totalBet += tokens;
        }
    }
        

    private void updateTotalBet() {
        updateTotalBetLabel();
    }

    private JButton findButtonByText(String buttonText) {
        for (JButton[] row : buttons) {
            for (JButton button : row) {
                if (button != null && button.getText().equals(buttonText)) {
                    return button;
                }
            }
        }
        return null;
    }

    private void disableButton(String buttonText) {
        JButton button = findButtonByText(buttonText);
        if (button != null) {
            button.setEnabled(false);
        }
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
        JButton button = findButtonByText(buttonText);
        return button != null && button.getComponentCount() > 0;
    }

    // Metodi statici per la gestione del risultato
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
                    } else if (buttonText.equals(" 2:1 ") && (model.getWinningNumber() - 1) % 3 + 1 == 1) {
                        points += tokens * 20 * 2 + tokens * 20;
                        won = true;
                    } else if (buttonText.equals("  2:1  ") && (model.getWinningNumber() - 1) % 3 + 1 == 2) {
                        points += tokens * 20 * 2 + tokens * 20;
                        won = true;
                    } else if (buttonText.equals("   2:1   ") && (model.getWinningNumber() - 1) % 3 + 1 == 3) {
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
}