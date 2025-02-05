package com.casino.view;

import com.casino.model.RouletteModel;

import javax.swing.*;
import java.awt.*;

public class RoulettePanel extends JPanel {
    private double angle;
    private Timer ballAnimationTimer;
    private int ballAngle = 270;
    private double ballSpeed;
    private int radius;
    private Image resizedImage;
    private RouletteModel model;

    public RoulettePanel(RouletteModel model) {
        this.model = model;
        ImageIcon wheelImage = new ImageIcon("src/main/resources/immagini/roulette.png");
        int newWidth = wheelImage.getIconWidth() * 2;
        int newHeight = wheelImage.getIconHeight() * 2;
        resizedImage = wheelImage.getImage().getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
        radius = newWidth / 11;
    }

    public void startBallAnimation() {
        if (ballAnimationTimer != null && ballAnimationTimer.isRunning()) {
            ballAnimationTimer.stop();
        }
        angle = 0;
        ballSpeed = 39;
        ballAnimationTimer = new Timer(50, e -> animateBall());
        ballAnimationTimer.start();
    }

    private void animateBall() {
        if (ballSpeed > 0.1) {
            ballSpeed *= 0.96;
        } else {
            ballSpeed = 0.5;
            ballAnimationTimer.stop();
            int winningNumber = model.getWinningNumber(ballAngle);
            RouletteView.showResultDialog(winningNumber, model);
        }

        ballAngle += ballSpeed;
        if (ballAngle >= 360) {
            ballAngle -= 360;
        }
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        int centerX = getWidth() / 2;
        int centerY = getHeight() / 2;
        g2d.rotate(Math.toRadians(angle), centerX, centerY);
        g2d.drawImage(resizedImage, centerX - resizedImage.getWidth(null) / 2, centerY - resizedImage.getHeight(null) / 2, this);
        int ballX = centerX + (int) (radius * Math.cos(Math.toRadians(ballAngle)));
        int ballY = centerY + (int) (radius * Math.sin(Math.toRadians(ballAngle)));
        g2d.setColor(Color.WHITE);
        g2d.fillOval(ballX - 5, ballY - 5, 10, 10);
    }
}