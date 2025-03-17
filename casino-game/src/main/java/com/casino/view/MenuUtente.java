package com.casino.view;

import java.awt.Color;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

public class MenuUtente {

    // Costruttore privato per impedire l'istanziazione
    private MenuUtente() {
        throw new UnsupportedOperationException("Questa classe non può essere istanziata.");
    }

    /**
     * Genera il menu e i due bottoni interattivi "accedi" e "registrati".
     */
    public static void startMenu() {
        JFrame frame = new JFrame("UniVegas");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(400, 500);
        frame.setLayout(null);

        // Etichette e campi di input
        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setBounds(20, 20, 100, 25);
        JTextField usernameField = new JTextField();
        usernameField.setBounds(140, 20, 120, 25);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(20, 60, 100, 25);
        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(140, 80, 120, 25);

        JLabel newLabel = new JLabel("Nuovo utente?", SwingConstants.CENTER);
        newLabel.setForeground(Color.WHITE);
        newLabel.setBounds(140, 320, 120, 25);

        // Bottoni
        JButton loginButton = new JButton("Accedi");
        loginButton.setBounds(100, 250, 200, 40);

        JButton registratiButton = new JButton("Registrati");
        registratiButton.setBounds(100, 350, 200, 40);

        // Immagine di sfondo
        ImageIcon backgroundImage = new ImageIcon("src/main/resources/immagini/logo.png");
        Image img = backgroundImage.getImage(); // Ottieni l'immagine dall'ImageIcon
        Image scaledImg = img.getScaledInstance(frame.getWidth(), frame.getHeight(), Image.SCALE_SMOOTH); // Ridimensiona l'immagine
        ImageIcon scaledBackgroundImage = new ImageIcon(scaledImg);

        JLabel background = new JLabel(scaledBackgroundImage);
        background.setBounds(0, 0, frame.getWidth(), frame.getHeight()); // Adatta l'immagine alle dimensioni del frame

        // Icona della finestra
        ImageIcon fiches = new ImageIcon("src/main/resources/immagini/fiches.png");
        frame.setIconImage(fiches.getImage());

        // Aggiungi componenti al frame
        frame.add(loginButton);
        frame.add(newLabel);
        frame.add(registratiButton);
        frame.add(background);

        frame.setLocationRelativeTo(null); // Centra la finestra
        frame.setVisible(true);
        frame.setResizable(false);

        // Azioni per i bottoni usando lambda
        loginButton.addActionListener(e -> Login.showLoginFrame()); // Apre la finestra di login

        registratiButton.addActionListener(e -> Registrazione.showRegisrationFrame()); // Apre la finestra di registrazione
    }
}