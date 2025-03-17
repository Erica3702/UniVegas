package com.casino.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.casino.utils.DBConnection;

public class UserDAO {

    private static final Logger logger = LogManager.getLogger(UserDAO.class);

    // istanza Singleton di DBConnection
    private DBConnection dbConnection;

    public UserDAO() {  
        this.dbConnection = DBConnection.getInstance();   // Utilizza l'istanza Singleton di DBConnection
    }

    /**
     * Metodo per verificare le credenziali di un utente
     */
    public boolean verificaUtente(String username, String password) {
        String query = "SELECT COUNT(*) FROM utenti WHERE username = ? AND password = ?";

        try (Connection conn = dbConnection.getConnection();
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
            logger.error("Errore durante la verifica dell'utente: ", e);
        }

        return false; // Se c'è un errore o l'utente non esiste
    }

    /**
     * Metodo per registrare un nuovo utente
     * @param username inserito
     * @param password inserita
     */
    public boolean registraUtente(String username, String password) {
        String query = "INSERT INTO utenti (username, password) VALUES (?, ?)";

        try (Connection conn = dbConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, username);
            pstmt.setString(2, password);

            pstmt.executeUpdate();
            return true; // Registrazione riuscita
        } catch (SQLException e) {
            logger.error("Errore durante la registrazione: ", e);
            return false; // Registrazione fallita
        }
    }
}