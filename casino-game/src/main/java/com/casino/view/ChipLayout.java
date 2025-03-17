package com.casino.view;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.LayoutManager;

public class ChipLayout implements LayoutManager {
    private int xOffset = 1;
    private int yOffset = 4; // Spostamento verticale tra le fiches

    @Override
    public void addLayoutComponent(String name, Component comp) {	
    }

    @Override
    public void removeLayoutComponent(Component comp) {

    }

    @Override
    public Dimension preferredLayoutSize(Container parent) {
        return new Dimension(100, 100);
    }

    @Override
    public Dimension minimumLayoutSize(Container parent) {
        return new Dimension(50, 50);
    }

    @Override
    public void layoutContainer(Container parent) {
        int x = 10;
        int y = 0;
        int scaleFactor = 0; // Fattore di riduzione delle dimensioni

        for (Component comp : parent.getComponents()) {
            int width = comp.getPreferredSize().width - scaleFactor;
            int height = comp.getPreferredSize().height - scaleFactor;
            comp.setBounds(x, y, width, height);
            x += xOffset;
            y += yOffset;
            scaleFactor += 2; // Riduce dimensioni per ogni fiche aggiunta
        }
    }
}