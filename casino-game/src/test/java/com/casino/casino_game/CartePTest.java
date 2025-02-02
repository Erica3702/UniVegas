package com.casino.casino_game;

import org.junit.Assert;
import org.junit.Test;

import com.casino.model.CarteP;



public class CartePTest {


    
    /**
     * Tests 
     */
    @Test
    public void basics() {
        CarteP card = new CarteP(CarteP.DIECI, CarteP.CUORI);
        Assert.assertNotNull(card);
        Assert.assertEquals(CarteP.DIECI, card.getRank());
        Assert.assertEquals(CarteP.CUORI, card.getSuit());
        Assert.assertEquals("Tc", card.toString());
        card = new CarteP("   Ap "); // Automatic trimming.
        Assert.assertNotNull(card);
        Assert.assertEquals(CarteP.ASSO, card.getRank());
        Assert.assertEquals(CarteP.PICCHE, card.getSuit());
        Assert.assertEquals("Ap", card.toString());
    }
    
    /**
     * Test costruttore
     */
    @Test
    public void testConstructors() {
        @SuppressWarnings("unused")
        CarteP card = null;
        
        // rango corto
        try {
            card = new CarteP(-1, 0);
            Assert.fail("No exception thrown");
        } catch (IllegalArgumentException e) {
            // OK.
        }

        // rango lungo
        try {
            card = new CarteP(CarteP.NO_OF_RANKS, 0);
            Assert.fail("No exception thrown");
        } catch (IllegalArgumentException e) {
            // OK.
        }

        // seme corto
        try {
            card = new CarteP(0, -1);
            Assert.fail("No exception thrown");
        } catch (IllegalArgumentException e) {
            // OK.
        }
        
        // seme alto
        try {
            card = new CarteP(0, CarteP.NO_OF_SUITS);
            Assert.fail("No exception thrown");
        } catch (IllegalArgumentException e) {
            // OK.
        }
        
        // Null string
        try {
            card = new CarteP(null);
            Assert.fail("No exception thrown");
        } catch (IllegalArgumentException e) {
            // OK.
        }
        
        // Empty string
        try {
            card = new CarteP("");
            Assert.fail("No exception thrown");
        } catch (IllegalArgumentException e) {
            // OK.
        }
        
        // String corta
        try {
            card = new CarteP("A");
            Assert.fail("No exception thrown");
        } catch (IllegalArgumentException e) {
            // OK.
        }
        
        // String lunga
        try {
            card = new CarteP("Acx");
            Assert.fail("No exception thrown");
        } catch (IllegalArgumentException e) {
            // OK.
        }
        
        // rango sconosciuto
        try {
            card = new CarteP("xc");
            Assert.fail("No exception thrown");
        } catch (IllegalArgumentException e) {
            // OK.
        }
        
        // rango sconosciuto
        try {
            card = new CarteP("xc");
            Assert.fail("No exception thrown");
        } catch (IllegalArgumentException e) {
            // OK.
        }
        
        // seme sconosciuto
        try {
            card = new CarteP("Ax");
            Assert.fail("No exception thrown");
        } catch (IllegalArgumentException e) {
            // OK.
        }
    }
    
    /**
     * Tests ordine carte
     */
    @Test
    public void sortOrder() {
        // quadri e basso, fiori e alto.
    	CarteP _2q = new CarteP("2q");
    	CarteP _3q = new CarteP("3q");
    	CarteP _2f = new CarteP("2f");
    	CarteP _3f = new CarteP("3f");
        Assert.assertEquals(_2q, _2q);
        Assert.assertFalse(_2q.equals(_3q));
        Assert.assertFalse(_2q.equals(_2f));
        Assert.assertEquals(0, _2q.hashCode());
        Assert.assertEquals(1, _2f.hashCode());
        Assert.assertEquals(4, _3q.hashCode());
        Assert.assertEquals(5, _3f.hashCode());
        Assert.assertTrue(_2q.compareTo(_2q) == 0);
        Assert.assertTrue(_2q.compareTo(_3q) < 0);
        Assert.assertTrue(_3q.compareTo(_2q) > 0);
        Assert.assertTrue(_2q.compareTo(_2f) < 0);
        Assert.assertTrue(_2f.compareTo(_2q) > 0);
    }

}
