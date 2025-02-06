package com.casino.view;

import javax.swing.*; // Per JFrame, JPanel, JButton, ecc.

import java.awt.*;
import java.awt.event.*;

public class MenuUtente {
	//genera il menu e i due bottoni interattivi
	  public static void startMenu() {
	        //Creazione del frame
	        JFrame frame = new JFrame("UniVegas");
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame.setSize(400, 500);
	        frame.setLayout(null);	         
	        
	        //username
	        JLabel usernameLabel = new JLabel("Username/Email:");
	        usernameLabel.setBounds(20, 20, 100, 25);
	        JTextField usernameField = new JTextField();
	        usernameField.setBounds(140, 20, 120, 25);
	        
	        //password
	        JLabel passwordLabel = new JLabel("Password:");
	        passwordLabel.setBounds(20, 60, 100, 25);
	        JPasswordField passwordField = new JPasswordField();
	        passwordField.setBounds(140, 80, 120, 25);
	        
	        //nuovo utente
	        JLabel newLabel = new JLabel("Nuovo utente?", SwingConstants.CENTER);
	        newLabel.setForeground(Color.WHITE);
	        newLabel.setBounds(140, 320, 120, 25);
	       
	        // Creazione dei pulsanti
	        JButton loginButton = new JButton("Accedi");
	        loginButton.setBounds(100, 250, 200, 40); // Posizione e dimensioni

	        JButton registratiButton = new JButton("Registrati");
	        registratiButton.setBounds(100, 350, 200, 40); // Posizione e dimensioni
	       
	        
	        // Caricamento dell'immagine di sfondo
	        ImageIcon backgroundImage = new ImageIcon("src/main/resources/immagini/logo.png");
	        
	        // Ridimensiona l'immagine per adattarla alla dimensione del frame
	        Image img = backgroundImage.getImage(); // Ottieni l'immagine dall'ImageIcon
	        Image scaledImg = img.getScaledInstance(frame.getWidth(), frame.getHeight(), Image.SCALE_SMOOTH); // Ridimensiona l'immagine
	        ImageIcon scaledBackgroundImage = new ImageIcon(scaledImg); // Crea un nuovo ImageIcon con l'immagine ridimensionata

	        // Crea un JLabel con l'immagine ridimensionata
	        JLabel background = new JLabel(scaledBackgroundImage);

	        // Impostazione delle dimensioni per l'immagine di sfondo
	        background.setBounds(0, 0, frame.getWidth(), frame.getHeight()); // Adatta l'immagine alle dimensioni del frame
	   
	        ImageIcon fiches = new ImageIcon("src/main/resources/immagini/fiches.png"); 
	        frame.setIconImage(fiches.getImage());
	        
	        // Aggiunta degli elementi al frame
	  	    frame.add(loginButton);
	  	    frame.add(newLabel);
	        frame.add(registratiButton);
	        frame.add(background);
	  	       
	  	    // Visualizzazione del frame
		    frame.setLocationRelativeTo(null); // Centrare la finestra
		    frame.setVisible(true);
		    frame.setResizable(false);
		    
		    
		    // Aggiunta ActionListener per il pulsante "Accedi"
	        loginButton.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	            	Login.showLoginFrame(); // Apri la finestra di login
	            }
	        });
		    
	        
	       // Aggiunta ActionListener per il pulsante "Registrati"
	       registratiButton.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                Registrazione.showRegisrationFrame(); // Apri la finestra di registrazione
	            }
	       });
	 }
}