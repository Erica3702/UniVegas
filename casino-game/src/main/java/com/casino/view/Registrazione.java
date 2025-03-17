package com.casino.view;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import com.casino.controller.MainController;


public class Registrazione {
	
	   // Costruttore privato per impedire l'istanziazione
 private Registrazione() {
     throw new UnsupportedOperationException("Questa classe non può essere istanziata.");
 }
	
	
	/**
	 * Creazione della schermata di registrazione
	 */
	public static void showRegisrationFrame() {

	JFrame registrationFrame = new JFrame("Registrati");
	registrationFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE); 
	registrationFrame.setSize(300, 250);
	registrationFrame.setLayout(null);

	ImageIcon fiches = new ImageIcon("src/main/resources/immagini/fiches.png");
	registrationFrame.setIconImage(fiches.getImage());

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

	JButton registratiButton2 = new JButton("Registrati");
	registratiButton2.setBounds(100, 150, 100, 40);
	registratiButton2.setEnabled(false); // Disabilitare pulsante 

	ageCheckBox.addActionListener(e -> 
    registratiButton2.setEnabled(ageCheckBox.isSelected())
);





	registratiButton2.addActionListener(e -> {
	    String username = usernameField.getText();
	    String password = new String(passwordField.getPassword());

	    // Validazione della lunghezza di username e password
	    if (username.length() < 4 || password.length() < 4) {
	        JOptionPane.showMessageDialog(registrationFrame, 
	            "Errore: username e password devono contenere almeno 4 caratteri.",
	            "Errore di validazione", 
	            JOptionPane.ERROR_MESSAGE);
	        return; // Interrompe l'esecuzione se la validazione fallisce
	    }

	    // Chiamata al metodo che salva i dati nel database
	    if (MainController.registraUtente(username, password)) {
	        JOptionPane.showMessageDialog(registrationFrame, 
	            "Registrazione completata!", 
	            "Successo", 
	            JOptionPane.INFORMATION_MESSAGE);
	        registrationFrame.dispose();
	    } else {
	        JOptionPane.showMessageDialog(registrationFrame, 
	            "Errore: username già esistente o problema tecnico.", 
	            "Errore", 
	            JOptionPane.ERROR_MESSAGE);
	    }
	});



		// Aggiunta degli elementi alla finestra di registrazione
		registrationFrame.add(usernameLabel);
		registrationFrame.add(usernameField);
		registrationFrame.add(passwordLabel);
		registrationFrame.add(passwordField);
		registrationFrame.add(ageCheckBox);
		registrationFrame.add(registratiButton2);

		// Mostra la finestra di registrazione
		registrationFrame.setLocationRelativeTo(null); // Centrare la finestra
		registrationFrame.setVisible(true);
		registrationFrame.setResizable(false);
	}

}