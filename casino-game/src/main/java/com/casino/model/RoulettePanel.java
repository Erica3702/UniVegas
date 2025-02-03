package com.casino.model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

import com.casino.view.TestRoulette;

public class RoulettePanel extends JPanel {
    private double angle; // Angolo di rotazione iniziale della pallina
    private Timer ballAnimationTimer;
    private static final int[] ROULETTE_NUMBERS = { 
        0, 32, 15, 4, 19, 21, 2, 25, 17, 34, 6, 27, 13, 36, 11, 30, 8, 23, 
        10, 5, 24, 16, 33, 1, 20, 14, 31, 9, 22, 18, 29, 7, 28, 12, 35, 3, 26 
    };

    private Image wheelImage;
    private int ballAngle = 270; // Angolo della pallina in gradi
    private double ballSpeed; // Velocità iniziale della pallina
    private int radius; // Raggio della pallina

    public RoulettePanel() {
        // Carica l'immagine della roulette
        wheelImage = new ImageIcon("src/main/resources/numeri roulette/ruota (4).png").getImage();
        // Calcola il raggio del cerchio di rotazione della pallina
        radius = wheelImage.getWidth(null) / 13;
    }

    public void startBallAnimation() {
        if (ballAnimationTimer != null && ballAnimationTimer.isRunning()) {
            ballAnimationTimer.stop();  // Ferma l'animazione precedente, se esistente
        }
        angle = 0;
        ballSpeed = 39; // Velocità iniziale (39 funziona)										//da aumentare

        // Avvia il timer per animare la pallina e la ruota
        ballAnimationTimer = new Timer(50, e -> animateBall());
        ballAnimationTimer.start();
    }

    public void animateBall() {
        if (ballSpeed > 0.1) {
            ballSpeed *= 0.96; // Rallenta più velocemente (da 0.99 a 0.95)
        } else {
            ballSpeed = 0; // Si ferma
            ballAnimationTimer.stop(); // Ferma il timer quando la pallina è ferma

            int winningNumber = getWinningNumber(ballAngle);
            showResultDialog(winningNumber); // Mostra il risultato immediatamente
        }

        // Aggiorna l'angolo della pallina
        ballAngle += ballSpeed;
        if (ballAngle >= 360) {
            ballAngle -= 360;
        }
        
        repaint(); // Ridisegna il pannello per aggiornare la pallina e la ruota
    }

    private int getWinningNumber(double finalAngle) {
        // Normalizza l'angolo tra 0 e 360
        double normalizedAngle = (finalAngle % 360 + 360) % 360;
        
        // Ogni numero sulla ruota occupa circa 360° / 37
        double sectorSize = 360.0 / 37;

        // Se la pallina parte da 270°, dobbiamo aggiungere 270° all'angolo
        // per allineare il numero 0 nella posizione corretta.
        double adjustedAngle = (normalizedAngle + 90) % 360;

        // Calcola l'indice del numero vincente
        int index = (int) (adjustedAngle / sectorSize);

        // Verifica che l'indice non esca dall'intervallo
        if (index >= ROULETTE_NUMBERS.length) {
            index = ROULETTE_NUMBERS.length - 1;
        }

        // Restituisce il numero vincente corrispondente all'indice
        return ROULETTE_NUMBERS[index];
    }



    private void showResultDialog(int winningNumber) {
        SwingUtilities.invokeLater(() -> {
            String message = "Il numero vincente è: " + winningNumber + "\nHai vinto: "  + " token!";
            JOptionPane.showMessageDialog(this, message, "Risultato Roulette", JOptionPane.INFORMATION_MESSAGE);
        });
    }

    private int calculateWinnings(int winningNumber) {
        
    	
    	
    	
    	// Aggiungi la logica per calcolare le vincite
        int winnings = 0;
        // Logica esempio: calcola le vincite in base alle scommesse fatte
        return winnings;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        // Disegna la ruota della roulette
        int centerX = getWidth() / 2;
        int centerY = getHeight() / 2;
        g2d.rotate(Math.toRadians(angle), centerX, centerY); // Ruota la ruota

        // Disegna l'immagine della ruota
        g2d.drawImage(wheelImage, centerX - wheelImage.getWidth(null) / 2, centerY - wheelImage.getHeight(null) / 2, this);

        // Calcola la posizione della pallina
        int ballX = centerX + (int) (radius * Math.cos(Math.toRadians(ballAngle)));
        int ballY = centerY + (int) (radius * Math.sin(Math.toRadians(ballAngle)));

        // Disegna la pallina
        g2d.setColor(Color.WHITE);
        g2d.fillOval(ballX - 5, ballY - 5, 10, 10);
    }
}
