package com.casino.casino_game;

import com.casino.utils.DBConnection;

import com.casino.utils.DBConnection;
import com.casino.view.Menu;
import com.casino.view.MenuGiochi;
import com.casino.view.MenuUtente;

import org.sqlite.core.DB;
import java.sql.Connection;

public class App {
    
    private static DBConnection db;

    public static void main(String[] args) {

		DBConnection db = new DBConnection();
        db.connect(); //collegamento db e test query
        
       MenuUtente.startMenu();
    // MenuGiochi.Start();
    }
}
