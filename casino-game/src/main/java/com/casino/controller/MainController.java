package com.casino.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MainController {

    private static final Logger logger = LogManager.getLogger(MainController.class);

    // Costruttore privato per impedire l'istanziazione
    private MainController() {
        throw new UnsupportedOperationException("Questa classe non può essere istanziata.");
    }
    
    /**
     * Metodo per controllare se username e password sono nel database.
     * @param username inserito
     * @param password inserita
     * @return true se è presente, altrimenti false
     */
    public static boolean verificaUtente(String username, String password) {
        String url = "jdbc:sqlite:src/main/resources/database/casino.db";
        String query = "SELECT COUNT(*) FROM utenti WHERE username = ? AND password = ?";

        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, username);
            pstmt.setString(2, password);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    int count = rs.getInt(1);
                    return count > 0; // Restituisce true se l'utente esiste
                }
            }
        } catch (SQLException e) {
            logger.error("Errore durante la verifica dell'utente: {}", e.getMessage());
        }
        return false; // Se c'è un errore o l'utente non esiste
    }

    /**
     * Metodo per registrare nel database un nuovo utente.
     * @param username inserito
     * @param password inserita
     * @return true se la registrazione è riuscita, altrimenti false
     */
    public static boolean registraUtente(String username, String password) {
        String query = "INSERT INTO Utenti (username, password) VALUES (?, ?)";

        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:src/main/resources/database/casino.db");
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, username);
            pstmt.setString(2, password);

            // Esegui l'insert
            pstmt.executeUpdate();
            logger.info("Utente registrato con successo: {}", username);
            return true; // Registrazione riuscita
        } catch (Exception e) {
            logger.error("Errore durante la registrazione: {}", e.getMessage());
            return false; // Registrazione fallita
        }
    }
}