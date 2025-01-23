package com.casino.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MainController {

	
	
	
	//metodo per controllare se username e pw sono nel db
    public static boolean verificaUtente(String username, String password) {
      String url = "jdbc:sqlite:src/main/resources/database/casino.db"; 
      String query = "SELECT COUNT(*) FROM utenti WHERE username = ? AND password = ?";

      try (Connection conn = DriverManager.getConnection(url);
           PreparedStatement pstmt = conn.prepareStatement(query)) {

          // Imposta i parametri nella query
          pstmt.setString(1, username);
          pstmt.setString(2, password);

          // Esegui la query
          try (ResultSet rs = pstmt.executeQuery()) {
              if (rs.next()) {
                  int count = rs.getInt(1);
                  return count > 0; // Restituisce true se l'utente esiste
              }
          }
      } catch (SQLException e) {
          System.out.println("Errore durante la verifica dell'utente: " + e.getMessage());
      }

      return false; // Se c'è un errore o l'utente non esiste
  }
    
    
    
 // Metodo per registrare nel db un nuovo utente
 	public static boolean registraUtente(String username, String password) {
 	        String query = "INSERT INTO Utenti (username, password) VALUES (?, ?)";
 	
 	        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:src/main/resources/database/casino.db");
 	             PreparedStatement pstmt = conn.prepareStatement(query)) {
 	
 	            // Imposta i parametri
 	            pstmt.setString(1, username);
 	            pstmt.setString(2, password);
 	
 	            // Esegui l'insert
 	            pstmt.executeUpdate();
 	            return true; // Registrazione riuscita
 	        } catch (Exception e) {
 	            System.err.println("Errore durante la registrazione: " + e.getMessage());
 	            return false; // Registrazione fallita
 	        }
 	}
    
    
}
