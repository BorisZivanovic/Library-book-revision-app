/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package baza;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jaca
 */
public class Konekcija {
    
    private static Konekcija instance;
    private Connection connection;

    private Konekcija() {
        try {
            String url = "jdbc:oracle:thin:@//192.168.1.5:1521/orcl";
            connection = DriverManager.getConnection(url, "student2", "boki00");
            connection.setAutoCommit(false);    
        } catch (SQLException ex) {
            Logger.getLogger(Konekcija.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static Konekcija getInstance() {
        if (instance == null) {
            instance = new Konekcija();
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }
    
}
