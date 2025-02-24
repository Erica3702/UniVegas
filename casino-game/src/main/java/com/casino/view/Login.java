package com.casino.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
	  // Metodo per finestra di login
	    public static void showLoginFrame() {
	        // Creazione della finestra di login
	        JFrame loginFrame = new JFrame("Login");
	        loginFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE); // Chiude solo questa finestra
	        loginFrame.setSize(300, 200);
	        loginFrame.setLayout(null);

	        ImageIcon fiches = new ImageIcon("src/main/resources/immagini/fiches.png");
	        loginFrame.setIconImage(fiches.getImage());

	        // Creazione dei campi per username e password
	        JLabel usernameLabel = new JLabel("Username:");
	        usernameLabel.setBounds(20, 30, 100, 25);

	        JTextField usernameField = new JTextField();
	        usernameField.setBounds(140, 30, 120, 25);

	        JLabel passwordLabel = new JLabel("Password:");
	        passwordLabel.setBounds(20, 70, 100, 25);

	        JPasswordField passwordField = new JPasswordField();
	        passwordField.setBounds(140, 70, 120, 25);

	        // Pulsante di login
	        JButton loginButton2 = new JButton("Login");
	        loginButton2.setBounds(100, 110, 100, 35);

	        // Aggiunta degli elementi alla finestra di login
	        loginFrame.add(usernameLabel);
	        loginFrame.add(usernameField);
	        loginFrame.add(passwordLabel);
	        loginFrame.add(passwordField);
	        loginFrame.add(loginButton2);

	        // Mostra la finestra di login
	        loginFrame.setLocationRelativeTo(null); // Centrare la finestra
	        loginFrame.setVisible(true);
	        loginFrame.setResizable(false);




	        loginButton2.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                String username = usernameField.getText();
	                String password = new String(passwordField.getPassword());

	                // Chiamata al metodo verificaUtente
	                if (MainController.verificaUtente(username, password)) {
	                    JOptionPane.showMessageDialog(loginFrame, "Accesso riuscito!");
	                    MenuGiochi.Start();

	                } else {
	                    JOptionPane.showMessageDialog(loginFrame, "Accesso negato: credenziali errate.");
	                }
	            }
	        });

	        loginFrame.setVisible(true);
	    }

}