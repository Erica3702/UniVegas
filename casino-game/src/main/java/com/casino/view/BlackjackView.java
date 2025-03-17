package com.casino.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import com.casino.model.BlackjackModel;
import com.casino.model.Card;

public class BlackjackView {
    private JFrame frame;
    private JPanel gamePanel;
    private JPanel buttonPanel;
    private JButton hitButton;
    private JButton stayButton;
    private JButton nextGameButton;
    private JButton exitToMenuButton;
    private BlackjackModel model;

    public BlackjackView(BlackjackModel model) {
        this.model = model;

        frame = new JFrame("Blackjack");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(1100,750);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);



        gamePanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                drawGame(g);
            }
        };
        gamePanel.setBackground(new Color(53, 101, 77));
        frame.add(gamePanel);

        buttonPanel = new JPanel();
        hitButton = new JButton("Hit");
        stayButton = new JButton("Stay");
        nextGameButton = new JButton("Nuova Partita");
        exitToMenuButton = new JButton("Torna al Menu");
        nextGameButton.setEnabled(false);
        exitToMenuButton.setEnabled(true);
        buttonPanel.add(hitButton);
        buttonPanel.add(stayButton);
        buttonPanel.add(nextGameButton);
        buttonPanel.add(exitToMenuButton);
        frame.add(buttonPanel, BorderLayout.SOUTH);

        frame.setVisible(true);
    }

    private void drawGame(Graphics g) {
        try {
            // Draw dealer's hand
            int x = 20;
            int y = 20;

            // Se la prima carta è nascosta, disegna il retro della carta
            if (model.isDealerCardHidden()) {
                Image hiddenCardImg = new ImageIcon(getClass().getResource("/cards/BACK.png")).getImage();
                g.drawImage(hiddenCardImg, x, y, 110, 154, null);
                x += 115;

                // Disegna solo la seconda carta del dealer
                if (model.getDealer().getHand().size() > 1) {
                    Card card = model.getDealer().getHand().get(1);
                    Image cardImg = new ImageIcon(getClass().getResource(card.getImagePath())).getImage();
                    g.drawImage(cardImg, x, y, 110, 154, null);
                }
            } else {
                // Se la prima carta è visibile, disegna tutte le carte del dealer
                for (Card card : model.getDealer().getHand()) {
                    Image cardImg = new ImageIcon(getClass().getResource(card.getImagePath())).getImage();
                    g.drawImage(cardImg, x, y, 110, 154, null);
                    x += 115;
                }
            }

            // Draw player's hand
            x = 20;
            y = 320;
            for (Card card : model.getPlayer().getHand()) {
                Image cardImg = new ImageIcon(getClass().getResource(card.getImagePath())).getImage();
                g.drawImage(cardImg, x, y, 110, 154, null);
                x += 115;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    

    public void updateView() {
        gamePanel.repaint();
    }

    public void disableHitButton() {
        hitButton.setEnabled(false);
    }

    public void disableButtons() {
        hitButton.setEnabled(false);
        stayButton.setEnabled(false);
    }

    public void enableNextGameButton() {
        nextGameButton.setEnabled(true); // Abilita il pulsante "Next Game"
    }

    public void showResult(String message) {
        JOptionPane.showMessageDialog(frame, message);
    }

    public void setHitButtonListener(ActionListener listener) {
        hitButton.addActionListener(listener);
    }

    public void setStayButtonListener(ActionListener listener) {
        stayButton.addActionListener(listener);
    }

    public void setNextGameButtonListener(ActionListener listener) {
        nextGameButton.addActionListener(listener); // Aggiungi listener per "Next Game"
    }

    public void setExitToMenuButtonListener(ActionListener listener) {
        exitToMenuButton.addActionListener(listener); // Aggiungi listener per "Exit to Menu"
    }

    public void close() {
        frame.dispose(); // Chiudi la finestra del gioco
    }
}
