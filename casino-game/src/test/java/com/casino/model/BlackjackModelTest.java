package com.casino.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class BlackjackModelTest {

    private BlackjackModel model;

    @Before
    public void setUp() {
        model = new BlackjackModel();
    }

    @Test
    public void testStartGame() {
        model.startGame();
        assertNotNull(model.getDeck());
        assertNotNull(model.getDealer());
        assertNotNull(model.getPlayer());
        assertEquals(2, model.getDealer().getHand().size());
        assertEquals(2, model.getPlayer().getHand().size());
        assertTrue(model.isDealerCardHidden());
    }

    @Test
    public void testRevealDealerCard() {
        model.revealDealerCard();
        assertFalse(model.isDealerCardHidden());
    }

    @Test
    public void testDealerDrawCard() {
        int initialSize = model.getDealer().getHand().size();
        model.getDealer().addCard(model.getDeck().drawCard());
        assertEquals(initialSize + 1, model.getDealer().getHand().size());
    }


    @Test
    public void testPlayerDrawCard() {
        int initialSize = model.getPlayer().getHand().size();
        model.getPlayer().addCard(model.getDeck().drawCard());
        assertEquals(initialSize + 1, model.getPlayer().getHand().size());
    }

}