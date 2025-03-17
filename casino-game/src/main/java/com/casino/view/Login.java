package com.casino.view;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import com.casino.controller.MainController;

public class Login {

    // Costruttore privato per impedire l'istanziazione
    private Login() {
        throw new UnsupportedOperationException("Questa classe non può essere istanziata.");
    }

    /**
     * Creazione della schermata di Login
     */
    public static void showLoginFrame() {
        JFrame loginFrame = new JFrame("Login");
        loginFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        loginFrame.setSize(300, 200);
        loginFrame.setLayout(null);

        ImageIcon fiches = new ImageIcon("src/main/resources/immagini/fiches.png");
        loginFrame.setIconImage(fiches.getImage());

        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setBounds(20, 30, 100, 25);

        JTextField usernameField = new JTextField();
        usernameField.setBounds(140, 30, 120, 25);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(20, 70, 100, 25);

        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(140, 70, 120, 25);

        JButton loginButton2 = new JButton("Login");
        loginButton2.setBounds(100, 110, 100, 35);

        loginFrame.add(usernameLabel);
        loginFrame.add(usernameField);
        loginFrame.add(passwordLabel);
        loginFrame.add(passwordField);
        loginFrame.add(loginButton2);

        loginFrame.setLocationRelativeTo(null); // per centrare
        loginFrame.setVisible(true);
        loginFrame.setResizable(false);

        // Sostituzione della classe anonima con una lambda
        loginButton2.addActionListener(e -> {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());

            if (MainController.verificaUtente(username, password)) {
                JOptionPane.showMessageDialog(loginFrame, "Accesso riuscito!");
                loginFrame.dispose();
                MenuGiochi.start();
            } else {
                JOptionPane.showMessageDialog(loginFrame, "Accesso negato: credenziali errate.");
            }
        });

        loginFrame.setVisible(true);
    }
}