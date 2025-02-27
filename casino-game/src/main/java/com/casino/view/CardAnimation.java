package com.casino.view;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.AffineTransform;
import javax.swing.JPanel;

public class CardAnimation extends JPanel {
    private int cardX; // Posizione X della carta
    private int cardY; // Posizione Y della carta
    private int targetX; // Posizione finale X della carta
    private int targetY; // Posizione finale Y della carta
    private Image cardImage; // Immagine della carta (fronte)
    private Image cardBackImage; // Immagine della carta (retro)
    private double rotationAngle = 0; // Angolo di rotazione della carta
    private boolean isFlipping = false; // Indica se la carta sta ruotando

    public CardAnimation(Image cardImage, Image cardBackImage, int startX, int startY, int targetX, int targetY) {
        this.cardImage = cardImage;
        this.cardBackImage = cardBackImage;
        this.cardX = startX;
        this.cardY = startY;
        this.targetX = targetX;
        this.targetY = targetY;
        setOpaque(false); // Rende il pannello trasparente
    }

    public void startAnimation() {
        new Thread(() -> {
            while (cardX < targetX || cardY < targetY || isFlipping) {
                // Aggiorna la posizione della carta
                if (cardX < targetX) cardX += 5; // Sposta la carta lungo l'asse X
                if (cardY < targetY) cardY += 5; // Sposta la carta lungo l'asse Y

                // Se la carta ha raggiunto la posizione finale, inizia la rotazione
                if (cardX >= targetX && cardY >= targetY && !isFlipping) {
                    isFlipping = true;
                }

                // Se la carta sta ruotando, aggiorna l'angolo di rotazione
                if (isFlipping) {
                    rotationAngle += Math.toRadians(5); // Aumenta l'angolo di rotazione
                    if (rotationAngle >= Math.PI * 2) { // Se la rotazione è completa (360 gradi)
                        rotationAngle = 0;
                        isFlipping = false;
                        break; // Termina l'animazione
                    }
                }

                // Ridisegna il pannello
                repaint();

                try {
                    Thread.sleep(20); // Ritardo per l'animazione
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        // Applica la rotazione alla carta
        AffineTransform transform = new AffineTransform();
        transform.translate(cardX + cardImage.getWidth(this) / 2.0, cardY + cardImage.getHeight(this) / 2.0);
        transform.rotate(rotationAngle);
        transform.translate(-cardImage.getWidth(this) / 2.0, -cardImage.getHeight(this) / 2.0);

        // Scegli l'immagine da disegnare in base all'angolo di rotazione
        Image currentImage = (rotationAngle < Math.PI / 2 || rotationAngle >= 3 * Math.PI / 2) ? cardImage : cardBackImage;

        // Disegna la carta ruotata
        g2d.drawImage(currentImage, transform, this);
    }
}