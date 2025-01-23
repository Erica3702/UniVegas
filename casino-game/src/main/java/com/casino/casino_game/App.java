package com.casino.casino_game;

import com.casino.utils.DBConnection;
import com.casino.view.MenuUtente;

public class App {
    

    public static void main(String[] args) {

    DBConnection.connect(); //collegamento db e test query
        
    MenuUtente.startMenu();
    // MenuGiochi.Start();
    }
}
