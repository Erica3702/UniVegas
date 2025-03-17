package com.casino.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DBConnection {
	private static final Logger logger = LogManager.getLogger(DBConnection.class);

	private static DBConnection instance;
	
	private static final String URL = "jdbc:sqlite:src/main/resources/database/casino.db"; // database in memoria

	private Connection connection;
	
	// Costruttore privato per impedire la creazione di istanze esterne
    private DBConnection() {
        try {
            connection = DriverManager.getConnection(URL);
            logger.info("Connection to the database successful!");
        } catch (SQLException e) {
            logger.error("Error connecting to the database: ", e);
        }
    }
	
    public static DBConnection getInstance() {
        if (instance == null) {
            instance = new DBConnection();
        }
        return instance;
    }
    
 // Metodo per ottenere la connessione al database
    public Connection getConnection() {
        return connection;
    }
}