package com.casino.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChipPlacer implements ActionListener {
    private final RouletteView rouletteView;
    private final String buttonText;

    public ChipPlacer(RouletteView rouletteView, String buttonText) {
        this.rouletteView = rouletteView;
        this.buttonText = buttonText;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        rouletteView.handleButtonClick(buttonText);
    }
}