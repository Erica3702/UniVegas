package com.casino.controller;

import com.casino.model.RouletteModel;
import com.casino.view.RouletteView;

public class RouletteController {
    private RouletteModel model;
    private RouletteView view;

    public RouletteController() {
        this.model = new RouletteModel();
        this.view = new RouletteView(this, model);
    }

    public boolean isSpecialBet(String text) {
        return model.isSpecialBet(text);
    }

    public boolean isRed(int num) {
        return model.isRed(num);
    }

    public void startGame() {
        view.setVisible(true);
    }
}