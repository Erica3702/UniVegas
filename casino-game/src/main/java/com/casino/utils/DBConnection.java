package com.casino.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	private static final Logger logger = LogManager.getLogger(DBConnection.class);

	
	private static final String URL = "jdbc:sqlite::memory:"; // Usa il database in memoria

	public Connection connect() {
        Connection connection = null;
        try {
            logger.info("Attempting to connect to the in-memory database...");
            connection = DriverManager.getConnection(URL);
            logger.info("Connection to the in-memory database successful!");

        } catch (SQLException e) {
            logger.error("Error connecting to the database: ", e);
        }
		return connection;
    }
}