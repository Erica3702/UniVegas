package com.casino.model;

import org.junit.Before;
import org.junit.Test;
import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class PointsCalculatorTest {

    private RouletteModel model;
    private PointsCalculator pointsCalculator;
    private Map<JButton, Integer> buttonTokens;

    @Before
    public void setUp() {
        model = new RouletteModel();
        pointsCalculator = new PointsCalculator();
        buttonTokens = new HashMap<>();
    }

    @Test
    public void testCalculatePoints_SingleNumberWin() {
        JButton button = new JButton("17");
        buttonTokens.put(button, 1);

        model.setWinningNumber(17);

        int points = PointsCalculator.calculatePoints(model, buttonTokens);
        assertEquals(180, points); 
    }

    @Test
    public void testCalculatePoints_SingleNumberLoss() {
        JButton button = new JButton("17");
        buttonTokens.put(button, 1);

        model.setWinningNumber(5);

        int points = PointsCalculator.calculatePoints(model, buttonTokens);
        assertEquals(-5, points); 
    }

    @Test
    public void testCalculatePoints_RedWin() {
        JButton button = new JButton("RED");
        buttonTokens.put(button, 1);

        model.setWinningNumber(1); // 1 è un numero rosso

        int points = PointsCalculator.calculatePoints(model, buttonTokens);
        assertEquals(40, points); 
    }

    @Test
    public void testCalculatePoints_BlackWin() {
        JButton button = new JButton("BLACK");
        buttonTokens.put(button, 1);

        model.setWinningNumber(2); // 2 è un numero nero

        int points = PointsCalculator.calculatePoints(model, buttonTokens);
        assertEquals(40, points); 
    }

    @Test
    public void testCalculatePoints_EvenWin() {
        JButton button = new JButton("EVEN");
        buttonTokens.put(button, 1);

        model.setWinningNumber(4); 

        int points = PointsCalculator.calculatePoints(model, buttonTokens);
        assertEquals(40, points); 
    }

    @Test
    public void testCalculatePoints_OddWin() {
        JButton button = new JButton("ODD");
        buttonTokens.put(button, 1);

        model.setWinningNumber(3); 

        int points = PointsCalculator.calculatePoints(model, buttonTokens);
        assertEquals(40, points); 
    }

    @Test
    public void testCalculatePoints_MultipleBetsMixedResults() {
        JButton button1 = new JButton("17");
        JButton button2 = new JButton("RED");
        JButton button3 = new JButton("EVEN");

        buttonTokens.put(button1, 1);
        buttonTokens.put(button2, 1);
        buttonTokens.put(button3, 1);

        model.setWinningNumber(17); // 17 è nero e dispari

        int points = PointsCalculator.calculatePoints(model, buttonTokens);
        int expectedPoints = 180 - 20 - 20;
        assertEquals(expectedPoints, points); // Verifica il calcolo dei punti
    }
}