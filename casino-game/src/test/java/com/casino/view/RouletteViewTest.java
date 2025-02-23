package com.casino.view;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;

import org.junit.Before;
import org.junit.Test;

import com.casino.model.RouletteModel;

public class RouletteViewTest {

	private RouletteModel model;
    private Map<JButton, Integer> buttonTokens;

    @Before
    public void setUp() {
        model = new RouletteModel();
        buttonTokens = new HashMap<>();
        RouletteView.buttonTokens = buttonTokens;
    }

    @Test
    public void testCalculatePoints_WinningNumber() {

    	model.setWinningNumber(7);  // Numero vincente impostato a 7

        JButton btn7 = new JButton("7");	 // Bottone con scommessa diretta sul numero 7
        buttonTokens.put(btn7, 1); // 1 token da 5 crediti

        int points = RouletteView.calculatePoints(model);

        assertEquals(180, points);  // Calcolo atteso: 1 * 5 * 35 + 1 * 5 = 180
    }


    @Test
    public void testCalculatePoints_LosingNumber() {
        model.setWinningNumber(10); // Numero vincente è 10

        JButton btn7 = new JButton("7");
        buttonTokens.put(btn7, 2); // Scommettiamo 2 token su 7 (perdita)

        int points = RouletteView.calculatePoints(model);

        assertEquals(-10, points);
    }


    @Test
    public void testCalculatePoints_RedWin() {
        model.setWinningNumber(3); // il 3 è rosso

        JButton redButton = new JButton("RED");
        buttonTokens.put(redButton, 1); // Scommessa di 1 token su RED

        int points = RouletteView.calculatePoints(model);

        assertEquals(40, points);
    }


    @Test
    public void testCalculatePoints_BlackLose() {
        model.setWinningNumber(3); // Supponiamo che il 3 sia rosso

        JButton blackButton = new JButton("BLACK");
        buttonTokens.put(blackButton, 2); // Scommessa di 2 token su BLACK (perdita)

        int points = RouletteView.calculatePoints(model);

        assertEquals(-40, points);
    }

}