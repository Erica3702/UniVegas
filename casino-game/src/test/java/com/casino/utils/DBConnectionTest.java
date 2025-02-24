package com.casino.utils;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DBConnectionTest {
    private Connection connection;

    @Before
    public void setUp() {
        connection = DBConnection.connect();
        assertNotNull("Connection should not be null", connection);
    }

    @Test
    public void testConnection() {
        assertNotNull("Database connection should be established", connection);
    }

    @Test
    public void testCreateTable() {
        String query = "CREATE TABLE IF NOT EXISTS test_table (id INTEGER PRIMARY KEY, name TEXT)";
        try (Statement stmt = connection.createStatement()) {
            stmt.execute(query);
        } catch (SQLException e) {
            fail("Table creation failed: " + e.getMessage());
        }
    }


    @After
    public void tearDown() {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
