package com.casino.utils;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;

public class DBConnectionTest {

    private DBConnection dbConnection;

    @Before
    public void setUp() {
        // Ottieni l'istanza Singleton di DBConnection
        dbConnection = DBConnection.getInstance();
    }

    @Test
    public void testSingletonInstance() {
        // Verifica che ci sia una sola istanza di DBConnection
        DBConnection anotherInstance = DBConnection.getInstance();
        assertSame("Le istanze di DBConnection devono essere la stessa", dbConnection, anotherInstance);
    }

    @Test
    public void testConnectionIsNotNull() {
        // Verifica che la connessione non sia null
        Connection connection = dbConnection.getConnection();
        assertNotNull("La connessione al database non deve essere null", connection);
    }

    @Test
    public void testConnectionIsValid() {
        // Verifica che la connessione sia valida
        Connection connection = dbConnection.getConnection();
        try {
            assertFalse("La connessione non deve essere chiusa", connection.isClosed());
            assertTrue("La connessione deve essere valida", connection.isValid(5)); // Timeout di 5 secondi
        } catch (SQLException e) {
            fail("Errore durante la verifica della connessione: " + e.getMessage());
        }
    }
}