package com.casino.view;

import com.casino.model.RouletteModel;

import javax.swing.*;
import java.awt.*;

public class RoulettePanel extends JPanel {
    private double angle; // Angolo di rotazione della ruota
    private Timer ballAnimationTimer; // Timer per l'animazione della pallina
    private int ballAngle = 270; // Angolo iniziale della pallina
    private double ballSpeed; // Velocità della pallina
    private int radius; // Raggio della traiettoria della pallina
    private Image resizedImage; // Immagine ridimensionata della roulette
    private final RouletteModel model; // Modello della roulette

    public RoulettePanel(RouletteModel model) {
        this.model = model;

        // Carica l'immagine della roulette e ridimensionala
        ImageIcon wheelImage = new ImageIcon("src/main/resources/immagini/roulette.png");
        int newWidth = wheelImage.getIconWidth() * 2;
        int newHeight = wheelImage.getIconHeight() * 2;
        resizedImage = wheelImage.getImage().getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);

        // Calcola il raggio della traiettoria della pallina
        radius = newWidth / 11;

        // Imposta il layout e aggiunge il pulsante "Torna al menu"
        setPreferredSize(new Dimension(Toolkit.getDefaultToolkit().getScreenSize().width / 2, getHeight()));
        setBackground(new Color(0, 100, 0));
        setLayout(new BorderLayout());

        JButton backToMenuButton = new JButton("Torna al menu");
        backToMenuButton.setFont(new Font("Arial", Font.BOLD, 14));
        backToMenuButton.setBackground(Color.DARK_GRAY);
        backToMenuButton.setForeground(Color.WHITE);
        backToMenuButton.addActionListener(e -> MenuGiochi.Start());

        add(backToMenuButton, BorderLayout.SOUTH);
        setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
    }

    /**
     * Avvia l'animazione della pallina.
     */
    public void startBallAnimation() {
        if (ballAnimationTimer != null && ballAnimationTimer.isRunning()) {
            ballAnimationTimer.stop();
        }
        angle = 0; // Resetta l'angolo di rotazione
        ballSpeed = 39; // Imposta la velocità iniziale della pallina
        ballAnimationTimer = new Timer(50, e -> animateBall()); // Crea un timer per l'animazione
        ballAnimationTimer.start(); // Avvia il timer
    }

    /**
     * Gestisce l'animazione della pallina.
     */
    private void animateBall() {
        if (ballSpeed > 0.1) {
            ballSpeed *= 0.96; // Riduce gradualmente la velocità della pallina
        } else {
            ballSpeed = 0.5; // Velocità minima per fermare la pallina
            ballAnimationTimer.stop(); // Ferma il timer

            // Ottiene il numero vincente in base all'angolo della pallina
            int winningNumber = model.getWinningNumber(ballAngle);
            ResultDialog.showResultDialog(winningNumber, model); // Mostra il risultato
        }

        // Aggiorna l'angolo della pallina
        ballAngle += ballSpeed;
        if (ballAngle >= 360) {
            ballAngle -= 360; // Mantiene l'angolo tra 0 e 360 gradi
        }

        repaint(); // Ridisegna il pannello
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        // Centra l'immagine della roulette
        int centerX = getWidth() / 2;
        int centerY = getHeight() / 2;

        // Ruota l'immagine della roulette
        g2d.rotate(Math.toRadians(angle), centerX, centerY);
        g2d.drawImage(resizedImage, centerX - resizedImage.getWidth(null) / 2, centerY - resizedImage.getHeight(null) / 2, this);

        // Calcola la posizione della pallina
        int ballX = centerX + (int) (radius * Math.cos(Math.toRadians(ballAngle)));
        int ballY = centerY + (int) (radius * Math.sin(Math.toRadians(ballAngle)));

        // Disegna la pallina
        g2d.setColor(Color.WHITE);
        g2d.fillOval(ballX - 5, ballY - 5, 10, 10);
    }
}