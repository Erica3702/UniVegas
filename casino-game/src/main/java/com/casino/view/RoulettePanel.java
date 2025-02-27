package com.casino.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

import com.casino.model.RouletteModel;

public class RoulettePanel extends JPanel {
    private double angle; // Angolo di rotazione della ruota
    private Timer ballAnimationTimer; // Timer per l'animazione della pallina
    private double ballAngle = 270; // Angolo iniziale della pallina
    private double ballSpeed; // Velocità della pallina
    private int radius; // Raggio della traiettoria della pallina
    private Image wheelImage; // Immagine della ruota (non ridimensionata)
    private final RouletteModel model; // Riferimento al modello
    private int currentRadius; // Raggio corrente della traiettoria
    private final int maxRadius; // Raggio massimo (iniziale)

    public RoulettePanel(RouletteModel model) {
        this.model = model;
        ImageIcon wheelIcon = new ImageIcon("src/main/resources/immagini/ruota.png");
        wheelImage = wheelIcon.getImage();
       
        this.maxRadius = wheelImage.getWidth(null) / 2 - 30; // Raggio massimo
        this.currentRadius = maxRadius;
    }


    //Avvia animazione pallina
    public void startBallAnimation() {
        if (ballAnimationTimer != null && ballAnimationTimer.isRunning()) {
            ballAnimationTimer.stop();
        }

        angle = 0; // Resetta l'angolo di rotazione
        Random random = new Random();
        ballSpeed = random.nextInt(21)+60;

        ballAnimationTimer = new Timer(50, e -> animateBall()); // Timer per l'animazione
    	currentRadius = wheelImage.getWidth(null) / 2 - 30;
        ballAnimationTimer.start();
    }



    private void animateBall() {
    	if (ballSpeed > 0.1) {
            ballSpeed *= 0.965; // Riduce gradualmente la velocità della pallina
        } else {
            ballSpeed = 0.4; // Velocità finale molto bassa
            ballAnimationTimer.stop(); // Ferma l'animazione

            // Determina il numero vincente e mostra il risultato
            int winningNumber = model.getWinningNumber(ballAngle);
            RouletteView.showResultDialog(winningNumber, model);
           
        }
        // Riduci il raggio gradualmente
        if (currentRadius > wheelImage.getWidth(null) / 4 - 15) { // Fermati a un raggio minimo
            currentRadius -= 1; // Riduci il raggio di x unità per frame
        }

        // Aggiorna l'angolo della pallina
        ballAngle += ballSpeed;
        if (ballAngle >= 360) {
            ballAngle -= 360; // Mantieni l'angolo tra 0 e 360 gradi
        }

        repaint(); // Ridisegna il pannello
    }



    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        // Centra l'immagine della ruota nel pannello
        int centerX = getWidth() / 2;
        int centerY = getHeight() / 2;

        // Disegna l'immagine della ruota
        g2d.drawImage(wheelImage, centerX - wheelImage.getWidth(null) / 2, centerY - wheelImage.getHeight(null) / 2, this);

        // Calcola la posizione della pallina in base al raggio corrente
        int ballX = centerX + (int) (currentRadius * Math.cos(Math.toRadians(ballAngle)));
        int ballY = centerY + (int) (currentRadius * Math.sin(Math.toRadians(ballAngle)));

        // Disegna la pallina
        g2d.setColor(Color.WHITE);
        g2d.fillOval(ballX - 6, ballY - 6, 12, 12); // Dimensioni della pallina
    }
}