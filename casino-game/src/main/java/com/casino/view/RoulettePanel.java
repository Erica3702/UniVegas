package com.casino.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.Serializable;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

import com.casino.model.RouletteModel;

public class RoulettePanel extends JPanel implements Serializable {
    private static final long serialVersionUID = 1L; // Aggiungi un UID per la serializzazione

    private transient Timer ballAnimationTimer; // Timer per l'animazione della pallina
    private double ballAngle = 270; // Angolo iniziale della pallina
    private double ballSpeed; // Velocità della pallina
    private transient Image wheelImage; // Immagine della ruota (non ridimensionata)
    private final transient RouletteModel model; // Riferimento al modello
    private int currentRadius; // Raggio corrente della traiettoria
    private final int maxRadius; // Raggio iniziale
    private final transient RouletteView rouletteView;
    
    Random random = new Random();

	

    public RoulettePanel(RouletteModel model, RouletteView rouletteView) {
        this.model = model;
        this.rouletteView = rouletteView; // Inizializza il riferimento
        
        ImageIcon wheelIcon = new ImageIcon("src/main/resources/immagini/ruota.png");
        wheelImage = wheelIcon.getImage();
        this.maxRadius = wheelImage.getWidth(null) / 2 - 30;
        this.currentRadius = maxRadius;
    }

    /**
     * Avvia l'animazione della pallina assegnando una velocita casuale
     */
    public void startBallAnimation() {
        if (ballAnimationTimer != null && ballAnimationTimer.isRunning()) {
            ballAnimationTimer.stop();
        }

        ballSpeed = (random.nextInt(21) + 60); // Cast a double

        ballAnimationTimer = new Timer(50, e -> animateBall()); // Timer per l'animazione
        currentRadius = wheelImage.getWidth(null) / 2 - 30;
        ballAnimationTimer.start();
    }

    /**
     * Diminuisce gradualmente la velocita e il raggio e quando si ferma determina il numero vincente sulla base dell'angolo in cui si trova
     */
    private void animateBall() {
        if (ballSpeed > 0.1) {
            ballSpeed *= 0.965;
        } else {
            ballSpeed = 0.4;
            ballAnimationTimer.stop();

            int winningNumber = model.getWinningNumber(ballAngle);
            RouletteView.showResultDialog(winningNumber, model, rouletteView);
        }
        if (currentRadius > wheelImage.getWidth(null) / 4 - 15) {
            currentRadius -= 1;
        }

        ballAngle += ballSpeed;
        if (ballAngle >= 360) {
            ballAngle -= 360; // Mantieni l'angolo tra 0 e 360 gradi
        }
        repaint();
    }

    /**
     * Centra l'immagine della ruota nel pannello e la disegna, disegna la pallina nella posizione corretta
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        int centerX = getWidth() / 2;
        int centerY = getHeight() / 2;

        g2d.drawImage(wheelImage, centerX - wheelImage.getWidth(null) / 2, centerY - wheelImage.getHeight(null) / 2, this);

        int ballX = centerX + (int) (currentRadius * Math.cos(Math.toRadians(ballAngle)));
        int ballY = centerY + (int) (currentRadius * Math.sin(Math.toRadians(ballAngle)));

        g2d.setColor(Color.WHITE);
        g2d.fillOval(ballX - 6, ballY - 6, 12, 12);
    }
}