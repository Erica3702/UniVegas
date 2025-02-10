package com.casino.view;

import com.casino.controller.RouletteController;
import com.casino.model.RouletteModel;

import javax.swing.*;
import java.awt.*;

public class RouletteView extends JFrame {
    private final RoulettePanel roulettePanel;
    private final BettingPanel bettingPanel;
    private final RouletteController controller;
    private final RouletteModel model;

    public RouletteView(RouletteController controller, RouletteModel model) {
        this.controller = controller;
        this.model = model;

        setTitle("Roulette Game");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
  
        
        roulettePanel = new RoulettePanel(model);
        bettingPanel = new BettingPanel(model,roulettePanel);

        setLayout(new BorderLayout());
        add(roulettePanel, BorderLayout.WEST);
        add(bettingPanel, BorderLayout.CENTER);

        setVisible(true);
    }
}