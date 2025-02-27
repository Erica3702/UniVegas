package com.casino.view;

import java.awt.*;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import javax.swing.*;
import com.casino.controller.RouletteController;
import com.casino.model.PointsCalculator;
import com.casino.model.RouletteModel;

public class RouletteView extends JFrame {
    // Costanti
    private static final Dimension BUTTON_SIZE = new Dimension(90, 30);
    private static final Color BACKGROUND_COLOR = new Color(53, 101, 77);
    private static final Color BUTTON_COLOR = Color.BLUE;
    private static final Color TEXT_COLOR = Color.WHITE;
    // Componenti UI
    private final ImageIcon chipIcon;
    private final JPanel bettingPanel;
    private final RoulettePanel roulettePanel;
    private static JButton[][] buttons;
    private static Map<JButton, Integer> buttonTokens = new HashMap<>();; 
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
        loadSounds();
        initializeFrame();
        setupSpinAndClearButtons(); // Configurazione dei pulsanti SPIN e CLEAR  
        setupTotalBetLabel(); // Configurazione dell'etichetta della puntata totale
    }
 
    private void initializeFrame() {
        setTitle("Roulette Game");
        setSize(1100,750);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridBagLayout());
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weighty = 1.0;
        
        initializeRoulettePanel();
        initializeBettingPanel();
        
     // Configura roulettePanel 
        gbc.gridx = 0;
        gbc.weightx = 0.80; 
        add(roulettePanel, gbc);
        
     // Configura bettingPanel
        gbc.gridx = 1;
        gbc.weightx = 0.20;  
        add(bettingPanel, gbc);
        
        setResizable(false);
        setVisible(true);
    }

    private void initializeRoulettePanel() {
    	roulettePanel.setBackground(BACKGROUND_COLOR);
        JButton backToMenuButton = createButton("MENU", Color.DARK_GRAY, TEXT_COLOR, e -> MenuGiochi.Start());
        roulettePanel.setLayout(new BorderLayout());
        roulettePanel.add(backToMenuButton, BorderLayout.SOUTH);
    }

    private void initializeBettingPanel() {
    	bettingPanel.setLayout(new GridBagLayout());
        bettingPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 10));
        bettingPanel.setBackground(BACKGROUND_COLOR);
        setupBettingButtons();
    }
    
    private ImageIcon initializeChipIcon() {
        ImageIcon fiches = new ImageIcon("src/main/resources/immagini/fiches.png");
        Image scaledImage = fiches.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        return new ImageIcon(scaledImage);
    }
    
    private void loadSounds() {
        soundManager.loadSound("src/main/resources/audio/ruota.wav", "spin");
        soundManager.loadSound("src/main/resources/audio/fiches.wav", "fiches");
    }

    private String[][] getButtonLayout() {
        return new String[][]{
            {"0"}, {"1", "2", "3"}, {"4", "5", "6"}, {"7", "8", "9"},
            {"10", "11", "12"}, {"13", "14", "15"}, {"16", "17", "18"},
            {"19", "20", "21"}, {"22", "23", "24"}, {"25", "26", "27"},
            {"28", "29", "30"}, {"31", "32", "33"}, {"34", "35", "36"},
            {" 2:1 ", "  2:1  ", "   2:1   "}, {"1ST 12", "2ND 12", "3RD 12"},
            {"RED", "1 TO 18", "EVEN"}, {"BLACK", "19 TO 36", "ODD"},
        };
    }

    private void setupBettingButtons() {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(1,1, 1, 1);

        String[][] layout = getButtonLayout();
        buttons = new JButton[layout.length][];

        for (int row = 0; row < layout.length; row++) {
            buttons[row] = new JButton[layout[row].length];
            for (int col = 0; col < layout[row].length; col++) {
                if (!layout[row][col].isEmpty()) {
                    JButton button = createBettingButton(layout[row][col], row, col, gbc);
                    buttons[row][col] = button;
                    gbc.gridx = col;
                    gbc.gridy = row;
                    bettingPanel.add(button, gbc);
                    buttonTokens.put(button, 0);
                }
            }
        }
    }

    private JButton createBettingButton(String text, int row, int col, GridBagConstraints gbc) {
        JButton button = createButton(text, getButtonBackground(text), TEXT_COLOR, new ChipPlacer(this, text));
        button.setPreferredSize(row == 0 ? new Dimension(273, 30) : BUTTON_SIZE);
        gbc.gridx = col;
        gbc.gridy = row;
        gbc.gridwidth = row == 0 ? 3 : 1;
        return button;
    }

    private Color getButtonBackground(String text) {
        if (text.matches("\\d+")) {	//una o piu cifre numeri
            int num = Integer.parseInt(text);
            return num == 0 ? Color.GREEN : model.isRed(num) ? Color.RED : Color.BLACK;
        } else {
        	return model.isSpecialBet(text) ? Color.GRAY : Color.LIGHT_GRAY;
        }     
    }

    private JButton createButton(String text, Color background, Color foreground, ActionListener listener) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.BOLD, 13));
        button.setBackground(background);
        button.setForeground(foreground);
        button.addActionListener(listener);
        return button;
    }
  
    private void setupSpinAndClearButtons() {
        JButton spinButton = createButton("SPIN", BUTTON_COLOR, TEXT_COLOR, e -> {
            disableAllBettingButtons();
            soundManager.playSound("spin");
            roulettePanel.startBallAnimation();
        });

        JButton clearButton = createButton("CLEAR", BUTTON_COLOR, TEXT_COLOR, e -> clearBets());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridy = getButtonLayout().length;
        gbc.gridwidth = 1;

        spinButton.setPreferredSize(BUTTON_SIZE);
        clearButton.setPreferredSize(BUTTON_SIZE);
        bettingPanel.add(spinButton, gbc);
        gbc.gridx = 1;
        bettingPanel.add(clearButton, gbc);    
    }

    private void setupTotalBetLabel() {
        totalBetLabel = new JLabel("BET: 0");
        totalBetLabel.setPreferredSize(BUTTON_SIZE);
        totalBetLabel.setFont(new Font("Arial", Font.BOLD, 13));
        totalBetLabel.setOpaque(true);
        totalBetLabel.setHorizontalAlignment(SwingConstants.CENTER);
        totalBetLabel.setBackground(BUTTON_COLOR);
        totalBetLabel.setForeground(TEXT_COLOR);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = getButtonLayout().length;
        bettingPanel.add(totalBetLabel, gbc);
    }
    
    public static void clearBets() {
        totalBet = 0;
        buttonTokens.forEach((button, value) -> {
            button.setEnabled(true);
            button.removeAll();
            button.repaint();
            button.revalidate();
            buttonTokens.put(button, 0);
        });
        updateTotalBetLabel();
    }

    private void disableAllBettingButtons() {
    	buttonTokens.keySet().forEach(button -> button.setEnabled(false));
    }

    private static void updateTotalBetLabel() {
        SwingUtilities.invokeLater(() -> totalBetLabel.setText(" BET: " + totalBet));
    }

    protected void handleButtonClick(String buttonText) {
        disableOppositeButtons(buttonText);
        placeChip(buttonText);
        updateTotalBetLabel();
    }

    public void disableOppositeButtons(String buttonText) {
        switch (buttonText) {
            case "RED" -> disableButton("BLACK");
            case "BLACK" -> disableButton("RED");
            case "EVEN" -> disableButton("ODD");
            case "ODD" -> disableButton("EVEN");
            case "1 TO 18" -> disableButton("19 TO 36");
            case "19 TO 36" -> disableButton("1 TO 18");
            case "1ST 12", "2ND 12", "3RD 12" -> checkAndDisableThird12Button(buttonText);
            case " 2:1 ", "  2:1  ", "   2:1   " -> checkAndDisableThird21Button(buttonText);
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

        if (is1st12Selected && is2nd12Selected) disableButton("3RD 12");
        else if (is1st12Selected && is3rd12Selected) disableButton("2ND 12");
        else if (is2nd12Selected && is3rd12Selected) disableButton("1ST 12");
    }

    private void checkAndDisableThird21Button(String clickedButtonText) {
        boolean isFirst21Selected = isButtonSelected(" 2:1 ") || clickedButtonText.equals(" 2:1 ");
        boolean isSecond21Selected = isButtonSelected("  2:1  ") || clickedButtonText.equals("  2:1  ");
        boolean isThird21Selected = isButtonSelected("   2:1   ") || clickedButtonText.equals("   2:1   ");

        if (isFirst21Selected && isSecond21Selected) disableButton("   2:1   ");
        else if (isFirst21Selected && isThird21Selected) disableButton("  2:1  ");
        else if (isSecond21Selected && isThird21Selected) disableButton(" 2:1 ");
    }

    private boolean isButtonSelected(String buttonText) {
        JButton button = findButtonByText(buttonText);
        return button != null && button.getComponentCount() > 0;
    }

	public static void showResultDialog(int winningNumber, RouletteModel model) {
	    SwingUtilities.invokeLater(() -> {
	        int points = PointsCalculator.calculatePoints(model, buttonTokens);
	        String message = "Il numero vincente è: " + winningNumber + "\n";
	        message += points > 0 ? "Hai vinto: " + points + " token!" : "Hai perso";
	
	        JOptionPane.showMessageDialog(null, message, "Risultato Roulette", JOptionPane.INFORMATION_MESSAGE);
	        clearBets();
	    });
	}  
}