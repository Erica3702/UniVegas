package com.casino.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.casino.utils.DBConnection;

public class UserDAO {

	private static final Logger logger = LogManager.getLogger(UserDAO.class);
	private DBConnection dbConnection;

	public UserDAO(DBConnection dbConnection) {
		super();
		this.dbConnection = dbConnection;
	}


}
