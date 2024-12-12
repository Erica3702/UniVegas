package com.casino.casino_game;


import com.casino.utils.DBConnection;
import org.sqlite.core.DB;
import java.sql.Connection;

public class App {
    // Attributo della classe DBConnection
    private static DBConnection db;

    public static void main(String[] args) {
        // Crea un'istanza della classe DBConnection
        db = new DBConnection();
        
        // Chiamata al metodo connect()
        Connection connection = db.connect();

        // Verifica la connessione
        if (connection != null) {
          System.out.println("Database connection established successfully!");
        } else {
          System.out.println("Failed to establish database connection.");
        }
        
        db.testQuery();
    }
}
