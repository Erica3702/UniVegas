package com.casino.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DBConnection {
	private static final Logger logger = LogManager.getLogger(DBConnection.class);

	private static final String URL = "jdbc:sqlite:src/main/resources/database/casino.db"; // Usa il database in memoria

	public static Connection connect() {
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

/*	public void testQuery() {
	    String query = "CREATE TABLE IF NOT EXISTS players (id INTEGER PRIMARY KEY, name TEXT, score INTEGER)";
	    try (Connection connection = connect();
	         var statement = connection.createStatement()) {
	        statement.execute(query);
	        logger.info("Test query executed successfully!");
	    } catch (SQLException e) {
	        logger.error("Error executing test query: ", e);
	    }
	}*/
}