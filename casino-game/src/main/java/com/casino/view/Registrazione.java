package com.casino.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.casino.controller.MainController;

public class Registrazione {
//blocco username gia usato
		
	    //creazione finestra di registraz
		public static void showRegisrationFrame() {

		JFrame RegistrationFrame = new JFrame("Registrati");
		RegistrationFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Chiude solo questa finestra
		RegistrationFrame.setSize(300, 250);
		RegistrationFrame.setLayout(null);
		
		ImageIcon fiches = new ImageIcon("src/main/resources/immagini/fiches.png"); 
		RegistrationFrame.setIconImage(fiches.getImage());
		
		// Creazione dei campi per username e password e verifica eta
		JLabel usernameLabel = new JLabel("Username:");
		usernameLabel.setBounds(20, 30, 100, 25);
		JTextField usernameField = new JTextField();
		usernameField.setBounds(140, 30, 120, 25);
		
		JLabel passwordLabel = new JLabel("Password:");
		passwordLabel.setBounds(20, 70, 100, 25);
		JPasswordField passwordField = new JPasswordField();
		passwordField.setBounds(140, 70, 120, 25);
		
		JCheckBox ageCheckBox = new JCheckBox("Confermo di avere almeno 18 anni");
		ageCheckBox.setBounds(20, 110, 300, 25);     
		
		// Pulsante di registraz
		JButton registratiButton2 = new JButton("Registrati");
		registratiButton2.setBounds(100, 150, 100, 40);
		
		// Disabilitare pulsante finché la casella di verifica non è selezionata
		registratiButton2.setEnabled(false);
		
		// Aggiunta di un listener alla casella di controllo
		ageCheckBox.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        if (ageCheckBox.isSelected()) {
		            registratiButton2.setEnabled(true);
		        } else {
		            registratiButton2.setEnabled(false);
		        }
		    }
		});
		
		

		
		
		registratiButton2.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                String username = usernameField.getText();
	                String password = new String(passwordField.getPassword());

	                // Chiamata al metodo che salva i dati nel database
	                if (MainController.registraUtente(username, password)) {
	                    JOptionPane.showMessageDialog(RegistrationFrame, "Registrazione completata!");
	                    RegistrationFrame.dispose();
	                } else {
	                    JOptionPane.showMessageDialog(RegistrationFrame, "Errore: username già esistente o problema tecnico.");
	                }
	            }
	        });
		
		
	
		// Aggiunta degli elementi alla finestra di registrazione
		RegistrationFrame.add(usernameLabel);
		RegistrationFrame.add(usernameField);
		RegistrationFrame.add(passwordLabel);
		RegistrationFrame.add(passwordField);
		RegistrationFrame.add(ageCheckBox);
		RegistrationFrame.add(registratiButton2);
		
		// Mostra la finestra di registrazione
		RegistrationFrame.setLocationRelativeTo(null); // Centrare la finestra
		RegistrationFrame.setVisible(true);
		RegistrationFrame.setResizable(false);
	}
	    
}