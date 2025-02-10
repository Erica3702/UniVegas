package com.casino.view;

import javax.swing.*;

import com.casino.model.RouletteModel;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChipPlacer implements ActionListener {
    private final JButton button;
    private JLabel chipLabel;
    private final RouletteModel model;

    public ChipPlacer(JButton button, RouletteModel model, ImageIcon chipIcon) {
        this.button = button;
        this.model = model;
        this.chipLabel = new JLabel(chipIcon);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        button.add(chipLabel, BorderLayout.CENTER);
        button.repaint();
        button.revalidate();

        
        int tokens = model.isSpecialBet(button.getText()) ? 20 : 5;
        model.buttonTokens.put(button, model.buttonTokens.getOrDefault(button, 0) + 1); 
        
        BettingPanel.totalBet += tokens;
        BettingPanel.updateTotalBetLabel();
    }
}