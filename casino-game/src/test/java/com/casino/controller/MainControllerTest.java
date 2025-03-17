package com.casino.controller;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class MainControllerTest {

    @Before
    public void setUp() {
        MainController.registraUtente("testUser", "testPass");
    }

    @Test
    public void testVerificaUtente_CredenzialiCorrette() {
        boolean risultato = MainController.verificaUtente("testUser", "testPass");
        assertTrue("Le credenziali dovrebbero essere corrette", risultato);
    }

    @Test
    public void testVerificaUtente_CredenzialiErrate() {
        boolean risultato = MainController.verificaUtente("testUser", "passwordErrata");
        assertFalse("Le credenziali dovrebbero essere errate", risultato);
    }

    @Test
    public void testVerificaUtente_UtenteNonEsistente() {
        // Test con un utente che non esiste nel database
        boolean risultato = MainController.verificaUtente("utenteInesistente", "passwordErrata");
        assertFalse("L'utente non dovrebbe esistere nel database", risultato);
    }
}