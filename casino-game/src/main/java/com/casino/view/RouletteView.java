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
    // Costanti per i pulsanti "2:1"
    private static final String FIRST_21 = " 2:1 ";
    private static final String SECOND_21 = "  2:1  ";
    private static final String THIRD_21 = "   2:1   ";
    private static final String FIRST18 = "1 TO 18";
    private static final String LAST18 = "19 TO 36";
    private static final String FIRST12 = "1ST 12";
    private static final String SECOND12 = "2ND 12";
    private static final String THIRD12 = "3RD 12";
    private static final String BLACK = "BLACK";

    // Altre costanti
    private static final Dimension BUTTON_SIZE = new Dimension(90, 30);
    private static final Color BACKGROUND_COLOR = new Color(53, 101, 77);
    private static final Color BUTTON_COLOR = Color.BLUE;
    private static final Color TEXT_COLOR = Color.WHITE;

    // Componenti UI
    private final ImageIcon chipIcon;
    private final JPanel bettingPanel;
    private final RoulettePanel roulettePanel;
    private static JButton[][] buttons;
    private static Map<JButton, Integer> buttonTokens = new HashMap<>();
    private static int totalBet = 0;
    private static JLabel totalBetLabel;

    // Audio
    private final transient  SoundManager soundManager;

    // Model e controller
    private final transient RouletteController controller;
    private final transient RouletteModel model;

    public RouletteView(RouletteController controller, RouletteModel model) {
        this.chipIcon = initializeChipIcon();
        this.bettingPanel = new JPanel();
        this.roulettePanel = new RoulettePanel(model);
        this.controller = controller;
        this.model = model;
        this.soundManager = new SoundManager();
        loadSounds();
        initializeFrame();
        setupSpinAndClearButtons();
        setupTotalBetLabel();
    }

    /**
     * Inizializza il frame e aggiunge i pannelli delle puntate e della ruota.
     */
    private void initializeFrame() {
        setTitle("Roulette Game");
        setSize(1100, 750);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridBagLayout());
        setResizable(false);
        setVisible(true);

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
    }

    private void initializeRoulettePanel() {
        roulettePanel.setBackground(BACKGROUND_COLOR);
        JButton backToMenuButton = createButton("MENU", Color.DARK_GRAY, TEXT_COLOR, e -> MenuGiochi.start());
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

    /**
     * Restituisce la disposizione dei pulsanti per il pannello delle scommesse.
     */
    private String[][] getButtonLayout() {
        return new String[][]{
            {"0"}, {"1", "2", "3"}, {"4", "5", "6"}, {"7", "8", "9"},
            {"10", "11", "12"}, {"13", "14", "15"}, {"16", "17", "18"},
            {"19", "20", "21"}, {"22", "23", "24"}, {"25", "26", "27"},
            {"28", "29", "30"}, {"31", "32", "33"}, {"34", "35", "36"},
            {FIRST_21, SECOND_21, THIRD_21}, {FIRST12, SECOND12, THIRD12},
            {"RED", FIRST18, "EVEN"}, {BLACK, LAST18, "ODD"},
        };
    }

    /**
     * Configura i pulsanti per le scommesse.
     */
    private void setupBettingButtons() {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(1, 1, 1, 1);

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

    /**
     * Crea un pulsante per le scommesse.
     */
    private JButton createBettingButton(String text, int row, int col, GridBagConstraints gbc) {
        JButton button = createButton(text, getButtonBackground(text), TEXT_COLOR, new ChipPlacer(this, text));
        button.setPreferredSize(row == 0 ? new Dimension(273, 30) : BUTTON_SIZE);
        gbc.gridx = col;
        gbc.gridy = row;
        gbc.gridwidth = row == 0 ? 3 : 1;
        return button;
    }

    private Color getButtonBackground(String text) {
        if (text.matches("\\d+")) {
            int num = Integer.parseInt(text);
            return getNumberColor(num);
        } else {
            return model.isSpecialBet(text) ? Color.GRAY : Color.LIGHT_GRAY;
        }
    }

    /**
     * Restituisce il colore di sfondo per un numero specifico.
     */
    private Color getNumberColor(int number) {
        if (number == 0) {
            return Color.GREEN;
        } else if (model.isRed(number)) {
            return Color.RED;
        } else {
            return Color.BLACK;
        }
    }

    /**
     * Crea un pulsante generico.
     */
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

    /**
     * Configura l'etichetta per visualizzare la puntata totale.
     */
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

    /**
     * Cancella tutte le scommesse e azzera l'etichetta della puntata totale.
     */
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

    /**
     * Disabilita tutti i pulsanti delle scommesse.
     */
    private void disableAllBettingButtons() {
        buttonTokens.keySet().forEach(button -> button.setEnabled(false));
    }

    /**
     * Aggiorna l'etichetta della puntata totale.
     */
    private static void updateTotalBetLabel() {
        SwingUtilities.invokeLater(() -> totalBetLabel.setText(" BET: " + totalBet));
    }

    /**
     * Gestisce il clic su un pulsante di scommessa.
     */
    protected void handleButtonClick(String buttonText) {
        disableOppositeButtons(buttonText);
        placeChip(buttonText);
        updateTotalBetLabel();
    }

    /**
     * Disabilita i pulsanti opposti a quello selezionato.
     */
    public void disableOppositeButtons(String buttonText) {
        switch (buttonText) {
            case "RED" -> disableButton(BLACK);
            case BLACK -> disableButton("RED");
            case "EVEN" -> disableButton("ODD");
            case "ODD" -> disableButton("EVEN");
            case FIRST18 -> disableButton(LAST18);
            case LAST18 -> disableButton(FIRST18);
            case FIRST12, SECOND12, THIRD12 -> checkAndDisableThird12Button(buttonText);
            case FIRST_21, SECOND_21, THIRD_21 -> checkAndDisableThird21Button(buttonText);
        }
    }

    /**
     * Posiziona una fiche sul pulsante selezionato.
     */
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

    /**
     * Trova un pulsante in base al testo.
     */
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

    /**
     * Disabilita un pulsante in base al testo.
     */
    private void disableButton(String buttonText) {
        JButton button = findButtonByText(buttonText);
        if (button != null) {
            button.setEnabled(false);
        }
    }

    /**
     * Disabilita il terzo pulsante "12" se due sono già selezionati.
     */
    private void checkAndDisableThird12Button(String clickedButtonText) {
        boolean is1st12Selected = isButtonSelected(FIRST12) || clickedButtonText.equals(FIRST12);
        boolean is2nd12Selected = isButtonSelected(SECOND12) || clickedButtonText.equals(SECOND12);
        boolean is3rd12Selected = isButtonSelected(THIRD12) || clickedButtonText.equals(THIRD12);

        if (is1st12Selected && is2nd12Selected) disableButton(THIRD12);
        else if (is1st12Selected && is3rd12Selected) disableButton(SECOND12);
        else if (is2nd12Selected && is3rd12Selected) disableButton(FIRST12);
    }

    /**
     * Disabilita il terzo pulsante "2:1" se due sono già selezionati.
     */
    private void checkAndDisableThird21Button(String clickedButtonText) {
        boolean isFirst21Selected = isButtonSelected(FIRST_21) || clickedButtonText.equals(FIRST_21);
        boolean isSecond21Selected = isButtonSelected(SECOND_21) || clickedButtonText.equals(SECOND_21);
        boolean isThird21Selected = isButtonSelected(THIRD_21) || clickedButtonText.equals(THIRD_21);

        if (isFirst21Selected && isSecond21Selected) disableButton(THIRD_21);
        else if (isFirst21Selected && isThird21Selected) disableButton(SECOND_21);
        else if (isSecond21Selected && isThird21Selected) disableButton(FIRST_21);
    }

    /**
     * Verifica se un pulsante è selezionato.
     */
    private boolean isButtonSelected(String buttonText) {
        JButton button = findButtonByText(buttonText);
        return button != null && button.getComponentCount() > 0;
    }

    /**
     * Mostra il risultato della roulette.
     */
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