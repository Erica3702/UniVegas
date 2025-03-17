package com.casino.model;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import javax.swing.*;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class) // Abilita i test parametrici
public class PointsCalculatorTest {

    private RouletteModel model;
    private Map<JButton, Integer> buttonTokens;

    // Parametri per il test parametrico
    private final String buttonText;
    private final int winningNumber;
    private final int expectedPoints;

    public PointsCalculatorTest(String buttonText, int winningNumber, int expectedPoints) {
        this.buttonText = buttonText;
        this.winningNumber = winningNumber;
        this.expectedPoints = expectedPoints;
    }

    @Before
    public void setUp() {
        model = new RouletteModel();
        buttonTokens = new HashMap<>();
    }

    // Fornisce i dati per i test parametrici
    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
            {"17", 17, 180},       // Singolo numero vincente
            {"17", 5, -5},         // Singolo numero perdente
            {"RED", 1, 40},        // Rosso vincente
            {"BLACK", 2, 40},      // Nero vincente
            {"EVEN", 4, 40},       // Pari vincente
            {"ODD", 3, 40},        // Dispari vincente
        });
    }

    @Test
    public void testCalculatePoints() {
        JButton button = new JButton(buttonText);
        buttonTokens.put(button, 1);

        model.setWinningNumber(winningNumber);

        int points = PointsCalculator.calculatePoints(model, buttonTokens);
        assertEquals(expectedPoints, points);
    }
}