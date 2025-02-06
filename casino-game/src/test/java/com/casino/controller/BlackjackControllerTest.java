package com.casino.controller;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import com.casino.model.BlackjackModel;
import com.casino.view.BlackjackView;

public class BlackjackControllerTest {

    private BlackjackController controller;
    private BlackjackModel model;
    private BlackjackView view;

    @Before
    public void setUp() {
        model = new BlackjackModel();
        view = new BlackjackView(model);
        controller = new BlackjackController(model, view);
    }

    @Test
    public void testHit() {
        int initialPlayerHandSize = model.getPlayer().getHand().size();
        controller.hit();
        assertEquals(initialPlayerHandSize + 1, model.getPlayer().getHand().size());
    }

    @Test
    public void testDetermineResult() {
        String result = controller.determineResult();
        assertTrue(result.equals("Hai Perso!") || result.equals("Hai Vinto!") || result.equals("Pareggio!"));
    }
}